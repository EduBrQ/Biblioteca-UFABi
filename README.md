## Controle de Biblioteca

Sistema que permitira o controle de emprestimos de livro


## Estrutura do sistema

- Abaixo temos o Diagrama de Domínios das Classes:

![alt text](https://drive.google.com/file/d/1uUK5ykafRjM2lbrfOCSwCtkP3XGkqOVO/view?usp=sharing)


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