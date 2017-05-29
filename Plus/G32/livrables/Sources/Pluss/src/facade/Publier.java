package facade;

import javax.servlet.http.HttpServletRequest;
import beans.Post;

public interface Publier {
	
	public void diffuser(Post postToPublish,HttpServletRequest request);
	public void recuperChamps(HttpServletRequest request);
	
}
