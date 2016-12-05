package wotr;

import java.util.*;

/**
 * This class describes Non player characters. They can be added to a room of the WOTR and joins the fellowship of frodo (see class game pickUpNPC())
 * Non player characters can use their power on the player (frodo) by letting him loose or gain healt points and/or corruption points.
 * They can use their power only one time except if their powers are restored (by a magician)
 * They can have multiples items (i.e the ncp "dragon" owns a key to unlock a door, the magican owns food and keys etc etc)
 * Specifics NPC (see subclasses) can act with other objects (items, doors, other NPC ...)
 */
public class NPC {
    private String name; // name of the NPC
    private String description; // a short description of th player ex : dwarfs are sprinters, they are fast on short distances but long distances tires them
    private int corruptionPower;// corruption power owned by the NPC, they are used to give corruption points to frodo
    private int hpPower;// health points wich will be given or retrieved to Frodo
    private Player currentPlayer; // frodo
    private boolean alreadyUsed; // true if the npc hae already used his powers
    private ArrayList<Item> itemList; // inventory of the NPC
    private String script; // what does the npc say


    /**
     * Constructor for objects of class NPC.
     *@param name : of the NPC
     *@param description : a short description of th player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
     *@param corruptionPower : /corruption power owned by the NPC, they are used to give corruption points to frodo
     *@param hpPower : health points wich will be given or retrieved to Frodo
     *@param currentPlayer : //frodo
     */
    public NPC(String name, String description, int corruptionPower, int hpPower, Player currentPlayer) {
	this.name = name;
	this.description = description;
	this.corruptionPower = corruptionPower;
	this.hpPower = hpPower;
	this.currentPlayer = currentPlayer;
	this.alreadyUsed = false;
	this.itemList = new ArrayList<>(); // DEV : Useless ??
    }

    public NPC(String name, String description, int corruptionPower, int hpPower, Player currentPlayer, String script) {
	this(name, description, corruptionPower, hpPower, currentPlayer);
	this.script = script;
    }

    /**
     * get name 
     * @return  the name of the NPC
     */
    public String getName() {
	return name;
    }

    /**
    * get description 
    * @return the description of a NPC
    */
    public String getDescription() {
	return description;
    }

    /**
    * get alreadyUsed
    * @return true if the NPC already used is powers
    *@return false, if the NPC never used is powers (or if they had been restored since the first time he used them)
    */
    public boolean getAlreadyUsed() {
	return alreadyUsed;
    }

    /**
    *Method to set the already used attributes to true or false. Mostly used by object from class "Magician"
     * @return true if done
    */
    public boolean setAlreadyUsed(boolean bool) {
	return this.alreadyUsed = bool;
    }

    /**
     * Convert some NPC attributes (name and description) to a string
     * @return the name and the description of the NPC
     */
    public String toString() {
	return getName() + " : " + this.getDescription();
    }

    /**
    *COmmon method use to all npc. A npc can at least, give or retrieve hp or corruption points to Frodo
    *@return true if the NPC is used
    *@return false if the npc is  already used
    */
    public boolean use() {
	if (!alreadyUsed) {
	    currentPlayer.addHp(hpPower);
	    currentPlayer.addCorruption(corruptionPower);
	    alreadyUsed = true;
	    return true;
	} else {
	    return false;
	}
    }

    /**
    *Restore the power of this NPC (used by the magician)
    *@return true if done
    */
    public boolean restorePower() {
	return this.setAlreadyUsed(false);
    }

    /**
     * @return player associated with this npc
     */
    public Player getPlayer() {
	return currentPlayer;
	
    }

    /**
     * @param player
     */
    public void setPlayer(Player player) {
	currentPlayer = player;
	
    }
}
