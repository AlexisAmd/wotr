package wotr;

public class Ennemy extends NPC{

	private Player currentPlayer;
	private int hpPower;

	
	
	public Ennemy(String name, String description, int corruptionPower, int hpPower, Player currentPlayer,
			String script) {
		super(name, description, corruptionPower, hpPower, currentPlayer, script);
		this.currentPlayer = currentPlayer;
	}
	
	public boolean use(){
		
		if (!this.getAlreadyUsed()){
		currentPlayer.addHp(hpPower); // we will put a number below 0 to make the player loose health points.
		return true;}
		else return false;
		
		
	}
}
