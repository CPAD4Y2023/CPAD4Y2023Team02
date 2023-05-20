if (process.env.NODE_ENV !== "production") {
    require("dotenv").config({ path: "config/local.env" });
}
let createError = require('http-errors');
let express = require('express');
let path = require('path');
let logger = require('morgan');
let indexRouter = require('./routes/index');
let app = express();
let winston = require('./config/winston');

app.use(logger("dev", { "stream": winston.stream }));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

const db = require("./models");

db.sequelize.sync({ force: true })
    .then(() => {
        winston.info("Database Synced Successfully");
    })
    .catch((err) => {
        winston.error("Database Failed to Sync: " + err.message);
    });

app.use('/', indexRouter);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
    next(createError(404));
});

let listener = app.listen(process.env.PORT || 3000, () => {
    winston.info(`Server started on port ${listener.address().port}`)
})

process.on('SIGINT', function() {
  console.log( "\nGracefully shutting down from SIGINT (Ctrl-C)" );
  process.exit();
});