Você pode ler esse documento também em [inglês](README-en.md).

# API para a criação, edição, atualização e deleção de clientes, entregas e ocorrências de entregas.

Foi desenvolvido junto ao curso Mergulho Spring Rest ministrado pela AlgaWorks, você pode acessar o repositório original clicando [aqui](https://github.com/algaworks/curso-mergulho-spring-rest).

Foi desenvolvido utilizando as seguintes tecnologias: <br>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/>
<img src="https://img.shields.io/badge/Lombok-ED8B00?color=red&style=for-the-badge&logo=lombok"/>
<img src="https://img.shields.io/badge/Flyway-ED8B00?color=blue&style=for-the-badge&logo=flyway"/>
<br/>
<br/>

## Coisas que aprendi:
<br/>

- Mapeamento de requisições HTTP dentro da API. <br/>
- Embutir uma classe¹ na classe² sem que haja necessidade de criar a tabela¹, usando a annotation @Embeddable e @Embedded. <br/>
- Versionar o banco de dados MySql com o Flyway. <br/>
- Tratamento de códigos de resposta HTTP (200, 404...). <br/>
- Uso da biblioteca ModelMapper para mapeamento Model <> DTO. <br/>
- Redução de código Boilerplate com o Lombok. <br/>
<br/>
<br/>

## Coisas que modifiquei em relação ao projeto original: 
<br/>

- Correção do fluxo de acesso das classes de repositório, serviço e controle, no projeto original camada de controle dependiam de ambas as camadas de serviço e repositório, cruzando a responsabilidade da camada de serviço. <br/>
- Criação de classes DTO em vez de modelo representacional e modelo de entrada de dados.
