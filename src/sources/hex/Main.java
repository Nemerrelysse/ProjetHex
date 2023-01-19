package sources.hex;

import java.util.Scanner;

import sources.hex.joueur.iControleur;
import sources.hex.joueur.Joueur;
import sources.hex.joueur.iSens;
import sources.hex.joueur.controleur.Humain;
import sources.hex.joueur.controleur.RandomIA;
import sources.hex.joueur.sens.Horizontal;
import sources.hex.joueur.sens.Vertical;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Bienvenue sur cette nouvelle partie de hex !");
		System.out.println("Quelle taille de plateau ?");
		int taille=scanner.nextInt();
		Jeu jeu=new Jeu(taille);
		
		iSens vertical=new Vertical(jeu);
		iSens horizontal=new Horizontal(jeu);
		iControleur humain=new Humain();
		iControleur bot=new RandomIA(jeu);
		boolean partieGagnee=false;
		
		
		System.out.println("Combien de bots voulez vous ?(0, 1 ou 2)");
		int nbBots=scanner.nextInt();
		
		iJoueur J1;
		iJoueur J2;
		
		switch(nbBots) {
			case 0:
				J1=new Joueur(humain, vertical);
				J2=new Joueur(humain, horizontal);
				break;
			
			case 1:
				J1=new Joueur(humain, vertical);
				J2=new Joueur(bot, horizontal);
				break;
			
			default:
				J1=new Joueur(bot, vertical);
				J2=new Joueur(bot, horizontal);
				break;
		}
		jeu.initialiserBordures(J1, J2);
		
		iJoueur actif=J1;
		
		while(!partieGagnee) {
			System.out.println(jeu);
			actif=J1;
			jeu.jouer(J1);
			partieGagnee=jeu.checkVictoire(J1, 0, 0, 0);
			if(!partieGagnee) {
				System.out.println(jeu);
				actif=J2;
				jeu.jouer(J2);
				partieGagnee=jeu.checkVictoire(J2, 0, 0, 0);
			}
		}
		System.out.println(jeu);
		System.out.println("Le joueur "+actif.getCouleur()+" a gagné !");
		
		
		
		
		
		

	}

}
