package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		if (gaulois != null) {
			System.out.println(village.rechercherEtal(gaulois).getVendeur());
			return village.rechercherEtal(gaulois);
		}
		return null;
	}
}
