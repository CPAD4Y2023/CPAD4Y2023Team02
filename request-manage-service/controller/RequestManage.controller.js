const db = require("../models");
const fetch = import('node-fetch');
const env = process.env
const ManageRequest = db.manageRequest;
const Validator = require('jsonschema').Validator;
const v = new Validator();

const manageRequestSchema = {
  "id": "/manageRequestSchema",
  "type": "object",
  "properties": {
    "reqId": { "type": "string" },
    "userId": { "type": "string" },
    "vendorId": { "type": "string" },
    "totalPrice": { "type": "integer" },
    "status": {
      "type": "string",
      "enum": ["Pending", "Out for Pickup", "On Hold" , "Completed"]
    },
  },
}

//Create request in database     -- local
exports.createRequest = (req,res) => {
    const userId = req.headers['x-userid'];

//    const userId ="user101";   //for local
    let totalPrice = 0;

    req.body.forEach(item => {
      const product = item.metricQuantity * item.price;
      totalPrice += product;
    });

    const manageRequest = {
        userId: userId,
        vendorId: req.body[0].vendorId,
        totalPrice: totalPrice,
        status: "Pending",
    };

      let checkValid = v.validate(manageRequest, manageRequestSchema)
      if (checkValid.valid) {
        // Save in the database
        ManageRequest.create(manageRequest)
          .then((data) => {

            res.status(201).send(data);
          })
          .catch((err) => {
            if (err.name === 'SequelizeUniqueConstraintError') {
              res.status(409).send({
                message: "Duplicate request placed."
              })
              return
            }
            res.status(500).send({
              message:
                err.message || "Some error occurred while creating the request.",
            });
          });
      } else {
        console.log(checkValid)
        res.status(400).send({
          message:
            checkValid.errors
        });
        return
      }
};


// Find all request for given user
exports.getAllRequest = (req, res) => {
  const userId = req.headers['x-userid'];

//  const userId ="user101";    //local
  const role = "CONSUMER";
   if(role === "CONSUMER"){
    ManageRequest.findAll({
          where: {
             userId: userId,
          },
         })
         .then(data => {
           if (data) {

             res.send(data);
           } else {
             res.status(404).send({
               message: `Cannot find request for user with userId ${userId}.`
             });
           }
         })
     }
     else if(role === "RECYCLER"){
      ManageRequest.findAll({
          where: {
           vendorId: userId,
            },
          })
         .then(data => {
               if (data) {

                 res.send(data);
               } else {
                 res.status(404).send({
                   message: `Cannot find request for vendor with userId ${userId}.`
               });
            }
        })
     }
     else{
        res.status(200).send({ message: "No Request Found For Admin."
      });
     }
};

// Find a single request with an id
exports.getRequestByReqId = (req, res) => {
  const reqId = req.params.reqId;
  ManageRequest.findByPk(reqId)
    .then(data => {
      if (data) {

        res.status(200).send(data);
      } else {
        res.status(404).send({message: `Cannot find request with reqId ${reqId}.`
        });
      }
    })
    .catch(err => {
      res.status(500).send({message: "Error retrieving request with reqId " + reqId
      });
    });
};


// Update status by the reqId in the request
exports.updateRequest = (req, res) => {
  const reqId = req.params.reqId;
  if (!reqId) {
    res.status(400).send({ message: "Request Id parameter missing" });
    return
  }
  const manageRequest = {    //using only patch, pass only status, passing thing check.
    categoryId: req.body.categoryId,
    quantity:req.body.quantity,
    totalPrice: req.body.totalPrice,
    status: req.body.status
  };

  let checkValid = v.validate(manageRequest, manageRequestSchema)
  if (checkValid.valid) {
    ManageRequest.update(manageRequest, {
      where: { reqId: reqId },
    })
      .then(num => {
        if (num == 1) {
          ManageRequest.findByPk(reqId)
            .then(data => {
              if (data) {

                res.status(200).send(data);
              }
            })
        } else {
          res.status(409).send({
            message: `Could not update request with reqId ${reqId}`
          });
        }
      })
      .catch(err => {
        res.status(500).send({ message: "Error updating request with reqId " + reqId });
      });
  } else {
    res.status(400).send({ message: checkValid.errors
    });
    return
  }
};

// Delete a request for provided request Id
exports.deleteRequest = (req, res) => {
  const reqId = req.params.reqId;
  if (!reqId) {
    res.status(400).send({ message:"Request id parameter missing"
    });
    return
  }
  ManageRequest.destroy({
    where: { reqId: reqId }
  })
    .then(num => {
      if (num == 1) {
        res.status(200).send({ message: "Request was deleted successfully!"
        });
      } else {
        res.status(409).send({ message: `Could not delete request with reqId ${reqId}`
        });
      }
    })
    .catch(err => {
      res.status(500).send({ message: err || "Could not delete request with reqId " + reqId
      });
    });
};

