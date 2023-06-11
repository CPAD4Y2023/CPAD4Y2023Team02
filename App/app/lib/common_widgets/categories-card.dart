import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../data_constants/categories-data.dart';
import '../model/cartModel.dart';

class CategoriesCard extends StatefulWidget {
  const CategoriesCard({super.key, required this.categoryItem});
  final CategoryItem categoryItem;

  @override
  State<CategoriesCard> createState() => _CategoriesCardState();
}

class _CategoriesCardState extends State<CategoriesCard> {

  @override
  Widget build(BuildContext context) {
    
      return Container(
      child: Consumer<CartViewModel>(builder: (context, viewModel, child) {
        List<CategoryItem> cartItem = viewModel.cartItem;
        CategoryItem categoryItem = widget.categoryItem;
        bool isAddedToCart = getIsActive(cartItem, categoryItem);

        return Container(
        margin: const EdgeInsets.fromLTRB(3.5, 0, 10, 18),
        padding: const EdgeInsets.fromLTRB(20, 18, 10, 18),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(20),
          boxShadow: const [BoxShadow(
            blurRadius: 7.0,
            offset: Offset(1.0,1.0),
            color: Color.fromRGBO(100, 100, 100, 0.1),
          )],
        ),
        child: Row(children: [
          Padding(
            padding: const EdgeInsets.fromLTRB(0, 0, 20, 0),
            child: Image.asset(categoryItem.imageLocation, height: 50),
          ),
          Flexible(
            child:Text(
              softWrap: true,
              categoryItem.description,
              style: TextStyle(color: Color(int.parse("0xff777777"))),
            ),
          ),
          TextButton(
            style: TextButton.styleFrom(
              foregroundColor: Colors.green,
              fixedSize: const Size(20, 64),
            ),
            child: isAddedToCart? const Icon(Icons.remove_shopping_cart) : const Icon(Icons.add_shopping_cart),
            onPressed: () {
              setState(() {
                isAddedToCart = !isAddedToCart;
              });
              _onItemClick(context, isAddedToCart, categoryItem);
            },
          ),
        ]),
      );
    }));
  }
}

void _showToast(BuildContext context, bool isAddedToCart, name) {
    final scaffold = ScaffoldMessenger.of(context);
    scaffold.showSnackBar(
      SnackBar(
        content: Text(
          isAddedToCart? "$name added to cart": "$name removed from cart",
        ),
        duration: const Duration(milliseconds: 490),
        action: SnackBarAction(label: 'Dismiss', onPressed: scaffold.hideCurrentSnackBar),
      ),
    );
  }

void _onItemClick(BuildContext context, bool isAddedToCart, CategoryItem categoryItem) {
  _showToast(context, isAddedToCart, categoryItem.name);
  if(isAddedToCart) {
    categoryItem.quantity = 0;
    Provider.of<CartViewModel>(context, listen: false).addCartItem(categoryItem);
  } else {
    Provider.of<CartViewModel>(context, listen: false).removeCartItem(categoryItem);
  }
}

bool getIsActive(List<CategoryItem> cartItem, CategoryItem currentCategory) {
  if(cartItem.isEmpty) {
    return false;
  }
  for(var item in cartItem) {
    if(item.id == currentCategory.id) {
      return true;
    }
  }
  return false;
}