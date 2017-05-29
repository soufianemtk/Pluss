<%@page import="form.Inscription"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<!-- Page styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.min.css">

    <meta charset="UTF-8">
    <title>Registration</title> 
    <link rel="stylesheet" href="css/register.css">
	<meta name="viewport" content="initial-scale=1, maximum-scale=1">

</head>

<body>
<div id="cf4a" class="mdl-layout mdl-js-layout">
<img class="background_image"  src="images/im1.jpg"/>
<img class="background_image"  src="images/im2.jpg"/>
<img class="background_image"  src="images/im3.jpg"/>
	<main class="mdl-layout__content">
		<div class="cadre mdl-card mdl-shadow--6dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">Pluss</h2>
			</div>
			<!-- Inscription form=(Inscription)request.getAttribute("form");-->
			<!--=form.getErreurs().get("usermail")-->
			<div class="encadre_utilisateur mdl-card__supporting-text">
				<form method="post" action="Connexion">
					<div class="mdl-textfield mdl-js-textfield log-status">
						<input class="form-control mdl-textfield__input" type="text" id="username" name="username" />
						<label class="mdl-textfield__label" for="username">Username</label>
						<!--<span class="alert"></span>-->
					</div>
					<div class="mdl-textfield mdl-js-textfield ">
						<input class="form-control mdl-textfield__input" type="password" id="userpass" name="userpass" value=""/>
						<label class=" mdl-textfield__label" for="userpass">Password</label>
						<span class="alert">${formulaire.erreurs['userpass']}</span>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<input class="form-control mdl-textfield__input" type="password" id="userpassconfirm" name="userpassconfirm" value=""/>
						<label class=" mdl-textfield__label" for="userpassconfirm">Confirm your Password</label>
						<span class="alert">${formulaire.['userpassconfirm']}</span>
					</div>
					<div class="mdl-textfield mdl-js-textfield log-status">
                        <input class="form-control mdl-textfield__input" type="email" id="usermail" name="usermail" />
                        <label class=" mdl-textfield__label" for="usermail">Email</label>
                        <span class="alert">${formulaire.erreurs['usermail']}</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield">
                         <input class="form-control mdl-textfield__input" type="email" id="usermailconfirm" name="usermailconfirm" />
                         <label class=" mdl-textfield__label" for="usermailconfirm">Confirm your Email</label>
                         <span class="alert">${formulaire.erreurs['usermailconfirm']}</span>
                    </div>
					<a class="already_registered link" href="Connexion?op=Authentification">Already registered ?</a>
					<span class="alert">Id or Email already used</span>
					
					<div class="card_register mdl-card__actions mdl-card--border">
					<button class="button_register mdl-button mdl-js-button mdl-button--raised" type ="submit">Register</button>
					<input type="hidden" name="op" value="Inscription">
					</div>
				</form>
			</div>
		</div>
	</div>
	</main>
</div>
</body>
<script src="https://code.getmdl.io/1.2.1/material.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/register.js"></script>
</html>
