package sources.hex.joueur;

import sources.hex.Couleur;
import sources.hex.iJoueur;

public class Joueur implements iJoueur{
	private iControleur controleur;
	private iSens sens;
	
	public Joueur(iControleur controleur, iSens sens) {
		this.controleur=controleur;
		this.sens=sens;
	}
	
	public char getSymbole() {
		return sens.getSymbole();
	}
	public Couleur getCouleur() {
		return sens.getCouleur();
	}
	public int getSens() {
		return sens.getSens();
	}
	public int getEndCheckX() {
		return sens.getEndCheckX();
	}
	public int getEndCheckY() {
		return sens.getEndCheckY();
	}
	
	public int[] jouer() {
		return controleur.jouer();
	}
	
	public void erreur() {
		controleur.erreur();
	}


}
