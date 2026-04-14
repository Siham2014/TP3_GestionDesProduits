package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Produit;
import services.ProduitMetier;
import services.ProduitMetierImpl;

public class EditProduitServlet extends HttpServlet {
	private static final ProduitMetier metier =  ProduitMetierImpl.getInstance();
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperation id 
		Long id = Long.parseLong(request.getParameter("id"));

		
	   //Recuperation du produit correspond via la couche metier 
		
		Produit p =metier.getProduitById(id);
		
		//pre remplir
		
		request.setAttribute("produitEdit", p);
		
		//on ajout la liste complet
		
		request.setAttribute("listeProduits", metier.getAllProduits());
		
		//forward
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
				
		
		
		
	}

	
	

}
