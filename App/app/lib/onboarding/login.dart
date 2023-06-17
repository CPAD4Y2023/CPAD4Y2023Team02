import 'package:flutter/material.dart';
import 'package:get_storage/get_storage.dart';
import 'package:flutter/services.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

import '../api/user_requests.dart';
import '../model/auth_model.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {

  bool isLoading = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(int.parse("0xffffffff")),
      resizeToAvoidBottomInset: false,
      body: SingleChildScrollView(child: SafeArea(
        child: Column(
          children: [
            Stack(
              children: [
                const HeadingText('Hello There.'),
                Padding(
                  padding: const EdgeInsets.fromLTRB(18.0, 0.0, 0.0, 0.0),
                  child: Image.asset(
                    "images/onbording/leaf.png",
                    fit: BoxFit.contain,
                    height: 400.0,
                    width: 600.0,
                  ),
                )
              ],
            ),
            const SizedBox(height: 36),
            const GreenEmailInputField(),
            const SizedBox(height: 36),
            const GreenPasswordInputField(),
            const SizedBox(height: 40),
            SizedBox(
              width: 150,
              child: TextButton(
                style: ButtonStyle(
                  foregroundColor:
                      MaterialStateProperty.all<Color>(Colors.green),
                  textStyle: MaterialStateProperty.all<TextStyle>(
                    const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight
                            .w300), // Set the desired font size for the button
                  ),
                  shape: MaterialStateProperty.all<OutlinedBorder>(
                    RoundedRectangleBorder(
                      // Set the desired outline color
                      side: const BorderSide(color: Colors.green),
                      borderRadius: BorderRadius.circular(
                          20), // Set the desired border radius
                    ),
                  ),
                ),
                onPressed: () async {
                  final box = GetStorage();
                  String text = "";
                  if (box.read('email') == null || box.read('email') == "") {
                    text = "Please enter email";
                  } else if (box.read('password') == null ||
                      box.read('password') == "") {
                    text = "Please enter password";
                  }
                  if (text == "") {
                    // Map<String, dynamic>? userDetails = await login("2020hs70041@wilp.bits-pilani.ac.in", "bitstechie@123");
                    Map<String, dynamic>? userDetails = await login(box.read('email'), box.read('password'));
                    Provider.of<UserAuthModel>(context, listen: false).saveUserDetails(
                      userDetails?["first_name"],
                      userDetails?["last_name"],
                      userDetails?["email"],
                      DateFormat("dd MMM yyyy").format(DateTime.parse(userDetails?["createdAt"])),
                    );

                  } else {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                        content: Text(text),
                        behavior: SnackBarBehavior.floating,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(5.0))));
                  }
                },
                child: const Text("Login"),
              ),
            )
          ],
        ),
      ),),
    );
  }
}

class HeadingText extends StatelessWidget {
  final String text;

  const HeadingText(this.text, {super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(10.0, 220.0, 0.0, 0.0),
      child: Text(
        text.replaceAll(' ', '\n'),
        style: const TextStyle(
          fontSize: 74,
          color: Colors.green,
          fontWeight: FontWeight.bold,
        ),
      ),
    );
  }
}

class GreenEmailInputField extends StatefulWidget {
  const GreenEmailInputField({super.key});

  @override
  _GreenEmailInputFieldState createState() => _GreenEmailInputFieldState();
}

class _GreenEmailInputFieldState extends State<GreenEmailInputField> {
  final box = GetStorage();
  final TextEditingController _emailController = TextEditingController();

  @override
  void initState() {
    super.initState();
    String savedEmail = box.read('email')?? '';
    _emailController.text = savedEmail;
  }

  void handleEmailInputChange(String value) {
    setState(() {
      box.write('email', value);
    });
  }

  @override
  void dispose() {
    _emailController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 340,
      child: TextField(
        controller: _emailController,
        style: const TextStyle(color: Colors.green),
        inputFormatters: [
          FilteringTextInputFormatter.allow(RegExp('[a-zA-Z@.0-9]')),
          LengthLimitingTextInputFormatter(40),
        ],
        onChanged: handleEmailInputChange,
        decoration: const InputDecoration(
          labelText: 'Email ID',
          prefixIcon: Icon(
            Icons.email_outlined,
            color: Colors.green,
          ),
          labelStyle: TextStyle(color: Colors.green),
          enabledBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Colors.green),
          ),
          focusedBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Colors.green, width: 2.0),
          ),
        ),
      ),
    );
  }
}

class GreenPasswordInputField extends StatefulWidget {
  const GreenPasswordInputField({super.key});

  @override
  _GreenPasswordInputFieldState createState() =>
      _GreenPasswordInputFieldState();
}

class _GreenPasswordInputFieldState extends State<GreenPasswordInputField> {
  final box = GetStorage();
  final TextEditingController _passwordController = TextEditingController();

  @override
  void initState() {
    super.initState();
    String savedPassword = box.read('password')?? ''; 
    _passwordController.text = savedPassword;
  }

  void handlePasswordInputChange(String value) {
    setState(() {
      box.write('password', value);
    });
  }

  @override
  void dispose() {
    _passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 340,
      child: TextField(
        style: const TextStyle(color: Colors.green),
        controller: _passwordController,
        onChanged: handlePasswordInputChange,
        obscureText: true,
        decoration: const InputDecoration(
          labelText: 'Password',
          prefixIcon: Icon(
            Icons.lock_outline,
            color: Colors.green,
          ),
          labelStyle: TextStyle(color: Colors.green),
          enabledBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Colors.green),
          ),
          focusedBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Colors.green, width: 2.0),
          ),
        ),
      ),
    );
  }
}

class CircularProgressBar extends StatelessWidget {
  const CircularProgressBar({super.key});

  @override
  Widget build(BuildContext context) {
    return Positioned.fill(
      child: Container(
        color: Colors.black
            .withOpacity(0.5), // Add a semi-transparent black background
        child: const Center(
          child: CircularProgressIndicator(
            color: Colors.green,
          ),
        ),
      ),
    );
  }
}

void showCircularProgressBar(BuildContext context) {
  showDialog(
    context: context,
    barrierDismissible: false,
    builder: (BuildContext context) {
      return WillPopScope(
        onWillPop: () async => false,
        child: const Dialog(
          backgroundColor: Colors.transparent,
          elevation: 0,
          child: CircularProgressBar(),
        ),
      );
    },
  );
}
