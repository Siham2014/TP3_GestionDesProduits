package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.UserService;
import services.UserServiceImpl;
import dao.User;


public class LoginServlet extends HttpServlet {
	private static final UserService service = UserServiceImpl.getInstance();
    
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	//traitemeny de formulaire login 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		
		User user=service.connecter(username, password);
		
		
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getUsername());
			session.setAttribute("role", user.getRole());
			
			response.sendRedirect("listProduits");
			
		}
		else {
			request.setAttribute("erreur", "Username ou mot de passe incorrect ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
