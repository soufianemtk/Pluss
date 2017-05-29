package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Post;
import beans.User;
import facade.Compte;
import facade.CompteFacebook;
import facade.CompteTwitter;
import facade.ProfilImplementation;
import facebook4j.FacebookException;
import facebook4j.ResponseList;
import twitter4j.TwitterException;



@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	
	@EJB
	ProfilImplementation p;
	
	@EJB
	CompteTwitter ct;
	
	@EJB
	CompteFacebook cf;
	
	
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/synchronisation.jsp";
	public static final String VUE1 = "/WEB-INF/profil.jsp";
	public static final String VUE2 = "/WEB-INF/parametres.jsp";
	public static final String VUE3 = "/WEB-INF/editer_profil.jsp";
	public static final String VUE4 = "/WEB-INF/reinitialiser_mdp.jsp";
	public static final String VUE5 = "/WEB-INF/delete_account.jsp";
	public static final String ATT_SESSION_USER = "userSession";
	
	public static final String MAINVUE = "/WEB-INF/accueil.jsp";
	public static final String VUE_PREMIERE     = "/WEB-INF/authentification.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (CheckSessionPublic(request, response)){
			return;
		}else{
			
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute( ATT_SESSION_USER );
			String op;
			
			if(request.getParameter("op") != null){
				
				op = request.getParameter("op");
				
				if (op.equals("synchronisation")) {
					this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
				}
				
				if (op.equals("profil")) {
					Long id = u.getId();
					if(p.consulterProfil(id) == null) { 		// si ce user n'a pas encore de profil associé
						p.createProfil(id);
						p.associer(id, id);
					}
					
					request.setAttribute("profil", p.consulterProfil(id));

					ArrayList<beans.Post> postsTwitter = new ArrayList();
					ArrayList<beans.Post> postsFacebook = new ArrayList();
					
					boolean TwitterState = request.getParameter("icon-toggle-6") != null;
					boolean FacebookState = request.getParameter("icon-toggle-5") != null;
					
					if(ct.consulterAccount(id) != null && TwitterState){
						try {
							List<twitter4j.Status> listTw = ct.recupererPostsPerso(session);
							postsTwitter = ct.formaterPost(listTw);
						} catch (TwitterException e) {
							e.printStackTrace();
						}
						
					}
					if(cf.consulterAccount(id) != null && FacebookState){
						try {
							ResponseList<facebook4j.Post> listFb = cf.recupererPostsPerso(session);
							postsFacebook = cf.formaterPost(listFb);
						} catch (FacebookException e) {
							e.printStackTrace();
						}
					}
					postsTwitter.addAll(postsFacebook);
					postsTwitter.add(cf.helperPost());
					cf.trierPost(postsTwitter);
					Collections.reverse(postsTwitter);
					cf.DateToString(postsTwitter);
					String fileJsonFacebook = cf.JsonEncode(postsTwitter);
					String nameFileJson = ct.generateJSONfile(fileJsonFacebook, session);
					request.setAttribute("nameFileJson", nameFileJson);
					this.getServletContext().getRequestDispatcher(VUE1).forward( request, response );
				}
				
				if (op.equals("EditProfil")) {
					Long id = u.getId();					
					
					if(p.consulterProfil(id) == null) { 		// si ce user n'a pas encore de profil associé
						p.createProfil(id);
						p.associer(id, id);
					}
					
					request.setAttribute("profil", p.consulterProfil(id));
					this.getServletContext().getRequestDispatcher(VUE3).forward( request, response );
				}

/////////////////////////// SIGN IN API
				
				if (op.equals("signInTwitter")) {
					String URLauth;
					CompteTwitter cTwitter = new CompteTwitter();
					URLauth = cTwitter.lienLierComptes(session);
					response.sendRedirect(URLauth);
				}
				
				if (op.equals("signInTwitterConnected")) {
					
					Long id = u.getId();					
					String oauth_verifier;
					
					if(ct.consulterAccount(id) == null) { 		// si ce user n'a pas encore de profil associé
						ct.creerCompte(id);
						ct.associer(id, id);
					}
					try{
						oauth_verifier = request.getParameter("oauth_verifier");
						ct.setTokens(session, oauth_verifier);
					}catch(Exception e){
						System.out.println("no token received");
					}
				}
				
				if (op.equals("signInFacebook")) {
					String URLauth;
					try {
						CompteFacebook cFacebook = new CompteFacebook();
						URLauth = cFacebook.lienLierComptes(session);
						response.sendRedirect(URLauth);
					} catch (Exception e){
					}
				}
				
				if (op.equals("signInFacebookConnected")) {
					
					Long id = u.getId();					
					String code;
					
					if(cf.consulterAccount(id) == null) { 		// si ce user n'a pas encore de profil associé
						cf.creerCompte(id);
						cf.associer(id, id);
					}
					try{
						code = request.getParameter("code");
						cf.setTokens(session, code);
					}catch(Exception e){
						System.out.println("no token received");
					}

				}
				
///////////////////// PARAMETRES 
				
				if (op.equals("parametres")) {
					this.getServletContext().getRequestDispatcher(VUE2).forward( request, response );
				}
				
				if (op.equals("reinitialiserMdp")) {
					this.getServletContext().getRequestDispatcher(VUE4).forward( request, response );
				}
				
				if (op.equals("DeleteAccount")) {
					this.getServletContext().getRequestDispatcher(VUE5).forward( request, response );
				}
				
				if (op.equals("accueil")) {
					Long id = u.getId();

					ArrayList<beans.Post> postsTwitter = new ArrayList();
					ArrayList<beans.Post> postsFacebook = new ArrayList();
					
					boolean TwitterState = request.getParameter("icon-toggle-6") != null;
					boolean FacebookState = request.getParameter("icon-toggle-5") != null;
					
					if(ct.consulterAccount(id) != null && TwitterState){
						try {
							List<twitter4j.Status> listTw = ct.recupererPosts(session);
							postsTwitter = ct.formaterPost(listTw);
						} catch (TwitterException e) {
							e.printStackTrace();
						}
						
					}
					if(cf.consulterAccount(id) != null && FacebookState){
						try {
							ResponseList<facebook4j.Post> listFb = cf.recupererPosts(session);
							postsFacebook = cf.formaterPost(listFb);
						} catch (FacebookException e) {
							e.printStackTrace();
						}
					}
					postsTwitter.addAll(postsFacebook);
					postsTwitter.add(cf.helperPost());
					cf.trierPost(postsTwitter);
					Collections.reverse(postsTwitter);
					cf.DateToString(postsTwitter);
					String fileJsonFacebook = cf.JsonEncode(postsTwitter);
					String nameFileJson = ct.generateJSONfile(fileJsonFacebook, session);
					request.setAttribute("nameFileJson", nameFileJson);
					this.getServletContext().getRequestDispatcher(MAINVUE).forward( request, response );
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op =  request.getParameter("op");
		HttpSession session = request.getSession();
		User user=  (User) session.getAttribute("userSession");
		Long id = user.getId();
		if (op.equals("accueil")){
			doGet(request, response);
		}
		if (op.equals("profil")){
			doGet(request, response);
		}
		if (op.equals("modifier_profil")) {
			
			/** Pour l'instant je gere que les parametres de type text, les photos dynamiques arriveront ultérieurement
			 * 
			 * ci-dessous : invocation de la méthode modify correspondante au nom du ieme paramètre
			 */
			String photo_profil = request.getParameter("photo_profil");
			if (photo_profil != ""){
				p.modifyPhotoProfil(id,photo_profil);
			}
			String photo_couv = request.getParameter("photo_couv");
			if (photo_couv != ""){
				p.modifyPhotoCouv(id,photo_couv);
			}
			
			String nom = request.getParameter("nom");
			if (nom != ""){
				p.modifyNom(id, nom);
			}
			String prenom = request.getParameter("prenom");
			if (prenom != ""){
				p.modifyPrenom(id, prenom);
			}
			String adresse = request.getParameter("adresse");
			if (adresse != ""){
				p.modifyAdresse(id, adresse);
			}
			String num_phone = request.getParameter("num_phone");
			if (num_phone != ""){
				p.modifyNumPhone(id, num_phone);
			}
			String site_web = request.getParameter("site_web");
			if (site_web != ""){
				p.modifySiteWeb(id, site_web);
			}
			String date_naissance = request.getParameter("date_naissance");
			if (date_naissance != ""){
				p.modifyDDN(id, date_naissance);
			}
			String profession = request.getParameter("profession");
			if (profession != ""){
				p.modifyProfession(id, profession);
			}
			String biographie = request.getParameter("biographie");
			if (biographie != ""){
				p.modifyBio(id, biographie);
			}
			
			request.setAttribute("profil", p.consulterProfil(id));
			this.getServletContext().getRequestDispatcher(VUE3).forward( request, response );
		}
		if (op.equals("publier")) {
			Post post = new Post();
			post.setContent(request.getParameter("textPost"));
			ct.publier(post, session);
			cf.publier(post, session);
			this.getServletContext().getRequestDispatcher(MAINVUE).forward( request, response );
		}	
	}
	
	protected boolean CheckSessionPublic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		boolean sortie = false;
		if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page accueil */
			this.getServletContext().getRequestDispatcher( VUE_PREMIERE ).forward( request, response );
            sortie = true;
        }
		return sortie;
	}
	
	protected boolean CheckSessionPrive(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		boolean sortie = false;
		if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page accueil */
			this.getServletContext().getRequestDispatcher( VUE_PREMIERE ).forward( request, response );
            sortie = true;
        }
		return sortie;
	}

}
