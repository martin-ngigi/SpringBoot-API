# SPRINGBOOT API INTRODUCTIONS
## Requirements
- Youtube link -> https://www.youtube.com/watch?v=9SGDpanrc8U&ab_channel=Amigoscode
- Spring initializer -> https://start.spring.io/
- jdk - version 19
- Intellij
- Database -> Spring Data JPA i.e. PostgreSql(host: localhost, port: 5432)


- initializer url -> https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.1&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,data-jpa,postgresql

## mvn commands
- mvn clean
- mvn clean compile
- mvn test

## Tomcat
- Tomcat port: 8080

## Solving plugin errors:
- Now lets say I had 10 such plugins which didn't get resolve and among them the first was 'org.apache.maven.plugins:maven-site-plugin' I went to '.m2/repository/org/apache/maven/plugins/' and deleted the directory 'maven-site-plugin' and did a maven reimport again. Guess what, particular missing plugin got dowloaded. And I just followed similar steps for other missing plugins and all got resolved.
- link -> https://stackoverflow.com/questions/20496239/maven-plugins-can-not-be-found-in-intellij

## NB : 
- While opening the project in IDEA such as Intellij IDEA, open the last 'demo' file


## Killing a process in cmd:
- First determine process id occupied by that port i.e. port 8080 by running:<br>

      netstat -ano | findstr :8080
- Then kill the process

      netstat -ano | findstr :8080

## Layers 
- API layer - Controller (Contains GET, POST, PUT, DELETE)
- Service Layer - Business logic
- Data Access Layer - 

## API Layer
![SpringBootLayers](images/SpringBootLayers.PNG)

# Postgresql
- Download Postgresql DB latest version, install copy the password while installing.
- Copy "C:\Program Files\PostgreSQL\14\lib" and "C:\Program Files\PostgreSQL\14\bin" and paste them in environment variables path to enable psql command line. 
- login in command in terminal :

       psql -U postgres
- Password:

      1234
- Check/View all available databases

      postgres=# \l
- Create Database command:

      CREATE DATABASE Student;
      CREATE DATABASE martin;
- View all rows in db:

      postgres=# \du
## Creating user in postgres
- Switch to the postgres user and start the interactive terminal with (Though not working on windows):

      sudo -u postgres psql
- Use the following statement to create a user:

      CREATE USER martin WITH PASSWORD '1234';
- Grant all privileges to user 'postgres' and 'martin':
  
      GRANT ALL PRIVILEGES ON DATABASE Student TO postgres;
      GRANT ALL PRIVILEGES ON DATABASE Student TO martin;
- Check/View all available databases

       \l
- Connect to Student db:

      \c student;
- View all student relations:

      \d
- describe student relations:

      \d student