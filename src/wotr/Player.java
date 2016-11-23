//WIP ALEXIS
package wotr;

import java.util.*;

/**
 * 
 * Player class stands for a World of the Ring player able to explore many
 * differents world. This player is named Frodo. A player have health point and
 * corruption points. When healt point is equal to 0 the player is dead. When
 * the percentage of corruption of the player is equal to 100% the payer is
 * dead. Player can not have more than 100 HP. A player have bag wich
 * contains items and a fellowship which contains NPCs. This inventory have a
 * maximum weight. By default, the player have 100 hp and 0 % of corruption A
 * player can pick an item in a room and add it to his inventory. He can drop it
 * in a room. He can also add npc to his fellowship then leave them in a room
 * (i.e if they are dead and/of and useless).
 * 
 * @author GR1
 * @version 21/11/16
 */
public class Player {
	private String name; // name of the player, st to frodo by default
	private int hp;// health points of the player, can be >100 but if <=0, the
					// player is dead
	private int percentCorruption; // percentage of corruption, cannot be <0,
									// player's die if percentage is >=100

	private ArrayList<NPC> fellowship; // list of all friends currently
										// following the hero
	private Bag inventory; //Frodo's bag
	private int maximumInventoryWeight; // maximum weight of th inventory
	private Room currentRoom; // current room of a player will moves when frodo
								// moves

	/**
	 * Constructor for objects of class Player The player is named Fordo, have
	 * 100 hp and 0 corruption point. As his inventory, is fellowship is empty.
	 *
	 */
	public Player() {
		// constructeur sans parametres ?
		this.name = "Frodo";
		this.hp = 100;
		this.percentCorruption = 0;
		this.inventory = new Bag(); //devrait demander un string normalemment
		this.fellowship = new ArrayList<>();
		this.currentRoom = null;
		this.maximumInventoryWeight = 20;

	}

	/**
	 * Checks if the player is still alive. Player is dead if his HP reaches 0 or his corruption reaches 100.
	 * 
	 * @return true if the player's HP are strictly higher than 0.
	 */
	public boolean isAlive() {
		return (hp != 0 || percentCorruption != 100);
	}

	/**
	 * Returns the number of health points.
	 * @return hp number of health points of th player
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * setHp : sets a new number of healthpoints
	 * @param newHpValue The new value of the player's health points.
	 */
	public void setHp(int newHpValue) {
		if ((newHpValue < 0) || (newHpValue > 100)) {
			throw new IllegalArgumentException("Value is out of range for newHpValue");
		} else {
			hp = newHpValue;
		}
	}

	/**
	 * Manages the gain or loss of health points. This method prevents the
	 * player to have more than 100 or less than 0 HP. 
	 * @param nb The number of health points to gain, can be a negative value.
	 */
	public void addHp(int nb) {
		hp += nb;
		if (hp > 100) // Sets HP if it exceeds its range.
			hp = 100;
		else if (hp < 0)
			hp = 0;
	}

	/**
	 * Access the percentCorruption attribute
	 * @return the percentCorruption value.
	 */
	public int getCorruption() {
		return percentCorruption;
	}

	/**
	 * Sets a new number of corruption
	 * @param newCorruptionValue The new value of the player's corruption percentage.
	 */
	public void setCorruption(int newCorruptionValue) {
		if ((newCorruptionValue < 0) || (newCorruptionValue > 100)) {
			throw new IllegalArgumentException("Value is out of range for newCorruptionValue");
		} else
			percentCorruption = newCorruptionValue;
	}

	/**
	 * Manages the gain or loss of corruption. If corruption reaches 100% the game is over. Corruption can not be under 0.
	 * 
	 * @param nb The number of corruption to loose, can be a negative value.
	 */
	public void addCorruption(int nb) {
		percentCorruption += nb;
		if (percentCorruption > 100) { //// Sets corruption if it exceeds its range.
			percentCorruption = 100;
		} else if (percentCorruption < 0) {
			percentCorruption = 0;
		}
	}

