# test

Run `docker-compose up` to create PostgreSQL databases


### Running App

Run `mvn clean install`

Run `java -jar target/test-0.0.1-SNAPSHOT.jar`

Tomcat will start on port *8081*


### Running stress tests

Run `npm i -g artillery`

Run `artillery run flight.yaml`

Run `artillery run airport.yaml`

Run `artillery run aircraft.yaml`

Run `artillery run pilot.yaml`

###Look at api documentation

http://localhost:8081/swagger-ui.html

###In order to Get api token, to use the api services, you should to use the follow user:

## /login

user: test@test.com password: 123456
