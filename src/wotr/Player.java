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
	private Fellowship fellowship; // list of all friends currently
	// following the hero
	private Bag bag; // Frodo's bag
	private int maximumInventoryWeight; // maximum weight of the inventory
	private Room currentRoom; // current room of a player will moves when frodo
	// moves

	/**
	 * Constructor for objects of class Player The player is named Fordo, have
	 * 100 hp and 0 corruption point. As his inventory, is fellowship is empty.
	 *
	 */
	public Player() {
		this.name = "Frodo";
		this.hp = 95;
		this.percentCorruption = 0;
		this.bag = new Bag("Baggins");
		this.fellowship = new Fellowship();
		this.currentRoom = null;
		this.maximumInventoryWeight = 50;
	}

	/**
	 * Checks if the player is still alive. Player is dead if his HP reaches 0 or his corruption reaches 100.
	 * 
	 * @return true if the player's HP are strictly higher than 0.
	 */
	public boolean isAlive() {
		return (hp != 0 && percentCorruption != 100);
	}

	/**
	 * Returns the number of health points.
	 * @return hp number of health points of th player
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * setHp : sets a new number of health points
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
			this.percentCorruption = newCorruptionValue;
	}

	/**
	 * Manages the gain or loss of corruption. If corruption reaches 100% the game is over. Corruption can not be under 0.
	 * 
	 * @param nb The number of corruption to loose, can be a negative value.
	 */
	public void addCorruption(int nb) {
		this.percentCorruption += nb;
		if (percentCorruption > 100) { //// Sets corruption if it exceeds its range.
			percentCorruption = 100;
		} 
		else if (percentCorruption < 0) {
			percentCorruption = 0;
		} 
	}

	/**
	 * Returns the total weight of the items the player carries.
	 * @return weight of the inventory
	 */
	public int getWeight() {
		return bag.getWeight();
	}

	/**
	 * Check if the player have a specific item.
	 * @param item you want to check
	 * @return true if the player has this item
	 */
	public boolean hasItem(Item item) {
		return bag.contains(item);
	}

	/**
	 * Check if the player have a specific npc.
	 * @param npc you want to check
	 * @return true if the player has it
	 */
	public boolean hasNPC(NPC npc) {
		return fellowship.contains(npc);
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
		moveItem = item; // local temporary variable
		if (bag.delItem(item)) {
			return currentRoom.addItem(moveItem); // add the removed object to the room
		} else
			return false;
	}

	/**
	 * Remove a specified NPC from the player's fellowship. The npc is droped in
	 * the currentRoom of the player
	 * 
	 * @param npc
	 *            the non player character that we want to drop
	 * @return true if done
	 * @return false if not done
	 * 
	 */
	public boolean dropNPC(NPC npc) {
		NPC moveNPC;
		moveNPC = npc;
		if (this.hasNPC(npc)) {
			if (fellowship.getFellowship().remove(npc)) { // if the npc is removed
				return getCurrentRoom().addNPC(moveNPC);// he is added to the
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
	 * Ring is not droped when used
	 * 
	 * @param item
	 *            the item that the player wants to use
	 */
	public void use(Item item) {
		if (!item.getClass().getSimpleName().equalsIgnoreCase("Ring")) {
			item.use();
			bag.delItem(item);
			
		}else{//s c'est une clef
		    item.use();
		}
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
	 *            @ return th actual room
	 */
	public Room goRoom(String direction) {
		// Try to leave current room.
		Room nextRoom = null;
		nextRoom = currentRoom.getNextRoom(direction);
		if (nextRoom == null) {
			return currentRoom;
		} else {
			if (currentRoom.isWorldDoor(direction)){
				this.restoreMagician();}
			currentRoom = nextRoom;
			return currentRoom;
			// System.out.println("Moved to " + direction + "\n");
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

	/*
	 * Method to set a room
	 * 
	 * @param currentRoom the room we want to et has currentRoom for the player
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * Method to return the feelowship of the hero
	 * @return the fellowship of the hero
	 */
	public ArrayList<NPC> getFellowship() {
		return fellowship.getFellowship();
	}

	/**
	 * Method to return the feelowship of the hero
	 * @return the fellowship of the hero
	 */
	public ArrayList<Item> getInventory() {
		return bag.getInventory();
	}

	/**
	 * pickUp an NPC is it is not an enemy, add it to the current player fellowship then remove it
	 * from the room
	 * 
	 * @param npc the npc
	 * @return true if the npc is pickedUp by the player then removed from the
	 *         current room
	 */
	public boolean pickUpNPC(NPC npc) {
		if (!npc.getClass().getSimpleName().equals("Enemy")  ) {
			fellowship.addNPC(npc);
			npc.setPlayer(this);
			return getCurrentRoom().delNPC(npc);
		} else
			return false;
	}

	/**
	 * pickUp an Item, add it to the current player bag if possible (i.e if the weigh is not superior to the maximumweight for the player) then
	 * remove it from the room
	 * 
	 * @param nameItem
	 * @return true if the item is picked up and deleted
	 */
	public boolean pickUpItem(Item item) {
		if (item.getWeight() + bag.getWeight() <= this.maximumInventoryWeight) {
			if (bag.addItem(item)) {
				item.setPlayer(this);
				return currentRoom.delItem(item);
			} else
				return false;
		} else
			return false;
	}


	/**
	 * This method return the size of our fellowship
	 * @return the size of the fellowship
	 */
	public int getFellowshipSize(){
		return fellowship.getFellowship().size();
	}


	/**
	 * This method restore the power of the magician, if it is present on the fellowship.
	 */
	public void restoreMagician(){
		for (int i =0; i<this.getFellowshipSize(); i++)
			if (fellowship.getNPC(i).getClass().getName()=="wotr.Magician"){
				fellowship.getNPC(i).restorePower();}

	}

	/**
	 * @return
	 */
	public int getMaximumInventoyWeight() {
		// TODO Auto-generated method stub
		return maximumInventoryWeight;
	}
}