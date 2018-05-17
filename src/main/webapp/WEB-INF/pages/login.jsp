<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<head>
<jsp:include page="template/header.jsp" />
</head>
<body>
	<div class="page-content">
		<div class="content">
			<div class="col-md-3">

				<h1>Login</h1>
				<form:form action="login" method="POST">
					<div>
						<label>Login <input class="form-control" type="text"
							name="username" />
						</label>
					</div>
					<div>
						<label>Senha <input class="form-control"
							type="password" name="password" />
						</label>
					</div>
					<div>
						<input class="btn btn-primary float-left" type="submit" value="Entrar" />
						
						<a style="float: right;margin-top: 10px;"href="/ControleBiblioteca/signup">Cadastrar</a>
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