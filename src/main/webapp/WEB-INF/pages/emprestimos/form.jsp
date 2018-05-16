<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<li><a href="#">Emprestimos</a></li>
					<li><a href="#" class="active">Cadastrar Emprestimos</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar
							Emprestimos</span>
					</h3>

				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Emprestimos</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row">

								<form:form method="POST" action="saveEmprestimo"
									modelAttribute="emprestimo">
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
												<form:input class="form-control" path="ano" />
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
											<label class="form-label">Livro</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container" name="livro_id"  id="source">
													<option value="">** Selecione o Livro **</option>
													<c:forEach items="${livros}" var="livro">
														<option value="${livro.id}"><c:out
																value="${livro.nome}"></c:out>
														</option>
													</c:forEach>
												</select>
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



