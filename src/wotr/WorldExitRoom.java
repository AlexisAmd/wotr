/**
 * Class wich describes WorldExit. A world exit is the last exit of a world before entering in a new world.
 * 
 * 
 * @author GR1
 * @version (a version number or a date)
 */
/**
 * Class to manage exits (door)
 * 

 */
package wotr;

/*
 * This class represent a door. 
 * This door is characterized by the current room (room where the player is) and the next room (room behind the door).
 */
public class WorldExitRoom extends Door {


    /**
     * Constructor for objects of class ExitRoom
     * @param currentRoom the current room
     * @param nextRoom the next room
     */
    public WorldExitRoom(Room currentRoom, Room nextRoom) {
	super(currentRoom, nextRoom);
    }


}
