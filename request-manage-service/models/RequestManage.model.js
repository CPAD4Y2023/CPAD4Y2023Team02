module.exports = (sequelize, DataTypes) => {
    const ManageRequest = sequelize.define("manageRequest", {
        reqId: {
            type: DataTypes.UUID,
            defaultValue: DataTypes.UUIDV4,
            primaryKey: true,
            allowNull: false
        },
        userId: {
            type: DataTypes.UUID,
            allowNull: false,
        },
        vendorId: {
            type: DataTypes.UUID,
            allowNull: false,
        },
        categoryId: {
            type: DataTypes.UUID,
            allowNull: false,
      },
      quantity: {
           type: DataTypes.FLOAT,
           allowNull: true,
      },
        fare: {
            type: DataTypes.FLOAT,
            allowNull: true,
      },
      status: {
            type: DataTypes.STRING,
            allowNull: true,
      },
    });

    return ManageRequest;
};