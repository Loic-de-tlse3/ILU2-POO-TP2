package frontiere;

import java.util.Scanner;

import controleur.ControlAfficherMarche;
import controleur.ControlEmmenager;
import controleur.ControlPrendreEtal;
import villagegaulois.Village;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (! nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (! etalDisponible) {
				System.out.println("Désolée " +  nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !");
		StringBuilder questionProduit = new StringBuilder();
		questionProduit.append("Il me faudrait quelques renseignements:\nQuel produit souhaitez-vous vendre ?");
		System.out.println(questionProduit.toString());
		String produit = scan.nextLine();
		StringBuilder questionNbProduit = new StringBuilder();
		questionNbProduit.append("Combien souhaitez vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(questionNbProduit.toString());
		int numeroEtal = -1;
		if ((numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit)) != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'etal n° " + numeroEtal);
		}
		
	}
}
