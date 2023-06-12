import 'dart:async';
import 'dart:io';
import 'package:app/api/api_env.dart';
import 'package:dio/dio.dart';

import '../model/authModel.dart';

/** 
Here we create a custom subclass of HttpOverrides called
customHttpOverrides and override the createHttpClient method.
n the overridden method, we return a modified HttpClient instance
 with the badCertificateCallback set to always return true.
*////
class CustomHttpOverrides extends HttpOverrides {
  @override
  HttpClient createHttpClient(SecurityContext? context) {
    return super.createHttpClient(context)
      ..badCertificateCallback = (X509Certificate cert, String host, int port) => true;
  }
}

Future<void> getUserDetailsOnLogin() async {
  // remove afterwards
  await saveToken();
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  BaseOptions options = BaseOptions(
    baseUrl: BASE_URL,
  );

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/user");

  print(response.data.toString());
}