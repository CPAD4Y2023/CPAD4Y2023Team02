import 'package:flutter/material.dart';
import '../../common_widgets/categories-card.dart';
import '../../data_constants/categories_data.dart';

class BatteriesCategory extends StatefulWidget {
  const BatteriesCategory({super.key, required this.pageNumber});
  
  final int pageNumber;

  @override
  State<BatteriesCategory> createState() => _BatteriesCategoryState();
}

class _BatteriesCategoryState extends State<BatteriesCategory> {
  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.fromLTRB(0, 10, 10, 0),
      child: ListView(
        scrollDirection: Axis.vertical,
        children: [
          buildCategories(getCategory(widget.pageNumber)),
        ],
      )
    );
  }
}

Widget buildCategories(List<CategoryItem> categoryList) {
  return Column(
    children: categoryList.map((categoryItem) {
      return CategoriesCard(categoryItem: categoryItem);
    }).toList(),
  );
}

List<CategoryItem> getCategory(int pageNumber) {
  switch(pageNumber){
    case 0: return plasticCategory;
    case 1: return batteryCategory;
    case 2: return glassCategory;
    case 3: return ewasteCategory;
    case 4: return paperCategory;
    case 5: return metalCategory;
    default: return plasticCategory;
  }
}