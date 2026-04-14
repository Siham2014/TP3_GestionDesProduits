package dao;

public interface UserDao {
	boolean register(User user);
	User login(String username ,String password);

}
