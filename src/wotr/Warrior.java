//WIP Alexis
package wotr;

public class Warrior extends NPC {
	/**
	 * A warrior is a specific npc. As like other npc he cans act on Frodo's healt points or corruption points. However he can also kill a npc.
	 * When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
	 * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship (because humans used to bury their dead friends...) 
	 */
	
	private Player currentPlayer;


	/**
	 *  * A warrior is a specific npc. As like other npc he cans act on Frodo's healt points or corruption points. However he can also kill a npc.
	 * When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
	 * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship (because humans used to bury their dead friends...) 
	 *@param name : of the NPC
     *@param description : a short description of th player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
     *@param corruptionPower : /corruption power owned by the NPC, they are used to give corruption points to frodo
     *@param hpPower : health points wich will be given or retrieved to Frodo
     *@param currentPlayer : //frodo
	 */
	public Warrior(String name, String description, int corruptionPower, int hpPower, Player currentPlayer) {
		super(name, description, corruptionPower, hpPower, currentPlayer);
		this.currentPlayer = currentPlayer;
		
	}
	
	/**
	    *Use method, kill a npc. this dead npc leaves the inventory of frodo to stay in the current room
	    *@return true if the npc is killed
	    *@return false if the powers cannot be used
	    */
	    public boolean use(NPC npc){
	        npc.setAlreadyUsed(true); //in order to don't pick him again and use his powers because he is dead. Possible if a magician restoreshis powers
	        currentPlayer.dropNPC(npc); //drop the n
	        this.setAlreadyUsed(true);
	        return true;
	    }
	    else{
	        return false;
	    }
	

}
}
