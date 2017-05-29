<%@ page import="java.util.*, beans.*" %>
<%@ page import="java.util.*, facade.*" %>
<%@ page import="java.util.*, servlets.*" %>
<%@page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<% boolean TwitterState = request.getParameter("icon-toggle-6") != null; %>
<% boolean FacebookState = request.getParameter("icon-toggle-5") != null; %>
<% String sCheckFacebook = null; %>
<% String sCheckTwitter = null; %>
<% String dataDir = "https://pluss.ddns.net:8443/Pluss/data/"+ request.getAttribute("nameFileJson"); %>

<html lang="fr">
    <head>                                                                                           
        <meta charset="utf-8" />                                                                     
        <meta name="description" content="Projet d'un rÃ©seau social combinÃ©, un tunel direct vers tout les rÃ©seaux sociaux" />
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">                            
        <title> Plus </title>                                                                        
<!-- Page styles -->
    <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"> 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">           
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.min.css">
    <link rel="stylesheet" href="css/color-scheme.css">
	<link rel="stylesheet" href="css/profil.css">
    <link rel="stylesheet" href="css/filActu.css">  

    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script src="js/main.js"></script> 
    </head>

<!-- Script -->

        <div class="layout-color mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <%@include  file="/banner.html" %>
        </div>

    <body>
    <main class="mdl-layout__content">
        <div class="page-content">

<!--  Declaration des variables dynamiques -->
	<%  ProfilUser profil = (ProfilUser)request.getAttribute("profil");
		String nom = profil.getNom();
		String prenom = profil.getPrenom();
		String adresse = profil.getAdresse();
		String num_phone = profil.getNumPhone();
		String site_web = profil.getSiteWeb();
		String date_naissance = profil.getDDN();
		String profession = profil.getProfession();
		String biographie = profil.getBio();
		String photo_profil = profil.getPhotoProfil();
		String photo_couv = profil.getPhotoCouv();
	%>
<!--  Declaration de constantes -->
	<%! final String NOM = "Hendrix";
		final String PRENOM = "Jimi";
		final String ADRESSE = "exemple : 8 avenue des Champs Elysées, 75 Paris, France";
		final String NUM_PHONE = "exemple : +33 6 75 92 31 56";
		final String SITE_WEB = "exemple : www.pluss.fr";
		final String DATE_NAISSANCE = "exemple : 18 / 03 / 1996";
		final String PROFESSION = "exemple : Etudiant";
		final String PHOTO_PROFIL = "images/profil_pictureDEV.jpg";
		final String PHOTO_COUV = "images/IMGmulhouse.jpg"; 
	%>
<!-- Couverture, photo profile  -->
	                                                                
    <div class="page-content">

<!-- BANNIERE -->
<!-- Image card -->
<div class="banner_position mdl-card mdl-shadow--2dp">
  <div class="banner_zone mdl-card__supporting-text">
  <div class="infosProfil">
      <img class="imageProfil" src="images/profil_pictureDEV.jpg">
      <div class="spacerTitle">
      <span class="nomsPrenom">
      <% if (nom == null) { nom = ""; } %>
      	<% if (prenom == null) { prenom = ""; } %>
		<%= nom  + " " %> <%= prenom %></span></div>
	  <a href="Main?op=EditProfil" class="editer_profil mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Mettre à  jour<i class="icon-publier material-icons">edit</i></a>
 
   <!-- photo couverture -->
  </div> 
	<% if (photo_couv == null || photo_couv == "") { photo_couv = PHOTO_COUV; }  %>
	<img class="banner_profil" id="image_couv" src="<%= photo_couv %>" />   	 
  </div>
</div>


