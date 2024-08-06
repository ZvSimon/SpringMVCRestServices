### Send POST request with json body
POST http://localhost:8081/api/v1/beer
Content-Type: application/json

{

  "version": 8 ,
  "beerName": "Simon",
  "beerStyle": "PALE_ALE",
  "upc": "12345612",
  "quantityOnHand": 12222,
  "price": 120.99,
  "createdDate": "2024-08-05T23:39:32.575706",
  "updateDate": "2024-08-05T23:39:32.57572"
}

<> 2024-08-05T234213.200.json

### Send GET request
GET http://localhost:8081/api/v1/beer
Content-Type: application/json

<> 2024-08-05T235818.200.json
<> 2024-08-05T235636.200.json
<> 2024-08-05T235205.200.json
<> 2024-08-05T235134.200.json
<> 2024-08-05T234636.200.json
<> 2024-08-05T234620.200.json
<> 2024-08-05T234516.200.json
<> 2024-08-05T234325.200.json
<> 2024-08-05T234308.404.json

### SEND PUT request with json body
PUT http://localhost:8081/api/v1/beer/7776f7e1-5a24-4d88-bb0a-31278c07a908
Content-Type: application/json

{
  "version": 100,
  "beerName": "Simone",
  "beerStyle": "PALE_ALE",
  "upc": "123456120",
  "quantityOnHand": 122220,
  "price": 1200.99,
  "createdDate": "2024-08-05T23:39:32.575706",
  "updateDate": "2024-08-05T23:39:32.57572"
}

### SEND DELETE request
DELETE http://localhost:8081/api/v1/beer/22cc38bc-d14a-432f-9666-da97e8209fe6

### SEND PATCH request
PATCH http://localhost:8081/api/v1/beer/1718ac32-a032-4659-ab36-ad13bd8ebd95
Content-Type: application/json

{

  "beerName": "ZvSimon",
  "price": 1000
}
