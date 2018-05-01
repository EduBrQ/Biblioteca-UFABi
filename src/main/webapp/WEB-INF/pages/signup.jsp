<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<jsp:include page="template/header.jsp" />
</head>
<body>
	<div class="page-content">
		<div class="content">
			<div class="col-md-3">
				<h1>Cadastrar</h1>
				<form:form action="signup" method="POST">
					<div>
						<label>Usuário <input class="form-control" type="text"
							name="userName" />
						</label>
					</div>
					<div>
						<label>Senha <input class="form-control"
							type="password" name="password" />
						</label>
					</div>
					<div>
						<input class="btn btn-primary" type="submit" value="Enviar" />
					</div>
				</form:form>
				<div class="page-container row-fluid"></div>
			</div>
		</div>
	</div>
	</div>
</body>
<jsp:include page="template/footer.jsp" />
</html>
