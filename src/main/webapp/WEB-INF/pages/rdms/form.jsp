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
					<li><a href="#">Rdms</a></li>
					<li><a href="#" class="active">Cadastrar Rdms</a></li>
				</ul>
				<div class="page-title">
					<i class="icon-custom-left"></i>
					<h3>
						Controle de Biblioteca - <span class="semi-bold">Cadastrar
							Rdms</span>
					</h3>

				</div>

				<div class="col-md-12">
					<div class="grid simple">
						<div class="grid-title no-border">
							<h4>Cadastro de Rdms</h4>
						</div>
						<div class="grid-body no-border">
							<div class="row">
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:form method="POST" action="saveRdm" modelAttribute="rdm">
										<form:hidden path="id" />

										<div class="form-group">
											<label class="form-label">Aluno</label>
											<div class="controls">
												<form:input value="${ aluno.getNomeCompleto() }"
													class="form-control" path="aluno" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Matrícula</label>
											<div class="controls">
												<form:input class="form-control" path="matricula" />
											</div>
										</div>

										<div class="form-group">
											<label class="form-label">Cursos</label>
											<div class="controls">
												<select class="form-control" name="cursos">
													<option>** Selecione um curso **</option>
													<option>Curso 1</option>
													<option>Curso 2</option>
													<option>Curso 3</option>

												</select>
											</div>
										</div>

										<div class="widget-item" style="width:50%">
											<div class="controller overlay right">
												<a href="javascript:;" class="reload"></a> <a
													href="javascript:;" class="remove"></a>
											</div>
											<div class="tiles purple " style="max-height: 345px">
												<div class="tiles-body">
													<h3 class="text-white m-t-50 m-b-30 m-r-20">
														<span class="semi-bold">Algebra linear</span>
													</h3>
													<div class="overlayer bottom-right fullwidth">
														<div class="overlayer-wrapper">
															<div class=" p-l-20 p-r-20 p-b-20 p-t-20">
																<div class="pull-right">
																	<a href="#" class="hashtags transparent">CPT01026</a>
																</div>
																<div class="clearfix"></div>
															</div>
														</div>
													</div>
													<br>
												</div>
											</div>
											<div class="tiles white ">
												<div class="tiles-body">
													<div class="row">
														<div class="user-comment-wrapper pull-left">
															<div class="comment">
																<div class="user-name text-black">
																	Carga horaria de 60H
																</div>
																<div class="user-name text-black">
																	Professora: Ana Bele
																</div>
																<div class="preview-wrapper">Quarta: Sala 204 </div>
																<div class="preview-wrapper">Sexta: Sala 202 </div>
															</div>
															<div class="clearfix"></div>
														</div>
													</div>
												</div>
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



