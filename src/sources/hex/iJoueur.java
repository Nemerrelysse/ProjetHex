package sources.hex;

public interface iJoueur {
	public char getSymbole();
	public Couleur getCouleur();
	public int getSens();
	public int getEndCheckX();
	public int getEndCheckY();
	public int[] jouer();
	public void erreur();

}
