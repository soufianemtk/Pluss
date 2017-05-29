package facade;

import beans.User;

public interface UserCompte {
	
	public void addUser(String usermail, String username, String userpass);
	public void deleteUser (User user);
	public User findUser(String usermail);	
	public void refreshUser (User user);
}
