class Product {
  final String productName;
  final String imageLocation;
  final String productId;

  Product({ required this.productName, required this.imageLocation, required this.productId});
}

List<Product> productList = [
  Product(
    productName: "Plastic",
    productId: "plastic",
    imageLocation: "images/products/plastic.png"
  ),
  Product(
    productName: "Battery",
    productId: "battery",
    imageLocation: "images/products/battery.png"
  ),
  Product(
    productName: "Glass",
    productId: "glass",
    imageLocation: "images/products/glass.png"
  ),
  Product(
    productName: "E-waste",
    productId: "ewaste",
    imageLocation: "images/products/e-waste.png"
  ),
  Product(
    productName: "Paper",
    productId: "paper",
    imageLocation: "images/products/paper.png"
  ),
  Product(
    productName: "Metal",
    productId: "metal",
    imageLocation: "images/products/metal.png"
  ),
];