package sources.hex;

public class Jeu {
	private int taillePlateau;
	private iJoueur[][] plateau;
	private static Direction[] direction=Direction.values();
	
	public Jeu(int taillePlateau) {
		this.taillePlateau=taillePlateau;
		this.plateau=new iJoueur[taillePlateau+2][taillePlateau+2];
	}
	
	
	
	public void initialiserBordures(iJoueur j1, iJoueur j2) {
		for(int i=1;i<plateau.length;++i){
			plateau[0][i]=j1;
			plateau[taillePlateau+1][i]=j1;
			plateau[i][0]=j2;
			plateau[i][taillePlateau+1]=j2;
		}
		plateau[j1.getEndCheckX()][j1.getEndCheckY()]=j1;
		plateau[j2.getEndCheckX()][j2.getEndCheckY()]=j2;
		
	}
	
	public void poserPiece(iJoueur joueur, int xCoord, int yCoord) {
		assert plateau[xCoord][yCoord]==null;
		plateau[xCoord][yCoord]=joueur;
	}
	
	public void jouer(iJoueur joueur) {
		int[] coord=joueur.jouer();
		int x=coord[0];
		int y=coord[1];
		if(caseJouable(x, y) && estVide(x, y)) {
			poserPiece(joueur, x, y);
		}
		else {
			joueur.erreur();
			jouer(joueur);
		}
	}
	
	public boolean checkVictoire(iJoueur joueur, int start, int startX, int startY) {
		int x=startX;
		int y=startY;
		int d=joueur.getSens();
		Direction to;
		if(x==joueur.getEndCheckX() && y==joueur.getEndCheckY()) {
			return false;
		}
		for(int i =start;i<start+direction.length;++i) {
			int n=i%direction.length;
			if(n==direction.length) {
				n=0;
			}
			to=direction[n];
			int tempx=x+(to.getX())*d;
			int tempy=y+(to.getY())*d;
			if(tempx==joueur.getEndCheckX() && tempy==joueur.getEndCheckY()) {
				return false;
			}
			if(caseInBoard(tempx, tempy)) {
				if(casePossede(joueur, tempx, tempy)) {
					n=(n+4)%direction.length;
					if(n==direction.length) {
						n=0;
					}
					return checkVictoire(joueur, n, tempx, tempy);
				}
				if(tempx==taillePlateau && tempy==taillePlateau) {
					 return true;
				}
			}
		}
		return false;
	}
	
	public boolean estVide(int x, int y) {
		return plateau[x][y]==null;
	}
	
	public boolean casePossede(iJoueur joueur, int x, int y) {
		assert caseInBoard(x, y);
		if (estVide(x,y)) {
			return false;
		}
		return joueur.getCouleur()==plateau[x][y].getCouleur();
	}
	
	public boolean caseInBoard(int x, int y){
		if(x<0 || y<0 || x>=(plateau.length) || y>=(plateau.length)) {
			return false;
		}
		return true;
	}
	
	public boolean caseJouable(int x, int y) {
		if(x<1 || y<1 || x>(taillePlateau) || y>(taillePlateau)){
			return false;
		}
		return true;
	}
	
	public int getTaille() {
		return taillePlateau;
	}
	
	@Override
	public String toString() {
		String s=(lettres()+"\n");
		char c;
		int i=1;
		for(; i<=taillePlateau;++i) {
			for(int j=0;j<i;++j) {
				s=(s+"    ");
			}
			s=(s+" "+i+" |");
			for(int k=1; k<=taillePlateau;++k) {
				if(estVide(i, k)) {
					c='.';
				}
				else {
					c=symbole(i, k);
				}
				s=(s+" "+c+" |");
			}
			s=s+" "+i+" |"+"\n";
		}
		for(int j=0;j<i;++j) {
			s=(s+"    ");
		}
		s=s+lettres();
		return s;
	}
	
	public String lettres() {
		String s="   |";
		for (int i=0; i<taillePlateau;++i) {
			char c = (char) ('A'+i);
			s=(s+" "+c+" |");
		}
		return s;
	}
	
	public char symbole(int x, int y) {
		assert !estVide(x, y);
		return plateau[x][y].getSymbole();
	}
	
	
	
	
	
	
}
