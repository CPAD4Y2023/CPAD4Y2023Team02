const winston = require("winston");

// define the custom settings for each transport (file, console)
const options = {
    console: {
        level: "info",
        handleExceptions: true,
        format: winston.format.combine(
            winston.format.timestamp(),
            winston.format.colorize(),
            winston.format.simple()
        ),
    },
};

// instantiate a new Winston Logger with the settings defined above
const logger = winston.createLogger({
    transports: [
        new winston.transports.Console(options.console),
    ],
    exitOnError: false, // do not exit on handled exceptions
});

module.exports = logger;
module.exports.stream = {
    write: function (message, encoding) {
        logger.info(message);
    }
};