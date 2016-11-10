package wotr;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description; //description 
    private HashMap <String,ExitRoom> roomHM; //avaible exits for this room
    private ArrayList<Item> itemList; //items avaibles in this room
    private ArrayList<NPC> NPCList; //NPC present in the room, can be a friend or an ennemy

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        this.roomHM = new HashMap<>();
        this.itemList=new ArrayList<>();
        this.NPCList= new ArrayList<>();
    }

    /**
     * Add an exit in the roomHM
     * @param direction direction of the exit
     * @param exit next room after pass the door (exit room)
     */
    public void addExit(String direction, ExitRoom exit){
        roomHM.put(direction,exit);
    }

    /**
     * Metho to add an item into the room list of items
     * @param i the item we want to add
     */
    public void addItem(Item i)
    {
        itemList.add(i);
    }


        /**
     * Metho to remove an item into the room list of items
     * @param i the item we want to add
     */
    public void delItem(Item i)
    {//should we have to check if the item is in the lsit before removing it ?
        itemList.remove(i);
    }




        /**
     * Metho to add an NPC into the room list of items
     * @paradm i the item we want to add
     */
    public void addNPC(NPC i)
    {
        NPCList.add(i);
    }

        /**
     * Metho to remove a NPC into the room list of items
     * @param npc the npc we want to delete
     */
    public void delNPC(NPC npc)
    {//should we have to check if the item is in the lsit before removing it ?
        NPCList.remove(npc);
    }


    /**
     * Method to get the description of a room
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Print the items of the room
     */
    public void printItems()
    {
        if (!itemList.isEmpty()){
            itemList.stream().forEach((i) -> {
                    System.out.println(i);
                });
        }
        else {System.out.println("No items here");}
    }

        /**
     * Print the items of the room
     */
    public void printNPC()
    {
        if (!NPCList.isEmpty()){
            NPCList.stream().forEach((i) -> {
                    System.out.println(i);
                });
        }
        else {System.out.println("No friend/ennemies here");}
    }

    /**
     * Method to get itemList
     * @return the array list of items
     */
    public ArrayList<Item> getItemList()
    {
        return itemList;
    }

    /**
     * Method to get NPCList
     * @return the array list of NCP
     */
    public ArrayList<NPC> getNPCList()
    {
        return NPCList;
    }

    /**
     * method to get the NextRoom
     * @param direction of the next room
     * @return  the next room
     */
    public Room getNextRoom(String direction){
        if(roomHM.containsKey(direction)){
            
            return roomHM.get(direction).getNextRoom(this);
            }
        
        else {
            return null;
        }
    }



    /**
     * Print avaible exit rooms
     * Key : direction
     * Object : Room
     */
    public void printExits()
    {
        roomHM.keySet().stream().forEach((exit) -> {
                System.out.println(exit);
            });
    }

    public String toString(){
        return "This room is the "+description+"\n";
    }

}
