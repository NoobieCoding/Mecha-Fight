
public class Player {
	private String name;
	private int score = -99;
	private boolean isTurn = false;
	private Mecha mech;

	public Mecha getMech() {
		return mech;
	}

	public void setMech(Mecha mech) {
		this.mech = mech;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean getIsTurn() {
		return isTurn;
	}

	public void setIsTurn(boolean newIsTurn) {
		isTurn = newIsTurn;
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int rollDice() {
		score = (int) (6 * Math.random() + 1);
		return score;
	}
}