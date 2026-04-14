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

public class UpdateProduitServlet extends HttpServlet {
	private static final ProduitMetier metier=ProduitMetierImpl.getInstance();
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Long id =Long.parseLong(request.getParameter("idProduit"));
	String nom =request.getParameter("nom");
	String description =request.getParameter("description");
	Double prix =Double.parseDouble(request.getParameter("prix"));

	
	//Creation de objet 
	
	Produit p=new Produit();
	p.setIdProduit(id);
	p.setDescription(description);
	p.setNom(nom);
	p.setPrix(prix);
	
	
    //Mise a jour via la couche metier 
	metier.updateProduit(p);
	
	//preparation list complet
	
	request.setAttribute("listeProduits", metier.getAllProduits());
	
	//forward
	
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
}
