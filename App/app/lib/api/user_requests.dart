import 'dart:async';
import 'dart:io';
import 'package:app/api/api_env.dart';
import 'package:app/api/utils.dart';
import 'package:dio/dio.dart';

import '../model/authModel.dart';

BaseOptions options = BaseOptions(
    baseUrl: BASE_URL,
);
Dio dio = Dio(options);

Future<void> getUserDetailsOnLogin() async {
  // remove afterwards
  await saveToken();
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/user");

  print(response.data.toString());
}

Future<void> createOrder() async {
  // remove afterwards
  await saveToken();
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  dio.options.headers["x-approuter-authorization"] = "Bearer $token";
  dio.options.headers["contentTypeHeader"] = "application/json";

  Response<dynamic> response = await dio.post(
    "/manageRequest",
    data: 
  );

  print(response.data.toString());
}