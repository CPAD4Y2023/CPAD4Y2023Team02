class CategoryItem{
  final String imageLocation;
  final String id;
  final String description;
  final String name;
  final String metric;
  late int quantity;
  final int pricePerKg;

  CategoryItem({ required this.imageLocation, required this.id, required this.description, required this.name, required this.metric, required this.quantity, required this.pricePerKg});
}

List<CategoryItem> plasticCategory = [
  CategoryItem(
    imageLocation: "images/plastic-category/pete.png",
    id: "pete",
    name: "PETE",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 4,
    description: "Thin and transparent bottles for water, juices, soft drinks, packaging for and vegetables and some type of cosmetics."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/hdpe.png",
    id: "hdpe",
    name: "HDPE",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 10,
    description: "Hard Opaque plastic bottles like milk jugs, laundry detergents, shampoo bottles, washing and shower soaps."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/pvc.png",
    id: "pvc",
    name: "PVC",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 8,
    description: "Plumbing items, medical tubing, pressure pipes, electrical cable insulation, outdoor furniture."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/ldpe.png",
    id: "ldpe",
    name: "LDPE",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 5,
    description: "This is ductile and mostly used in shopping bags, food containers, films or bags and stretch wrap."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/pp.png",
    id: "pp",
    name: "PP",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 5,
    description: "Disposable cutlery and tableware, laboratory equipment, automotive parts, medical devices and toys."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/ps.png",
    id: "ps",
    name: "PS",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 8,
    description: "Foam Packaging, Insulation materials, television remotes, CD, DVD, Office Supplies, Craft materials."
  ),
];

List<CategoryItem> batteryCategory = [
  CategoryItem(
    imageLocation: "images/battery-category/lead-acid.png",
    id: "lead-acid",
    name: "Lead acid Battery",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 12,
    description: "Automotive batteries, Motorcycle batteries, Emergency lighting batteries, Electric vehicle batteries."
  ),
  CategoryItem(
    imageLocation: "images/battery-category/lithium-ion.png",
    id: "lithium-ion",
    name: "Lithium ion Battery",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 10,
    description: "Batteries from Smartphones, tablets, Laptops, cameras, power tools, wearable devices and power banks."
  ),
  CategoryItem(
    imageLocation: "images/battery-category/silver-oxide.png",
    id: "silver-oxide",
    name: "Silver oxide Battery",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 7,
    description: "Batteries from Watches, calculators, medical devices, Electronic toys and small electronic devices."
  ),
];

List<CategoryItem> glassCategory = [
  CategoryItem(
    imageLocation: "images/glass-category/glass.png",
    id: "colorless-glass",
    name: "Glass",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 17,
    description: "Only colorless glasses like pickle jars, beverage bottles, perfume bottles, baby food jars, Sauce and oil jars."
  ),
];

List<CategoryItem> ewasteCategory = [
  CategoryItem(
    imageLocation: "images/ewaste-category/large-household.png",
    id: "large-household",
    name: "Large household ewaste",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 20,
    description: "Refrigerators, Freezers, Dishwashers, Heating and cooling units, microservices, washing machines."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/it-equipment.png",
    id: "it-equipment",
    name: "It equipment ewaste",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 10,
    description: "Personal computers, laptops, monitors, keyboards, printers, gaming consoles, mobile phones, cameras."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/medical.png",
    id: "medical",
    name: "Medical ewaste",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 14,
    description: "Radiotherapy equipment, Dialysis equipment, Ventilators, Scanners, Lab and Diagnostic equipment."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/lighting.png",
    id: "lighting",
    name: "Lighting equipment ewaste",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 10,
    description: "LED lamps, Fluorescent lamps, High intensity discharge lamps, Sodium vapor lamps, Switches, Wires."
  ),
];

List<CategoryItem> paperCategory = [
  CategoryItem(
    imageLocation: "images/paper-category/graphic-paper.png",
    id: "graphic-paper",
    name: "Graphic paper",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 17,
    description: "products made from graphic paper, such as newspapers, notebooks, other printed products, and office paper."
  ),
  CategoryItem(
    imageLocation: "images/paper-category/packaging-paper.png",
    id: "packaging-paper",
    name: "Packaging paper",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 12,
    description: "Products made from packaging paper, such as transport packaging or secondary packaging."
  ),
];

List<CategoryItem> metalCategory = [
  CategoryItem(
    imageLocation: "images/metal-category/iron.png",
    id: "iron",
    name: "Iron",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 20,
    description: "Cooking items and cutlery, cloth hangers, curtain rods, garden tools, decorative items and some furniture."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/carbide.png",
    id: "carbide",
    name: "Carbide",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 25,
    description: "Carbide is mainly used in Cutting tools, Aluminum Cans, Saw Blades, Industrial Sharpeners."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/copper.png",
    id: "copper",
    name: "Copper",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 22,
    description: "Kitchen utensils, Kitchen sink, Bathroom fixtures, Electrical wiring, water bottles and some cookware."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/titanium.png",
    id: "titanium",
    name: "Titanium",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 29,
    description: "Cutlery, Camping cookware, watches, jewelries, key chains, not stick and costly cookwares ans some pens."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/aluminum.png",
    id: "aluminum",
    name: "Aluminum",
    metric: "Kg",
    quantity: 0,
    pricePerKg: 19,
    description: "Aluminum Foil, Aluminum Cans, Cookware, Baking pans, window blinds, Ladders, Thermo flasks."
  ),
];