package sources.hex.joueur.controleur;

import java.util.Random;

import sources.hex.Jeu;
import sources.hex.joueur.iControleur;

public class RandomIA implements iControleur{
	private int taillePlateau;
	
	public RandomIA(Jeu jeu) {
		this.taillePlateau=jeu.getTaille();
	}
	
	public int[] jouer() {
		int[] emplacement=new int[2];
		emplacement[0]=getRandom(1, taillePlateau-1);
		emplacement[1]=getRandom(1, taillePlateau-1);
		return emplacement;
	}
	
	private static int getRandom(int min, int max) {
		Random r = new Random();
		return r.ints(min, max).findFirst().getAsInt();
	}
	
	public void erreur() {}
	
	
	

}
