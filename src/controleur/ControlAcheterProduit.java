package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean estHabitant(String nomAcheteur) {
		return village.trouverHabitant(nomAcheteur) != null;
	}
	
	public Gaulois[] vendeursDisponibles(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int numeroEtal(String vendeur) {
		//village.
		return -1;
	}
}
