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
	
	/**
	 * Method to return the feelowship of the hero
	 * @return the fellowship of the hero
	 */
	public ArrayList<NPC> getFellowship() {
		return this.fellowship;
	}
	
	/**
	 * Check if the player have this friend
	 * @param npc The npc you want to find.
	 * @return true if the player have this npc
	 */
	public boolean hasNPC(NPC npc) {
		return fellowship.contains(npc);
	}
	
	/**
	 * Add a friend to the player's fellowship
	 * @param npc The non player character you just met.
	 * @return true if added
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
	
	
	/**
	 * Remove a specified NPC from the player's fellowship. The npc is droped in
	 * the currentRoom of the player
	 * 
	 * @param npc
	 *            the non player character that we want to drop
	 * @return true if done
	 * @return false if not donr
	 * 
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
	
	
	/**
	 * pickUp an Item, add it to the current player inventory then remove it
	 * from the room
	 * 
	 * @param nameItem
	 * @return true if the item is pickedUp by the npc then removed from the
	 *         current room
	 */
	public boolean pickUpNPC(NPC npc) {
		if (this.addNPC(npc)) {
			return player.getCurrentRoom().delNPC(npc);
		} else
			return false;
	}
	
	
	
	
	

}
