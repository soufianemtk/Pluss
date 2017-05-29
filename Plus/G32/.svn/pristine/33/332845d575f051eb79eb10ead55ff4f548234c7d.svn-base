package facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import beans.Post;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;
import org.json.*;

@Singleton
public class CompteFacebook {
	
	@PersistenceContext(unitName="MaPU")
	private EntityManager em;
		
	private static String ConsumerKey = "1139213636172981";
	private static String ConsumerSecret = "dafea330f974148fbd3e656a7a22c636";
	
	private static String testFullAccessToken = "EAAQMG9gbfLUBAEE6ZCvTaUp2HMv4KYjfrvKzJ5DcmZCLOkk2nM2yQhHX01bNKU2aKltRZBAMy3chpGffa3dZBbTHZBRMnW5RWptApVLOREKoZBgv31cL5dm176taM1JZC2NyVk3uChMIyr1PTxQ8N7zqqBlGnMGbNWQr2D1UFUX4gZDZD"; // A METTRE POUR FAIRE LES TESTS FACEBOOK
	
	public void creerCompte(Long id) {
		FacebookAccount facebookAcc = new FacebookAccount();
		facebookAcc.setId(id);
		em.persist(facebookAcc);
	}
	
	public FacebookAccount consulterAccount(Long id) {
		FacebookAccount facebookAcc = em.find(FacebookAccount.class, id);
		return facebookAcc;
	}
	
	public void associer(Long id_user, Long id_compteFacebook) {
		FacebookAccount facebookAcc = (FacebookAccount)em.find(FacebookAccount.class, id_compteFacebook);
		beans.User owner = (beans.User)em.find(beans.User.class, id_user);
		owner.setFacebookAcc(facebookAcc);
		facebookAcc.setUser(owner);
	}

	public String lienLierComptes(HttpSession session) throws IOException {
		String authURL = null;
		try {		
			Facebook facebook=null;
			ConfigurationBuilder cb = new ConfigurationBuilder();
			   
			cb.setDebugEnabled(true)
			     .setOAuthAppId(ConsumerKey)
			     .setOAuthAppSecret(ConsumerSecret)
			     .setUseSSL(true);
			
			facebook = new FacebookFactory(cb.build()).getInstance();
			session.setAttribute("facebook",facebook);
			authURL = facebook.getOAuthAuthorizationURL("https://pluss.ddns.net:8443/Pluss/Main?op=signInFacebookConnected");
		} catch(Exception e){
			System.out.println("erreur liaison de compte facebook");
		}
		return authURL;
	}

	public Object ouvrirConnexion(Long id) throws IOException {
		
		Facebook facebook=null;
		
		try {
		   FacebookAccount facebookAcc = consulterAccount(id);
		   ConfigurationBuilder cb = new ConfigurationBuilder();
		   
		   String accessToken = facebookAcc.getToken();
		   
		   cb.setDebugEnabled(true)
		     .setOAuthAppId(ConsumerKey)
		     .setOAuthAppSecret(ConsumerSecret)		     
		     .setOAuthAccessToken(accessToken)
			 .setOAuthPermissions("user_status ,user_posts , friends_status,email, publish_stream, id, name, first_name, last_name, generic")
		     .setUseSSL(true);
		   	 
			facebook = new FacebookFactory(cb.build()).getInstance();
		} catch(Exception e){
			System.out.println("Erreur Connexion Impossible");
		}
			return facebook;
		}
	
	public void setTokens(HttpSession session, String code){
		Facebook facebook = (Facebook) session.getAttribute("facebook");
		beans.User user = (beans.User) session.getAttribute("userSession");
		try {
			Long id;
			AccessToken accessToken;
			facebook.getOAuthAccessToken(code);
			accessToken = facebook.getOAuthAccessToken();
			
			String finalAccessToken = accessToken.getToken();
		    id = user.getId();
		    this.modifyTokens(id,finalAccessToken);
			
		} catch(FacebookException  facebookException) {
			facebookException.printStackTrace();
		}	
	}
	
	public void modifyTokens(Long id, String finalAccessToken) {
		FacebookAccount facebookAcc = this.consulterAccount(id);
		facebookAcc.setToken(testFullAccessToken);
		System.out.println(finalAccessToken);
	}
		
