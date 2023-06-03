import 'package:app/model/cartModel.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../data_constants/categories-data.dart';

class CategoriesCard extends StatefulWidget {
  const CategoriesCard({super.key, required this.categoryItem});
  final CategoryItem categoryItem;

  @override
  State<CategoriesCard> createState() => _CategoriesCardState();
}

class _CategoriesCardState extends State<CategoriesCard> {
  bool isAddedToCart = false;

  @override
  Widget build(BuildContext context) {
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
            child: Image.asset(widget.categoryItem.imageLocation, height: 50),
          ),
          Flexible(
            child:Text(
              softWrap: true,
              widget.categoryItem.description,
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
              _showToast(context, isAddedToCart, widget.categoryItem.name);
              Provider.of<CartViewModel>(context, listen: false).addCartItem(widget.categoryItem);
            },
          ),
        ]),
      );
  }
}

void _showToast(BuildContext context, bool isAddedToCart, name) {
    final scaffold = ScaffoldMessenger.of(context);
    scaffold.showSnackBar(
      SnackBar(
        content: Text(
          isAddedToCart? "$name added to cart": "$name removed from cart",
        ),
        action: SnackBarAction(label: 'Dismiss', onPressed: scaffold.hideCurrentSnackBar),
      ),
    );
  }