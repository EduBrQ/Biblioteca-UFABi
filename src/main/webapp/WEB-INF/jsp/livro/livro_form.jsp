<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livro Form</title>
</head>
<body>
 <spring:url value="/livro/save" var="saveURL" />
 <form:form modelAttribute="livroForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>ISBN: </td>
    <td>
     <form:input path="isbn"/>
    </td>
   </tr>
   <tr>
    <td>Titulo: </td>
    <td>
     <form:input path="titulo"/>
    </td>
   </tr>
   <tr>
    <td>Autores: </td>
    <td>
     <form:input path="autores"/>
    </td>
   </tr>
    <tr>
    <td>Editora: </td>
    <td>
     <form:input path="editora"/>
    </td>
   </tr>
    <tr>
    <td>Ano de Publicação: </td>
    <td>
     <form:input path="anoPublicacao"/>
    </td>
   </tr>
    <tr>
    <td>Edição: </td>
    <td>
     <form:input path="edicao"/>
    </td>
   </tr>
    <tr>
    <td>Páginas: </td>
    <td>
     <form:input path="paginas"/>
    </td>
   </tr>
    <tr>
    <td>Área de conhecimento: </td>
    <td>
     <form:input path="areaConhecimento"/>
    </td>
   </tr>
    <tr>
    <td>Tema: </td>
    <td>
     <form:input path="tema"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>