package sources.hex.joueur.sens;

import sources.hex.Couleur;
import sources.hex.Jeu;
import sources.hex.joueur.iSens;

public class Horizontal implements iSens {
	
	private final char SYMBOLE='B';
	private final Couleur COULEUR=Couleur.BLEU;
	private final int SENS=-1;
	private int endCheckX;
	private int endCheckY;
	
	public Horizontal(Jeu jeu) {
		endCheckY=0;
		endCheckX=jeu.getTaille()+1;
	}
	
	
	
	public char getSymbole() {
		return SYMBOLE;
	}
	
	public Couleur getCouleur() {
		return COULEUR;
	}
	
	public int getSens() {
		return SENS;
	}
	
	public int getEndCheckX() {
		return endCheckX;
	}
	
	public int getEndCheckY() {
		return endCheckY;
	}

}
