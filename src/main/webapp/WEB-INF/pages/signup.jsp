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
						<label>Login <input class="form-control" type="text"
							name="userName" />
						</label>
					</div>
					<div>
						<label>Senha <input class="form-control" type="password"
							name="password" />
						</label>
					</div>

					<div class="form-group">
						<label class="form-label">Roles</label> <select
							style="width: 100%" class="select2-container"
							name="roleName">
							<option value="">-- Selecione a Role do Usuário --</option>
							<option value="ADMIN">ADMIN</option>
							<option value="FUNCIONARIO">FUNCIONARIO</option>
							<option value="ALUNO">ALUNO</option>
						</select>
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