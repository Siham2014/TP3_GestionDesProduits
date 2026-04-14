package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;
import services.UserServiceImpl;
import dao.User;



public class RegisterServlet extends HttpServlet {
	private static final UserService service= UserServiceImpl.getInstance();
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//affectation de role user pour tous 
		
		user.setRole("user");
		
		boolean ok = service.inscrire(user);
		if (ok) {
			request.setAttribute("success", "Inscription reussie");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("error", "Utilisateur existe deja ou champls  invalides");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
	}

}
