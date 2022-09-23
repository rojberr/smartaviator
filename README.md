# smartaviator

## This is a simple Spring Boot application  
### Allowing you to search for flights and luggage in a prefilled test database! 🛫 👨🍸 🛬

![Airplane and Jets Flying in the Blue Sky](assets/readme-pic.jpg)


## Usage: 💡

0) Build the project f.e. using gradle wrapper:
```bash 
./gradlew build -x test
```

1) **Start the application**. Start up the postgres database container and smartaviator container 
(assuming your have docker installed on your system). Run 🏃 :
```bash
docker-compose up
```

2) Populate the database with exemplary data saved in .json files by **sending**:
 ```bash
POST localhost:8080/init  
```

3) Test ✈️the application by sending GET requests to cargo with either ...

* to get cargo, baggage and total weight of searched flight:
```bash
GET localhost:8080/cargo?flightNumber=2741&date=2018-03-31T06:52:28Z
```

* to search with iata code:
```bash
GET localhost:8080/cargo?iata=LUX&date=2018-03-31T06:52:28Z
```
## Prometeus endpoints

This API includes 2 endpoints for Prometheus:
- `localhost:9000/actuator/metrics` to navigate under metrics,
- `localhost:9000/actuator/prometeus` with format that Prometheus is expecting and scrapes from.
(remember to configure the Prometheus accordingly)
Those endpoints will show f.e. how many request are taken and how long do they last, and if they were successful.

## Requirements for this API 📋
 
You can find the requirements in `PDF` file located in project root folder.
> ./docu.pdf  
  