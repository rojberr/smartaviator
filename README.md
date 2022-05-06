# smart4aviation

## This is a simple Spring Boot application

![Airplane and Jets Flying in the Blue Sky](readme-pic.jpg)


## Usage:

1) Start up the postgres database container (assuming your have docker installed on your system) by running from repo main folder:
> $ docker-compose up
2) Start the application. I usually run it with IntelliJ (open project and start App class)  
4) Populate the database with exemplary data saved in .json files:
> SEND POST localhost:8080/init
5) Test the application by sending GET requests to cargo with either:
> GET localhost:8080/cargo?flightNumber=2741&date=2018-03-31T06:52:28Z  
 ... to get cargo, baggage and total weight of searched flight,  

or:
> GET localhost:8080/cargo?iata=LUX&date=2741&date=2018-03-31T06:52:28Z
 ... to get ...
 
 ## Instructions
 
 You can find the instructions in PDF file located in project root folder.
 
