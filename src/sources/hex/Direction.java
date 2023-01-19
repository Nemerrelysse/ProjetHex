package sources.hex;

public enum Direction {
	E(0,1),
	NE(-1,1),
	NO(-1,0),
	O(0,-1),
	SO(1,-1),
	SE(1,0);
	
	private final int x;
	private final int y;
	
	private Direction(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}


}
