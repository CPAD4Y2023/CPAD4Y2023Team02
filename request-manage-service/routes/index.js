const express = require('express');
const reqRouter = express.Router();
const requestManage = require("../controller/RequestManage.controller.js");


/* GET home page. */
reqRouter.post('/api/v1/manageRequest', requestManage.createRequest)
  .get('/api/v1/manageRequest/:reqId', requestManage.getRequestByReqId)
  .get('/api/v1/manageRequest', requestManage.getAllRequest)
  .patch('/api/v1/manageRequest/:reqId', requestManage.updateRequest)
  .delete('/api/v1/manageRequest/:reqId', requestManage.deleteRequest);

module.exports = reqRouter;