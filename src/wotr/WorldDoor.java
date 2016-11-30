/**
 * Class wich describes WorldExit. A world exit is the last exit of a world before entering in a new world.
 * When the player pass reach this door powers of magician are restored (see player class)
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
 * This class represent a wolrd door. 
 * This door is characterized by the current room (room where the player is) and the next room (room behind the door).
 * When the player pass reach this door powers of magician are restored.
 */
public class WorldDoor extends Door {


    /**
     * Constructor for objects of class ExitRoom
     * @param currentRoom the current room
     * @param nextRoom the next room
     */
    public WorldDoor(Room currentRoom, Room nextRoom) {
	super(currentRoom, nextRoom);

    }


}
