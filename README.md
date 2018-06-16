## Controle de Biblioteca

Sistema que permitira o controle de emprestimos de livro

## Versão Sprint 3
 https://bitbucket.org/pabliciotgg/controle-de-biblioteca/src/v2.0.0/


## Estrutura do sistema

- Abaixo temos o Diagrama de Domínios das Classes:

![picture](https://bitbucket.org/pabliciotgg/controle-de-biblioteca/raw/bf57b6393694557616b463e582137ec716d7d9af/diagrama.jpeg)

## Instrucoes

- Baixe o repositori

- Na pasta "\.settings" Modifique o arquivo "org.eclipse.wst.common.project.facet.core.xml",
- na seguinte linha: <installed facet="jst.web" version="3.1"/>  para  <installed facet="jst.web" version="3.0"/>

### Banco de Dados
```bash
Crie um banco controle_biblioteca
```

### Iniciando

#### Em Run As:

```bash
- Maven Clean & Maven Install
- Run on Server - Tomcat 7.0
```