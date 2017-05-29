package beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import twitter4j.auth.AccessToken;

@Entity
public class TwitterAccount {
	
	@Id
	private long id;
	
	@OneToOne(mappedBy="twitterAcc",fetch = FetchType.EAGER)
	private User user;
	
	private long TwitterId;
	private String nameTwitter;
	private String avatarUrlTwitter;
	private String TokenSecret;
	
	@Column(name="token", length=200)
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
	
	public long getTwitterId() {
		return TwitterId;
	}
	
	public void setTwitterId(long TwitterId) {
		this.TwitterId = TwitterId;
	}
	
	public String getNameTwitter() {
		return nameTwitter;
	}
	
	public void setNameTwitter(String nameTwitter) {
		this.nameTwitter = nameTwitter;
	}
	
	public String getAvatarUrlTwitter() {
		return avatarUrlTwitter;
	}
	
	public void setAvatarUrlTwitter(String avatarUrlTwitter) {
		this.avatarUrlTwitter = avatarUrlTwitter;
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
