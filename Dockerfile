FROM openjdk:17
EXPOSE 8080
ADD target/natflix.jar natflix.jar
ENTRYPOINT ["java","-jar","/natflix.jar"]