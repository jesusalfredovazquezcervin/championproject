<html>
<head>
	<meta name="layout" content="login"/>
	<title>LOGIN :: CTMWEBAPP</title>
	<link rel="stylesheet" href="${resource(dir: 'css/champion-theme', file: 'jquery-ui-1.10.3.custom.min.css')}" />
	<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.min.js')}"></script>
	<script type="text/javascript">
	$(function(){
	
		$("#login").button({
			icons: {
		        primary: "ui-icon-locked"
		      }
		});
	});
	</script>
	<!--  style type='text/css' media='screen'>
	#login {
		margin: 15px 0px;
		padding: 0px;
		text-align: center;
	}

	#login .inner {
		width: 340px;
		padding-bottom: 6px;
		margin: 60px auto;
		text-align: left;
		border: 1px solid #aab;
		background-color: #f0f0fa;
		-moz-box-shadow: 2px 2px 2px #eee;
		-webkit-box-shadow: 2px 2px 2px #eee;
		-khtml-box-shadow: 2px 2px 2px #eee;
		box-shadow: 2px 2px 2px #eee;
	}

	#login .inner .fheader {
		padding: 18px 26px 14px 26px;
		background-color: #f7f7ff;
		margin: 0px 0 14px 0;
		color: #2e3741;
		font-size: 18px;
		font-weight: bold;
	}

	#login .inner .cssform p {
		clear: left;
		margin: 0;
		padding: 4px 0 3px 0;
		padding-left: 105px;
		margin-bottom: 20px;
		height: 1%;
	}

	#login .inner .cssform input[type='text'] {
		width: 120px;
	}

	#login .inner .cssform label {
		font-weight: bold;
		float: left;
		text-align: right;
		margin-left: -105px;
		width: 110px;
		padding-top: 3px;
		padding-right: 10px;
	}

	#login #remember_me_holder {
		padding-left: 120px;
	}

	#login #submit {
		margin-left: 15px;
	}

	#login #remember_me_holder label {
		float: none;
		margin-left: 0;
		text-align: left;
		width: 200px
	}

	#login .inner .login_message {
		padding: 6px 25px 20px 25px;
		color: #c33;
	}

	#login .inner .text_ {
		width: 120px;
	}

	#login .inner .chk {
		height: 12px;
	}
	</style -->
</head>

<body>
<div class="headerLogin" role="contentinfo" align="center">
	<h3>BIENVENIDO</h3>
  </div>
  
<div id="page-body" class="loginUsr">
	<div class='inner'>
		<div class='fheader'><g:message code="springSecurity.login.header"/></div>
		<br>
		<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>

		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
			<p>
				<!--  label for='username'><g:message code="springSecurity.login.username.label"/>:</label -->
				<input type='text' class='text_' name='j_username' id='username' placeholder="Usuario" required />
			</p>
			<br>
			<p>
				<!-- label for='password'><g:message code="springSecurity.login.password.label"/>:</label -->
				<input type='password' class='text_' name='j_password' id='password' placeholder="Contrase&ntilde;a" required/>
			</p>

			<br>
			<p>
				<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
			</p>
		</form><br/><br/>
		<label style="font-size: 80%"><g:link controller="recoveryLink" action="create">¿Ha olvidado su contraseña?</g:link></label>
	</div>
</div>
<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>
