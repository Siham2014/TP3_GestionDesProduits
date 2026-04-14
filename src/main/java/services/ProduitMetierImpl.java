package services;

import java.util.List;
import dao.Produit;
import dao.ProduitDAO;
import dao.ProduitImpl;

public class ProduitMetierImpl implements ProduitMetier{

   
	//instance unique pour le singleton
	
	private static ProduitMetierImpl instance;
	
	//reference vers la couche dao
	
	private ProduitDAO dao;
	private ProduitMetierImpl() {
	    dao = new ProduitImpl();
	    ((ProduitImpl) dao).init();
	}
	
	//creation de dao et chargement des produit au debut par init 
	
	
	public static ProduitMetier getInstance() {
		if (instance == null) {
			instance = new ProduitMetierImpl();
		}
		 return instance;
		 
	}
	
	
	
	
	//red des methode produitmetier
	

	@Override
	public void addProduit(Produit p) {
             dao.addProduit(p);		
	}

	@Override
	public List<Produit> getAllProduits() {
		
		return dao.getAllProduits();
	}

	@Override
	public void deleteProduit(Long id) {
		dao.deleteProduit(id);
		
	}

	@Override
	public void updateProduit(Produit p) {
		dao.updateProduit(p);
		
	}

	@Override
	public Produit getProduitById(Long id) {
		
		return dao.getProduitById(id);
	}





	

}
