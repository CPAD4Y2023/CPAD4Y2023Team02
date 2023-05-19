module.exports = (sequelize, DataTypes) => {
    const User = sequelize.define("user", {
        id: {
            type: DataTypes.UUID,
            primaryKey: true,
            allowNull: false
        },
        address: {
            type: DataTypes.STRING,
            allowNull: true,
        },
        latitude: {
            type: DataTypes.STRING,
            allowNull: true,
        },
        longitude: {
          type: DataTypes.STRING,
          allowNull: true,
      },
        role: {
          type: DataTypes.STRING,
          allowNull: true,
      },
    });

    return User;
};