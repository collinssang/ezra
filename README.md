# ezra

Java task A.  The program is written using java spring boot. 
Clone the project to your local machine. the jdk version is version 17. 
database using is Postgres. Login to your postgress database and create a schema in my case named "ezra"

open the cloned project folder using your preffered IDEA, preferably intellij (used when developing) and 

run the application and by default it will create tables and insert initial values at the data.sql. 
from the sql, it shows there are 5 lifts and the building is of 6 floors. and lift is bond to have status of different nature. 

When the application starts we initialise and start the elevator thread as a singleton from BuildingServiceHelper

# REST API

BuildingController has REST API related to the elevator call made from each floor

    PUT /building/up/{floorNo}: Used to call a lift to go up from the floor with number as floorNo
    PUT /building/down/{floorNo}: Used to call a lift to go down from the floor with number as floorNo

ElevatorController has REST API related to the elevator call made from the inside of the elevator

    PUT /elevator/{elevatorId}/goto/{floorNo}: called when a person inside the elevator press a button to goto a floor
    GET /elevator/{elevatorId}/status: To get the status of the elevator identified by the elevatorId
    PUT /elevator/{elevatorId}/stop: To stop the elevator identified by the elevatorId
    
# Test CASE
    
    i have created a test case Class ElevatorTest to test the elevator simulation 
