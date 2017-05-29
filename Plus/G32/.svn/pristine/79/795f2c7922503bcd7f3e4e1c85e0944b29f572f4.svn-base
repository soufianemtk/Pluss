<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<body>
	<div class="layout-color mdl-layout mdl-js-layout mdl-layout--fixed-header">		
        <%@include  file="/banner.html" %>>
    </div>
    <main class="mdl-layout__content">
    <div class="page-content">                                               
          <div class="column mdl-grid">                                                                    
           <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>       
           <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">
            <h3> Suppresion compte </h3>
            <div class="spacer"></div>
            <h1> Compte </h1>
            <div class="barre_colore"></div>
            <div class="spacer"></div>
            <!-- Simple Textfield : Email -->
        <div class="cadre3 mdl-shadow--0dp">
        	<div class="text">  Voulez vous réellement supprimer votre compte ?   </div>
        	<br/> 
        	<div class="text">  Notez que cette opération sera irréversible !   </div>
        	
        	<form name = "DeleteAccount" method="get" action="Connexion">
        <div class="cadre3 mdl-shadow--0dp">   
                <button class="button-reset mdl-button boutton_param mdl-js-button">OUI</button>
               	<input type="hidden" name="op" value="DeleteAccountOUI">                        
         </div>
         </form>
         
         <form name = "DeleteAccount" method="get" action="Connexion">
        <div class="cadre3 mdl-shadow--0dp">   
                <button class="button-reset mdl-button boutton_param mdl-js-button">NON</button>
               	<input type="hidden" name="op" value="DeleteAccountNON">                        
         </div>
         </form>
      </div>
      </main>

</body>
</html>