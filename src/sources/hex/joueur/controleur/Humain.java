package sources.hex.joueur.controleur;

import java.util.Scanner;

import sources.hex.joueur.iControleur;

public class Humain implements iControleur{
	
	
	public int[] jouer(){
		int[] emplacement=new int[2];
		String s=askCoup();
		emplacement[0]=1+(s.charAt(0))-'1';
		emplacement[1]=1+(s.charAt(1))-'A';
		return emplacement;
	}
	
	public String askCoup() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Sur quelle case veux tu joueur ? (ex format : 1A )");
	    return scanner.nextLine();
	}
	
	public void erreur() {
		System.out.println("Coup invalide ! Recommence");
	}
 
}
