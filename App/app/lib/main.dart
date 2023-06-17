import 'package:app/model/auth_model.dart';
import 'package:app/model/cart_model.dart';
import 'package:app/skeleton.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';





void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  final Future<String?> _calculation = getToken();

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(providers: [
      ChangeNotifierProvider<CartViewModel>(create: (context) => CartViewModel()),
      ChangeNotifierProvider<UserAuthModel>(create: (context) => UserAuthModel()),
    ],
      child: const MaterialApp(
        home: Skeleton(),
      ),
    );

    // return MultiProvider(providers: [
    //   ChangeNotifierProvider<CartViewModel>(create: (context) => CartViewModel()),
    //   ChangeNotifierProvider<UserAuthModel>(create: (context) => UserAuthModel()),
    // ],
    //   child: MaterialApp(
    //     home: FutureBuilder<String?>(
    //     future: _calculation, // a previously-obtained Future<String> or null
    //     builder: (BuildContext context, AsyncSnapshot<String?> snapshot) {
    //       if(snapshot.data!=null) {
    //         return const Skeleton();
    //       } else {
    //         return const OnBordingScreen();
    //       }
    //     }),
    //   ),
    // );
  }
}