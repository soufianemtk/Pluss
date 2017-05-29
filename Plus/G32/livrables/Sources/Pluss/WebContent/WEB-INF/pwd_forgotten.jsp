<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<!-- Page styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.min.css">

    <meta charset="UTF-8">
    <title>How to get a new password?</title> 
    <link rel="stylesheet" href="css/pwd_forgotten.css">
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
			<div class="encadre_utilisateur mdl-card__supporting-text">
				<form action="#">
					<p>Enter the e-mail adress associated to your Pluss account. Then click on the button &quot;Send Email&quot; and we will email you a link to a page where you can easily create a new password.</p>
					<div class="mdl-textfield mdl-js-textfield log-status">
                                     <input class="form-control mdl-textfield__input" type="email" id="usermail" />
                          <label class=" mdl-textfield__label" for="usermail">Email</label>
                    </div>
					<a class="go_back link" href="Connexion?op=Authentification">Just remembered your Password?</a>
					<span class="alert">This Email is not affiliated to any account</span>
				</form>
			</div>
			<div class="card_pawd_forgotten mdl-card__actions mdl-card--border">
				<button class="button_pwd_forgotten mdl-button mdl-js-button mdl-button--raised" type ="submit">Send Email</button>
			</div>
		</div>
	</div>
	</main>
</div>
</body>
<script src="https://code.getmdl.io/1.2.1/material.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/pwd_forgotten.js"></script>
</html>
