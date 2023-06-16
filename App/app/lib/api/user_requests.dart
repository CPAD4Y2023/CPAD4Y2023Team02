import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'package:app/api/api_env.dart';
import 'package:app/api/utils.dart';
import 'package:dio/dio.dart';

import '../data_constants/order_details.dart';
import '../model/auth_model.dart';

BaseOptions options = BaseOptions(
    baseUrl: BASE_URL,
);


// get user
Future<Map<String, dynamic>> getUserDetails() async {
  // remove afterwards
  await saveToken();
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/user");
  print(response.data.toString());

  return response.data;
}

// login
Future<void> login(String email, String password) async {

  HttpOverrides.global = CustomHttpOverrides();

  // dio.options.headers["x-approuter-authorization"] = "Bearer $token";
  Dio dio = Dio(options);
  dio.options.headers["grant_type"] = "password";
  dio.options.headers["Content-Type"] = "application/x-www-form-urlencoded";
  dio.options.headers["authorization"] = "'Basic '+ $base64Encode(utf8.encode('$email:$password'))";

  Response<dynamic> response = await dio.post(
    AUTH_URL,
    data: {
      "username": email,
      "password": password,
    }
  );

  print(response.data.toString());


  // final token = await getToken();
}



// create orders
Future<void> sendOrder(List<Map<String, dynamic>> orderItems) async {
  // remove afterwards
  await saveToken();
  var body = jsonEncode(orderItems);
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";
  dio.options.headers["contentTypeHeader"] = "application/json";

  Response<dynamic> response = await dio.post(
    "/manageRequest",
    data: body,
  );

  print(response.data.toString());
}

// get user
Future<List<OrderItems>> getOrdersCreated() async {
  // remove afterwards
  await saveToken();
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/manageRequest");

  List<dynamic> mapOfOrders = response.data as List<dynamic>;

  return fromJson(mapOfOrders);
}