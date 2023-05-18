module.exports = (sequelize, DataTypes) => {
    const Item = sequelize.define("item", {
        itemId: {
            type: DataTypes.UUID,
            defaultValue: DataTypes.UUIDV4,
            primaryKey: true,
            allowNull: false
        },
        itemName: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        itemPrice: {
            type: DataTypes.INTEGER,
            allowNull: false,
        },
    });

    return Item;
};