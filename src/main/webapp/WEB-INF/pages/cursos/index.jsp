<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../template/header.jsp" />
<body>
	<jsp:include page="../template/topnavbar.jsp" />

	<div class="page-container row-fluid">


		<jsp:include page="../template/sidebarleft.jsp" />

		<div class="page-content">
			<div class="content">

				<ul class="breadcrumb">
					<li>
						<p>Você está Aqui</p>
					</li>
					<li><a href="#">Início</a></li>
					<li><a href="#" class="active">Cursos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cursos</span>
					</h3>
					<a class="btn btn-info float-rigth" href="newCurso">Cadastrar
						Curso</a>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<div class="grid simple ">
							<div class="grid-title">
								<h4>Listagem de Cursos</h4>

							</div>

							<div class="grid-body ">
								<table class="table table-hover table-condensed" id="example">
									<thead>
										<tr>
											<th>ID</th>
											<th>Nome</th>
											<th>Área</th>
											<th>Nível</th>
							
											<th>Ações</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="curso" items="${listCurso}">
											<tr>
												<td>${curso.id}</td>
												<td>${curso.nome}</td>
												<td>${curso.area}</td>
												<td>${curso.nivel}</td>
												<td><a href="editCurso?id=${curso.id}">Edit</a>
													&nbsp;&nbsp;&nbsp;&nbsp; <a
													href="deleteCurso?id=${curso.id}">Delete</a></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../template/footer.jsp" />
</body>
</html>