<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
					<li><a href="#">Funcionarios</a></li>
					<li><a href="#" class="active">Cadastrar Funcionarios</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar Funcionarios</span>
					</h3>
			
				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Funcionarios</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row" id="janela">
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:form method="POST" action="saveFuncionario"
										modelAttribute="funcionario">
										<form:hidden path="id" />
								
										<div class="form-group">
											<label class="form-label">Nome</label>
											<div class="controls">
												<form:input class="form-control" path="nome" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Senha</label>
											<div class="controls">
												<form:input class="form-control" path="senha" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Cpf</label>
											<div class="controls">
												<form:input class="form-control" path="cpf" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="form-label">Naturalidade</label>
											<div class="controls">
												<form:input class="form-control" path="naturalidade" />
											</div>
										</div>
										
											<div class="form-group">
											<label class="form-label">Endereço</label>
											<div class="controls">
												<form:input class="form-control" path="endereco" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="form-label">Telefone</label>
											<div class="controls">
												<form:input class="form-control" path="telefone" />
											</div>
										</div>
										
											<div class="form-group">
											<label class="form-label">Email</label>
											<div class="controls">
												<form:input class="form-control" path="email" />
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



