<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livro Page</title>
</head>
<body>
 <spring:url value="/livro/add" var="addURL" />
 <a href="${addURL }">Add Livro</a>

 <h1>Users List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>ISBN</th>
   <th>Titulo</th>
   <th>Autores</th>
   <th>Editora</th>
   <th>Ano de Publicação</th>
   <th>Edicao</th>
   <th>Paginas</th>
   <th>Area de Conhecimento</th>
   <th>Tema</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listLivros }" var="livro" >
   <tr>
    <td>${livro.id }</td>
    <td>${livro.titulo }</td>
    <td>${livro.autores }</td>
    <td>${livro.editora }</td>
    <td>${livro.anoPublicacao }</td>
    <td>${livro.edicao }</td>
    <td>${livro.paginas }</td>
    <td>${livro.areaConhecimento }</td>
    <td>${livro.tema }</td>
    <td>
     <spring:url value="/livro/update/${livro.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/livro/delete/${livro.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>