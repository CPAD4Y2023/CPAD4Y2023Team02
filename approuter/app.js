let approuter = require('@sap/approuter');
let jwt_decode = require("jwt-decode");
 
let ar = approuter();

ar.beforeRequestHandler.use('/', function myMiddleware(req, res, next) {
  let token, decoded;
  if(req.user){
    token = req.user.token.accessToken
  } else {
    token = req.session.user.token.accessToken
  }
  decoded = jwt_decode(token);
  req.headers['x-firstname'] = decoded.given_name;
  req.headers['x-lastname'] = decoded.family_name;
  req.headers['x-email'] = decoded.email;
  req.headers['x-userid'] = decoded.user_id;
  next();
});
ar.start();