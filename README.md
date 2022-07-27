# smartaviator

## This is a simple Spring Boot application  
### Allowing you to search for flights and luggage in a prefilled test database!  

![Airplane and Jets Flying in the Blue Sky](readme-pic.jpg)


## Usage: 💡

0) Build the project f.e. using gradle wrapper:
> $ ./gradlew build -x test

1) **Start the application**. Start up the postgres database container and smartaviator container 
(assuming your have docker installed on your system). Run 🏃 :
> $ docker-compose up

2) Populate the database with exemplary data saved in .json files by **sending**:
> POST localhost:8080/init  

3) Test ✈️the application by sending GET requests to cargo with either ...

* to get cargo, baggage and total weight of searched flight:
> GET localhost:8080/cargo?flightNumber=2741&date=2018-03-31T06:52:28Z

* to search with iata code:
> GET localhost:8080/cargo?iata=LUX&date=2018-03-31T06:52:28Z


 ## Instructions 
 
You can find the instructions in PDF file located in project root folder.
> ./docu.pdf  
  