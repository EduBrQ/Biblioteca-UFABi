<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<li><a href="#" class="active">Alunos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Alunos</span>
					</h3>
					<a class="btn btn-info float-rigth" href="newAluno">Cadastrar
						Aluno</a>
				</div>

				<div class="row-fluid">
					<div class="span12">
						<div class="grid simple ">
							<div class="grid-title">
								<h4>Listagem de Alunos</h4>

							</div>

							<div class="grid-body ">
								<table class="table table-hover table-condensed" id="example">
									<thead>
										<tr>
											<th>ID</th>
											<th>Nome</th>
											<th>Telefone</th>
											<th>Endereço</th>
											<th>Cpf</th>
											<th>Rg</th>
											<th>Pai</th>
											<th>Mãe</th>
											<th>Naturalidade</th>
											<th>Ações</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="aluno" items="${listAluno}">
											<tr>
												<td>${aluno.id}</td>
												<td>${aluno.nomeCompleto}</td>
												<td>${aluno.telefone}</td>
												<td>${aluno.endereco}</td>
												<td>${aluno.cpf}</td>
												<td>${aluno.rg}</td>
												<td>${aluno.nomeMae}</td>
												<td>${aluno.nomePai}</td>
												<td>${aluno.naturalidade}</td>
												<td><a href="editAluno?id=${aluno.id}">Edit</a>
													&nbsp;&nbsp;&nbsp;&nbsp; 
													<sec:authorize access="hasRole('ADMIN')">
														<a href="deleteAluno?id=${aluno.id}">Delete</a>
													</sec:authorize></td>

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