You can also read this document in [portuguese](README.md).

# API for create, read, update and delete clients, deliverys and deliverys occurrences.

It was developed along with the course Mergulho Spring Rest by AlgaWorks, you can see the original repository clicking [here](https://github.com/algaworks/curso-mergulho-spring-rest).

Uses the following technologies: <br>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/>
<img src="https://img.shields.io/badge/Lombok-ED8B00?color=red&style=for-the-badge&logo=lombok"/>
<img src="https://img.shields.io/badge/Flyway-ED8B00?color=blue&style=for-the-badge&logo=flyway"/>
<br/>
<br/>

## Things i learned:
<br/>

- HTTP request mapping inside API. <br/>
- Embed a class¹ in class² without creating the table¹ in database, using the @Embeddable and @Embedded annotation . <br/>
- Database versioning using Flyway.. <br/>
- Handling of HTTP reponse codes(201, 404...). <br/
- Use of ModelMapper library for Model <> DTO conversion. <br/>
- Boilerplate code reduced with Lombok. <br/>
<br/>
<br/>

## Things i changed from the original project: 
<br/>

- Correction of the access flow of repository, service and control classes, in the original design control layer depended on both the service and repository layers, crossing the responsibility of the service layer. <br/>
- Create of DTO classes instead of RepresentationalModel and Input classes.
