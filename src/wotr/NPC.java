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
	 *@param description : a short description of the player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
	 *@param corruptionPower : /corruption power owned by the NPC, they are used to give corruption points to frodo
	 *@param hpPower : health points which will be given or retrieved to Frodo
	 */
	public NPC(String name, String description, int corruptionPower, int hpPower) {
		this.name = name;
		this.description = description;
		this.corruptionPower = corruptionPower;
		this.hpPower = hpPower;
		this.alreadyUsed = false;
		this.itemList = new ArrayList<>(); // DEV : Useless ??
	}

	/**
	 * A second constructor where the currentPlayer and the script is added
	 * @param name the name of the npc
	 * @param description the description of the npc
	 * @param corruptionPower how many corruption he can reduce to the player
	 * @param hpPower how many hp he can reduce to the player
	 * @param currentPlayer the player associated
	 * @param script the script of the npc
	 */
	public NPC(String name, String description, int corruptionPower, int hpPower, Player currentPlayer, String script) {
		this(name, description, corruptionPower, hpPower);
		this.script = script;
	}

	/**
	 * Method which return the name of the NPC
	 * @return name the name of the NPC
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method which return the description of the NPC 
	 * @return description the description of a NPC
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method which allows user to know if the NPC has been already use
	 * @return true if the NPC already used is powers
	 *@return false, if the NPC never used is powers (or if they had been restored since the first time he used them)
	 */
	public boolean getAlreadyUsed() {
		return alreadyUsed;
	}

	/**
	 *Method to set the already used attributes to true or false. Mostly used by object from class "Magician"
	 *@param bool the boolean which say if the NPC has been already use
	 *@return true if done
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
	 *COmmon method used by all npc. A npc can at least, give or retrieve hp or corruption points to Frodo. He can do that only one time. Once he done that, his powers are set to "already used"
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
	 * Method which return the currentPlayer
	 * @return player associated with this npc
	 */
	public Player getPlayer() {
		return currentPlayer;
	}

	/**
	 * Method which associate a new player to the npc
	 * @param player
	 */
	public void setPlayer(Player player) {
		currentPlayer = player;
	}

	/**
	 * Method which return the hpPower of the npc (which determinate the hp reduce to the player)
	 * @return hpPower the hpPower of the npc
	 */
	public int getHpPower() {
		return hpPower;
	}

	/**
	 * Method which return the corruptionPower of the npc (which determinate the corruption points reduce to the player)
	 * @return corruptionPower the corruptionPower of the npc
	 */
	public int getCpPower() {
		return corruptionPower;
	}
}
