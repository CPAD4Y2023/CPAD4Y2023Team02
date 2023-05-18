const db = require("../models");
const Item = db.item;
const Validator = require('jsonschema').Validator;
const v = new Validator();
const itemSchema = {
    "id": "/itemSchema",
    "type": "object",
    "properties": {
        "itemName": { "type": "string" },
        "itemPrice": { "type": "integer", "minimum": 1, "maximum": 99999 }
    },
    "required": ["itemName", "itemPrice"]
}

// Create and Save a new Item
exports.create = (req, res) => {
    const item = {
        itemName: req.body.itemName,
        itemPrice: req.body.itemPrice,
    };

    let checkValid = v.validate(item, itemSchema)
    if (checkValid.valid) {
        // Save Tutorial in the database
        Item.create(item)
            .then((data) => {
                res.status(201).send(data);
            })
            .catch((err) => {
                res.status(500).send({
                    message:
                        err.message || "Some error occurred while creating the Tutorial.",
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

// Retrieve all Items from the database.
exports.findAll = (req, res) => {
    console.log(req)
    Item.findAll()
        .then(data => {
            res.send(data);
        })
        .catch(err => {
            res.status(500).send({
                message:
                    err.message || "Some error occurred while retrieving tutorials."
            });
        });
};

// Find a single Item with an id
exports.findOne = (req, res) => {
    const id = req.params.id;

    Item.findByPk(id)
        .then(data => {
            if (data) {
                res.send(data);
            } else {
                res.status(404).send({
                    message: `Cannot find Item with id ${id}.`
                });
            }
        })
        .catch(err => {
            res.status(500).send({
                message: "Error retrieving Item with id " + id
            });
        });
};

// Update a Item by the id in the request
exports.update = (req, res) => {
    const id = req.params.id;
    if (!id) {
        res.status(400).send({
            message:
                "Item id parameter missing"
        });
        return
    }
    const item = {
        itemName: req.body.itemName,
        itemPrice: req.body.itemPrice,
    };

    let checkValid = v.validate(item, itemSchema)
    if (checkValid.valid) {
        Item.update(item, {
            where: { itemId: id }
        })
            .then(num => {
                if (num == 1) {
                    res.status(202).send({
                        message: "Item was updated successfully."
                    });
                } else {
                    res.status(409).send({
                        message: `Could not update Item with id ${id}`
                    });
                }
            })
            .catch(err => {
                res.status(500).send({
                    message: "Error updating Item with id " + id
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

// Delete a Item with the specified id in the request
exports.delete = (req, res) => {
    const id = req.params.id;
    if (!id) {
        res.status(400).send({
            message:
                "Item id parameter missing"
        });
        return
    }
    Item.destroy({
        where: { itemId: id }
    })
        .then(num => {
            //console.log(err)
            if (num == 1) {
                res.status(200).send({
                    message: "Item was deleted successfully!"
                });
            } else {
                res.status(409).send({
                    message: `Could not delete Item with id ${id}`
                });
            }
        })
        .catch(err => {
            res.status(500).send({
                message: err || "Could not delete Item with id " + id
            });
        });
};
