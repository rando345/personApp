Example solution for Moderan: Junior Full Stack developer exercise
done by Rando Tõnisson (randotonisson@gmail.com)

The application called personApp is written in java using maven and spring boot.
The database logic is based on H2 and is not saved between sessions (after closing the data is lost).

Starting the application:
1. locate the root folder of the application (personApp)
2. from command line run the following command: java -jar personApp-0.0.1-SNAPSHOT.jar
3. ctrl + c to terminate and close the application


The testing of the functionalities was done by using postman. Some examples below.

The POST endpoint /person (used to create persons in the DB)
POST request at localhost:8888/person/ with body:
{
	"person":"Siim Toomingas"
}

The GET endpoint /person?search=term (used to search for DB entries using the term provided)
GET request at localhost:8888/person?search=siim

There is an additional GET endpoint /person/all/ which lists all the person DB entries
GET request at localhost:8888/person/all/