	/**
	 * Method to return the feelowship of the hero
	 * @return the fellowship of the hero
	 */
	public ArrayList<NPC> getFellowship() {
		return fellowship;
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
	 * Returns the total weight of the items the player carries.
	 * @return weight of the inventory
	 */
	public int getInventoryWeight() {
		return inventory.getInventoryWeight();
	}



	/**
	 * Check if the player have a specific item.
	 * @param item you want to check
	 * @return true if the player has this item
	 */
	public boolean hasItem(Item item) {
		return inventory.contains(item);
	}

	/**
	 * Add the item to the player's inventory. Only if its added weight does not
	 * make the total inventory weight superior to the maximum weight. A player
	 * can carry many items of the same type. (i.e it can contains 6 beers)
	 * 
	 * @param newItem the new item in the player's inventory
	 * @return true if the item has been added to the inventoru
	 */
	public boolean addItem(Item newItem) {
		if (newItem.getWeight() + inventory.getInventoryWeight() > this.maximumInventoryWeight) {
			// System.out.println("Objet too heavy for your inventory (itemweight : "+newItem.getWeight()+" ) !");
			return false;
		} else {
			inventory.addItem(newItem);
			return true;
		}
	}

	/**
	 * Remove a specified item from the player's inventory. If the item is
	 * deleted the total weight of the inventory decrease according to the
	 * weight of the item (see class bag), then the item is drop in the currentRoom of the
	 * Player
	 * 
	 * @param item the item to remove
	 * @return false if not done
	 */
	public boolean dropItem(Item item) {
		Item moveItem;
		moveItem = item; //local temporary variable
		if (inventory.delItem(item)){
			return currentRoom.addItem(moveItem); // add the removed object to the room
			}
		else return false;

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
		if (this.hasNPC(npc)) {
			if (fellowship.remove(npc)) { // if the npc is removed
				return currentRoom.addNPC(moveNPC);// he is added to the
													// currentRoom of the player
			} else
				return false; // if the player do not have this npc
		} else
			return false; // if it is impossible to remove the npc (impossible
						// in theory)
	}

	/**
	 * Allow the player to use an item. Items can have an action on the world
	 * and/or on the player's HP and/or CP.  Once used the objected is droped in the current room
	 * 
	 * @param item
	 *            the item that the player wants to use
	 */
	public void use(Item item) {
		item.use(); // usefull for keys
		inventory.delItem(item);

	}

	/**
	 * Allow the player to use a NPC. NPC can have act on the world and/or on
	 * the player's HP and/or CP.
	 * 
	 * @param npc the NPC that the player wants to use.
	 */
	public void use(NPC npc) {
		npc.use();
	}


	/**
	 * Try to go to one direction. If there is a room in this direction, go to
	 * this room Otherwise print an error message
	 * 
	 * @param direction
	 *            the direction of the move
	 */
	public void goRoom(String direction) {
		// Try to leave current room.
		Room nextRoom = null;
		nextRoom = currentRoom.getNextRoom(direction);
		if (nextRoom == null) {
			System.out.println("Can't move to " + direction + "\n");
		} else {
			currentRoom = nextRoom;
			System.out.println("Moved to " + direction + "\n");
		}
	}

	/**
	 * Method to return the currentRoom of a player
	 * 
	 * @return currentRoom , the currentRoom of the player
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * pickUp an Item, add it to the current player bag if possible then
	 * remove it from the room
	 * 
	 * @param nameItem
	 */
	public boolean pickUpItem(Item item) {
		Item moveItem;// temporary varaible to store the item
		moveItem = item;
		currentRoom.delItem(item);
		if (moveItem != null) {
			if (!this.addItem(moveItem)) {
				return currentRoom.addItem(moveItem); // si item pas ajouté au perso on le remet dans la piece
			}else return false;
		}else return false;
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
			return currentRoom.delNPC(npc);
		} else
			return false;
	}

	/*
	 * Method to set a room
	 * @param currentRoom the room we want to et has currentRoom for the player
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}