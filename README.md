## java-exercises
<b> Algorithmic exercises and challenges implemented in Java 11. </b>

Quiz sources:  
&emsp;	https://edabit.com/challenges/java <br>
&emsp;	https://www.hackerrank.com/

Levels: Very Hard, Expert

All challenges have been developed from scratch without checking the solutions. <br>
Each challenge has been implemented in a distinct Java class with a public static method 
and contains corresponding unit tests in the test folder. <br>
Example: <br>
`Brick.java (challenge) -> BrickTest.java (unit tests)`
 
### Update 19/4/2021 - repo on steroids 🔴 

This repo has been significantly enhanced, containing a complete Spring boot application, with controllers, utility classes, integration tests etc. <br>
All quizzes are still here, under the `quiz` package.

##### MongoDB Atlas Integration
The repo contains a MongoService that integrates with a MongoDB in Atlas. In order to successfully connect, a VM option has to be added: <br>
`-Djdk.tls.client.protocols=TLSv1.2` <br>
For more info read <a href="https://developer.mongodb.com/community/forums/t/sslhandshakeexception-should-not-be-presented-in-certificate-request/12493">here</a>

##### Run tests from terminal
* Run **unit tests** only <br>
  `mvn test`
* Run **all tests** (unit & integration) <br>
  `mvn verify -Djdk.tls.client.protocols=TLSv1.2`
  