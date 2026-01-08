├── Blog<br>
├── .gitattributes<br>
├── .mvn<br>
│   └── wrapper <br>
│   │   └── maven-wrapper.properties<br>
├── src<br>
│   ├── test<br>
│   │   └── java<br>
│   │   │   └── com<br>
│   │   │       └── BlogPlatform<br>
│   │   │           └── Blog<br>
│   │   │               └── BlogApplicationTests.java<br>
│   └── main<br>
│   │   ├── java<br>
│   │       └── com<br>
│   │       │   └── BlogPlatform<br>
│   │       │       └── Blog<br>
│   │       │           ├── Repositories<br>
│   │       │               └── UserRepository.java<br>
│   │       │           ├── Entity<br>
│   │       │               ├── ApiResponse.java <br>
│   │       │               ├── Comment.java<br>
│   │       │               ├── User.java<br>
│   │       │               └── Post.java<br>
│   │       │           ├── BlogApplication.java<br>
│   │       │           ├── Payloads<br>
│   │       │               └── UserDto.java<br>
│   │       │           ├── services<br>
│   │       │               ├── UserService.java<br>
│   │       │               └── UserServiceImpl.java<br>
│   │       │           ├── ExceptionHandling<br>
│   │       │               ├── ResourceNotFoundException.java<br>
│   │       │               └── GlobalExceptionHandler.java<br>
│   │       │           ├── Config<br>
│   │       │               └── UserDtoMapper.java<br>
│   │       │           └── controller<br>
│   │       │               └── UserController.java<br>
│   │   └── resources<br>
│   │       └── application.properties<br>
├── .gitignore<br>
├── pom.xml<br>
├── mvnw.cmd<br>
└── mvnw<br>