import 'dart:io';

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