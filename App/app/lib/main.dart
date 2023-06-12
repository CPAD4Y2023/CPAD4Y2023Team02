import 'package:app/model/cartModel.dart';
import 'package:app/skeleton.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(providers: [
      ChangeNotifierProvider<CartViewModel>(create: (context) => CartViewModel()),
    ],
      child: const MaterialApp(
        home: Skeleton(),
      ),
    );
  }
}