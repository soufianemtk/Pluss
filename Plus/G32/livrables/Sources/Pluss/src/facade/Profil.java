package facade;

import beans.ProfilUser;

public interface Profil {
	
	public void addProfil(ProfilUser p);
	public ProfilUser ConsulterProfil(int id);

}
