package test.hex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sources.hex.joueur.iControleur;
import sources.hex.joueur.controleur.Humain;

class humainTest {

	@Test
	void test() {
		iControleur humain=new Humain();
		//1A
		int[] t1=humain.jouer();
		assertEquals(1,t1[0]);
		assertEquals(1,t1[1]);
		
		//6E
		int[] t2=humain.jouer();
		assertEquals(6,t2[0]);
		assertEquals(5,t2[1]);
		
		//2G
		int[] t3=humain.jouer();
		assertEquals(2,t3[0]);
		assertEquals(7,t3[1]);
	}

}
