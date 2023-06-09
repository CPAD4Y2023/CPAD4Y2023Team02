import 'package:app/model/auth_model.dart';
import 'package:app/onboarding/login.dart';
import 'package:app/onboarding/onbording.dart';
import 'package:app/orders/orders.dart';
import 'package:app/profile/profile.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'cart/cart.dart';
import 'home/home.dart';

class Skeleton extends StatefulWidget {
  const Skeleton({super.key});

  @override
  State<Skeleton> createState() => _SkeletonState();
}

class _SkeletonState extends State<Skeleton> {
  int _selectedIndex=0;
  static const TextStyle optionStyle = TextStyle(
    fontSize: 28, fontWeight: FontWeight.bold,
  );

  static const List<Widget> _widgetOptions = <Widget> [
    Home(),
    Cart(),
    OrderBuilder(),
    Profile(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<UserAuthModel>(builder: (context, viewModel, child) {
      bool isAuthenticated = viewModel.getAuthStatus();
      bool isOnboard = viewModel.isOnboard();
     return isAuthenticated? Scaffold(
      body: _widgetOptions.elementAt(_selectedIndex),
      backgroundColor: Color(int.parse("0xfff7f7f7")),
      bottomNavigationBar: 
        Container(
          decoration: const BoxDecoration(
            boxShadow: <BoxShadow>[
              BoxShadow(
                color: Color.fromRGBO(0, 0, 0, 0.1),
                blurRadius: 10,
              ),
            ],
          ),
          child: BottomNavigationBar(
            items: <BottomNavigationBarItem>[
              BottomNavigationBarItem(
                icon: Icon(Icons.home, color: Color(int.parse("0xff222222"))),
                activeIcon: const Icon(Icons.home),
                label: 'Home',
                backgroundColor: Color(int.parse("0xffffffff")),
              ),
              BottomNavigationBarItem(
                icon: Icon(Icons.shopping_cart, color: Color(int.parse("0xff222222"))),
                activeIcon: const Icon(Icons.shopping_cart),
                label: 'Cart',
              ),
              BottomNavigationBarItem(
                icon: Icon(Icons.list_alt, color: Color(int.parse("0xff222222"))),
                activeIcon: const Icon(Icons.list_alt),
                label: 'Orders',
              ),
              BottomNavigationBarItem(
                icon: Icon(Icons.person, color: Color(int.parse("0xff222222"))),
                activeIcon: const Icon(Icons.person),
                label: 'Profile',
              ),
            ],
            currentIndex: _selectedIndex,
            selectedItemColor: Colors.green,
            onTap: _onItemTapped,
          ),
        ),
    ): isOnboard? const LoginScreen(): const OnBordingScreen();
    });
  }
}