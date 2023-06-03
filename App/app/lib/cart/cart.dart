import 'package:app/model/cartModel.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';


class Cart extends StatefulWidget {
  const Cart({super.key});

  @override
  State<Cart> createState() => _CartState();
}

class _CartState extends State<Cart> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Consumer<CartViewModel>(builder: (context, viewModel, child) {
        String name = viewModel.cartItem[0].name;
        return Text(name);
      }),
    );
  }
}