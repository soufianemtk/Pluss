package beans;

import javax.persistence.*;


@Entity
public class ProfilUser {

	@Id
	private long id;
	
	@OneToOne(mappedBy="profil",fetch = FetchType.EAGER)
	private User user;
	
	private String prenom;
	private String nom;
	private String photo_couv;
	private String photo_profil;
	private String adresse;
	private String num_phone;
	private String site_web;
	private String date_naissance;
	private String profession;
	private String biographie;
	
	//---------  getters  -----------//
	
	public Long getId() {
		return id;
	}	
	public User getUser() {
		return user;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNom() {
		return nom;
	}
	public String getPhotoCouv() {
		return photo_couv;
	}
	public String getPhotoProfil() {
		return photo_profil;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getNumPhone() {
		return num_phone;
	}
	public String getSiteWeb() {
		return site_web;
	}
	public String getDDN() {
		return date_naissance;
	}
	public String getProfession() {
		return profession;
	}
	public String getBio() {
		return biographie;
	}
	
	//---------  setters  -----------//
	 
	public void setId(Long new_id) {
		this.id = new_id;
	}
	public void setUser(User new_user) {
		user = new_user;
	}
	public void setPrenom(String new_prenom) {
		prenom = new_prenom;
	}
	public void setNom(String new_nom) {
		nom = new_nom;
	}
	public void setPhotoCouv(String new_p) {
		photo_couv = new_p;
	}
	public void setPhotoProfil(String new_p) {
		photo_profil = new_p;
	}
	public void setAdresse(String new_a) {
		adresse = new_a;
	}
	public void setNumPhone(String new_n) {
		num_phone = new_n;
	}
	public void setSiteWeb(String new_s) {
		site_web = new_s;
	}
	public void setDDN(String new_d) {
		date_naissance = new_d;
	}
	public void setProfession(String new_p) {
		profession = new_p;
	}
	public void setBio(String new_b) {
		biographie = new_b;
	}
}
