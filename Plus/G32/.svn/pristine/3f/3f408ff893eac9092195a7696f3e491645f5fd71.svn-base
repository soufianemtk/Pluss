package beans;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import facebook4j.auth.AccessToken;

@Entity
public class FacebookAccount {
	
	@Id
	private long id;
	
	@OneToOne(mappedBy="facebookAcc",fetch = FetchType.EAGER)
	private User user;
	
	private long FacebookId;
	private String nameFacebook;
	private String avatarUrlFacebook;
	private String TokenSecret;
	private String Token;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long Id) {
		this.id = Id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User new_user) {
		user = new_user;
	}
	
	public long getFacebookId() {
		return FacebookId;
	}
	
	public void setFacebookId(long FacebookId) {
		this.FacebookId = FacebookId;
	}
	
	public String getNameFacebook() {
		return nameFacebook;
	}
	
	public void setNameFacebook(String nameFacebook) {
		this.nameFacebook = nameFacebook;
	}
	
	public String getAvatarUrlFacebook() {
		return avatarUrlFacebook;
	}
	
	public void setAvatarUrlFacebook(String avatarUrlFacebook) {
		this.avatarUrlFacebook = avatarUrlFacebook;
	}
	
	public String getTokenSecret() {
		return TokenSecret;
	}
	
	public void setTokenSecret(String tokenSecret) {
		TokenSecret = tokenSecret;
	}
	
	public String getToken() {
		return Token;
	}
	
	public void setToken(String token) {
		Token = token;
	}
	
	
	
}
