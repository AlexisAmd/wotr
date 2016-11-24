package wotr;
import java.util.*;
import java.util.ArrayList;

/*
 * This class represent the fellowship. It contains a list of all NPC friends who follow the player and will help him to throw the ring  in the Mount Doom.
 */

public class Fellowship {
	
	private ArrayList<NPC> fellowship;// the list which contains NPCs.
	

	
	/*
	 * Constructor for Fellowship class
	 */
	public Fellowship(){
		fellowship = new ArrayList<>(); 

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
	public boolean contains(NPC npc) {
		return fellowship.contains(npc);
	}
	

	
	
	/**
	 * Add a friend to the player's fellowship
	 * @param npc The non player character you just met.
	 * @return true if added
	 */
	public boolean addNPC(NPC npc) {
		if (!this.contains(npc)) {
			return fellowship.add(npc); // add the this new friend to the fellowship  System.out.println(npc.getName()+" is now a member of thefellowship of the ring.");
			
		} else {
			// System.out.println(npc.getName()+" is already a member of the fellowship of the ring.");
			return false;
		}
	}
	

	public NPC getNPC(int i){
		return fellowship.get(i);
	}
	
	
	
	
	
	
	

}