	public void publier(Post post, HttpSession session){
		beans.User user = (beans.User) session.getAttribute("userSession");
		Long id = user.getId();
		try {
			Facebook facebook = (Facebook) ouvrirConnexion(id);
			String content= post.getContent();
			facebook.postStatusMessage(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResponseList<facebook4j.Post> recupererPosts(HttpSession session) throws FacebookException{
		beans.User user = (beans.User) session.getAttribute("userSession");
		Facebook facebook = (Facebook) session.getAttribute("facebook");
		Long id = user.getId();
		if (facebook == null){
			try {
				facebook = (Facebook) ouvrirConnexion(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		ResponseList<facebook4j.Post> post = facebook.getFeed();
		
		return post;
		}
	
	public ResponseList<facebook4j.Post> recupererPostsPerso(HttpSession session) throws FacebookException{
		beans.User user = (beans.User) session.getAttribute("userSession");
		Facebook facebook = (Facebook) session.getAttribute("facebook");
		Long id = user.getId();
		if (facebook == null){
			try {
				facebook = (Facebook) ouvrirConnexion(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		ResponseList<facebook4j.Post> post = facebook.getFeed();
		
		return post;
		}
	
	public ArrayList<beans.Post> formaterPost(ResponseList<facebook4j.Post> list){
		ArrayList<beans.Post> listFormat = new ArrayList<beans.Post>();
		for(facebook4j.Post p : list){
			Post pi = new Post();
			pi.setContent(p.getMessage());
			pi.setName("A DEFINIR");
			pi.setProfilPicture("https://goo.gl/fgNdvo");
			pi.setDate(p.getCreatedTime());
			pi.setSocials("facebook-tag fa fa-facebook");
			listFormat.add(pi);
		}
		return listFormat;
	}
	
	
// UTILITAIRE A CHANGER DE CLASSE
	
	private String ContentHelp = "Bienvenue sur notre plateforme Pluss ! Synchronisez vos comptes dès maintenant"
								+ " via la rubrique SYNCHRONISATION afin de profiter d'une experience inédite.";
	private String URLHelp = "http://bit.ly/2ilK3BW";
	
	public Post helperPost(){
		Date m1900 = new Date(0);
		Post p = new Post();
		p.setContent(ContentHelp);
		p.setProfilPicture(URLHelp);
		p.setDate(m1900);
		p.setName("Team Pluss :D");
		return p;
	}
	
	
	public String JsonEncode(ArrayList<beans.Post> listPosts){
		JSONArray obj = new JSONArray();
		for(beans.Post p : listPosts){
			try {
				JSONObject postJ = new JSONObject();
				postJ.put("profilPicture", p.getProfilPicture());
				postJ.put("name", p.getName());
				postJ.put("content", p.getContent());
				postJ.put("time", p.getStringDate());
				postJ.put("socials",p.getSocials());
				obj.put(postJ);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		JSONObject full = new JSONObject();
		try {
			full.put("posts",obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	    String jsonText = full.toString();
	    System.out.println(jsonText);
	    return jsonText;
	}	
	
	 
	 
	 public void trierPost(ArrayList<beans.Post> listPosts) {
		Collections.sort(listPosts, new Comparator<Post>() {
		    public int compare(Post m1, Post m2) {
		        return m1.getDate().compareTo(m2.getDate());
		    }
		});
	}
	

	@SuppressWarnings("deprecation")
	public void DateToString(ArrayList<beans.Post> listPosts){
		Date date = new Date();
		for(Post p : listPosts){
			Date datePost = p.getDate();
			if (date.getYear() == datePost.getYear()){
				if (date.getMonth() == datePost.getMonth()){
					if (date.getDay() == datePost.getDay()){
						if (date.getHours() == datePost.getHours()){
							if (date.getMinutes() == datePost.getMinutes()){
								if (date.getSeconds() == datePost.getSeconds()){
									String now = "now";
									p.setStringDate(now);
								}else{
									int secondes = date.getSeconds() - datePost.getSeconds();
									String string = "il y a " + secondes + " sec(s)";
									p.setStringDate(string);
								}
							}else{
								int minutes = date.getMinutes() - datePost.getMinutes();
								String string = "il y a " + minutes + " min(s)";
								p.setStringDate(string);
							}
						}else{
							int hours = date.getHours() - datePost.getHours();
							String string = "il y a " + hours + " h";
							p.setStringDate(string);
						}
					}else{
						int day = date.getDate() - datePost.getDate();
						String string = "il y a " + day + " jour(s)";
						p.setStringDate(string);
					}
				}else{
					int months = date.getMonth() - datePost.getMonth();
					String string = "il y a " + months + " mois";
					p.setStringDate(string);
				}
			}else{
				int years = date.getYear() - datePost.getYear();
				if (years == 1) {
					String string = "il y a " + years + " an";
					p.setStringDate(string);
				}else{
					String string = "il y a " + years + " an(s)";
					p.setStringDate(string);
				}
			}
		}
	}
	
		
}