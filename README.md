## Controle de Biblioteca

Sistema que permitira o controle de emprestimos de livro


## Estrutura do sistema

- Abaixo temos o Diagrama de Domínios das Classes:

![picture](https://bitbucket.org/pabliciotgg/controle-de-biblioteca/raw/bf57b6393694557616b463e582137ec716d7d9af/diagrama.jpeg)

## Instrucoes

- Baixe o repositorio

- Na pasta "\.settings" Modifique o arquivo "org.eclipse.wst.common.project.facet.core.xml",
- na seguinte linha: <installed facet="jst.web" version="3.1"/>  para  <installed facet="jst.web" version="3.0"/>

### Banco de Dados
```bash
Crie no banco a tabela "controle_biblioteca" (sem aspas)
```

### Iniciando

#### Em Run As:

```bash
- Maven Clean & Maven Install
- Run on Server - Tomcat 7.0
```