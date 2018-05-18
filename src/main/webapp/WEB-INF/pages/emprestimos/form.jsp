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
						<p>Voc� est� Aqui</p>
					</li>
					<li><a href="#">In�cio</a></li>
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
											<label class="form-label">Itens de Empr�stimo</label> <select
												style="width: 100%" class="select2-container"
												name="itemEmprestimo_id" id="itemEmprestimo">
												<option value="">-- Item de Emprestimo --</option>
												<option value="itemLivro">Livro</option>
												<option value="itemRevista">Revista</option>
												<option value="itemAnalCongresso">Anal de Congresso</option>
												<option value="itemMidiaEletronica">M�dia
													Eletr�nica</option>
												<option value="itemTrabalhoConclusao">Trabalho de
													Conclus�o</option>
											</select> </select>
										</div>



										<div class="form-group acervo" id="itemLivro" hidden>
											<label class="form-label">Livro</label>
											<div class="controls">
												<form:select class="select2-container" path="livro.id"
													id="livro">
													<option value="">** Selecione o Livro **</option>
													<c:forEach var="livro" items="${livros}">
														<option value="${livro.id}">${livro.titulo}</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										
										<div class="form-group acervo" id="itemRevista" hidden>
											<label class="form-label">Revista</label>
											<div class="controls">
												<form:select class="select2-container" path="revista.id"
													id="revista">
													<option value="">** Selecione a Revista **</option>
													<c:forEach var="revista" items="${revistas}">
														<option value="${revista.id}">${revista.editora}</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										

										<%--
										<div class="form-group acervo" id="itemTrabalhoConclusao"
											hidden>
											<label class="form-label">Trabalhos de Conclus�o</label>
											<div class="controls">
												<form:select style="width: 100%" class="select2-container"
													path="trabalhosConclusao.id" id="trabalhoConclusao">
													<option value="">** Selecione o Trabalho de
														Conclus�o **</option>
													<c:forEach items="${trabalhosConclusao}"
														var="trabalhoConclusao">
														<option value="${trabalhoConclusao.id}"><c:out
																value="${trabalhoConclusao.tipo}"></c:out>
														</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="form-group acervo" id="itemAnalCongresso" hidden>
											<label class="form-label">Anais de Congresso</label>
											<div class="controls">
												<form:select style="width: 100%" class="select2-container"
													path="anaisCongresso.id" id="analCongresso">
													<option value="">** Selecione o Anal de Congresso
														**</option>
													<c:forEach items="${anaisCongresso}" var="analCongresso">
														<option value="${analCongresso.id}"><c:out
																value="${analCongresso.nomeCongresso}"></c:out>
														</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="form-group acervo" id="itemMidiaEletronica" hidden>
											<label class="form-label">M�dias Eletr�nicas</label>
											<div class="controls">
												<form:select style="width: 100%" class="select2-container"
													path="midiaEletronica.id" id="midiaEletronica">
													<option value="">** Selecione a M�dia Eletr�nica
														**</option>
													<c:forEach items="${midiasEletronicas}"
														var="midiaEletronica">
														<option value="${midiaEletronica.id}"><c:out
																value="${midiaEletronica.titulo}"></c:out>
														</option>
													</c:forEach>
												</form:select>
											</div>
										</div>
									</div>
 --%>


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
	</script>
</body>
</html>



