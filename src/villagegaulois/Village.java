package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.marche = new Marche(nbEtals);
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
					+ " vivent les légendaires gaulois :\n");
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
			for(int i = 0; i < nbrEtal ; i++) {
				etals[i] = new Etal();
			}
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit){
			if(indiceEtal >= 0 && indiceEtal < etals.length) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
				System.out.println(vendeur.getNom() + " a bien emménager dans l'étal" ) ;
			}
			else {
				System.out.println(vendeur.getNom() + "n'a pas pu emménager dans l'étal" ) ;
			}
			
			
		}
		
		private int trouverEtalLibre() {
			for (int i = 0; i < etals.length; i++) {
                if (!etals[i].isEtalOccupe()) {
                    return i;
                }
            }
            return -1;
		}
		
		//retourne un tableau contenant tous les étals qui vendent le produit donnée 
		private Etal[] trouverEtals(String produit) {
			int nbr_etal= 0;
			//on cherche le nombre de etal occupés
			for(int i = 0; i < etals.length ; i++) {
				if((etals[i].isEtalOccupe()) && etals[i].contientProduit(produit)) {
					nbr_etal ++;
				}
			}
			Etal[] etal_trouve = new Etal[nbr_etal];
			
			//on rempli le nouveau tableau
			int index = 0;
			for(int i = 0; i < etals.length ; i++) {
				if((etals[i].isEtalOccupe()) && etals[i].contientProduit(produit)) {
					etal_trouve[index] = etals[i];
					index++;
				}
			}
			return etal_trouve;
			
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			for(int i = 0; i < etals.length; i++) {
				if((etals[i].isEtalOccupe()) && etals[i].getVendeur() == gaulois ) {
					return etals[i];
				}
			}
			return null;
		}
		
		private String afficherMarche() {
			int nbEtalVide= 0;
			String res = "L'étal est libre";
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
	
	
	//toutes les méthodes permettant d'appeler chaque méthodes dans la classe interne
	public int test_trouverEtalsLibre() {
		return marche.trouverEtalLibre();
	}
	
	public void test_utiliserEtals(Gaulois vendeur , String produit, int nbProduit) {
		int etalLibre = test_trouverEtalsLibre();
        if (etalLibre != -1) {
            marche.utiliserEtal(etalLibre, vendeur, produit, nbProduit);
        } else {
            System.out.println("Aucun étal disponible pour " + vendeur.getNom());
        }
	}
	
	public Etal[] test_trouverEtals(String produit) {
        return marche.trouverEtals(produit);
    }
	
	public Etal test_trouverVendeur(Gaulois gaulois) {
		return marche.trouverVendeur( gaulois);
	}
	
	
	public String test_afficherMarche() {
		return marche.afficherMarche();
	}
	
	
}