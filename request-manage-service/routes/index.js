const express = require('express');
const reqRouter = express.Router();
const requestManage = require("../controller/RequestManage.controller.js");


/* GET home page. */
reqRouter.post('/manageRequest', requestManage.createRequest)
  .get('/manageRequest/:reqId', requestManage.getRequestByReqId)
  .get('/manageRequest', requestManage.getAllRequest)
  .patch('/manageRequest/:reqId', requestManage.updateRequest)
  .delete('/manageRequest/:reqId', requestManage.deleteRequest);

module.exports = reqRouter;