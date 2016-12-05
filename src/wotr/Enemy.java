package wotr;

public class Enemy extends NPC{



	
	
	public Enemy(String name, String description, int corruptionPower, int hpPower, Player currentPlayer) {
		super(name, description, corruptionPower, hpPower, currentPlayer);
	}
	
	public boolean use(){
		
		if (!this.getAlreadyUsed()){
		super.getPlayer().addHp(super.getHpPower()); // we will put a number below 0 to make the player loose health points.
		super.getPlayer().addCorruption(super.getCpPower());
		//this.setAlreadyUsed(true);
		return true;}
		else return false;
		
		
	}
}
