Restaurant Reservation System
Developer: Sharmila Kale  
Date- Wed 20th 2016			
		
Assumptions:
-------------
- rest service - Input/output JSON format is fix.
- Sort response/output JSON format is same as input
- Distance sort - use apache Vector3D commons-math3 3.0


Technology Stack
-----------------
Eclipse 4.5
java 1.8
maven 3.3.3
tomcat 8.0	- deployed/tested webservice on tomcat container 
jackson 
jersey		- RESTful webservice
Postman/Advance Rest Client (Chrome Browser)- Used for testing GET/POST for service calls


How to Run:
-------------
Step 1. Check out code from github https://github.com/sharmilakale/restaurant-repo branch module-final

Step 2. If you have eclipse, Import it as a maven project and run maven clean install
	   or browse checkout folder and run mvn clean install on Terminal (Provided maven is set in PATH)

Step 3.	Deploy newly built war to tomcat. 
		- For Eclipse IDE -> Right click on Project -> Run As -> Run on Server -> tomcat 
		- For Manual Deployment
			a. Browse maven target folder (resto-web/target/)
			b. Copy  resto-web-0.0.1-SNAPSHOT.war to 'tomcat/webapps/' folder
			c. Rename folder to resto-web
			d. Please note tomcat port number from conf/server.xml
			e. Start Tomcat server
			
Step 4. module-ui: My tomcat is running on port 8080.  http://localhost:8080/resto-web/#/home
	Note: 
	1. Default menu for all users (TODO: implement authorization and load menu based on user login)
	2. On Edit reservation screen, owner can manually assign table number. (TODO: Select table from restaurant map)

Step 5. module-api: services
	 ----------------------
		resto-web/api/reservations   — Get/Post reservation
		resto-web/api/reservations/{id}   — Get/Delete/Put reservation by id
		
		other APIs profiles, users, tables, userReservation, tableReservation.
				
Step 6. Sample JSON to create reservation
		Post /api/reservations
		----------------------
		a. Select method Post in Chrome Advance Rest Client 
		b. Set Header Raw to:  
				Content-Type:application/json
		c. Copy your custom json dataset in payload RAW:
			{
			  "reserveDate": "2016-01-21",
			  "reserveTime": "7:30 PM",
			  "noOfPeople": 6,
			  "status": null,
			  "tableNo": null,
			  "tableCapacity": null,
			  "customerName": "Anushka Patil",
			  "customerPhone": "229-909-9878",	
			  "customerEmail": "ani@sh.com"
			}



Thank you for the taking time to review.

.Sharmila
