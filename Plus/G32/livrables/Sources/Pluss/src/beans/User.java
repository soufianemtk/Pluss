package beans;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long   id;
	private String usermail;
    private String userpass;
    private String username;
    
    @OneToOne
    private ProfilUser profil;
    
    @OneToOne
    private TwitterAccount twitterAcc;
    
	@OneToOne
    private FacebookAccount facebookAcc;
    
	
	public FacebookAccount getFacebookAcc() {
		return facebookAcc;
	}
		
	public void setFacebookAcc(FacebookAccount facebookAcc) {
		this.facebookAcc = facebookAcc;
	}
	
    public TwitterAccount getTwitterAcc() {
		return twitterAcc;
	}
	public void setTwitterAcc(TwitterAccount twitterAcc) {
		this.twitterAcc = twitterAcc;
	}
    
    public ProfilUser getProfil() {
		return profil;
	}
	public void setProfil(ProfilUser profil) {
		this.profil = profil;
	}

    public Long getId() { 
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }
    
    public void setEmail(String email) {
    this.usermail = email;
    }
    public String getEmail() {
    return usermail;
    }

    public void setPassword(String password) {
    this.userpass = password;
    }
    public String getPassword() {
    return userpass;
    }

    public void setUsername(String username) {
    this.username = username;
    }
    
    public String getUsername() {
    return username;
    }
	
}