## Controle de Biblioteca

Sistema que permitira o controle de emprestimos de livro

## Versão Sprint 3
 https://bitbucket.org/pabliciotgg/controle-de-biblioteca/src/v2.0.0/


## Estrutura do sistema

- Abaixo temos o Diagrama de Domínios das Classes:

![picture](https://bitbucket.org/pabliciotgg/controle-de-biblioteca/raw/a5502e4db27931d24a2d6d1d92a3a7bcfc2df088/diagrama.jpeg)

## Instrucoes

- Baixe o repositorio

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