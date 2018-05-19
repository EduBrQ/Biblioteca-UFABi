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


										<div id="mainselection" class="form-group">
											<label class="form-label">Alunos</label>
											<form:select style="width: 100%" class="select2-container"
												path="aluno.id" id="aluno">
												<option style="font: bold" value="">-- Selecione o
													Aluno --</option>
												<c:forEach items="${alunos}" var="aluno">
													<option value="${aluno.id}"><c:out
															value="${aluno.nomeCompleto}"></c:out>
													</option>
												</c:forEach>
											</form:select>
										</div>

										<div id="mainselection" class="form-group">
											<label class="form-label">Itens de Empréstimo</label> <select
												style="width: 100%" class="select2-container"
												name="itemEmprestimo_id" id="itemEmprestimo">
												<option value="">-- Item de Emprestimo --</option>
												<option value="itemLivro">Livro</option>
												<option value="itemRevista">Revista</option>
												<option value="itemAnalCongresso">Anal de Congresso</option>
												<option value="itemMidiaEletronica">Mídia
													Eletrônica</option>
												<option value="itemTrabalhoConclusao">Trabalho de
													Conclusão</option>
											</select>
										</div>


										<div class="form-group acervo" id="itemLivro" hidden>
											<label class="form-label">Livro</label>
											<div class="controls">

												<form:select id="itemLivro" class="select2-container"
													path="livro.id">
													<c:forEach var="livro" items="${livros}">
														<option class="form-group acervo2" id="itemLivro" value="">--
															Selecione um Livro --</option>
														<option value="${livro.id}">${livro.titulo}</option>
														<%-- <c:out value="${livro.id}"></c:out> --%>
													</c:forEach>
												</form:select>

											</div>
										</div>

										<div class="form-group acervo" id="itemRevista" hidden>
											<label class="form-label">Revista</label>
											<div class="controls">

												<form:select id="itemRevista" class="select2-container"
													path="revista.id">
													<c:forEach var="revista" items="${revistas}">
														<option class="form-group acervo2" id="itemRevista"
															value="">-- Selecione uma Revista --</option>
														<option value="${revista.id}">${revista.editora}</option>

													</c:forEach>
												</form:select>
											</div>
										</div>


										<div class="form-group acervo" id="itemTrabalhoConclusao" hidden>
											<label class="form-label">Trabalhos de Conclusão</label>
											<div class="controls">
												<form:select class="select2-container"
													path="trabalhoConclusao.id" id="trabalhoConclusao">
													<c:forEach var="trabalhoConclusao"
														items="${trabalhosConclusao}">
														<option class="form-group acervo2"
															id="itemTrabalhoConclusao" value="">-- Selecione
															um T. Conclusao --</option>
														<option value="${trabalhoConclusao.id}">${trabalhoConclusao.tipo}</option>
													</c:forEach>
												</form:select>
											</div>
										</div>

										<div class="form-group acervo" id="itemAnalCongresso" hidden>
											<label class="form-label">Anais de Congresso</label>
											<div class="controls">
												<form:select class="select2-container"
													path="analCongresso.id" id="analCongresso">
													<c:forEach var="analCongresso" items="${anaisCongresso}">
														<option class="form-group acervo2" id="itemAnalCongresso"
															value="">-- Selecione um An. de Congresso --</option>
														<option value="${analCongresso.id}">${analCongresso.nomeCongresso}</option>
													</c:forEach>
												</form:select>
											</div>
										</div>

										<div class="form-group acervo" id="itemMidiaEletronica" hidden>
											<label class="form-label">Mídias Eletrônicas</label>
											<div class="controls">
												<form:select class="select2-container"
													path="midiaEletronica.id" id="midiaEletronica">
													<c:forEach var="midiaEletronica"
														items="${midiasEletronicas}">
														<option class="form-group acervo2"
															id="itemMidiaEletronica" value="">-- Selecione
															uma Midia Elet. --</option>
														<option value="${midiaEletronica.id}">${midiaEletronica.tipo}</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										
										
										<div class="form-group">
											<label class="form-label">Data de Emprestimo</label>
											<div class="controls">
												<form:input type="date" class="form-control" path="dataEmprestimo" />
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

	<script type="text/javascript">
			$("#itemEmprestimo").change(function() {
			$('.acervo').hide();
			$('#' + $(this).val()).show();
		});
		$("#itemEmprestimo").change(function() {
			$('.acervo2').attr("disabled", "disabled");
			$('#' + $(this)).removeAttr("disabled");

		});
	</script>
</body>
</html>



