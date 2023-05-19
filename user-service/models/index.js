const Sequelize = require("sequelize");
const env = process.env

const sequelize = new Sequelize(env.DB, env.USER, env.PASSWORD, {
    host: env.HOST,
    dialect: env.DIALECT,
    operatorsAliases: false,
    storage: env.DB_LOCAL_STORAGE_PATH,
    pool: {
        max: parseInt(env.POOL_MAX),
        min: parseInt(env.POOL_MIN),
    }
});

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

db.user = require("./User.model.js")(sequelize, Sequelize.DataTypes);

module.exports = db;