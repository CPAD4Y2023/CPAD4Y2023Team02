import 'package:app/api/user_requests.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class Profile extends StatefulWidget {
  const Profile({super.key});

  @override
  State<Profile> createState() => _ProfileState();
}

class _ProfileState extends State<Profile> {
  final Future<Map<String, dynamic>> _calculation = getUserDetails();

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<Map<String, dynamic>>(
        future: _calculation,
        builder: (BuildContext context, AsyncSnapshot<Map<String, dynamic>> snapshot) {
          List<Widget> children;
          if (snapshot.hasData) {
            String joinedOn = DateFormat("dd MMM yyyy").format(DateTime.parse(snapshot.data?['createdAt']));
            
            children = <Widget>[
              Image.asset("images/avatar.png", height: 140),
              Padding(
                padding: const EdgeInsets.fromLTRB(10, 64, 10, 5),
                child: Column(
                  children: [
                    Text(
                      "${snapshot.data?['first_name'].toString()?? ''} ${snapshot.data?['last_name'].toString()?? ''}",
                      style: const TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20
                      ),
                    ),
                    const SizedBox(height: 12),
                    Text(snapshot.data?['email'].toString()?? ''),
                    const SizedBox(height: 8),
                    Text("Joined the movement on: $joinedOn")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.fromLTRB(44, 64, 44, 0),
                // child: Text('Result: ${snapshot.data}'),
                child: Text(
                  'We want to take a moment to express our heartfelt gratitude for joining our platform and making a conscious effort to recycle waste with us. Your decision to be a part of our community is truly commendable, and we are thrilled to have you on board.',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    color: Color(int.parse("0xff777777"))
                  ),
                )
              ),
            ];
          } else if (snapshot.hasError) {
            children = <Widget>[
              const Icon(
                Icons.error_outline,
                color: Colors.red,
                size: 60,
              ),
              Padding(
                padding: const EdgeInsets.only(top: 16),
                child: Text('Error: ${snapshot.error}'),
              ),
            ];
          } else {
            children = const <Widget>[
              SizedBox(
                width: 60,
                height: 60,
                child: CircularProgressIndicator(),
              ),
              Padding(
                padding: EdgeInsets.only(top: 16),
                child: Text('Loading user details...'),
              ),
            ];
          }
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: children,
            ),
          );
        },
      );
  }
}