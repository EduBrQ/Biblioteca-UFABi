<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
						<div class="grid-body no-border">
							<div class="row">
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:form method="POST" action="saveAluno"
										modelAttribute="aluno">
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
											<label class="form-label">Naturalidade</label>
											<div class="controls">
												<form:input class="form-control" path="naturalidade" />
											</div>
										</div>
										<div class="form-group">

											<div class="controls">
												<input type="submit" class="btn btn-info" value="Enviar" />
											</div>
										</div>

									</form:form>
								</div>
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



