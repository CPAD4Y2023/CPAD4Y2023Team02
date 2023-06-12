import 'package:app/model/cartModel.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../api/user_requests.dart';
import '../data_constants/categories-data.dart';


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
        bool isCartEmpty = viewModel.cartItem.isEmpty;
        String totalWeight = isCartEmpty? "--": getTotalWeightInKg(viewModel.cartItem).toString();
        String totalOrderQuantity = isCartEmpty? "--": viewModel.cartItem.length.toString();
        String pickupDate = "20 jun";

        return Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              margin: const EdgeInsets.fromLTRB(25, 82, 25, 20),
              padding: const EdgeInsets.all(25),
              decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(10),
              boxShadow: const [BoxShadow(
                blurRadius: 7.0,
                offset: Offset(1.0,1.0),
                color: Color.fromRGBO(100, 100, 100, 0.1),
              )],
            ),

              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [

                  //cart welcome and description text
                  DefaultTextStyle(
                    style: TextStyle(fontSize: 23, color: Color(int.parse("0xff555555"))),
                    child: Row(
                      children: [
                        const Text("Wonderful, "),
                        Text(
                          "{abhi}",
                          style: TextStyle(color: Color(int.parse("0xffF8B500"))),
                        ),
                      ],
                    ),
                  ),
                  const SizedBox(height: 7),
                  Text(
                    "You are about to recycle your waste,\nBelow is your order details.",
                    style: TextStyle(color: Color(int.parse("0xff9B9B9B"))),
                  ),
                  const SizedBox(height: 28),

                  //order details
                  Row(
                    children: [
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text("Order weight: $totalWeight kg"),
                          const SizedBox(height: 12),
                          Text("Order Quantity: $totalOrderQuantity"),
                          const SizedBox(height: 12),
                          Text("Pickup date: $pickupDate")
                        ],
                      ),
                      const Spacer(),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(0, 0, 5, 0),
                        child: Column(children: [
                          const Text("Order value"),
                          const SizedBox(height: 8),
                          Row(children: [
                            Icon(
                              Icons.currency_rupee,
                              color: Color(int.parse("0xff9B9B9B")),
                              size: 18,
                            ),
                            Text(
                              "100",
                              style: TextStyle(fontSize: 35, color: Color(int.parse("0xff1F9500"))),
                            ),
                            const SizedBox(width: 14)
                          ],)
                        ],),
                      )
                    ],
                  ),
                ],
              )
            ),

            // order list
            const SizedBox(height: 16),
            Container(
              margin: const EdgeInsets.fromLTRB(25, 0, 25, 0),
              child: Row(children: [
                Text(
                  "Items added",
                  style: TextStyle(fontSize: 15, color: Color(int.parse("0xff555555"))),
                ),
                const Spacer(),
                OutlinedButton(
                  onPressed: () {},
                  style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all<Color>(Colors.green),
                    foregroundColor: MaterialStateProperty.all<Color>(Colors.white),
                    overlayColor: MaterialStateProperty.all<Color>(const Color.fromARGB(255, 48, 138, 51)),
                  ),
                  child: const Text("Create Order"),
                )
              ],),
            ),
            const SizedBox(height: 5),
            Expanded(
              child: ListView(
                children: [
                  SingleChildScrollView(
                    child: buildAddedItems(context, viewModel.cartItem),
                  ),
                ],
              ),
            )
          ],
        );
      }),
    );
  }
}


Widget buildAddedItems(BuildContext context, List<CategoryItem> addedItems) {
  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: addedItems.map((addedItem) {

      int index = addedItems.indexOf(addedItem);
      var inputTextController = TextEditingController();
      inputTextController.text = addedItem.quantity.toString();

      return Container(
        margin: const EdgeInsets.fromLTRB(25, 0, 25, 20),
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.circular(10),
            boxShadow: const [BoxShadow(
              blurRadius: 7.0,
              color: Color.fromRGBO(0, 0, 0, 0.1),
              offset: Offset(2.0,2.0)
            )],
          ),
        child: Row(children: [
          Text(
            "${index+1}. ${addedItem.name} (in ${addedItem.metric})",
            style: TextStyle(
              color: Color(int.parse("0xff555555")),
            ),
          ),
          const Spacer(),
          IconButton(
            onPressed: () {
              _onQuantityChange(context, addedItems, addedItem, "-", inputTextController, "");
            },
            icon: const Icon(Icons.remove_circle_outline),
            color: Color(int.parse("0xff777777")),
          ),
          SizedBox(
            width: 50,
            child: TextField(
              textAlign: TextAlign.center,
              controller: inputTextController,
              onChanged: (text) {
                _onQuantityChange(context, addedItems, addedItem, "onChange", inputTextController, text);
              },
              keyboardType: TextInputType.number,
          ),),
          IconButton(
            onPressed: () {
              _onQuantityChange(context, addedItems, addedItem, "+", inputTextController, "");
            },
            icon: const Icon(Icons.add_circle_outline),
            color: Color(int.parse("0xff777777"))
          ),
        ],),
      );
    }).toList(),
  );
}

_onQuantityChange(BuildContext context, List<CategoryItem> addedItems, CategoryItem addedItem, String operator, TextEditingController inputTextController,String text) {
  int index = addedItems.indexOf(addedItem);
  List<CategoryItem> newAddedItem = addedItems;
  int quantity = addedItem.quantity;
  String idOfChangedItem = addedItem.id;

  for(var item in addedItems) {
    if(item.id == idOfChangedItem) {
      if(operator == "+") {
        newAddedItem[index].quantity = quantity+1;
        inputTextController.text = newAddedItem[index].quantity.toString();
      } else if(operator == "-" && quantity>0) {
        newAddedItem[index].quantity = quantity-1;
        inputTextController.text = newAddedItem[index].quantity.toString();
      } else if(operator == "onChange") {
        newAddedItem[index].quantity = int.parse(text.isNotEmpty? text: '0');
        inputTextController.text = text;
      }
    }
  }

  Provider.of<CartViewModel>(context, listen: false).updateQuantity(idOfChangedItem, newAddedItem[index]);
}

int getTotalWeightInKg(List<CategoryItem> addedItems) {
  int totalWeightInKg = 0;
  for(var addedItem in addedItems) {
    if(addedItem.metric == "Kg") {
      totalWeightInKg = totalWeightInKg + addedItem.quantity;
    }
  }
  getUserDetailsOnLogin();
  return totalWeightInKg;
}