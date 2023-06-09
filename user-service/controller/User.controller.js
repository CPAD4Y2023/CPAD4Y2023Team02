const db = require("../models");
const User = db.user;
const Validator = require('jsonschema').Validator;
const v = new Validator();
const userSchema = {
  "id": "/userSchema",
  "type": "object",
  "properties": {
    "id": { "type": "string" },
    "address": { "type": "string" },
    "role": {
      "type": "string",
      "enum": ["ADMIN", "RECYCLER", "CONSUMER"]
    },
  },
}
function appendHeaders(req, data) {
  data["dataValues"]["first_name"] = req.header('x-firstname')
  data["dataValues"]["last_name"] = req.header('x-lastname')
  data["dataValues"]["email"] = req.header('x-email')
  return data
}

// Find a single user with an id
exports.findOne = (req, res) => {
  const id = req.headers['x-userid'];

  User.findByPk(id)
    .then(data => {
      if (data) {
        data = appendHeaders(req, data)
        res.send(data);
        return
      } else {
        const user = {
          id: req.headers['x-userid'],
          address: req.body.address,
        };
        // Save Tutorial in the database
        User.create(user)
          .then((data) => {
            data = appendHeaders(req, data)
            data["dataValues"]["role"] = null
            data["dataValues"]["address"] = null
            res.status(201).send(data);
            return
          })
          .catch((err) => {
            if (err.name === 'SequelizeUniqueConstraintError') {
              res.status(409).send({
                message: "User data already exists"
              })
              return
            }
            res.status(500).send({
              message:
                err.message || "Some error occurred while creating the Tutorial.",
            });
          });
      }
    })
    .catch(err => {
      res.status(500).send({
        message: "Error retrieving user with id " + id
      });
    });
};

// Update a user by the id in the request
exports.update = (req, res) => {
  const id = req.headers['x-userid'];
  if (!id) {
    res.status(400).send({
      message:
        "user id parameter missing"
    });
    return
  }
  const user = {
    address: req.body.address,
    role: req.body.role
  };

  let checkValid = v.validate(user, userSchema)
  if (checkValid.valid) {
    User.update(user, {
      where: { id: id },
    })
      .then(num => {
        if (num == 1) {
          User.findByPk(id)
            .then(data => {
              if (data) {
                data = appendHeaders(req, data)
                res.status(202).send(data);
              }
            })
        } else {
          res.status(409).send({
            message: `Could not update user with id ${id}`
          });
        }
      })
      .catch(err => {
        res.status(500).send({
          message: "Error updating user with id " + id
        });
      });
  } else {
    res.status(400).send({
      message:
        checkValid.errors
    });
    return
  }
};

// Delete a user with the specified id in the request
exports.delete = (req, res) => {
  const id = req.headers['x-userid'];
  if (!id) {
    res.status(400).send({
      message:
        "user id parameter missing"
    });
    return
  }
  User.destroy({
    where: { id: id }
  })
    .then(num => {
      if (num == 1) {
        res.status(200).send({
          message: "user was deleted successfully!"
        });
      } else {
        res.status(409).send({
          message: `Could not delete user with id ${id}`
        });
      }
    })
    .catch(err => {
      res.status(500).send({
        message: err || "Could not delete user with id " + id
      });
    });
};
