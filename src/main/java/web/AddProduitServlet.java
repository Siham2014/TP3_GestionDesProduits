package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import dao.Produit;
import services.ProduitMetier;
import services.ProduitMetierImpl;


public class AddProduitServlet extends HttpServlet {
	
	//Instance singleton de la couche metier
	
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
     
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperation des parametres du formulaire 
		String nom =request.getParameter("nom");
		String description =request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		
		//Creation d'objet 
		
		Produit p = new Produit(nom , description , prix);
		
		// appel de la couche metier pour ajout de produit 
		metier.addProduit(p);
		 //Mise a jour des donnees pour la jsp
		request.setAttribute("listeProduits", metier.getAllProduits());
		
		//forward vers la jsp pour affichage 
		request.getRequestDispatcher("index.jsp").forward(request,response);
				
		
	}

}
