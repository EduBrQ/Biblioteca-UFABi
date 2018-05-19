<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#janela{
	width: 60%;
	
}
</style>
<html>
<head>
<jsp:include page="../template/header.jsp" />
</head>
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
					<li><a href="#">Alunos</a></li>
					<li><a href="#" class="active">Cadastrar Alunos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar
							Alunos</span>
					</h3>

				</div>


				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Alunos</h4>
						</div>
						<div class="grid-body no-border" >
							<div class="row" id="janela" >

								<form:form method="POST" action="saveAluno"
									modelAttribute="aluno">
									<div class="col-md-6 col-sm-6 col-xs-6">
									
										<form:hidden path="id" />

										<div class="form-group">
											<label class="form-label">Nome Completo</label>
											<div class="controls">
												<form:input class="form-control" path="nomeCompleto" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Telefone</label>
											<div class="controls">
												<form:input class="form-control" path="telefone" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Endereço</label>
											<div class="controls">
												<form:input class="form-control" path="endereco" />
											</div>
										</div>


										<div class="form-group">
											<label class="form-label">Cpf</label>
											<div class="controls">
												<form:input class="form-control" path="cpf" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Rg</label>
											<div class="controls">
												<form:input class="form-control" path="rg" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Naturalidade</label>
											<div class="controls">
												<form:input class="form-control" path="naturalidade" />
											</div>
										</div>

									</div>

									<div class="col-md-6 col-sm-6 col-xs-6">
										<div class="form-group">
											<label class="form-label">Nome da Mãe</label>
											<div class="controls">
												<form:input class="form-control" path="nomeMae" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Nome do Pai</label>
											<div class="controls">
												<form:input class="form-control" path="nomePai" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Ano</label>
											<div class="controls">
												<form:input type="date" class="form-control" path="ano" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Periodo</label>
											<div class="controls">
												<form:input class="form-control" path="periodo" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Senha</label>
											<div class="controls">
												<form:input class="form-control" path="senha" />
											</div>
										</div>


										<div class="form-group">
										
											
											
												
											<label class="form-label">Curso</label>
											<!-- <button>+</button> -->
											<div class="controls">
												<form:select path="curso.id" id="source"
													class="select2-container" style="width: 100%">

													<option value="">** Selecione o Curso **</option>
													<c:forEach items="${cursos}" var="mCurso">
														<option value="${mCurso.id}"
															${aluno.curso.id eq mCurso.id ? 'selected' : ''}>${mCurso.nome}</option>
													</c:forEach>

												</form:select>

											</div>

										</div>

									</div>

									<input type="submit" class="btn btn-info pull-left"
										value="Enviar" />


								</form:form>

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



