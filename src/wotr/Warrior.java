package wotr;

public class Warrior extends NPC {
	
	private Player currentPlayer;


	/**
	 * @param name
	 * @param description
	 * @param corruptionPower
	 * @param hpPower
	 * @param currentPlayer
	 */
	public Warrior(String name, String description, int corruptionPower, int hpPower, Player currentPlayer) {
		super(name, description, corruptionPower, hpPower, currentPlayer);
		this.currentPlayer = currentPlayer;
		
	}
	
	/**
	    *Use method, kill a npc. this dead npc leave the inventory of frodo
	    *@return true if the npc is killed
	    *@return false if the powers cannot be used
	    */
	    public boolean use(NPC npc){
	        if (currentPlayer.hasNPC(npc)){
	        npc.setAlreadyUsed(true);
	        currentPlayer.dropNPC(npc);
	        
	        this.setAlreadyUsed(true);
	        return true;
	    }
	    else{
	        return false;
	    }
	

}
}
