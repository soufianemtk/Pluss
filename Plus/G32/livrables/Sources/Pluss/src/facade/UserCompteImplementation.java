package facade;

import javax.ejb.Singleton;
import javax.persistence.*;
import beans.User;

@Singleton
public class UserCompteImplementation {

	@PersistenceContext(unitName="MaPU")
	EntityManager em;
	
	public void setId (User user){
		User userID = this.findUser(user.getEmail());
		Long id = userID.getId();
		user.setId(id);
	}
	
	public void addUser (User user){
		em.persist(user);
		em.flush();
	}
	
	public void deleteUser (User user){
		User userToDelete = (User)em.find(User.class,  user.getId());
		em.remove(userToDelete);
		em.flush();
	}
	
	public User findUser (String usermail){
		User user;
		if (usermail != null){
			/*"SELECT id, usermail, userpass, username, register_date, etc FROM User WHERE usermail = ?"*/
			String SQL = "SELECT * FROM USER WHERE USERMAIL = '" + usermail + "'";
			Query query = em.createNativeQuery(SQL, User.class);
			user = (User) query.getSingleResult();
		} else {
			user = null;
		}
        return user;
	}
	
	public void refreshUser (User user){
		User userToChange = (User)em.find(User.class, user.getId());
		em.refresh(em.merge(userToChange));
	}

}
