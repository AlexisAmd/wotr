package wotr;
/**
 * Class Potion
 * This class allows the player to use a potion.
 * Can give their power back to dead NPC
 * 
 * @author  G1
 * @version 23/11/2016
 */
public class Potion extends Item 
{	
	 /**
     * Constructor for objects of class Potion
     * @param name (name of the potion)
     * @param description (its description)
     * @param weight (its weight)
     * @param player (the player associated)
     */
	public Potion(String name, String description, int weight, Player currentPlayer) {
		super(name, description, weight, currentPlayer);
	}
	
	/**
	 * Method that check if the NPC already used its power.
	 * If it already used its power, the boolean alreadyUsed is set to false.
	 * If not, the boolean alreadyUsed is not changed (stays false).
	 * On used the player drop item
	 * @param npc (the NPC on which the player wants to use the potion)
	 * @return true if the boolean alreadyUsed is set from true to false OR false if this boolean is not changed
	 */
	
	public boolean use(NPC npc){ 
        if (npc.getAlreadyUsed()){
        	return npc.restorePower();
        }
        else {
        	return false;
        }
	}
	
	/**
     * Give all the attributes of the potion 
     * @return name (name of the potion)
     * @return description (its description)
     * @return weight (its weight) 
     */
	public String toString() {
		return "Name : "+getName() + "\n"+
		        "Description : "+getDescription() + "\n"+
		        "Weight : "+getWeight() + "\n";
	}
		
}
