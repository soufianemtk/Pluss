package facade;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.*;
import facade.Compte;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Reading;
import facebook4j.ResponseList;
import form.CryptageMD5;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

@Singleton
public class CompteTwitter {
	
	@PersistenceContext(unitName="MaPU")
	private EntityManager em;
		
	private static String ConsumerKey = "iQtYwOEHKuHqoZMGGj22wuuQx";
	private static String ConsumerSecret = "aU2PLvqXCHxQVRMLXL4zFnWmTpUjZsQTJ4c0iYsdhVDprvHaGw";
	

	
	public void creerCompte(Long id) {
		TwitterAccount twitterAcc = new TwitterAccount();
		twitterAcc.setId(id);
		em.persist(twitterAcc);
	}
	
	public TwitterAccount consulterAccount(Long id) {
		TwitterAccount twitterAcc = em.find(TwitterAccount.class, id);
		return twitterAcc;
	}
	
	public void associer(Long id_user, Long id_compteTwitter) {
		TwitterAccount twitterAcc = (TwitterAccount)em.find(TwitterAccount.class, id_compteTwitter);
		beans.User owner = (beans.User)em.find(beans.User.class, id_user);
		owner.setTwitterAcc(twitterAcc);
		twitterAcc.setUser(owner);
	}
	
	public String lienLierComptes(HttpSession session){
		
		String authURL = null;
		
		try {
			
			Twitter twitter=null;
			ConfigurationBuilder cb = new ConfigurationBuilder();
			   
			cb.setDebugEnabled(true)
			     .setOAuthConsumerKey(ConsumerKey)
			     .setOAuthConsumerSecret(ConsumerSecret)
			     .setUseSSL(true);
			
			twitter = new TwitterFactory(cb.build()).getInstance();
				
			RequestToken requestToken = twitter.getOAuthRequestToken();
			session.setAttribute("requestToken", requestToken);
			session.setAttribute("twitter",twitter);
			authURL = requestToken.getAuthenticationURL();
			authURL= new StringBuilder(authURL).insert(4, "s").toString();
		}
		catch(TwitterException  twitterException) {
			twitterException.printStackTrace();
		}
		return authURL;
	}
	
	public Object ouvrirConnexion(Long id) throws IOException {
		
		Twitter twitter=null;
		
		try {
		   TwitterAccount twitterAcc = consulterAccount(id);
		   ConfigurationBuilder cb = new ConfigurationBuilder();
		   
		   String accessToken = twitterAcc.getToken();
		   String accessTokenSecret = twitterAcc.getTokenSecret();
		   
		   cb.setDebugEnabled(true)
		     .setOAuthConsumerKey(ConsumerKey)
		     .setOAuthConsumerSecret(ConsumerSecret)
		     .setOAuthAccessToken(accessToken)
		     .setOAuthAccessTokenSecret(accessTokenSecret)
		     .setUseSSL(true);
		   	 
			twitter = new TwitterFactory(cb.build()).getInstance();
		} catch(Exception e){
			System.out.println("Erreur Connexion Impossible");
		}
			return twitter;
		}
	
	public void setTokens(HttpSession session, String oauth_verifier){
		RequestToken token = (RequestToken) session.getAttribute("requestToken");
		Twitter twitter = (Twitter) session.getAttribute("twitter");
		beans.User user = (beans.User) session.getAttribute("userSession");
		try {
			Long id;
			AccessToken accessToken;
			accessToken = twitter.getOAuthAccessToken(token, oauth_verifier);
			
			String finalAccessToken = accessToken.getToken();
		    String finalAccessTokenSecret = accessToken.getTokenSecret();
		    
		    id = user.getId();
		    this.modifyTokens(id,finalAccessToken, finalAccessTokenSecret );
			
		} catch(TwitterException  twitterException) {
			twitterException.printStackTrace();
		}	
	}
	
	public void modifyTokens(Long id, String finalAccessToken, String finalAccessTokenSecret ) {
		TwitterAccount twitterAcc = this.consulterAccount(id);
		twitterAcc.setToken(finalAccessToken);
		twitterAcc.setTokenSecret(finalAccessTokenSecret);
	}
		
	public void publier(Post post, HttpSession session) throws IOException{
		beans.User user = (beans.User) session.getAttribute("userSession");
		Long id = user.getId();
		try {
			Twitter twitter = (Twitter) ouvrirConnexion(id);
			String content= post.getContent();
			twitter.updateStatus(content);
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	
	}
	
	public List<twitter4j.Status> recupererPosts(HttpSession session) throws TwitterException{
		beans.User user = (beans.User) session.getAttribute("userSession");
		Twitter twitter = (Twitter) session.getAttribute("twitter");
		Long id = user.getId();
		if (twitter == null){
			try {
				twitter = (Twitter) ouvrirConnexion(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		List<twitter4j.Status> post = twitter.getHomeTimeline();
		
		return post;
		}
	
	public List<twitter4j.Status> recupererPostsPerso(HttpSession session) throws TwitterException{
		beans.User user = (beans.User) session.getAttribute("userSession");
		Twitter twitter = (Twitter) session.getAttribute("twitter");
		Long id = user.getId();
		if (twitter == null){
			try {
				twitter = (Twitter) ouvrirConnexion(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		List<twitter4j.Status> post = twitter.getUserTimeline();
		
		return post;
		}
	
	public ArrayList<beans.Post> formaterPost(List<twitter4j.Status> list){
		ArrayList<beans.Post> listFormat = new ArrayList<beans.Post>();
		for(twitter4j.Status p : list){
			Post pi = new Post();
			pi.setContent(p.getText());
			pi.setName(p.getUser().getName());
			pi.setProfilPicture(p.getUser().getOriginalProfileImageURL());
			pi.setDate(p.getCreatedAt());
			pi.setSocials("twitter-tag fa fa-twitter");
			listFormat.add(pi);
		}
		return listFormat;
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
	    return jsonText;
	}	
	
	public String generateJSONfile(String jsonContent,HttpSession session){
        CryptageMD5 crypteur;
		beans.User u = (beans.User) session.getAttribute("userSession");
		String email = u.getEmail();
		crypteur = new CryptageMD5(email);
		String fileCrypted = crypteur.codeGet() + ".json";
				
		File dataDir = new File(System.getProperty("jboss.server.data.dir"));
		File yourFile = new File(dataDir, fileCrypted);
		System.out.println(yourFile);

		
		try {
			if (!yourFile.exists())
				yourFile.createNewFile();
			FileWriter writer = new FileWriter(yourFile);
			writer.write(jsonContent);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Erreur: impossible de créer le fichier");
		}
		return fileCrypted;
	}

}
