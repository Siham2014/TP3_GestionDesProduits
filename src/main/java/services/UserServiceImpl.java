package services;

import dao.User;
import dao.UserDao;
import dao.UserImpl;

public class UserServiceImpl implements UserService {
	private static UserServiceImpl instance;
	private UserDao dao;
	
	private UserServiceImpl() {
		dao=new UserImpl();
		
	}
	
	public static UserServiceImpl getInstance() {
		if( instance == null) {
			instance = new UserServiceImpl();
			
			
		}
		return instance;
		
	}
	@Override
	public boolean inscrire(User user) {
		if(user == null) {
			return false;
			
		}
		if(user.getUsername()==null || user.getUsername().trim().equals("")) {
			return false;
		}
		if(user.getPassword()==null || user.getPassword().trim().equals("")) {
			return false;
		}
			
		if(user.getRole()== null || user.getRole().trim().equals("")) {
			return false;
			
		}
		
		
		return dao.register(user);
	}

	@Override
	public User connecter(String username, String password) {
		
		if(username==null || username.trim().equals("")) {
			return null;
		}
		if(password==null || password.trim().equals("")) {
			return null;
		}
			
		
		return dao.login(username, password);
	}
	
	

}
