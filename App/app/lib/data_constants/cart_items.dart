class CartItem{
  final String categoryId;
  final String categoryName;
  final int metricQuantity;
  final String vendorId;
  final String metric;
  final int price;

  CartItem({ required this.categoryId, required this.categoryName, required this.metricQuantity, required this.vendorId, required this.metric, required this.price});

  Map<String, dynamic> toJson() {
    return {
      "categoryId": categoryId,
      "categoryName": categoryName,
      "vendorId": vendorId,
      "price": price,
      "metric": metric,
      "metricQuantity": metricQuantity,
    };
  }
}

List<Map<String, dynamic>> orderItems = [];