<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en"
	class=" js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"
	style="">
<head>
<script
	src="//static.codepen.io/assets/editor/live/console_runner-ce3034e6bde3912cc25f83cccb7caa2b0f976196f2f2d52303a462c826d54a73.js"></script>
<script
	src="//static.codepen.io/assets/editor/live/css_live_reload_init-890dc39bb89183d4642d58b1ae5376a0193342f9aed88ea04330dc14c8d52f55.js"></script>
<meta charset="UTF-8">
<meta name="robots" content="noindex">
<link rel="shortcut icon" type="image/x-icon"
	href="//static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico">
<link rel="mask-icon" type=""
	href="//static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111">
<link rel="canonical" href="https://codepen.io/jaycbrf/pen/iBszr">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>


<link rel="stylesheet prefetch"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet prefetch"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet prefetch"
	href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
<style class="cp-pen-styles">
html {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	font-size: 100%;
	height: 100%;
}

body {
	background-color: #2c3338;
	color: #606468;
	font-family: 'Open Sans', sans-serif;
	font-size: 14px;
	font-size: 0.875rem;
	font-weight: 400;
	height: 100%;
	line-height: 1.5;
	margin: 0;
	min-height: 100vh;
}


#success_message {
	display: none;
}
</style>
</head>
<body>
	<div class="container">

		<form class="well form-horizontal bv-form" action=" " method="post"
			id="contact_form" novalidate="novalidate">
			<fieldset>

				<!-- Form Name -->
				<legend>Realizar Cadastro</legend>

				<!-- Text input-->
				<form:form action="signup" method="POST">
					<div class="form-group has-feedback">
						<label class="col-md-4 control-label">Nome</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="userName"
									placeholder="First Name" class="form-control" type="text"
									data-bv-field="userName"><i
									class="form-control-feedback" data-bv-icon-for="userName"
									style="display: none;"></i>
							</div>
							<small data-bv-validator="stringLength"
								data-bv-validator-for="userName" class="help-block"
								style="display: none;">Esse valor não é válido</small><small
								data-bv-validator="notEmpty" data-bv-validator-for="userName"
								class="help-block" style="display: none;">Por favor,
								forneça seu primeiro nome</small>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group has-feedback">
						<label class="col-md-4 control-label">Senha</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="password"
									placeholder="Last Name" class="form-control" type="password"
									data-bv-field="password"><i
									class="form-control-feedback" data-bv-icon-for="password"
									style="display: none;"></i>
							</div>
							<small data-bv-validator="stringLength"
								data-bv-validator-for="password" class="help-block"
								style="display: none;">Mínimo 6 caracteres</small><small
								data-bv-validator="notEmpty" data-bv-validator-for="password"
								class="help-block" style="display: none;">Forneça uma
								senha</small>
						</div>
					</div>
					<!-- Text input-->
					<!-- <div class="form-group has-feedback">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								placeholder="E-Mail Address" class="form-control" type="text"
								data-bv-field="email"><i class="form-control-feedback"
								data-bv-icon-for="email" style="display: none;"></i>
						</div>
						<small data-bv-validator="notEmpty" data-bv-validator-for="email"
							class="help-block" style="display: none;">Please supply
							your email address</small><small data-bv-validator="emailAddress"
							data-bv-validator-for="email" class="help-block"
							style="display: none;">Please supply a valid email
							address</small>
					</div>
				</div>


				Text input

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">Phone #</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
								placeholder="(845)555-1212" class="form-control" type="text"
								data-bv-field="phone"><i class="form-control-feedback"
								data-bv-icon-for="phone" style="display: none;"></i>
						</div>
						<small data-bv-validator="notEmpty" data-bv-validator-for="phone"
							class="help-block" style="display: none;">Please supply
							your phone number</small><small data-bv-validator="phone"
							data-bv-validator-for="phone" class="help-block"
							style="display: none;">Please supply a vaild phone number
							with area code</small>
					</div>
				</div>

				Text input

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">Address</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="address"
								placeholder="Address" class="form-control" type="text"
								data-bv-field="address"><i class="form-control-feedback"
								data-bv-icon-for="address" style="display: none;"></i>
						</div>
						<small data-bv-validator="stringLength"
							data-bv-validator-for="address" class="help-block"
							style="display: none;">This value is not valid</small><small
							data-bv-validator="notEmpty" data-bv-validator-for="address"
							class="help-block" style="display: none;">Please supply
							your street address</small>
					</div>
				</div>

				Text input

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">City</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="city"
								placeholder="city" class="form-control" type="text"
								data-bv-field="city"><i class="form-control-feedback"
								data-bv-icon-for="city" style="display: none;"></i>
						</div>
						<small data-bv-validator="stringLength"
							data-bv-validator-for="city" class="help-block"
							style="display: none;">This value is not valid</small><small
							data-bv-validator="notEmpty" data-bv-validator-for="city"
							class="help-block" style="display: none;">Please supply
							your city</small>
					</div>
				</div>

				Select Basic

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">State</label>
					<div class="col-md-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="state"
								class="form-control selectpicker" data-bv-field="state">
								<option value=" ">Selecione o seu Estado</option>
								<option>PB</option>
								<option>PE</option>
								<option>RN</option>
								<option>BA</option>
								<option>MA</option>
								<option>CE</option>
								<option>TO</option>
								<option>PA</option>
								<option>BS</option>
								<option>RS</option>
								<option>MS</option>
								<option>MG</option>
								<option>AM</option>
								<option>AP</option>
								<option>AC</option>
								<option>RR</option>
								<option>SP</option>
								<option>RJ</option>
								<option>SC</option>
								
							</select><i class="form-control-feedback" data-bv-icon-for="state"
								style="display: none;"></i>
						</div>
						<small data-bv-validator="notEmpty" data-bv-validator-for="state"
							class="help-block" style="display: none;">Por favor, selecione o seu Estado</small>
					</div>
				</div>

				Text input

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">CEP</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="zip"
								placeholder="Zip Code" class="form-control" type="text"
								data-bv-field="zip"><i class="form-control-feedback"
								data-bv-icon-for="zip" style="display: none;"></i>
						</div>
						<small data-bv-validator="notEmpty" data-bv-validator-for="zip"
							class="help-block" style="display: none;">Por favor, insira o CEP</small><small data-bv-validator="zipCode"
							data-bv-validator-for="zip" class="help-block"
							style="display: none;">Insira um CEP válido</small>
					</div>
				</div>



				Text area

				<div class="form-group has-feedback">
					<label class="col-md-4 control-label">Project Description</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>
							<textarea class="form-control" name="comment"
								placeholder="Project Description" data-bv-field="comment"></textarea>
							<i class="form-control-feedback" data-bv-icon-for="comment"
								style="display: none;"></i>
						</div>
						<small data-bv-validator="stringLength"
							data-bv-validator-for="comment" class="help-block"
							style="display: none;">Please enter at least 10
							characters and no more than 200</small><small
							data-bv-validator="notEmpty" data-bv-validator-for="comment"
							class="help-block" style="display: none;">Please supply a
							description of your project</small>
					</div>
				</div>

				Success message
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for
					contacting us, we will get back to you shortly.
				</div> -->

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<button type="submit" class="btn btn-warning" value="Enviar">
								Registrar <span class="glyphicon glyphicon-send"></span>
							</button>
						</div>
					</div>

				</form:form>

			</fieldset>
			<input type="hidden" value="">
		</form>
	</div>

	<!-- /.container -->
	<script
		src="//static.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$('#contact_form')
									.bootstrapValidator(
											{
												// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
												feedbackIcons : {
													valid : 'glyphicon glyphicon-ok',
													invalid : 'glyphicon glyphicon-remove',
													validating : 'glyphicon glyphicon-refresh'
												},
												fields : {
													userName : {
														validators : {
															stringLength : {
																min : 2,
															},
															notEmpty : {
																message : 'Por favor, forneça seu primeiro nome'
															}
														}
													},
													password : {
														validators : {
															stringLength : {
																min : 6,
																max : 12,
															},
															notEmpty : {
																message : 'Mínimo 6 caracteres'
															}
														}
													},
													email : {
														validators : {
															notEmpty : {
																message : 'Please supply your email address'
															},
															emailAddress : {
																message : 'Please supply a valid email address'
															}
														}
													},
													phone : {
														validators : {
															notEmpty : {
																message : 'Please supply your phone number'
															},
															phone : {
																country : 'US',
																message : 'Please supply a vaild phone number with area code'
															}
														}
													},
													address : {
														validators : {
															stringLength : {
																min : 8,
															},
															notEmpty : {
																message : 'Please supply your street address'
															}
														}
													},
													city : {
														validators : {
															stringLength : {
																min : 4,
															},
															notEmpty : {
																message : 'Please supply your city'
															}
														}
													},
													state : {
														validators : {
															notEmpty : {
																message : 'Please select your state'
															}
														}
													},
													zip : {
														validators : {
															notEmpty : {
																message : 'Please supply your zip code'
															},
															zipCode : {
																country : 'US',
																message : 'Please supply a vaild zip code'
															}
														}
													},
													comment : {
														validators : {
															stringLength : {
																min : 10,
																max : 200,
																message : 'Please enter at least 10 characters and no more than 200'
															},
															notEmpty : {
																message : 'Please supply a description of your project'
															}
														}
													}
												}
											})
									.on(
											'success.form.bv',
											function(e) {
												$('#success_message')
														.slideDown({
															opacity : "show"
														}, "slow") // Do something ...
												$('#contact_form').data(
														'bootstrapValidator')
														.resetForm();

												// Prevent form submission
												e.preventDefault();

												// Get the form instance
												var $form = $(e.target);

												// Get the BootstrapValidator instance
												var bv = $form
														.data('bootstrapValidator');

												// Use Ajax to submit form data
												$
														.post(
																$form
																		.attr('action'),
																$form
																		.serialize(),
																function(result) {
																	console
																			.log(result);
																}, 'json');
											});
						});

		//# sourceURL=pen.js
	</script>
</body>
</html>