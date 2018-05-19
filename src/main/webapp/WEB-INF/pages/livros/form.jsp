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
					<li><a href="#">Livros</a></li>
					<li><a href="#" class="active">Cadastrar Livros</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar Livros</span>
					</h3>
			
				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Livros</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row" id="janela">
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:form method="POST" action="saveLivro"
										modelAttribute="livro">
										<form:hidden path="id" />
										<div class="form-group">
											<label class="form-label">Título</label>
											<div class="controls">
												<form:input class="form-control" path="titulo" />
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">IBS</label>
											<div class="controls">
												<form:input class="form-control" path="ibs" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Editora</label>
											<div class="controls">
												<form:input class="form-control" path="editora" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Edição</label>
											<div class="controls">
												<form:input class="form-control" path="edicao" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">N° Páginas</label>
											<div class="controls">
												<form:input class="form-control" path="numPaginas" />
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">Área do Conhecimento</label>
											<div class="controls">
												<form:input class="form-control" path="areaConhecimento" />
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">Tema</label>
											<div class="controls">
												<form:input class="form-control" path="tema" />
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



