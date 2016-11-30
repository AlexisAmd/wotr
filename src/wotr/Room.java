package wotr;

import java.util.HashMap;

import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game. Initially, it has no exits. It can
 * have 4 exits max (one in each cardinal direction, north, south, east, west)
 * They represent rooms like "a kitchen" or "an open court yard". Rooms are
 * connected to each others with ExitRoom.
 * 
 * @author Gr1 (math)
 * @version 1
 */
public class Room {
    private String description; // description
    private String script;//txt
    private String img;//img
    private HashMap<String, Door> roomHM; // avaible exits for this room
    private ArrayList<Item> itemList; // items avaibles in this room
    private ArrayList<NPC> NPCList; // NPC present in the room, can be a friend or an ennemy

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description
     *            The room's description.
     */
    public Room(String description) {
	this.description = description;
  
	this.roomHM = new HashMap<>(); // HashMap of all rooms with their direction
	this.itemList = new ArrayList<>();// ItemList in each room containing the list of item
	this.NPCList = new ArrayList<>();//
    }
    
    public Room(String description, String script, String img) {
	//impossible d'appeler le constructeur precedent
	this.description = description;
        this.script= script;
	this.roomHM = new HashMap<>(); // HashMap of all rooms with their direction
	this.itemList = new ArrayList<>();// ItemList in each room containing the list of item
	this.NPCList = new ArrayList<>();//
	//
	this.script=script;
	this.img=img;
    }
    

    
    /**
     * Getter of the script
     * 
     * @return The script of the room.
     */
    public String getScript()
    {
        return script ;
    }
    
    
    /**
     * Getter for the room image name
     * 
     * @return imgLoc Name of the room image
     */
    public String getImg(){
    	return img;
    }
    
    /**
     * Getter for the room exits
     * 
     * @return The map of the rooms available from the current room.
     */
    public HashMap<String,Door> getExits(){
        return(roomHM);
    }


    /**
     * Add an exit in the roomHM
     * 
     * @param direction of the exit
     * @param exit, next room after pass the door (exit room)
     */
    public void addExit(String direction, Door exit) {
	roomHM.put(direction, exit);
    }

    /**
     * Method to add an item into the room list of items
     * 
     * @param i
     *            the item we want to add
     * @return true if deleted
     */
    public boolean addItem(Item i) {
	return itemList.add(i);
    }

    /**
     * Method to remove an item from the room' list of items
     * 
     * @param i the item we want to remove
     * @return true if deleted
     */
    public boolean delItem(Item i) {// should we have to check if the item is in
				    // the lsit before removing it ?
	if (itemList.contains(i)) {
	    return itemList.remove(i);
	} else
	    return false;
    }

    /**
     * Method to add an NPC into the room list of items
     * 
     * @paradm i the item we want to add
     * @return true if removed
     */
    public boolean addNPC(NPC i) {
	return NPCList.add(i);
    }

    /**
     * Method to remove a NPC into the room list of items
     * @param npc the npc we want to delete
     * @return true if the npc is corrected removed from the room
     */
    public boolean delNPC(NPC npc) {// should we have to check if the item is in
				    // the lsit before removing it ?
	return NPCList.remove(npc);
    }

    /**
     * Method to get the description of a room
     * 
     * @return The description of the room.
     */
    public String getDescription() {
	return description;
    }

    public HashMap<String, Door> getRoomExits() 
    {
	return this.roomHM;
    }

    /**
     * Print the items of the room
     */
    public void printItems()// a modifier
    {
	if (!itemList.isEmpty()) {
	    itemList.stream().forEach((i) -> {
	    	JOptionPane.showMessageDialog(null, i, "Items", JOptionPane.PLAIN_MESSAGE);
	    });
	} else {
		JOptionPane.showMessageDialog(null, "No items here", "Items", JOptionPane.PLAIN_MESSAGE);
	}
    }

    /**
     * Print the NPC(s) of the room
     */
    public void printNPC() // a modifier
    {
	if (!NPCList.isEmpty()) {
	    NPCList.stream().forEach((i) -> {
	    	JOptionPane.showMessageDialog(null, i, "NPC", JOptionPane.PLAIN_MESSAGE);
	    });
	} else {
		JOptionPane.showMessageDialog(null, "No friend/ennemies here", "NPC", JOptionPane.PLAIN_MESSAGE);
	}
    }

    /**
     * Method to get itemList
     * 
     * @return the array list of items
     */
    public ArrayList<Item> getItemList() {
	return itemList;
    }

    /**
     * Method to get NPCList
     * 
     * @return the array list of NCP
     */
    public ArrayList<NPC> getNPCList() {
	return NPCList;
    }

    /**
     * method to get the NextRoom
     * 
     * @param direction
     *            of the next room
     * @return the next room
     */
    public Room getNextRoom(String direction) {
	if (roomHM.containsKey(direction)) {
	    return roomHM.get(direction).getNextRoom(this);
	} else {
	    return null;
	}
    }

    /**
     * Print avaible exit rooms Key : direction Object : Room
     */
    public void printExits() {
	roomHM.keySet().stream().forEach((exit) -> {
		JOptionPane.showMessageDialog(null, exit, "Room", JOptionPane.PLAIN_MESSAGE);
	});
    }

    /**
     * Return the description of the room
     */
    public String toString() {
	return "This room is the " + description + "\n";
    }




    /**
     *    
     * This method check if the exit room chose is a WorldExit
     * @param direction: direction chose by the player, which leads to the exit we want to check 
     * @return true if the exit chose is an door which allow to exit from a world
     */

    public boolean isWorldDoor(String direction) {
	String exit = roomHM.get(direction).getClass().getName();
	return (exit == "wotr.WorldDoor"); 
    }
}

