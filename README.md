## Controle de Biblioteca

Sistema que permitira o controle de emprestimos de livro

## Instrucoes

- Baixe o repositorio

- Na pasta "\.settings" Modifique o arquivo "org.eclipse.wst.common.project.facet.core.xml",
- na seguinte linha: <installed facet="jst.web" version="3.1"/>  para  <installed facet="jst.web" version="3.0"/>

### Importe o Banco de Dados
```bash
Obs.: arquivo "controle_biblioteca.sql" esta localizado na raiz do projeto
```

### Iniciando

#### Em Run As:

```bash
- Maven Clean & Maven Install
- Run on Server - Tomcat 7.0
```