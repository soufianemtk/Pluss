package facade;

import javax.ejb.Singleton;
import javax.persistence.*;
import beans.ProfilUser;
import beans.User;

@Singleton
public class ProfilImplementation {
	
	@PersistenceContext(unitName="MaPU")
	private EntityManager em;

	public void createProfil(Long id) {
		ProfilUser profil = new ProfilUser();
		profil.setId(id);
		em.persist(profil);
	}
	
	public void associer(Long id_user, Long id_profil) {
		ProfilUser profil = (ProfilUser)em.find(ProfilUser.class, id_profil);
		User owner = (User)em.find(User.class, id_user);
		owner.setProfil(profil);
		profil.setUser(owner);
	}
	
	public ProfilUser consulterProfil(Long id) {
		ProfilUser p = em.find(ProfilUser.class, id);
		return p;
	}
	
	public void modifyPrenom(Long id, String new_prenom) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setPrenom(new_prenom);
	}

	public void modifyNom(Long id, String new_nom) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setNom(new_nom);
	}

	public void modifyPhotoCouv(Long id, String new_couv) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setPhotoCouv(new_couv);
	}
	public void modifyPhotoProfil(Long id,String new_photo) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setPhotoProfil(new_photo);
	}
	public void modifyAdresse(Long id, String new_adresse) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setAdresse(new_adresse);
	}
	public void modifyNumPhone(Long id, String new_num) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setNumPhone(new_num);
	}
	public void modifySiteWeb(Long id, String new_link) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setSiteWeb(new_link);
	}
	public void modifyDDN(Long id, String new_date) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setDDN(new_date);
	}
	public void modifyProfession(Long id, String new_profession) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setProfession(new_profession);
	}
	public void modifyBio(Long id, String new_bio) {
		ProfilUser profil = this.consulterProfil(id);
		profil.setBio(new_bio);
	}

	
}
