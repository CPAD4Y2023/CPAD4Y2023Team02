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
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/user");
  print(response.data.toString());

  return response.data;
}

// login
Future<Map<String, dynamic>?> login(String email, String password) async {

  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(BaseOptions(
    baseUrl: AUTH_URL,
  ));
  dio.options.headers["grant_type"] = "password";
  dio.options.headers["Content-Type"] = "application/x-www-form-urlencoded";
  dio.options.headers["authorization"] = "Basic ${base64Encode(utf8.encode('sb-recyclone!t160380:tmbgJN9ypZ261ZWC77OsrNKf2U0='))}";
  try{
  Response<dynamic> response = await dio.post(
    AUTH_URL,
    data: {
      "response_type": "token",
      "grant_type": "password",
      "username": email,
      "password": password,
    }
  );
  saveToken(response.data?["access_token"]);
  return await getUserDetails();
  } catch (error) {
    print(error);
  }
  return null;
}

// create orders
Future<int?> sendOrder(List<Map<String, dynamic>> orderItems) async {
  var body = jsonEncode(orderItems);
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";
  dio.options.headers["contentTypeHeader"] = "application/json";

  Response<Map<String, dynamic>> response = await dio.post(
    "/manageRequest",
    data: body,
  );

  print(response.data.toString());
  return response.statusCode;
}

// get user
Future<List<OrderItems>> getOrdersCreated() async {
  
  final token = await getToken();
  HttpOverrides.global = CustomHttpOverrides();

  Dio dio = Dio(options);
  dio.options.headers["x-approuter-authorization"] = "Bearer $token";

  Response<dynamic> response = await dio.get("/manageRequest");

  List<dynamic> mapOfOrders = response.data as List<dynamic>;

  return fromJson(mapOfOrders);
}