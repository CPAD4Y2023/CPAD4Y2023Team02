class User {
  late String firstName;
  late String lastName;
  late String email;
  late String createdAt;
  bool isAuthenticated = false;
  bool isOnboard = false;

  User({ required this.firstName, required this.lastName, required this.email, required this.createdAt, required this.isAuthenticated});
}