const express = require('express');
const router = express.Router();
const items = require("../controller/Item.controller.js");


/* GET home page. */
router.post('/item', items.create)
  .get('/item', items.findAll)
  .get('/item/:id', items.findOne)
  .put('/item/:id', items.update)
  .patch('/item/:id', items.update)
  .delete('/item/:id', items.delete);

module.exports = router;