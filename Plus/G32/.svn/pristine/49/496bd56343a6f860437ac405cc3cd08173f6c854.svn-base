<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, beans.*" %>
<%@ page import="java.util.*, facade.*" %>
<%@ page import="java.util.*, servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	
	<!-- liens bibli de css  -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">           
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.min.css">
	
	<!-- text field -->
	<script src="https://code.getmdl.io/1.2.1/material.min.js"></script>
	
	<!-- css de cet page -->
	<link rel="stylesheet" href="css/color-scheme.css" />
	<link rel="stylesheet" href="css/profil.css" /> 
	<link rel="stylesheet" href="css/editer_profil.css" type="text/css" />


</head>



<!-- Header -->
 
<div class="layout-color mdl-layout mdl-js-layout mdl-layout--fixed-header">		
	<%@include  file="/banner.html" %>
</div>  
	
	
<body>
<main class="mdl-layout__content"> 

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
	<%! final String NOM = "exemple : Hendrix";
		final String PRENOM = "exemple : Jimi";
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

<form method="post" action="Main">
<div class="banner_position mdl-card mdl-shadow--2dp">
  <div class="banner_zone mdl-card__supporting-text">
  <!-- photo profil + nom/prenom"  -->
  <div class="infosProfil">
      <% if (photo_profil == null || photo_profil == "") { photo_profil = PHOTO_PROFIL; }  %>  
      <img class="imageProfil" id="image_profil" src="<%= photo_profil %>"/>
      <!-- Bouton "editer photo profil"  -->
      <div class="bouton-edit-profil">
	  <input name="editer_pp" class="button-spec mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" 
	  		value="Editer">
      </div>
      <!--  nom/prenom -->
      <div class="spacerTitle">
      <span class="nomsPrenom">
      	<% if (nom == null) { nom = ""; } %>
      	<% if (prenom == null) { prenom = ""; } %>
		<%= nom  + " " %> <%= prenom %>
      </span></div>
  </div>
	<!-- photo couverture -->
	<% if (photo_couv == null || photo_couv == "") { photo_couv = PHOTO_COUV; }  %> 
	<img class="banner_profil" id="image_couv" src="<%= photo_couv %>" />
	<!-- Bouton "editer photo couverture"  -->
	<div class="bouton-edit-cover">
		<input name="editer_cover" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect button-spec" value="Editer">
	</div>         	 
  </div>
</div>


<!-- Texte des différents champs :

Remarque : 	le # doit etre remplacer par l'URL auquel est 
			envoyé la donnée.
			(Where to send the form-data when the form is submitted)
-->

	<div class="cadre mdl-shadow--4dp">	
	
		<!-- Simple Textfield : Nom -->
		<div class="cadre2">
			<div class="text_titre_bloc">Nom : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="nom">
				<label class="mdl-textfield__label"  for="sample1"> 
				<%  if (nom == null || nom == "") {
					 nom = NOM; }%>
				<%= nom %></label>
			</div>
		</div>	
		
		<!-- Simple Textfield : Prenom -->
		<div class="cadre2">
			<div class="text_titre_bloc">Prenom : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="prenom">
				<label class="mdl-textfield__label"  for="sample1"> 
				<% if (prenom == null || prenom == "") {
					 prenom = PRENOM; }%>
				<%= prenom %> </label>
			</div>
		</div>		
	
		<!-- Simple Textfield : Adresse postale -->
		<div class="cadre2">
			<div class="text_titre_bloc">Adresse : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="adresse">
				<label class="mdl-textfield__label"  for="sample1">
				<% if (adresse == null || adresse == "") {
					 adresse = ADRESSE; }%>
				<%= adresse %> </label>
			</div>
		</div>	
		
	
			
		<!-- Simple Textfield : Numero de telephone -->
		<div class="cadre2">
			<div class="text_titre_bloc">Numero de telephone : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="num_phone">
				<label class="mdl-textfield__label" for="sample1">
				<% if (num_phone == null || num_phone == "") {
					num_phone = NUM_PHONE; }%>
				<%= num_phone %> </label>
			</div>
		</div>
			
		<!-- Simple Textfield : Adresse site web -->
		<div class="cadre2">
			<div class="text_titre_bloc">Site web : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="site_web">
				<label class="mdl-textfield__label" for="sample1">
				<% if (site_web == null || site_web == "") {
					site_web = SITE_WEB; }%>
				<%= site_web %> </label>
			</div>
		</div>	
			
		<!-- Simple Textfield : Date de naissance -->
		<div class="cadre2">
			<div class="text_titre_bloc"> Date de naissance : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="date_naissance">
				<label class="mdl-textfield__label" for="sample1">
				<% if (date_naissance == null || date_naissance == "") {
					date_naissance = DATE_NAISSANCE; }%>
				<%= date_naissance %> </label>
			</div>
		</div>	
			
		<!-- Simple Textfield : Formation / Emploi -->
		<div class="cadre2">
			<div class="text_titre_bloc"> Formation / Emploi : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" name="profession">
				<label class="mdl-textfield__label" for="sample1">
				<% if (profession == null || profession == "") {
					profession = PROFESSION; }%>
				<%= profession %> </label>
			</div>
		</div>	
			
		<!-- Textfield  Area : Biographie -->
		<div class="cadre2">
			<div class="text_titre_bloc"> Biographie : </div>
			<div class="textfield mdl-textfield mdl-js-textfield">
				<textarea class="mdl-textfield__input" type="text" rows= "3" name="biographie" ></textarea>
				<label class="mdl-textfield__label" for="sample5"> 
				<% if (biographie == null || biographie == "") {
					biographie = "200 mots max !"; }%>
				<%= biographie %> </label>
			</div>
		</div>	
	                                                                    
                                                               
        <input name="send_boutton" value="METTRE A JOUR" class="mdl-button  mdl-js-button mdl-js-ripple-effect envoyer_b" type="submit">
		<input type="hidden" name="op" value="modifier_profil">	
	
	</div>
	</form>
	
</div>
</main>
	
	<script src="https://code.getmdl.io/1.2.1/material.min.js"></script> 
	
</body>
</html>
