class CategoryItem{
  final String imageLocation;
  final String categoryId;
  final String description;
  final String categoryName;

  CategoryItem({ required this.imageLocation, required this.categoryId, required this.description, required this.categoryName});
}

List<CategoryItem> plasticCategory = [
  CategoryItem(
    imageLocation: "images/plastic-category/pete.png",
    categoryId: "pete",
    categoryName: "PETE",
    description: "Thin and transparent bottles for water, juices, soft drinks, packaging for and vegetables and some type of cosmetics."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/hdpe.png",
    categoryId: "hdpe",
    categoryName: "HDPE",
    description: "Hard Opaque plastic bottles like milk jugs, laundry detergents, shampoo bottles, washing and shower soaps."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/pvc.png",
    categoryId: "pvc",
    categoryName: "PVC",
    description: "Plumbing items, medical tubing, pressure pipes, electrical cable insulation, outdoor furniture."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/ldpe.png",
    categoryId: "ldpe",
    categoryName: "LDPE",
    description: "This is ductile and mostly used in shopping bags, food containers, films or bags and stretch wrap."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/pp.png",
    categoryId: "pp",
    categoryName: "PP",
    description: "Disposable cutlery and tableware, laboratory equipment, automotive parts, medical devices and toys."
  ),
  CategoryItem(
    imageLocation: "images/plastic-category/ps.png",
    categoryId: "ps",
    categoryName: "PS",
    description: "Foam Packaging, Insulation materials, television remotes, CD, DVD, Office Supplies, Craft materials."
  ),
];

List<CategoryItem> batteryCategory = [
  CategoryItem(
    imageLocation: "images/battery-category/lead-acid.png",
    categoryId: "lead-acid",
    categoryName: "Lead acid Battery",
    description: "Automotive batteries, Motorcycle batteries, Emergency lighting batteries, Electric vehicle batteries."
  ),
  CategoryItem(
    imageLocation: "images/battery-category/lithium-ion.png",
    categoryId: "lithium-ion",
    categoryName: "Lithium ion Battery",
    description: "Batteries from Smartphones, tablets, Laptops, cameras, power tools, wearable devices and power banks."
  ),
  CategoryItem(
    imageLocation: "images/battery-category/silver-oxide.png",
    categoryId: "silver-oxide",
    categoryName: "Silver oxide Battery",
    description: "Batteries from Watches, calculators, medical devices, Electronic toys and small electronic devices."
  ),
];

List<CategoryItem> glassCategory = [
  CategoryItem(
    imageLocation: "images/glass-category/glass.png",
    categoryId: "colorless-glass",
    categoryName: "Glass",
    description: "Only colorless glasses like pickle jars, beverage bottles, perfume bottles, baby food jars, Sauce and oil jars."
  ),
];

List<CategoryItem> ewasteCategory = [
  CategoryItem(
    imageLocation: "images/ewaste-category/large-household.png",
    categoryId: "large-household",
    categoryName: "Large household ewaste",
    description: "Refrigerators, Freezers, Dishwashers, Heating and cooling units, microservices, washing machines."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/it-equipment.png",
    categoryId: "it-equipment",
    categoryName: "It equipment ewaste",
    description: "Personal computers, laptops, monitors, keyboards, printers, gaming consoles, mobile phones, cameras."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/medical.png",
    categoryId: "medical",
    categoryName: "Medical ewaste",
    description: "Radiotherapy equipment, Dialysis equipment, Ventilators, Scanners, Lab and Diagnostic equipment."
  ),
  CategoryItem(
    imageLocation: "images/ewaste-category/lighting.png",
    categoryId: "lighting",
    categoryName: "Lighting equipment ewaste",
    description: "LED lamps, Fluorescent lamps, High intensity discharge lamps, Sodium vapor lamps, Switches, Wires."
  ),
];

List<CategoryItem> paperCategory = [
  CategoryItem(
    imageLocation: "images/paper-category/graphic-paper.png",
    categoryId: "graphic-paper",
    categoryName: "Graphic paper",
    description: "products made from graphic paper, such as newspapers, notebooks, other printed products, and office paper."
  ),
  CategoryItem(
    imageLocation: "images/paper-category/packaging-paper.png",
    categoryId: "packaging-paper",
    categoryName: "Packaging paper",
    description: "Products made from packaging paper, such as transport packaging or secondary packaging."
  ),
];

List<CategoryItem> metalCategory = [
  CategoryItem(
    imageLocation: "images/metal-category/iron.png",
    categoryId: "iron",
    categoryName: "Iron",
    description: "Cooking items and cutlery, cloth hangers, curtain rods, garden tools, decorative items and some furniture."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/carbide.png",
    categoryId: "carbide",
    categoryName: "Carbide",
    description: "Carbide is mainly used in Cutting tools, Aluminum Cans, Saw Blades, Industrial Sharpeners."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/copper.png",
    categoryId: "copper",
    categoryName: "Copper",
    description: "Kitchen utensils, Kitchen sink, Bathroom fixtures, Electrical wiring, water bottles and some cookware."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/titanium.png",
    categoryId: "titanium",
    categoryName: "Titanium",
    description: "Cutlery, Camping cookware, watches, jewelries, key chains, not stick and costly cookwares ans some pens."
  ),
  CategoryItem(
    imageLocation: "images/metal-category/aluminum.png",
    categoryId: "aluminum",
    categoryName: "Aluminum",
    description: "Aluminum Foil, Aluminum Cans, Cookware, Baking pans, window blinds, Ladders, Thermo flasks."
  ),
];