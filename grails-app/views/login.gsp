<%@ page contentType="text/html;charset=ISO-8859-1" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
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

</head>
<body>
<div class="headerLogin" role="contentinfo" align="center">
	<h3>BIENVENIDO</h3>
  </div>
  <div id="page-body" class="loginUsr">
  
  <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:if test="${flash.error}">
		<div class="errors" role="alert">
			<ul>
				<li>${flash.error}</li>
			</ul>
		</div>
	 </g:if>
  
  	<form action="usuario/authenticate">
			<input type="text" maxlength="50" placeholder="Usuario" name="usuario" required/>
			<br/><br/>
			<input type="password" maxlength="50" placeholder="Contrase&ntilde;a" name="password" required/>
			<br/><br/>
			<button type="submit" id="login">Entrar</button>
		</form><br/><br/>
		<label style="font-size: 80%"><g:link url="recovery">¿Ha olvidado su contraseña?</g:link></label>
	</div>
</body>
</html>