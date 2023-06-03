const express = require('express');
const router = express.Router();
const users = require("../controller/User.controller.js");


/* GET home page. */
router.get('/user', users.findOne)
  .put('/user', users.update)
  .patch('/user', users.update)
  .delete('/user', users.delete);

module.exports = router;