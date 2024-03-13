package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder bienvenue = new StringBuilder();
					bienvenue.append("Bienvenue villageois " + nomVisiteur);
					System.out.println(bienvenue.toString());
					StringBuilder questionForceGaulois = new StringBuilder();
					questionForceGaulois.append("Quelle est votre force ?");
					int forceGaulois = Clavier.entrerEntier(questionForceGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder bienvenue = new StringBuilder();
		bienvenue.append("Bienvenue druide " + nomVisiteur);
		System.out.println(bienvenue.toString());
		StringBuilder questionForceDruide = new StringBuilder();
		questionForceDruide.append("Quelle est votre force ?");
		int forceDruide = Clavier.entrerEntier(questionForceDruide.toString());
		int effetPotionMax = -1;
		int effetPotionMin = 0;
		do {
			StringBuilder questionForcePotionMin = new StringBuilder();
			questionForcePotionMin.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(questionForcePotionMin.toString());
			StringBuilder questionForcePotionMax = new StringBuilder();
			questionForcePotionMax.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(questionForcePotionMax.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println("attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
