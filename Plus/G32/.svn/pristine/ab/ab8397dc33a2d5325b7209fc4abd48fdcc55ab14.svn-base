<%@ page import="java.util.*, beans.*" %>
<%@ page import="java.util.*, facade.*" %>
<%@ page import="java.util.*, servlets.*" %>
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
		<%@include  file="/banner.html" %>
    </div>
    <main class="mdl-layout__content">
    <div class="page-content">                                               
          <div class="column mdl-grid">                                                                    
           <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>       
           <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">
            <h3> Mes paramètres </h3>
            <div class="spacer"></div>
            <h1> Compte </h1>
            <div class="barre_colore"></div>
            <div class="spacer"></div>
            <!-- Simple Textfield : Email -->
        <div class="cadre3 mdl-shadow--0dp">
        <% User utilisateur = (User) request.getSession().getAttribute( "userSession" );%>
        <% String mail = utilisateur.getEmail(); %>
            <div class="text">  Email : <span class="email"><%=mail%></span></div> 
        
        <br/>
            <!-- Simple Textfield : Reinitialiser mot de passe -->

		<form name = "reinitialiserMdp" method="get" action="Main">
        <div class="cadre3 mdl-shadow--0dp">
                <div class ="text"> Mot de passe:    
                     <button class="button-reset mdl-button boutton_param mdl-js-button">Reinitialiser</button>
                </div>
               	<input type="hidden" name="op" value="reinitialiserMdp">                        
         </div>
         </form>              
        <!-- Simple Textfield : deconnexion -->

		<form name = "reinitialiserMdp" method="get" action="Connexion">
        <div class="cadre3 mdl-shadow--0dp">
                <div class ="text"> Deconnexion:    
                     <button class="button-reset mdl-button boutton_param mdl-js-button">Deconnexion</button>
                </div>
               	<input type="hidden" name="op" value="Deconnexion">                        
         </div>
         </form>
         
         <form name = "DeleteAccount" method="get" action="Main">
        <div class="cadre3 mdl-shadow--0dp">
                <div class ="text"> Supprimer mon compte Pluss:    
                     <button class="button-reset mdl-button boutton_param mdl-js-button">Suppression</button>
                </div>
               	<input type="hidden" name="op" value="DeleteAccount">                        
         </div>
         </form>  
		</div>
           </div>
</div>
    </main>
</div>
 </body>
</html>

