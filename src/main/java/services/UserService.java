package services;
import dao.User;

public interface UserService {
	boolean inscrire(User user);
	User connecter(String username , String password);
	

}
