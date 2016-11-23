package wotr;
import java.util.*;

/*
 * This class represent the fellowship. It contains a list of all NPC friends who follow the player and will help him to throw the ring  in the Mount Doom.
 */

public class Fellowship {
	
	private Player player; // the fellowship is related to the player
	private ArrayList<NPC> fellowship; // the list which contains NPCs.
	
	
	
	/*
	 * Constructor for Fellowship class
	 */
	public Fellowship(Player hero){
		fellowship = new ArrayList<>(); 
		player = hero;
	}
	
	/*
	 * Return friends who follow the player
	 */
	public ArrayList<NPC> getFellowship() {
		return this.fellowship;
	}
	
	/*
	 * Verify if our fellowship contains a NPC
	 */
	public boolean hasNPC(NPC npc) {
		return fellowship.contains(npc);
	}
	
	/*
	 * Add an NPC to our fellowship only if he is not already in the fellowship
	 */
	public boolean addNPC(NPC npc) {
		if (!hasNPC(npc)) {
			fellowship.add(npc); // add the this new friend to the fellowship  System.out.println(npc.getName()+" is now a member of thefellowship of the ring.");
			return true;
		} else {
			// System.out.println(npc.getName()+" is already a member of the fellowship of the ring.");
			return false;
		}
	}
	
	
	/*
	 * Throw a NPC out of the fellowship
	 */
	public boolean dropNPC(NPC npc) {
		NPC moveNPC;
		moveNPC = npc;
		if (hasNPC(npc)) {
			if (fellowship.remove(npc)) { // if the npc is removed
				return player.getCurrentRoom().addNPC(moveNPC);// he is added to the
													// currentRoom of the player
			} else
				return false; // if the player do not have this npc
		} else
			return false; // if it is impossible to remove the npc (impossible
						// in theory)
	}
	
	/*
	 * Pick up  NPC in the room and add it to the fellowship
	 */
	public boolean pickUpNPC(NPC npc) {
		if (this.addNPC(npc)) {
			return player.getCurrentRoom().delNPC(npc);
		} else
			return false;
	}
	
	
	
	
	

}
