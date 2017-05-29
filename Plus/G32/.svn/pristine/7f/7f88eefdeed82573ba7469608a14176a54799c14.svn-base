<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">                                                                                     
    <head>      
    	<meta charset="utf-8" />    
	    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Paramètres</title>
<!-- liens -->
            <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"> 
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.min.css">
    <!-- text field -->
            <script src="https://code.getmdl.io/1.2.1/material.min.js"></script>
    <!-- header -->
            <link rel="stylesheet" href="css/color-scheme.css" />
            <link rel="stylesheet" href="css/parametres.css" />
        </head>	

       
    </div> 

     <body>

    <div class="layout-color mdl-layout mdl-js-layout mdl-layout--fixed-header">		
        <%@include  file="/banner.html" %>>
    </div>
    <main class="mdl-layout__content">
    <div class="page-content">                                               
          <div class="column mdl-grid">                                                                    
           <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>       
           <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">
            <h3> Réinitialiser </h3>
            <div class="spacer"></div>
            <h1> Compte </h1>
            <div class="barre_colore"></div>
            <div class="spacer"></div>
            <!-- Simple Textfield : Email -->
       <form name = "reinitialiserMdp" method="post" action="Connexion">
       <% User utilisateur = (User) request.getSession().getAttribute( "userSession" );%>
        <% String mail = utilisateur.getEmail(); %>
            <div class="text">  Email : <span class="email"><%=mail%></span></div> 
        	<div class="mdl-textfield mdl-js-textfield log-status">
						<input class="form-control mdl-textfield__input" type="password" id="userpass" name="userpass" />
						<label class=" mdl-textfield__label" for="userpass">Password</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield">
						<input class="form-control mdl-textfield__input" type="password" id="userpassnew" name="userpassnew" value=""/>
						<label class=" mdl-textfield__label" for="userpassnew">New Password</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield">
						<input class="form-control mdl-textfield__input" type="password" id="userpassnewconfirm" name="userpassnewconfirm" value=""/>
						<label class=" mdl-textfield__label" for="userpassnewconfirm">Confirm your new Password</label>
			</div>
			<div class="card_signup mdl-card__actions mdl-card--border">
                <button type="submit" class="button_signup mdl-button mdl-js-button mdl-button--raised">Reinitialiser</button>
            </div>
            <input type="hidden" name="op" value="reinitialiserMdp">                        
         </div>
         </form>              

		</div>
           </div>
</div>
    </main>
</div>
 </body>
</html>

