package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean estHabitant = controlAcheterProduit.estHabitant(nomAcheteur);
		if (! estHabitant) {
			System.out.println("Je suis d�sol�e " + nomAcheteur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Que souhaitez-vous acheter ?");
			String produitRecherche = scan.nextLine();
			Gaulois[] vendeursProduit = controlAcheterProduit.vendeursDisponibles(produitRecherche);
			if (vendeursProduit.length == 0) {
				System.out.println("D�sol�, personne ne vend ce produit au marche.");
			} else {
				for (int i = 0; i < vendeursProduit.length; i++) {
					String nomVendeur = vendeursProduit[i].getNom();
				}
			}
		}
	}
}
