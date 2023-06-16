import 'package:app/data_constants/categories_data.dart';
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
  
  void updateQuantity (String itemId, CategoryItem modifiedItem) {
    int index=0;
    for(var item in _cartItem) {
      if(item.id == itemId) {
        _cartItem[index] = modifiedItem;
        break;
      }
      ++index;
    }
    notifyListeners();
  }
}