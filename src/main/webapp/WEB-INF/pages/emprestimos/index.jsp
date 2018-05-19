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
					<li><a href="#" class="active">Emprestimos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Emprestimos</span>
					</h3>
					<a class="btn btn-info float-rigth" href="newEmprestimo">Cadastrar
						Emprestimo</a>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<div class="grid simple ">
							<div class="grid-title">
								<h4>Listagem de Emprestimos</h4>

							</div>

							<div class="grid-body ">
								<table class="table table-hover table-condensed" id="example">
									<thead>
										<tr>
											<th>ID</th>
											<th>Aluno</th>
											<th>Item</th>
											<th>Data do Emprestimo</th>
											<th>Ações</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="emprestimo" items="${listEmprestimo}">
											<tr>
												<td>${emprestimo.id}</td>
												<td>${emprestimo.aluno.nomeCompleto}</td>
													<c:if test="${not empty emprestimo.livro.titulo}">
												    <td>${emprestimo.livro.titulo}</td>
												</c:if>
												
												<c:if test="${not empty emprestimo.revista.editora}">
												    <td>${emprestimo.revista.editora}</td>
												</c:if>
												
												
												<c:if test="${not empty emprestimo.midiaEletronica.titulo}">
												    <td>${emprestimo.midiaEletronica.titulo}</td>
												</c:if>
												
												<c:if test="${not empty emprestimo.trabalhoConclusao.tipo}">
												    <td>${emprestimo.trabalhoConclusao.tipo}</td>
												</c:if>
												
												<c:if test="${not empty emprestimo.analCongresso.tipo}">
												    <td>${emprestimo.analCongresso.tipo}</td>
												</c:if>
												<td>${emprestimo.dataEmprestimo}</td>
												<td><a href="editEmprestimo?id=${emprestimo.id}">Edit</a>
													&nbsp;&nbsp;&nbsp;&nbsp; <a
													href="deleteEmprestimo?id=${emprestimo.id}">Delete</a></td>

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