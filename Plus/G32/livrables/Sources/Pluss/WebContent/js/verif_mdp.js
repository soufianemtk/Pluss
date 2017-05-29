	  $(document).readyfunction checkMdp() {
		  	var mdp = document.getElementById("nouveau_mdp").value;
		  	var mdp2 = document.getElementById("nouveau_mdp2").value;
		  		if (mdp!=mdp2) {
		  			var msg = document.createTextNode("Confirmation du mot de passe invalide");
		  			document.getElementById("mdperror").appendChild(msg);
		  		}
	  }
