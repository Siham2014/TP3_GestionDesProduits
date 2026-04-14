package services;

import dao.Produit;
import java.util.List;

public interface ProduitMetier {

	public void addProduit(Produit p);

	public List<Produit> getAllProduits();
	
	public void deleteProduit(Long id);
	
	public void updateProduit(Produit p);
	
	public Produit getProduitById(Long id);
	

}
