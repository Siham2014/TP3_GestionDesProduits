package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



public class AuthFilter extends HttpFilter implements Filter {
    
    public AuthFilter() {
        super();
        
    }

	
    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		 String uri = req.getRequestURI();
		 // Pages publiques : on laisse passer
        if (uri.endsWith("/login") || uri.endsWith("/register")
                || uri.endsWith("/login.jsp") || uri.endsWith("/register.jsp")) {
            chain.doFilter(request, response);
            return;
        }

		
		HttpSession session = req.getSession(false);
		
		if (session == null || session.getAttribute("user") == null) {
			
			resp.sendRedirect("login.jsp");
			
			
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
