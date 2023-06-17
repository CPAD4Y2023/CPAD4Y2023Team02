import 'package:app/data_constants/order_details.dart';
import 'package:app/model/auth_model.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';
import '../api/user_requests.dart';


class Orders extends StatefulWidget {
  const Orders({super.key, required this.orderItems});

  final List<OrderItems> orderItems;

  @override
  State<Orders> createState() => _OrdersState();
}

class _OrdersState extends State<Orders> {

  @override
  Widget build(BuildContext context) {

    final orderItems = widget.orderItems;
    bool isOrdersEmpty = orderItems.isEmpty;
    final totalEarnings = isOrdersEmpty? "--": getOrderDetails(orderItems)["totalEarningsCompleted"].toString();
    final upcomingEarnings = isOrdersEmpty? "--": getOrderDetails(orderItems)["upcomingEarnings"].toString();
    final ordersCompleted = isOrdersEmpty? "--": getOrderDetails(orderItems)["ordersCompleted"].toString();
    final numberOfPendingOrders = isOrdersEmpty? "--": getOrderDetails(orderItems)["numberOfPendingOrders"].toString();

    return Container(
      child: Column(
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
                        const Text("Awesome, "),
                        Text(
                          Provider.of<UserAuthModel>(context, listen: false).getUsersFirstName(),
                          style: TextStyle(color: Color(int.parse("0xffF8B500"))),
                        ),
                      ],
                    ),
                  ),
                  const SizedBox(height: 7),
                  Text(
                    "You are great!,\nThanks for helping our environment.",
                    style: TextStyle(color: Color(int.parse("0xff9B9B9B"))),
                  ),
                  const SizedBox(height: 28),

                  //order details
                  Row(
                    children: [
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text("Orders completed: $ordersCompleted"),
                          const SizedBox(height: 12),
                          Text("Pending Orders: $numberOfPendingOrders"),
                          const SizedBox(height: 12),
                          Text("Upcoming earnings: ₹ $upcomingEarnings"),
                        ],
                      ),
                      const Spacer(),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(0, 0, 5, 0),
                        child: Column(children: [
                          const Text("Total earnings"),
                          const SizedBox(height: 8),
                          Row(children: [
                            Icon(
                              Icons.currency_rupee,
                              color: Color(int.parse("0xff9B9B9B")),
                              size: 18,
                            ),
                            Text(
                              totalEarnings,
                              style: TextStyle(fontSize: 35, color: Color(int.parse("0xff1F9500"))),
                            ),
                            const SizedBox(width: 12.5)
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
              margin: const EdgeInsets.fromLTRB(28, 0, 28, 0),
              child: Row(children: [
                Text(
                  "Orders created",
                  style: TextStyle(fontSize: 15, color: Color(int.parse("0xff555555"))),
                ),
              ],),
            ),
            const SizedBox(height: 5),
            Expanded(
              child: ListView(
                children: [
                  SingleChildScrollView(
                    child: buildAddedItems(context, widget.orderItems),
                  ),
                ],
              ),
            )
          ],
        )
    );
  }
}

Widget buildAddedItems(BuildContext context, List<OrderItems> orderItems) {
  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: orderItems.map((orderItem) {

      int index = orderItems.indexOf(orderItem);
      String creationDate = DateFormat("dd MMM yyyy").format(DateTime.parse(orderItem.createdAt));

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
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Order ${index+1}",
                style: TextStyle(
                  color: Color(int.parse("0xff555555")),
                ),
              ),
              const SizedBox(height: 4),
              Text("Ordered on: $creationDate"),
              const SizedBox(height: 4),
              Text(
                "Status: ${orderItem.status}",
                style: TextStyle(
                  color: getColorBasedOnStatus(orderItem.status),
                ),
              ),
          ],),
          const Spacer(),
          Text("Order value: ${orderItem.totalPrice}"),
          const SizedBox(width: 14),
        ],),
      );
    }).toList(),
  );
}


class OrderBuilder extends StatefulWidget {
  const OrderBuilder({super.key});

  @override
  State<OrderBuilder> createState() => _OrderBuilderState();
}

class _OrderBuilderState extends State<OrderBuilder> {


  final Future<List<OrderItems>> _calculation = getOrdersCreated();

  @override
  Widget build(BuildContext context) {
    // return Orders(orderItems: getDummyData());
    return FutureBuilder<List<OrderItems>>(
        future: _calculation, // a previously-obtained Future<String> or null
        builder: (BuildContext context, AsyncSnapshot<List<OrderItems>> snapshot) {
          Widget children;
          if (snapshot.hasData) {
            // children = Orders(orderItems: getDummyData());
            children = Orders(orderItems: snapshot.data??[]);
          } else if (snapshot.hasError) {
            children = Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
              const Icon(
                Icons.error_outline,
                color: Colors.red,
                size: 60,
              ),
              Padding(
                padding: const EdgeInsets.only(top: 16),
                child: Text('Error: ${snapshot.error}'),
              ),
            ]);
          } else {
            children = const Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
              SizedBox(
                width: 60,
                height: 60,
                child: CircularProgressIndicator(),
              ),
              Padding(
                padding: EdgeInsets.only(top: 16),
                child: Text(
                  'Loading your orders...',
                  textAlign: TextAlign.center,
                ),
              ),
            ]));
          }
          return children;
        },
      );
  }
}

Color getColorBasedOnStatus(String status) {
  if(status == "Pending") {
    return Color(int.parse("0xff0047AB"));
  } else if(status == "Completed") {
    return Color(int.parse("0xff008000"));
  } else {
    return Color(int.parse("0xffD22B2B"));
  }
}

Map<String, int> getOrderDetails(List<OrderItems> orderItems) {
  int totalEarningsCompleted = 0;
  int upcomingEarnings = 0;
  int ordersCompleted = 0;
  int numberOfPendingOrders = 0;
  for(var orderItem in orderItems) {
    if(orderItem.status == "Pending") {
      numberOfPendingOrders = numberOfPendingOrders + 1;
      upcomingEarnings = upcomingEarnings + orderItem.totalPrice;
    } else if(orderItem.status == "Completed") {
      ordersCompleted = ordersCompleted +1;
      totalEarningsCompleted = totalEarningsCompleted + orderItem.totalPrice;
    }
  }
  return {
    "totalEarningsCompleted": totalEarningsCompleted,
    "upcomingEarnings": upcomingEarnings,
    "ordersCompleted": ordersCompleted,
    "numberOfPendingOrders": numberOfPendingOrders
  };
}