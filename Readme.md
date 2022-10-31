# Natflix
Project 5


## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Documents](#documents)
* [Run](#run)


# Introduction
Natflix is an online streaming platform for movies, series, and documentaries.
It is an web based applicatipn with React in frontend and Springboot in backend.
The user can login to the platform and select various contents like Movies, Series and Documentaries.
The user will the able to filter ane search contents and aslo play contents.

The Admin user will be able to add new contents and also update existing contents.



## Technologies
Project is created with:
* node 16.11.62 Version
* React 18.0.21 version
* TypeScript 4.8.4 version
* Java 17
* Spring Boot 2.7.4
* MySQL 8 - AWS RDS
* AWS S3
* Docker

## Project mamnagement Documents
Project Management Documents:
- [Architecture Diagram](https://github.com/rashmoni/Natflix/blob/main/ProjectManagement/Architecture.pdf)
- [UseCase Diagram](https://github.com/rashmoni/Natflix/blob/main/ProjectManagement/UseCase.pdf)
- [Product Backlog](https://github.com/rashmoni/Natflix/blob/main/ProjectManagement/Product_Backlog_Natflix.xlsx)
- [Create AWS S3 bucket](https://github.com/rashmoni/Natflix/blob/main/ProjectManagement/Steps%20to%20Create%20AWS%20S3%20bucket.docx)
- [Create AWS RDS](https://github.com/rashmoni/Natflix/blob/main/ProjectManagement/Steps%20to%20Create%20AWS%20RDS.docx)

## Run
To run this application do the following steps.
1. git clone https://github.com/rashmoni/Natflix
2. cd Natflix
3. mvn install
4. docker compose up
5. Access the application on port 8080.

NOTE -  Due to AWS security requirement, I have to disabled the access key id of the S3 bucket.
This means that update, delete and add new content features will not work. Please ping me before testing the application and I will provide separate access key which you can place in application.properties file and access use al the features.

This one is inactive, I will provide new one separately -
<img width="892" alt="Screenshot 2022-10-31 at 15 03 14" src="https://user-images.githubusercontent.com/91156734/199026724-dd5eb154-52dc-4a33-a7f0-0e0987dacac4.png">




## Folder structure -
/Natflix
 - src 
 - docker-compose.yml
 - Dockerfile
 - pom.xml


