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
						<p>Voc� est� Aqui</p>
					</li>
					<li><a href="#">In�cio</a></li>
					<li><a href="#">AnaisCongressos</a></li>
					<li><a href="#" class="active">Cadastrar Anais de Congressos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar Anais de Congressos</span>
					</h3>
			
				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Anais de Congressos</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row">
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:form method="POST" action="saveAnaisCongresso"
										modelAttribute="anaisCongresso">
										<form:hidden path="id" />
										<div class="form-group">
											<label class="form-label">Tipo</label>
											<div class="controls">
												<form:input class="form-control" path="tipo" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Nome do Congresso</label>
											<div class="controls">
												<form:input class="form-control" path="nomeCongresso" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Local</label>
											<div class="controls">
												<form:input class="form-control" path="local" />
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


