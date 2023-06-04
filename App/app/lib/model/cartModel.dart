import 'package:app/data_constants/categories-data.dart';
import 'package:flutter/material.dart';

class CartViewModel extends ChangeNotifier {
  final List<CategoryItem> _cartItem = [];

  List<CategoryItem> get cartItem => _cartItem;

  void addCartItem (CategoryItem cartItemToBeAdded) {
    _cartItem.insert(0, cartItemToBeAdded);
    notifyListeners();
  }

  void removeCartItem (CategoryItem cartItemToBeRemoved) {
    _cartItem.remove(cartItemToBeRemoved);
    notifyListeners();
  }
}