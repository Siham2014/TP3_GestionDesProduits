package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProduitMetierImpl;
import services.ProduitMetier;



public class DeleteProduitServlet extends HttpServlet {
	//singleton de la couche métier pour acc"der a la liste produits
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
	
	
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation de parametre id depuis url
		Long id =Long.parseLong(request.getParameter("id"));
		//Appel de la couche metier pour supprimer le produit 
		metier.deleteProduit(id);
		
		//Rediretion vers listProduitServlet 
		response.sendRedirect("listProduits");
		
		
		
	}

	
	
}
