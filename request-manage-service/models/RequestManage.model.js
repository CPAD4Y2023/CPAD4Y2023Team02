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
        totalPrice: {
            type: DataTypes.INTEGER,
            allowNull: true,
      },
      status: {
            type: DataTypes.STRING,
            allowNull: true,
      },
    });

    return ManageRequest;
};