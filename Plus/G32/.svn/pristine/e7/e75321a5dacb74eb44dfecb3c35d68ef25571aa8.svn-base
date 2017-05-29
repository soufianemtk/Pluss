package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;
import form.*;
import beans.*;
import facade.*;

@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	
	@EJB
	UserCompteImplementation compte;
	
	private static final long serialVersionUID = 1L;
	public static final String VUE_PREMIERE     = "/WEB-INF/authentification.jsp";
	public static final String VUE_INSCRIPTION  = "/WEB-INF/inscription.jsp";
	public static final String VUE_PWD  		= "/WEB-INF/pwd_forgotten.jsp";
	public static final String VUE_REINITIALISER = "/WEB-INF/reinitialiser_mdp.jsp";
	public static final String ATT_USER         = "user";
    public static final String ATT_FORM         = "formulaire";
	public static final String ATT_SESSION_USER = "userSession";
    public static final String VUE_ACCUEIL 	= "/WEB-INF/accueil.jsp";
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation =  request.getParameter("op");
		if (operation != null){
		if (operation.equals("Deconnexion")) {
			HttpSession session = request.getSession();
	        session.invalidate();
	        request.getRequestDispatcher( VUE_PREMIERE ).forward(request, response);
	        return;
		}else if (operation.equals("DeleteAccountOUI")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute( ATT_SESSION_USER );
			System.out.println(user.getEmail());
			compte.deleteUser(user);
			session.invalidate();
			request.getRequestDispatcher( VUE_PREMIERE ).forward(request, response);
	        return;
		}else if (operation.equals("DeleteAccountNON")) {
			request.getRequestDispatcher( VUE_ACCUEIL ).forward(request, response);
	        return;
		}
		doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation =  request.getParameter("op");
		if (operation.equals("Authentification")) {
			Authentification formulaire = new Authentification(compte);
			User user = formulaire.connectUser(request);
			
			if (user != null){
				/* Récupération de la session depuis la requête */
				HttpSession session = request.getSession();
				/**
				 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
				 * Utilisateur à la session, sinon suppression du bean de la session.
				 */
				if ( formulaire.getErreurs().isEmpty() ) {
					session.setAttribute( ATT_SESSION_USER, user );
					compte.setId(user); //set le ID de notre côté
					request.getRequestDispatcher("/Main?&op=accueil").forward(request, response);
					return;
				} else {
					this.getServletContext().setAttribute( ATT_SESSION_USER, null ); //detruire session invalidate
		        }
			}
			this.getServletContext().getRequestDispatcher( VUE_PREMIERE ).forward(request, response);
			return;
			
		}else if (operation.equals("Inscription")){
			Inscription formulaire = new Inscription(compte);
			User user = formulaire.userRegister(request);
			System.out.println(user);
			if ( formulaire.getErreurs().isEmpty() && user != null) {
				compte.addUser(user);
		        request.setAttribute( ATT_FORM, formulaire );
		        request.setAttribute( ATT_USER, user );
		        HttpSession session = request.getSession();
		        session.setAttribute( ATT_SESSION_USER, user );
		        System.out.println(user.getId());
		        request.getRequestDispatcher("/Main?&op=accueil").forward(request, response);
		        return;
			} else {
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}*/
				request.setAttribute( ATT_FORM, formulaire );
	        } 
	        request.getRequestDispatcher( VUE_INSCRIPTION ).forward( request, response );

			
		} else if (operation.equals("pwdforgotten")) {
			request.getRequestDispatcher( VUE_PWD ).forward( request, response );
		}
		if (operation.equals("reinitialiserMdp")) {
			ReinitialiserMdp reiMdp = new ReinitialiserMdp(compte);
			User user = reiMdp.userPassword(request);
			compte.refreshUser(user);
			request.getRequestDispatcher( VUE_ACCUEIL ).forward(request, response);
		}
	}
	
	protected boolean CheckSessionPublic(HttpServletRequest request, HttpServletResponse response, String VUE) throws IOException, ServletException {
		HttpSession session = request.getSession();
		boolean sortie = false;
		if ( session.getAttribute( ATT_SESSION_USER ) != null ) {
            /* Redirection vers la page accueil */
			System.out.println("OUI");
			request.getRequestDispatcher( VUE ).forward( request, response );
            sortie = true;
        }
		return sortie;
	}
	
	protected boolean CheckSessionPrive(HttpServletRequest request, HttpServletResponse response, String VUE) throws IOException, ServletException {
		HttpSession session = request.getSession();
		boolean sortie = false;
		if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page accueil */
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            sortie = true;
        }
		return sortie;
	}
}
