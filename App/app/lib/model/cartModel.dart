import 'package:app/data_constants/categories-data.dart';
import 'package:flutter/material.dart';

class CartViewModel extends ChangeNotifier {
  final List<CategoryItem> _cartItem = [];

  List<CategoryItem> get cartItem => _cartItem;

  void addCartItem (CategoryItem cartItemToBeAdded) {
    _cartItem.add(cartItemToBeAdded);
    notifyListeners();
  }
}