package form;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import beans.User;
import facade.UserCompteImplementation;



public class ReinitialiserMdp {
	public static final String CHAMP_EMAIL = "usermail";
    public static final String CHAMP_PASS = "userpass";
    public static final String CHAMP_NEW_PASS = "userpassnew";
    public static final String CHAMP_NEW_PASS_CONF = "userpassnewconfirm";
    
     
    
    private UserCompteImplementation compte;
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    
	@PersistenceContext(unitName="MaPU")
	private EntityManager em;
    
    public ReinitialiserMdp( UserCompteImplementation compte ) {
        this.compte = compte;
    }
    
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    /* Enregistrement d'un nouveau mot de passe */
    public User userPassword( HttpServletRequest request ) {
    	User userSession = (User) request.getSession().getAttribute("userSession");
    	String email = userSession.getEmail();
        String ancien_mdp = getValeurChamp( request, CHAMP_PASS );
        String nouveau_mdp = getValeurChamp( request, CHAMP_NEW_PASS );
        String nouveau_mdp2 = getValeurChamp( request, CHAMP_NEW_PASS_CONF);
        //int id = userSession.getId();
        //User user = (User) em.find(User.class, id);
       // System.out.println(user);
        
       	return passwordCheck (email, ancien_mdp, nouveau_mdp, nouveau_mdp2, userSession);
    }
   
  
	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur;
		}
	}
	
	  /*
     * Valide si le mot de passe rentré est bien celui qui a été enregistré
     */
   private void validationAncienMdp(String email, String ancien_mdp) throws Exception{
	  
	   String userpassCrypted = ancien_mdp;
	   CryptageMD5 crypteur = new CryptageMD5(ancien_mdp);
   	   userpassCrypted = crypteur.codeGet();
   	   User user = compte.findUser(email);
   	   if (userpassCrypted != user.getPassword()){
   		   throw new Exception("Wrong Password");
   	   }
   	   
   }
	

	/**
	 * Valide si les password saisis sont utilisables.
	 */
	private void validationPassword( String userpass, String userpassconfirm ) throws Exception{
		if (userpass != null && userpass.trim().length() != 0 && userpassconfirm != null && userpassconfirm.trim().length() != 0) {
			if (!userpass.equals(userpassconfirm)) {
				throw new Exception("The two given passwords are different. Try again");
			} else if (userpass.trim().length() < 6) {
				throw new Exception("Your password should be at least 6 letters length");
			}
		} else {
			throw new Exception("Thanks to enter and confirm your password");
		}
	}

	/**
	 * Traitement du password saisi et enregistrement.
	 */
	private User passwordCheck (String email, String ancien_mdp, String userpass, String userpassconfirm, User user){
		String userpassCrypted = userpass;
		User userRetour = user;
		try {
			//validationAncienMdp(email, ancien_mdp);
			validationPassword( userpass, userpassconfirm );
			CryptageMD5 crypteur = new CryptageMD5(userpass);
        	userpassCrypted = crypteur.codeGet();
        	System.out.println(userpassCrypted);
        	userRetour.setPassword( userpassCrypted );
		} catch ( Exception e ) {
			setErreur( CHAMP_NEW_PASS, e.getMessage() );
			setErreur( CHAMP_NEW_PASS_CONF, null );
		}
		return userRetour;
	} 

}
