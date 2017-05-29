package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import form.CryptageMD5;

import beans.User;
import facade.UserCompteImplementation;

public class Inscription {
	public static final String CHAMP_EMAIL = "usermail";
	public static final String CHAMP_EMAIL_CONFIRM = "usermailconfirm";
    public static final String CHAMP_PASS = "userpass";
    public static final String CHAMP_PASS_CONF = "userpassconfirm";
    public static final String CHAMP_USERNAME = "username"; 
    
    private UserCompteImplementation compte;
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    
    public Inscription( UserCompteImplementation compte ) {
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
    
    /* Enregistrement d'un nouvel utilisateur */
    public User userRegister( HttpServletRequest request ) {
        String usermail = getValeurChamp( request, CHAMP_EMAIL );
        String usermailconfirm = getValeurChamp( request, CHAMP_EMAIL_CONFIRM );
        String userpass = getValeurChamp( request, CHAMP_PASS );
        String userpassconfirm = getValeurChamp( request, CHAMP_PASS_CONF );
        String username = getValeurChamp( request, CHAMP_USERNAME );

        User user = new User();
        
        emailCheck(usermail, usermailconfirm, user);
        passwordCheck (userpass, userpassconfirm, user);
        usernameCheck (username, user);
    
       	if ( erreurs.isEmpty() ) {
       		resultat = "You're now registred on Pluss.";
       	} else {
       		resultat = "Inscription failed.";
        }

        return user;
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
    
    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String usermail, String usermailconfirm ) throws FormValidationException {
    	if ( usermail != null && usermail.trim().length() != 0 
    		&& usermailconfirm != null && usermailconfirm.trim().length() != 0) {
    		User userbdd = null;
    		try {
    			userbdd = this.compte.findUser( usermail );
    		}catch(Exception j){
    		}
    		if (!usermail.equals(usermailconfirm)){
    			throw new FormValidationException( "The two email adresses are different" );
    		} else if ( userbdd != null) {
    			throw new FormValidationException( "This Email adress is already used" );
    		}
        } else {
            throw new FormValidationException( "Please, give and confirm your email adress if you want to register" );
        }
    }
    
    /**
     * Traitement de l'adresse mail saisie et enregistrement.
     */
    private void emailCheck (String usermail, String usermailconfirm, User user){
    	try {
            validationEmail( usermail, usermailconfirm );
    	} catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail( usermail );
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
    private void passwordCheck (String userpass, String userpassconfirm, User user){
    	String userpassCrypted = userpass;
    	try {
            validationPassword( userpass, userpassconfirm );
            CryptageMD5 crypteur = new CryptageMD5(userpass);
       	 	userpassCrypted = crypteur.codeGet();
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_PASS_CONF, null );
        }

        user.setPassword( userpassCrypted );
    }
    
    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationUsername( String username ) throws Exception {
        if ( username != null && username.trim().length() < 5 ) {
            throw new Exception("Your username should be at least 5 letters long");
        }
    }
    
    /**
     * Traitement de l'id saisi et enregistrement.
     */
    private void usernameCheck (String username, User user){
    	try {
            validationUsername( username );
        } catch ( Exception e ) {
            setErreur( CHAMP_USERNAME, e.getMessage() );
        }
        user.setUsername( username );
    }
}
