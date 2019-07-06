# The Retail Store Discounts

This application is for calculate discount for retail store according to different client types, item types, and bill total amount.

Tools : 
    - spring boot
    - Junit 5

## Installation

This maven project can be used by any IDE just clone the project and open it as a maven project.

To install (create jar file), and run test cases use the following maven command

```maven
mvn clean install
```

To run jar file 

```cmd
java -jar [jar name]
```

## Usage

Open url 

```URL
localhost:8080/swagger-ui.html
```
try out the service [/bill/calculateDiscount] you can use following body request or you can change it 

```json
{
  "client": {
    "clientType": "AFFILIATE",
    "id": 1,
    "name": "Ahmed",
    "registrationDate": "2019-07-06T11:16:20.385Z"
  },
  "items": [
    {
      "grocery": true,
      "id": 101,
      "name": "Apple",
      "price": 100,
      "quantity": 4
    },{
      "grocery": false,
      "id": 102,
      "name": "Mobile",
      "price": 150,
      "quantity": 4
    }
  ]
}
```

response will be like
```json
[15:25, 7/6/2019] مصطفى بكار2: "client": {
    "id": 1,
    "name": "Ahmed",
    "registrationDate": "2019-07-06T11:16:20.385+0000",
    "clientType": "AFFILIATE"
  },
  "totalPrice": 1000,
  "discount": 60,
  "discountBasedOnTotalAmount": 45,
  "netPayment": 895
}
```
