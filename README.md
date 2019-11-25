# Student Review

Student Review is a web-based tool to help improving the group allocation process of university students. The tool allows student users to review

past group member base on how their behaviours mets five qualities: "Meeting Punctuality", "Effort", "Team Skills", "Technical Skills", and

"Contextual Skills". The result will be presented in the user's profile, giving others an overview


## Description





## install
Go to \ELEC5619\studentreview and mvn clean install with command line or Eclipse

The dependencies will all be installed automatically by the maven

## run
In Eclipse ,publish it to the tomcat and start the server

or

find .war package in \ELEC5619\studentreview\target and placed it into your tomcat\webapps\webapps and run bat.sh or any other way to start the

Tomcat


Now you can open your Chrome and type http://localhost:8080/sr to start your journey


## Test
Tests are implemented for all the domain classes and Dao classes except DataAddition(used to add sample data)

Use mvn test to see if the system pass all the unit tests
