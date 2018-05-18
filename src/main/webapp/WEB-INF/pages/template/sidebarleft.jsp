<!-- BEGIN SIDEBAR -->
<div class="page-sidebar " id="main-menu">
	<!-- BEGIN MINI-PROFILE -->
	<div class="page-sidebar-wrapper scrollbar-dynamic"
		id="main-menu-wrapper">
		<div class="user-info-wrapper sm">
			<div class="profile-wrapper sm">
				<img
					src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar.jpg"
					alt=""
					data-src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar.jpg"
					data-src-retina="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar2x.jpg"
					width="69" height="69" />
				<div class="availability-bubble online"></div>
			</div>
			<div class="user-info sm">
				<div class="username">
					Olá <span class="semi-bold">${username}</span>
				</div>
				<div class="status">Boa Tarde...</div>
			</div>
		</div>
		<!-- END MINI-PROFILE -->
		<!-- BEGIN SIDEBAR MENU -->
		<p class="menu-title sm">
			BROWSE <span class="pull-right"><a href="javascript:;"><i
					class="material-icons">refresh</i></a></span>
		</p>
		<ul>
			<li><a href="/ControleBiblioteca/"> <i
					class="material-icons">home</i> <span class="title">Início</span> <span
					class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/livros"> <i
					class="material-icons">local_library</i> <span class="title">Livros</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/anaisCongresso"> <i
					class="material-icons">chrome_reader_mode</i> <span class="title">Anais
						de Congressos</span> <span
					class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/midiasEletronicas"> <i
					class="material-icons">perm_media</i> <span class="title">Midias
						Eletrônicas</span> <span
					class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/trabalhosConclusao"> <i
					class="material-icons">euro_symbol</i> <span class="title">Trabalhos</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/revistas"> <i
					class="material-icons">book</i> <span class="title">Revistas</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/cursos"> <i
					class="material-icons">category</i> <span class="title">Cursos</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/alunos"> <i
					class="material-icons">school</i> <span class="title">Alunos</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/funcionarios"> <i
					class="material-icons">group</i> <span class="title">Funcionários</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/reservas"> <i
					class="material-icons">compare_arrows</i> <span class="title">Reservas</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
			<li><a href="/ControleBiblioteca/emprestimos"> <i
					class="material-icons">compare_arrows</i> <span class="title">Empréstimos</span>
					<span class="label label-important bubble-only pull-right "></span>
			</a></li>
		</ul>

		<div class="clearfix"></div>
		<!-- END SIDEBAR MENU -->
	</div>
</div>

<a href="#" class="scrollup">Scroll</a>
<div class="footer-widget"></div>
<!-- END SIDEBAR -->
