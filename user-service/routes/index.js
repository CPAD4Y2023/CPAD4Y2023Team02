const express = require('express');
const router = express.Router();
const users = require("../controller/User.controller.js");


/* GET home page. */
router.get('/api/v1/user', users.findOne)
  .put('/api/v1/user', users.update)
  .patch('/api/v1/user', users.update)
  .delete('/api/v1/user', users.delete);

module.exports = router;