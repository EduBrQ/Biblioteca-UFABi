<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<jsp:include page="../template/header.jsp" />
</head>
<style>
#mainselection {
	overflow: hidden;
	width: 350px;
	-moz-border-radius: 9px 9px 9px 9px;
	-webkit-border-radius: 9px 9px 9px 9px;
	border-radius: 9px 9px 9px 9px;
	box-shadow: 1px 1px 11px #330033;
	background: #58B14C url("http://i62.tinypic.com/15xvbd5.png") no-repeat
		scroll 319px center;
}
</style>
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
											<select style="width: 100%" class="select2-container"
													name="itemEmprestimo_id" id="itemEmprestimo">
													<option value="">-- Item de Emprestimo --</option>
													<option value="livro">Livro</option>
													<option value="revista">Revista</option>
													<option value="analCongresso">Anal de Congresso</option>
													<option value="midiaEletronica">M�dia Eletr�nica</option>
													<option value="trabalhoConclusao">Trabalho de
														Conclus�o</option>
												</select>
											</select>
										</div>
										
										<div id="mainselection" class="form-group">
											<select style="width: 100%" class="select2-container"
												name="aluno_id" id="aluno">
												<option style="font: bold" value="">-- Selecione o Aluno --</option>
												<c:forEach items="${alunos}" var="livro">
													<option value="${aluno.id}"><c:out
															value="${aluno.nomeCompleto}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
										<%-- <div class="form-group">
											<label class="form-label">Aluno</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="aluno_id" id="aluno">
													<option value="">** Selecione o Aluno **</option>
													<c:forEach items="${alunos}" var="livro">
														<option value="${aluno.id}"><c:out
																value="${aluno.nomeCompleto}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div> --%>

										<div class="form-group">
											<label class="form-label">Livro</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="livro_id" id="livro">
													<option value="">** Selecione o Livro **</option>
													<c:forEach items="${livros}" var="livro">
														<option value="${livro.id}"><c:out
																value="${livro.titulo}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Revista</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="revista_id" id="revista">
													<option value="">** Selecione a Revista **</option>
													<c:forEach items="${revistas}" var="livro">
														<option value="${revista.id}"><c:out
																value="${revista.nome}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">Trabalhos de Conclus�o</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="trabalhoConclusao_id" id="trabalhoConclusao">
													<option value="">** Selecione o Trabalho de
														Conclus�o **</option>
													<c:forEach items="${trabalhosConclusao}" var="livro">
														<option value="${trabalhoConclusao.id}"><c:out
																value="${trabalhoConclusao.nome}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">Anais de Congresso</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="analCongresso_id" id="analCongresso">
													<option value="">** Selecione o Anal de Congresso
														**</option>
													<c:forEach items="${anaisCongresso}" var="livro">
														<option value="${analCongresso.id}"><c:out
																value="${analCongresso.nome}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="form-label">M�dias Eletr�nicas</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="midiaEletronica_id" id="midiaEletronica">
													<option value="">** Selecione a M�dia Eletr�nica
														**</option>
													<c:forEach items="${midiasEletronicas}" var="livro">
														<option value="${midiaEletronicas.id}"><c:out
																value="${midiaEletronicas.nome}"></c:out>
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



