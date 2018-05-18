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
					<li><a href="#">Reservas</a></li>
					<li><a href="#" class="active">Cadastrar Reservas</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar
							Reservas</span>
					</h3>

				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Reservas</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row">

								<form:form method="POST" action="saveReserva"
									modelAttribute="reserva">
									<div class="col-md-6 col-sm-6 col-xs-6">
										<form:hidden path="id" />


										<div id="mainselection" class="form-group">
										<label class="form-label">Alunos</label>
											<select style="width: 100%" class="select2-container"
												name="aluno_id" id="aluno">
												<option style="font: bold" value="">-- Selecione o
													Aluno --</option>
												<c:forEach items="${alunos}" var="aluno">
													<option value="${aluno.id}"><c:out
															value="${aluno.nomeCompleto}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>

										<div id="mainselection" class="form-group">
										<label class="form-label">Itens de Empr�stimo</label>
											<select style="width: 100%" class="select2-container"
												name="itemReserva_id" id="itemReserva">
												<option value="">-- Item de Reserva --</option>
												<option value="itemLivro">Livro</option>
												<option value="itemRevista">Revista</option>
												<option value="itemAnalCongresso">Anal de Congresso</option>
												<option value="itemMidiaEletronica">M�dia Eletr�nica</option>
												<option value="itemTrabalhoConclusao">Trabalho de
													Conclus�o</option>
											</select> </select>
										</div>



										<div class="form-group acervo" id="itemLivro" hidden>
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

										<div class="form-group acervo" id="itemRevista" hidden>
											<label class="form-label">Revista</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="revista_id" id="revista">
													<option value="">** Selecione a Revista **</option>
													<c:forEach items="${revistas}" var="revista">
														<option value="${revista.id}"><c:out
																value="${revista.editora}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group acervo" id="itemTrabalhoConclusao" hidden>
											<label class="form-label">Trabalhos de Conclus�o</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="trabalhoConclusao_id" id="trabalhoConclusao">
													<option value="">** Selecione o Trabalho de
														Conclus�o **</option>
													<c:forEach items="${trabalhosConclusao}" var="trabalhoConclusao">
														<option value="${trabalhoConclusao.id}"><c:out
																value="${trabalhoConclusao.tipo}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group acervo" id="itemAnalCongresso" hidden>
											<label class="form-label">Anais de Congresso</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="analCongresso_id" id="analCongresso">
													<option value="">** Selecione o Anal de Congresso
														**</option>
													<c:forEach items="${anaisCongresso}" var="analCongresso">
														<option value="${analCongresso.id}"><c:out
																value="${analCongresso.nomeCongresso}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group acervo" id="itemMidiaEletronica" hidden>
											<label class="form-label">M�dias Eletr�nicas</label>
											<div class="controls">
												<select style="width: 100%" class="select2-container"
													name="midiaEletronica_id" id="midiaEletronica">
													<option value="">** Selecione a M�dia Eletr�nica
														**</option>
													<c:forEach items="${midiasEletronicas}" var="midiaEletronica">
														<option value="${midiaEletronica.id}"><c:out
																value="${midiaEletronica.titulo}"></c:out>
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

	<script type="text/javascript">
		$("#itemReserva").change(function() {
			$('.acervo').hide();
			$('#'+$(this).val()).show();
		});
	</script>
</body>
</html>



