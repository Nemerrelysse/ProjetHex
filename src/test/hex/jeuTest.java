package test.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sources.hex.Jeu;
import sources.hex.iJoueur;
import sources.hex.joueur.iControleur;
import sources.hex.joueur.Joueur;
import sources.hex.joueur.iSens;
import sources.hex.joueur.controleur.Humain;
import sources.hex.joueur.sens.Horizontal;
import sources.hex.joueur.sens.Vertical;

class jeuTest {

	@Test
	void test() {
		int taille=4;
		Jeu jeu=new Jeu(taille);
		iSens vertical=new Vertical(jeu);
		iSens horizontal=new Horizontal(jeu);
		iControleur humain=new Humain();
		iJoueur J1=new Joueur(humain, vertical);
		iJoueur J2=new Joueur(humain, horizontal);
		
		assertEquals(4, jeu.getTaille());
		
		jeu.initialiserBordures(J1, J2);
		assertEquals(J1.getSymbole(), jeu.symbole(0, 2));
		assertEquals(J1.getSymbole(), jeu.symbole(0, 1));
		assertEquals(J1.getSymbole(), jeu.symbole(5, 2));
		assertEquals(J1.getSymbole(), jeu.symbole(5, 1));
		assertEquals(J1.getSymbole(), jeu.symbole(0, 5));
		assertEquals(J2.getSymbole(), jeu.symbole(2, 0));
		assertEquals(J2.getSymbole(), jeu.symbole(1, 0));
		assertEquals(J2.getSymbole(), jeu.symbole(5, 0));
		assertEquals(J2.getSymbole(), jeu.symbole(2, 5));
		assertEquals(J2.getSymbole(), jeu.symbole(1, 5));
		
		assertFalse(jeu.checkVictoire(J1, 0, 0, 0));
		assertFalse(jeu.checkVictoire(J2, 0, 0, 0));
		
		assertTrue(jeu.estVide(2, 3));
		
		jeu.poserPiece(J1, 2, 3);
		assertFalse(jeu.estVide(2, 3));
		assertTrue(jeu.casePossede(J1, 2, 3));
		assertFalse(jeu.casePossede(J2, 2, 3));
		assertFalse(jeu.casePossede(J1, 3, 2));
		
		assertTrue(jeu.caseInBoard(2, 2));
		assertTrue(jeu.caseInBoard(0, 5));
		assertFalse(jeu.caseInBoard(3, 7));
		
		assertTrue(jeu.caseJouable(2, 2));
		assertFalse(jeu.caseJouable(0, 5));
		assertFalse(jeu.caseJouable(3, 7));
		
		jeu.poserPiece(J2, 2, 2);
		jeu.poserPiece(J1, 1, 3);
		jeu.poserPiece(J2, 2, 4);
		jeu.poserPiece(J1, 3, 2);
		jeu.poserPiece(J2, 4, 1);
		jeu.poserPiece(J1, 4, 2);
		
		
		
		assertFalse(jeu.checkVictoire(J2, 0, 0, 0));
		assertTrue(jeu.checkVictoire(J1, 0, 0, 0));
	}

}
