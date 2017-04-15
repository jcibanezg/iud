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


