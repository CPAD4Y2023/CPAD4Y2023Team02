import 'package:flutter_secure_storage/flutter_secure_storage.dart';

// creating secure store
const storage = FlutterSecureStorage();

const token = "eyJhbGciOiJSUzI1NiIsImprdSI6Imh0dHBzOi8vZGEwZjZhNmF0cmlhbC5hdXRoZW50aWNhdGlvbi51czEwLmhhbmEub25kZW1hbmQuY29tL3Rva2VuX2tleXMiLCJraWQiOiJkZWZhdWx0LWp3dC1rZXktNjI3MzQ5NzY3IiwidHlwIjoiSldUIiwiamlkIjogImFXUkNFU210VUZ5cXYyL0xCM2Q4YWxmTzgvakpxN1JVUkdBazBXR1oreWM9In0.eyJqdGkiOiI3ODkzYTYwOTM1ZjE0ZWY2YWYzNmFhZmIzNzQ4YTFhYiIsImV4dF9hdHRyIjp7ImVuaGFuY2VyIjoiWFNVQUEiLCJzdWJhY2NvdW50aWQiOiI5Nzk1NjBkZi1mOWI0LTQ2NjctODlkNi03MWRlZTVmNmQxMTciLCJ6ZG4iOiJkYTBmNmE2YXRyaWFsIiwib2lkY0lzc3VlciI6Imh0dHBzOi8vYWNjb3VudHMuc2FwLmNvbSJ9LCJ4cy5zeXN0ZW0uYXR0cmlidXRlcyI6eyJ4cy5yb2xlY29sbGVjdGlvbnMiOltdfSwiZ2l2ZW5fbmFtZSI6ImJpdHMyMDIwIiwieHMudXNlci5hdHRyaWJ1dGVzIjp7fSwiZmFtaWx5X25hbWUiOiJ0ZWNoaWUiLCJzdWIiOiJiOGFmNTE0ZC0wOGFjLTQ1NTQtYjBjMC01MmYzMTNjOWE5ZTAiLCJzY29wZSI6WyJvcGVuaWQiLCJ1YWEudXNlciJdLCJjbGllbnRfaWQiOiJzYi1yZWN5Y2xvbmUhdDE2MDM4MCIsImNpZCI6InNiLXJlY3ljbG9uZSF0MTYwMzgwIiwiYXpwIjoic2ItcmVjeWNsb25lIXQxNjAzODAiLCJncmFudF90eXBlIjoicGFzc3dvcmQiLCJ1c2VyX2lkIjoiYjhhZjUxNGQtMDhhYy00NTU0LWIwYzAtNTJmMzEzYzlhOWUwIiwib3JpZ2luIjoic2FwLmRlZmF1bHQiLCJ1c2VyX25hbWUiOiIyMDIwaHM3MDA0MUB3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiZW1haWwiOiIyMDIwaHM3MDA0MUB3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiYXV0aF90aW1lIjoxNjg2OTM5MDg0LCJyZXZfc2lnIjoiYWFlYjFkZTYiLCJpYXQiOjE2ODY5MzkwODQsImV4cCI6MTY4Njk4MjI4NCwiaXNzIjoiaHR0cHM6Ly9kYTBmNmE2YXRyaWFsLmF1dGhlbnRpY2F0aW9uLnVzMTAuaGFuYS5vbmRlbWFuZC5jb20vb2F1dGgvdG9rZW4iLCJ6aWQiOiI5Nzk1NjBkZi1mOWI0LTQ2NjctODlkNi03MWRlZTVmNmQxMTciLCJhdWQiOlsic2ItcmVjeWNsb25lIXQxNjAzODAiLCJ1YWEiLCJvcGVuaWQiXX0.B2rwOQ9OMdpIFX4N26s-Sfdg0z3MitnHsDA645_gKZNjn4vaXsKFAuD8Twjbv1SStDZ713SSN22C3GtrNx7ps0NpU3UEcOH0g8flOD0yGDQM9-Lw2Q3hn8cfWSxsndpJpsMj2_ic8R2RHlABQo073lyJd4v5I7_KaqM2gapvybhJzkarX_XJALf1YFR469y6VLhLMOjY8BMso7l6mTUUyve3Wg1GwfCvtERC3YCYnUGmWW-0mcun2JskgA6xXOq-muILxQqs8Sx-DRWtPd3-ntu2lHhk58cFHQm8NiRnBkrfumeZouB8uQdGggvgTmlbonX1-plH00ILH1q-QEzddA";

Future saveToken() async {
  await storage.write(key: 'token', value: token);
}

Future<String?> getToken() async {
  return await storage.read(key: 'token');
}