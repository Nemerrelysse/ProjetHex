package test.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sources.hex.Couleur;
import sources.hex.Jeu;
import sources.hex.joueur.iSens;
import sources.hex.joueur.sens.Horizontal;
import sources.hex.joueur.sens.Vertical;

class sensTest {

	@Test
	void test() {
		int taille=5;
		Jeu jeu=new Jeu(taille);
		iSens v=new Vertical(jeu);
		iSens h=new Horizontal(jeu);
		assertEquals('R',v.getSymbole());
		assertEquals('B',h.getSymbole());
		assertEquals(Couleur.ROUGE,v.getCouleur());
		assertEquals(Couleur.BLEU,h.getCouleur());
		assertEquals(1,v.getSens());
		assertEquals(0,v.getEndCheckX());
		assertEquals(6,v.getEndCheckY());
		assertEquals(0,h.getEndCheckY());
		assertEquals(6,h.getEndCheckX());
	}

}
