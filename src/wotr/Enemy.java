package wotr;

public class Enemy extends NPC{

	private Player currentPlayer;
	private int hpPower;
	private int corruptionPower;

	
	
	public Enemy(String name, String description, int corruptionPower, int hpPower, Player currentPlayer) {
		super(name, description, corruptionPower, hpPower, currentPlayer);
		this.currentPlayer = currentPlayer;
		this.corruptionPower= corruptionPower;
		this.hpPower = hpPower;
	}
	
	public boolean use(){
		
		if (!this.getAlreadyUsed()){
		currentPlayer.addHp(hpPower); // we will put a number below 0 to make the player loose health points.
		currentPlayer.addCorruption(corruptionPower);
		//this.setAlreadyUsed(true);
		return true;}
		else return false;
		
		
	}
}
