package dao;
import java.util.*;


public class UserImpl implements UserDao {
	
	private static Map<String ,User>users = new HashMap<>();
	 
	static {
		users.put("admin",new User("admin","123","admin"));
		users.put("siham",new User("siham","123","user"));
	}
	

	@Override
	public boolean register(User user) {
		if(users.containsKey(user.getUsername())) {
			return false;
			
			
		}
		users.put(user.getUsername(), user);
		return true;
		
		
	}
	@Override
	public User login(String username, String password) {
		User user =users.get(username);
		
		if(user != null && user.getPassword().equals(password)) {
			 return user;
		}
		
		  
		
		return null;
	}
	

}
