GET-ALL-ORDERS

curl -X GET \
  http://localhost:8090/api/orders \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 2afaf4d7-4869-bf6e-a39f-a466dfd4526e'
  
  
GET-ALL-PRODUCTS

curl -X GET \
  http://localhost:8090/api/products \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 9155b35c-ff00-0a28-86ab-92f691afa0af'
  

CREATE-ORDER

curl -X POST \
  http://localhost:8090/api/orders/create \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c53725ec-2bd7-d2ca-57aa-c9a94b2f2e13' \
  -d '{
	"productOrders": [{
		"product": {
		"id": 7
		},
		"quantity": 5
	}]
}'


CREATE-PRODUCT

curl -X POST \
  http://localhost:8090/api/products/create \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 6cff2860-eeb6-fcdd-36be-1b1915906746' \
  -d '{
		"products": [{
		"name": "Product-ABC",
		"price": 100
		},
		{
		"name": "Product-CDE",
		"price": 300
		
		}]
}'


UPDATE-ITEM-IN-CART
curl -X PUT \
  http://localhost:8090/api/cart/3 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d5857b1b-71e1-6e79-d993-0a1e09a0789f' \
  -d '{
	"productId": 2,
	"stock": 700,
	"userId": 1,
	"status": "NOT_PURCHASED"
}'


GET-CART-ITEMS
curl -X GET \
  http://localhost:8090/api/cart \
  -H 'cache-control: no-cache' \
  -H 'postman-token: cfd2f372-3cd3-916c-7f66-fd6dcb150ca7'
  
  
PAYMENT-REQUEST
curl -X POST \
  http://localhost:8090/api/payment \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 3e6fb8f6-0e45-0bff-ec99-e02432185d9f' \
  -d '{
	"initialPaymentRef": 1,
	"orderId": 7,
	"orderAmount": "900",
	"paymentMode": "CARD"
}'
