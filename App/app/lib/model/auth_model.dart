import 'package:app/data_constants/user_data.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

// creating secure store
const storage = FlutterSecureStorage();

Future saveToken(String token) async {
  await storage.write(key: 'token', value: token);
}

Future<String?> getToken() async {
  return await storage.read(key: 'token');
}


// model for provider of auth
class UserAuthModel extends ChangeNotifier {
  late final User _userDetails = User(email: '', lastName: '', firstName: '', createdAt: '', isAuthenticated: false);

  User? get userDetails => _userDetails;

  void onboarded () {
    _userDetails.isOnboard = true;
    notifyListeners();
  }

  bool isOnboard () {
    return _userDetails.isOnboard;
  }

  void saveUserDetails (String firstName, String lastName, String email, String createdAt) {
    _userDetails.email = email;
    _userDetails.firstName = firstName;
    _userDetails.lastName = lastName;
    _userDetails.createdAt = createdAt;
    _userDetails.isAuthenticated = true;
    notifyListeners();
  }

  void logout() {
    _userDetails.email = '';
    _userDetails.firstName = '';
    _userDetails.lastName = '';
    _userDetails.createdAt = '';
    _userDetails.isAuthenticated = false;
    notifyListeners();
  }

  bool getAuthStatus() {
    return _userDetails.isAuthenticated;
  }

  String getUsersFirstName () {
    return _userDetails.firstName;
  }
}