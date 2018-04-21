## Controle de Biblioteca

Sistema que permitirá o controle de empréstimos de livro

## Instruções

- Baixe o repositÃ³rio
```bash
	https://pabliciotgg@bitbucket.org/pabliciotgg/controle-de-biblioteca.git
```


- Crie Uma Base de Dados
```bash
CREATE DATABASE `jack_rutorial_demo`;

CREATE TABLE  `jack_rutorial_demo`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL DEFAULT '',
  `lastname` varchar(100) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```


- Insira o conector mysql

```bash
Properties -> Java Build Path -> Libraries -> Add External Libraries -> Aponte o Conector
```


- Atualize o Mavem

```bash
mavem -> update project
```


- Rode um Clean

```bash
Run As -> Maven clean
```

- Rode um Install

```bash
Run As -> Maven install
```


- Configure o Tomcat

```bash

Procure: 
<Context docBase="SpringMvcCRUDExample" path="/SpringMvcCRUDExample" reloadable="true" source="org.eclipse.jst.jee.server:SpringMvcCRUDExample" />

Substitua por: 

<Context docBase="<LOCAL DO PROJETO>\SpringMvcCRUDExample\target\SpringMvcCRUDExample-0.0.1-SNAPSHOT\" path="/SpringMvcCRUDExample" reloadable="true" >
        <Resource 
                    name="jdbc/springmvc" 
                    auth="Container" 
                    type="javax.sql.DataSource"
                    username="root" 
                     password="root" 
                     driverClassName="com.mysql.jdbc.Driver"
                     url="jdbc:mysql://localhost:3306/web"
                     maxActive="5" 
                     maxIdle="3" 
                      />
</Context>

```

- Starte o tomcat

```bash

Servers add tomcat -> run 

ou como queira iniciar
```

- Abra o navegador

```bash
http://localhost:8080/SpringMvcCRUDExample/user/list
```

