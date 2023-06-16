import 'package:flutter_secure_storage/flutter_secure_storage.dart';

// creating secure store
const storage = FlutterSecureStorage();

const token = "jwt";

Future saveToken() async {
  await storage.write(key: 'token', value: token);
}

Future<String?> getToken() async {
  return await storage.read(key: 'token');
}