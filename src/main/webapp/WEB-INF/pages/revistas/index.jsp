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
					<li><a href="#" class="active">Revistas</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Revistas</span>
					</h3>
					<a class="btn btn-info float-rigth" href="newRevista">Cadastrar
						Revista</a>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<div class="grid simple ">
							<div class="grid-title">
								<h4>Listagem de Revistas</h4>

							</div>

							<div class="grid-body ">
								<table class="table table-hover table-condensed" id="example">
									<thead>
										<tr>
											<th>ID</th>
											<th>Edição</th>
											<th>Editora</th>
											<th>N° de Páginas</th>
											<th>Ações</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="revista" items="${listRevista}">
											<tr>
												<td>${revista.id}</td>
												<td>${revista.edicao}</td>
												<td>${revista.editora}</td>
												<td>${revista.numPaginas}</td>
												<td><a href="editRevista?id=${revista.id}">Edit</a>
													&nbsp;&nbsp;&nbsp;&nbsp; <a
													href="deleteRevista?id=${revista.id}">Delete</a></td>

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