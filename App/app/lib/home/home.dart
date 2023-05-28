import 'package:flutter/material.dart';
import '../data_constants/products-data.dart';
import 'product_categories/battery.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {

  late PageController _pageController;
  int _pageIndex = 0;

  @override
  void initState() {
    _pageController = PageController(initialPage: 0);
    super.initState();
  }

  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }
  
  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: const EdgeInsets.fromLTRB(17, 70, 0, 0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            DefaultTextStyle(
              style: TextStyle(fontSize: 23, color: Color(int.parse("0xff555555"))),
              child:Row(
                children: [
                  const Text("Welcome, "),
                  Text(
                    "{abhi}",
                    style: TextStyle(color: Color(int.parse("0xffF8B500"))),
                  ),
                  const SizedBox(width: 10),
                  const Icon(Icons.waving_hand),
                ],
              ),
            ),

            const SizedBox(height: 12),
            Text(
              "What would you like to recycle today?",
              style: TextStyle(color: Color(int.parse("0xff9B9B9B")))
            ),

            const SizedBox(height: 70),
            Text(
              "Products",
              style: TextStyle(fontSize: 16, color: Color(int.parse("0xff555555"))),
            ),
            const SizedBox(height: 7),

            SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              child: cardBuilder(productList, _pageController, _pageIndex),
            ),
            
            const SizedBox(height: 28),

            Text(
              "Categories",
              style: TextStyle(fontSize: 15, color: Color(int.parse("0xff555555"))),
            ),
            
            Flexible(
              child: PageView.builder(
                physics: const NeverScrollableScrollPhysics(),
                itemCount: productList.length,
                controller: _pageController,
                onPageChanged: (index) {
                  setState(() {
                    _pageIndex = index;
                  });
                },
                itemBuilder: (context, index) => ProductCategory(index: index)
              )
            )
          ],
      ),
    );
  }
}

class ProductCategory extends StatelessWidget {
  const ProductCategory({super.key, required this.index});

  final int index;

  @override
  Widget build(BuildContext context) {
    return BatteriesCategory(pageNumber: index);
  }
}

Widget cardBuilder(List<Product> productList, PageController pageController, int pageIndex) {
  return Row(children: productList.map((Product) {
    int index = productList.indexOf(Product);
    bool isSelectedCard = pageIndex==index;
    
    return InkWell(
      onTap: () {
        pageController.jumpToPage(index);
      },
      splashColor: Colors.transparent,
      child: AnimatedContainer(
        duration: const Duration(milliseconds: 200),
        margin: const EdgeInsets.all(10),
        height: 134,
        width: 110,
        decoration: BoxDecoration(
            // border: Border.all(color: Colors.black, width: 2),
            color: isSelectedCard? Color(int.parse("0xffC6F3B7")): Colors.white,
            borderRadius: BorderRadius.circular(10),
            boxShadow: [BoxShadow(
              blurRadius: 7.0,
              color: isSelectedCard? const Color.fromRGBO(80, 220, 79, 0.2) :const Color.fromRGBO(0, 0, 0, 0.1),
              offset: const Offset(2.0,2.0)
            )],
          ),
          child:Column(
            children: [
              const SizedBox(height: 22),
              Image.asset(Product.imageLocation, height: 50),
              const SizedBox(height:18),
              Text(Product.productName),
            ]
          ),
        ),
    );
  }).toList());
  }
