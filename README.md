# \[Spring Boot\] Order tracking

Proof of concept app done as part of a recruiting process. Runs over Spring Boot. **Maven required**.

### Usage

Go to the root of the project and run
```
./mvnw package && java -jar target/spring-boot-docker-0.0.1-SNAPSHOT.jar
```

App should start and listen on port `8080`. The relevant endpoint is `/order/tracking/`

If performing a `GET` request against it, a list in form of JSON will be returned with the data of all the current orders.

When performing a `POST`, the body of the request has to contain a JSON with the order tracking data. e.g.
```
{"orderTrackings": [
	{
		"orderId": 230688716,
		"trackingStatusId": 2,
		"changeStatusDate": "2019-01-27T07:18:23.108+00:00"
	},
	{
		"orderId": 953688716,
		"trackingStatusId": 2,
		"changeStatusDate": "2019-01-27T07:18:23.108+00:00"
	},
	{
		"orderId": 189688716,
		"trackingStatusId": 2,
		"changeStatusDate": "2019-01-27T07:18:23.108+00:00"
	}
]}
```

In my case I have leveraged `curl` to test:

* `GET`

```
curl localhost:8080/order/tracking/
```

* `POST` (trackingData.json file included in the repo)

```
curl -X POST -H "Content-Type: application/json" -d @trackingData.json localhost:8080/order/tracking/
```


### TODOs 
* Proper error handling (Invalid requests (5xx errors), 4xx errors)
* Sanitize content (JSON) receceived in the endpoint to detect invalid fields
* Store history of changes for a given Order Id
* Check dates when updating an order (update date > order last modification date)
* Log Invalid requests
* Log when an invalid statr transition tried to be done


