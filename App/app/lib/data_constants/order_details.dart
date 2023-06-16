
class OrderItems{
  final String vendorId;
  final int totalPrice;
  final String status;
  final String createdAt;

  OrderItems({ required this.vendorId, required this.totalPrice, required this.status, required this.createdAt });
}

const jsonData = [
    {
        "vendorId": "01",
        "totalPrice": 20,
        "status": "Pending",
        "createdAt": "2023-06-15T10:05:43.000Z",
        "updatedAt": "2023-06-15T10:05:43.000Z"
    },
    {
        "reqId": "32098865-29ee-47e7-b797-4416a38ecf42",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 4,
        "status": "Pending",
        "createdAt": "2023-06-15T09:56:36.000Z",
        "updatedAt": "2023-06-15T09:56:36.000Z"
    },
    {
        "reqId": "501712ca-8a7c-4bc8-82f6-730d491a5a9b",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 4,
        "status": "Completed",
        "createdAt": "2023-06-07T12:54:26.000Z",
        "updatedAt": "2023-06-07T12:54:26.000Z"
    },
    {
        "reqId": "56ce5bdb-e9b5-4c70-a932-9b8804534522",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 18,
        "status": "Rejected",
        "createdAt": "2023-06-15T10:01:49.000Z",
        "updatedAt": "2023-06-15T10:01:49.000Z"
    },
    {
        "reqId": "7b773003-9d28-43d8-89fb-6f406ef5352e",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 14,
        "status": "Completed",
        "createdAt": "2023-06-15T10:05:15.000Z",
        "updatedAt": "2023-06-15T10:05:15.000Z"
    },
    {
        "reqId": "c61a8b9e-45d6-442e-b2c0-42a1ed93549e",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 4,
        "status": "Completed",
        "createdAt": "2023-06-07T13:33:55.000Z",
        "updatedAt": "2023-06-07T13:33:55.000Z"
    },
    {
        "reqId": "f7e3a80f-973c-48d4-8abb-cde9417112d9",
        "userId": "b8af514d-08ac-4554-b0c0-52f313c9a9e0",
        "vendorId": "01",
        "totalPrice": 4,
        "status": "Completed",
        "createdAt": "2023-06-07T13:34:00.000Z",
        "updatedAt": "2023-06-07T13:34:00.000Z"
    }
];

List<OrderItems> getDummyData() {
  return fromJson(jsonData);
}



List<OrderItems> fromJson(List<dynamic> jsonItems) {
  List<OrderItems> orderItems = [];
  for(var orderItem in jsonItems) {
    orderItems.add(OrderItems(
      vendorId: orderItem['vendorId'] as String,
      totalPrice: orderItem['totalPrice'] as int,
      status: orderItem['status'] as String,
      createdAt: orderItem['createdAt'] as String,
    ));
  }
  return orderItems;
}