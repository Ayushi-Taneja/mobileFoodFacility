MobileFoodFacility

An application which maintains food facility data of trucks or push carts based on location (longitude, latitude). 

#Functionalities currently supported are:
1. Search all permit data by applicant name
2. Search all permit data by Street name
3. Search all permit data on or before expiry date
4. Add a new truck/push cart data
5. Given a location find the closest non expired truck/push cart

#Technologies used:
1. Java spring boot
2. MongoDb to store permit data
3. Geo spatial query on truck location to find nearest
4. Docker to spin up the service by command line
5. Maven for dependency management
6. OpenAPI for maintaining a testable swagger-ui of controllers

#Challenges faced:
1. Links given in schedule column are not accesible and working daysHours data per food facility is generally blank and in different formats where present.
This prevented considering only working trucks/push_cart candidates for finding the closest.
2. Populate a new street column with text before ":" in location description column

#Future Improvements:
1. Seperate out read/write mongodb connections.
2. Add caching on the controller endpoints.
3. Docker file which includes mvn install and creating mongo index as well, to allow for one command run
4. Add tests

#Steps to setup and run the project
1. clone the repository -> git clone git@github.com:Ayushi-Taneja/mobileFoodFacility.git
2. checkout develop
3. Install maven on your local - https://www.baeldung.com/install-maven-on-windows-linux-mac
4. Install docker - https://docs.docker.com/engine/install/ 
5. run "bash start_service.sh"
6. The project should be up and running on your local. Can be tested on swagger http://localhost:8080/swagger-ui/index.html

Data referenced from - https://data.sfgov.org/Economy-and-Community/Mobile-Food-Facility-Permit/rqzj-sfat
