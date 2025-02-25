package histoire;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class test_Classe_Marche {

	public static void main(String[] args) {
		Village village = new Village("le Village", 10, 5);
		Gaulois asterix = new Gaulois("Astérix", 10);
		Gaulois obelix = new Gaulois ("Obélix", 8);
		Gaulois anna = new Gaulois ("Anna", 5);
		
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		village.test_utiliserEtals(obelix, "fruit", 3);
		village.test_utiliserEtals(asterix, "potions", 9);
		village.test_utiliserEtals(anna, "potions", 5);
		
		System.out.println((village.test_trouverVendeur(obelix)).afficherEtal());
		Etal[] res = village.test_trouverEtals("potions");
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i].afficherEtal());
		}
		
		System.out.println(village.test_afficherMarche());
	}

}
