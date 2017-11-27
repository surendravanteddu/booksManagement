# booksManagement
A simple books management application

Steps to setup
1. You need to have JDK 8, eclipse and maven installed on you computer. And also you need apache tomcat server. 
2. Clone the repository.
3. Goto eclipse and import this project as existing maven project. 
4. Add tomcat server to this project. 
5. Right click on the app, click on 'run as' and then click on 'run on server'.

Set up instructions video: https://www.screencast.com/t/lG6ibgKR9QC

In this project I am using mysql instance on amazon RDS. I have configured this project to connect to the dbInstance on aws RDS. So, you dont have to setup db on your local. I still added the sql dump in this repository. Credentials to connect to RDS is inside config.properties file which is in booksManagement/src/main/resources folder. Change credentials in that file if you want to connect to db on your local. I have used 'mysql workbench' to access db for this project.

This webservices is deployed on heroku. Api Endpoint: https://bmwebservices.herokuapp.com/