<!-- SECTION PUBLIER -->                                                                             
<div class="publication_content" id="publication_content">                                           
    <div class="voile" id="voile"></div>                                                             
    <!-- SECTION PUBLIER FORMULAIRE -->                                                              
    <div class="publication_content_form">                                                           
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">                                        
                                                                                                     
        <div class="mdl-card__title">                                                                
            <h2>Publier</h2>                                                                         
        <div class="mdl-card__menu">                                                                 
                <a id="send_boutton" class="envoyer_b mdl-button  mdl-js-button mdl-js-ripple-effect">Envoyer</a>
        </div>                                                                                       
        </div>                                                                                       
                                                                                                     
            <!-- text field -->                                                                      
      <div class="mdl-card__supporting-text">                                                        
        <div class="zone_text mdl-textfield mdl-js-textfield">                                       
            <textarea class=" mdl-textfield__input" type="text" rows= "3" id="sample5" ></textarea>  
            <label class="mdl-textfield__label" for="sample5">Exprimez vous !</label>                
        </div>                                                                                       
        <div class="icon-bar">                                                                       
             <a href="#"><i class="publication_icons material-icons">photo_camera</i></a>            
             <a href="#"><i class="publication_icons material-icons">add_location</i></a>            
        </div>                                                                                       
      </div>                                                                                         
                                                                                                     
      <div class="mdl-card__actions mdl-card--border">                                               
        <div>                                                                                        
            <label class="mdl-icon-toggle mdl-js-icon-toggle mdl-js-ripple-effect" for="icon-toggle-1">
                <input type="checkbox" id="icon-toggle-1" class="mdl-icon-toggle__input">    
            <i class="social-icons mdl-icon-toggle__label fa fa-facebook"></i>                       
            </label>                                                                                 
                                                                                                     
            <label class="mdl-icon-toggle mdl-js-icon-toggle mdl-js-ripple-effect" for="icon-toggle-2">
                <input type="checkbox" id="icon-toggle-2" class="mdl-icon-toggle__input">            
                <i class="social-icons mdl-icon-toggle__label fa fa-twitter"></i>                    
            </label>                                                                                 
                                                                                
        </div>                                                                                       
      </div>                                                                                         
    </div>                                                                                           
    </div>                                                                                           
</div>      


<!-- SECTION ACTUALITE -->
<div class="actualite_content" id="actualite_content">
	<div class="column mdl-grid">                                                        
          <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>       
          <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">
            <form method="post" action="Main?op=profil" id="submitFilter">
            <div class="filtres">
			<label id="labelFacebook" class="mdl-icon-toggle mdl-js-icon-toggle mdl-js-ripple-effect" for="icon-toggle-5">
  				<input type="checkbox" name="icon-toggle-5" id="icon-toggle-5" class=" mdl-icon-toggle__input" 
  				<% if (FacebookState) {
  					sCheckFacebook = "checked"; }%>
  				<%= sCheckFacebook %> >
			    <label for="icon-toggle-5" class="facebook-filter social-icons mdl-icon-toggle__label fa fa-facebook"></label>
			</label>			
			
			<label id="labelTwitter" class="mdl-icon-toggle mdl-js-icon-toggle mdl-js-ripple-effect" for="icon-toggle-6">
  				<input type="checkbox" name="icon-toggle-6" id="icon-toggle-6" class="mdl-icon-toggle__input"
  				<% if (TwitterState) {
  					sCheckTwitter = "checked"; }%>
  				<%= sCheckTwitter %> >
 				<label class="twitter-filter social-icons mdl-icon-toggle__label fa fa-twitter" ></label>
			</label>
			</form>
            </div>

<div id="placeholder" ></div>
		<script>
			$.getJSON( "<%= dataDir %>" ,{}, function(data) {
			
			var output= "";
            for (var i in data.posts) {
            	output+= "<div class=\"post wide-card mdl-card mdl-shadow--2dp\">" 
            	  + "<div class=\"mdl-card__title\"> "
            	  +	"<img class=\"message_picture\" src=\"" + data.posts[i].profilPicture + "\">"
            	  + "<div class=\"mdl-card__title-text\"> "
            	  + "<span class=\"name_post\"> " + data.posts[i].name + "</span></div></div>"
            	  + "<div class=\"message_post mdl-card__supporting-text\">" + data.posts[i].content + "</div>"
            	  + "<div class=\"mdl-card__menu\">"
            	  + "<span class=\"time_post\">" + data.posts[i].time + "</br></span>"
            	  + "<span class=\"network_post\">"
            	  + "<label class=\"social-icons mdl-icon-toggle__label " + data.posts[i].socials + "\"\"></label>"
            	  + "</span></div></div>";
        	}
        document.getElementById("placeholder").innerHTML=output;
        })
        </script>
		</div>
	</div>

		</div>                 
  
        <!-- Bouton publier mobile -->
        <a id="publier" class="boutton-publier mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"><i class="material-icons">edit</i></a>	
        <!-- Bouton publier normal -->
        <a id="publier_mobile" class="boutton-publier-normal mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Publier<i class="icon-publier material-icons">edit</i></a>	
	</main>
</div>

	<script src="https://code.getmdl.io/1.2.1/material.min.js"></script>  
	
	</body>
</html>

