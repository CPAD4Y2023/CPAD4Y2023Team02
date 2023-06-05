const Sequelize = require("sequelize");
const env = process.env

// setting uo Sequelize instance
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

db.manageRequest = require("./RequestManage.model.js")(sequelize, Sequelize.DataTypes);

module.exports = db;