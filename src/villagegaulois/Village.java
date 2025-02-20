package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	//classe interne Marche
	private static class Marche{
		private Etal[] etals ;
		
		private Marche(int nbrEtal) {
			this.etals = new Etal[nbrEtal];
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit){
			if(indiceEtal >= 0) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
				System.out.println(vendeur.getNom() + "a bien emménager dans l'étal" ) ;
			}
			else {
				System.out.println(vendeur.getNom() + "n'a pas pu emménager dans l'étal" ) ;
			}
			
			
		}
		
		private int trouverEtalLibre() {
			int etalLibre = 0;
			for(int i = 0; i < etals.length ; i++) {
				if(etals[i].isEtalOccupe()) {
					return i;
				}
			}
			return -1;
		}
		
		private Etal[] trouverEtals(String produit) {
			int nbr_etal= 0;
			for(int i = 0; i < etals.length ; i++) {
				if(!(etals[i].isEtalOccupe()) && etals[i].contientProduit(produit)) {
					nbr_etal ++;
				}
			}
			Etal[] etal_trouve = new Etal[nbr_etal];
			return etal_trouve;
			
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			for(int i = 0; i < etals.length; i++) {
				if(!(etals[i].isEtalOccupe()) && etals[i].getVendeur().getNom() == gaulois.getNom()) {
					return etals[i];
				}
			}
			return null;
		}
		
		private String afficherMarche() {
			int nbEtalVide= 0;
			String res = "L'Ã©tal est libre";
			for(int i = 0; i< etals.length ; i++) {
				if(res.equals(etals[i].afficherEtal())) {
					 nbEtalVide++;
				}
				else {
					etals[i].afficherEtal();
				}
			}
			return "Il reste " + nbEtalVide + " étals non utilisés dans le marché. \n";
		}
	 }
	
	
}