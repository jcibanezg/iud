# Development Rest Service with Spring Boot, Travis and Heroku 

## Objective

The main objective of this repository is to create a Rest Service with Spring-boot, upload it to Github, use Travis as ALM and deploy in Production (Internet) through Heroku

## Generating our spring-boot project
It is useful to use the tool provided by Spring: http://start.spring.io/

This way we can not start from 0 to create our project.

When generating the project we can download a zip with the name "iud.zip", for example.
```
unzip iud.zip
cd iud
mvn clean install
java -jar target/*.jar
```
## Implement Rest Service

In version 1.0 a basic implementation of a Rest service. 
There are many repositories with examples of creation of Services Rest with Spring-boot and we will go deepening in the improvement of the same.

The endpoints that we are going to publish are the following:
#### Endpoints

| Method | Url | Description |
| ------ | --- | ---------- |
| GET    |/api/user/getall  | Return all users |
| GET    |/api/user/get/{id}  | Return user for id |
| POST    |/api/user/create  | Create user |
| PUT    |/api/user/update  | Update and Return user |
| DELETE    |/api/user/remove/{id}  | Delete user |

### TDD oriented development
It is interesting to start the developments by creating the tests that will make our application more robust. These tests can be oriented to both service layer and endpoint.

```
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
  @Autowired
  private UserService userService;

  @Test
  public void createUserSuccessfuly() throws Exception {
  ...
  }
  @Test
  public void removeUserSuccessfuly() throws Exception {
  ...
  }
  @Test
  public void updateUserSuccessfuly() throws Exception {
  ...
  }
  @Test
  public void getAllUserSuccessfuly() throws Exception {
  ...
  }  
}
```

## Continuous integration with Travis
Whenever you've worked with Continuous Integration processes like Jenkins or Bamboo, when you do not have them you think how important they are.
Therefore, to realize our developments we need to guarantee our deliveries in the cloud and for this does not help Travis.
Travis is free for Open Source projects you deploy on GitHub, for example. In its website you have all the details: https://travis-ci.org/

It also does not allow to automatically deploy, for example, in Heroku, which does not allow closing our ALM in the cloud. Allowing us to try our deployed service

The file that allows us to do this continuous integration is a file that we have to have at the root of our project: .travis.yml

```
language: java
jdk:
 - oraclejdk8
before_install:
 - chmod +x mvnw
deploy:
 provider: heroku
 api-key: 
  secure: $HEROKU_API_KEY
 app: nameAppOrService
````
"HEROKU_API_KEY": It will be an environment variable within our Travis project, whose value can be obtained from our Heroku account (https://dashboard.heroku.com/account - API KEY)

## Deployment in the cloud with Heroku
Certainly the last thing discussed in the previous point is what we need for Travis to automatically deploy to Heroku our application or service.
In the following URL we can see the domain that we have been assigned to access our application:
https://dashboard.heroku.com/apps/nameAppOrService/settings

But it will be something of the style:

https://nameAppOrService.herokuapp.com/

I hope you have been useful to see that we can try a service in the cloud without spending anything and see that we are able to do so.
