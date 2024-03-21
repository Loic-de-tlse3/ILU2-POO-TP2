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
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Que souhaitez-vous acheter ?");
			String produitRecherche = scan.nextLine();
			String[] infosMarche = controlAcheterProduit.vendeursDisponibles();
			for (int i = 2; i < infosMarche.length; i+=3) {
				if (infosMarche[i].equals(produitRecherche)) {
					System.out.println(i/3 + " - " + infosMarche[i-2]);
				}
			}
		}
	}
}
