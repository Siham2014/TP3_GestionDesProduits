package dao;

import java.util.*;
import dao.Produit;
import dao.ProduitDAO;

public class ProduitImpl implements ProduitDAO {
	
	
	
	//Liste 
	private List<Produit> produits =new ArrayList <Produit>();
	
    //initialisation 
	public void init() {
		System.out.println("Initialisation");
		addProduit(new Produit("PC 1","Sony 1",7000.0));
		addProduit(new Produit("PC 2","Sony 2",6000.0));
		
	}

	@Override
	public void addProduit(Produit p) {
		p.setIdProduit(Long.valueOf(produits.size() + 1));
		produits.add(p);
		
	}

	@Override
	public void deleteProduit(Long id) {
		produits.remove(getProduitById(id));
		
	}

	@Override
	public void updateProduit(Produit p) {
		for (int i =0 ;i< produits.size();i++) {
			Produit existingProduit = produits.get(i);
			if (existingProduit.getIdProduit().equals(p.getIdProduit())) {
				//mise a jour des donnees
				existingProduit.setNom(p.getNom());
				existingProduit.setDescription(p.getDescription());
				existingProduit.setPrix(p.getPrix());
				break;
				
			}
		}
		
	}

	@Override
	public Produit getProduitById(Long id) {
		Produit produit = null;
		for(Produit p :produits) {
			if (p.getIdProduit().equals(id)) {
				produit = p;
				break;
			}
		}
		
		return produit;
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produits;
	}
	

}
