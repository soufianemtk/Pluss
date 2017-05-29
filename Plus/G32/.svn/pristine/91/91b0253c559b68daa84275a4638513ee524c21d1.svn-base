package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import form.CryptageMD5;

import beans.User;
import facade.UserCompteImplementation;

public class Authentification {
	private static final String CHAMP_EMAIL  = "usermail";
    private static final String CHAMP_PASS   = "userpass";
    private UserCompteImplementation compte;
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Authentification( UserCompteImplementation compte ) {
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
    
    public User connectUser( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String usermail = getValeurChamp( request, CHAMP_EMAIL );
        String userpass = getValeurChamp( request, CHAMP_PASS );

        User user = new User();
        User userFound = new User();

        /* Validation du champ email. */
        try {
            validationEmail( usermail );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail(usermail);

        /* Validation du champ mot de passe. */
        try {
        	userFound = this.compte.findUser(usermail);
        	String userpassBDD = userFound.getPassword();
        	
        	CryptageMD5 crypteur = new CryptageMD5(userpass);
        	String userpassCrypted = crypteur.codeGet();
            
        	validationPassword( userpassBDD,  userpassCrypted);
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        user.setPassword(userpass);

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "You're now connected.";
            return user;
        } else {
            resultat = "Connection failed.";
            return null;
        }
    }
    
    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String usermail ) throws Exception {
    	if ( usermail == null ) {
            throw new Exception( "Please, enter your email." );
        }else if (this.compte.findUser(usermail) == null){
        	throw new Exception( "This email isn't linked to any account." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationPassword( String userpass, String userpassTest ) throws Exception {
        if ( userpass != null ) {
            if ( userpass.length() < 3 ) {
                throw new Exception( "Passwords should be at least 3 letters long" );
            }else if (!userpass.equals(userpassTest)) {
                throw new Exception("Wrong password. Try again!");
            }
        } else {
            throw new Exception( "Please, enter your password." );
        }
    }
    
}
