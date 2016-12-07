/**
 *  * This class represent a door. 
 * This door is characterized by the current room (room where the player is) and the next room (room behind the door).
 * 
 * @author GR1 - 
 * @version (a version number or a date)
 */
package wotr;

public class Door {
    protected Room nextRoom;
    protected Room currentRoom;

    /**
     * Constructor for objects of class Door
     * @param currentRoom the current room
     * @param nextRoom the next room
     */
    public Door(Room currentRoom, Room nextRoom) {
	this.currentRoom = currentRoom;
	this.nextRoom = nextRoom;
    }

    /**
     * Method to get the description of the next room
     * return the description of the next room
     */
    @Override
    public String toString() {
	return nextRoom.getDescription();
    }

    /**
       *Methods to get the future current room after moving
     * @param currentRoom
     * @return the next room
     */
    public Room getNextRoom(Room nextRoom) {
	if (this.currentRoom != nextRoom) {
	    return this.currentRoom;
	} else {
	    return this.nextRoom;
	}
    }

    /**
     * Method which return the current room
     * @return the currentRoom
     */
    public Room getCurrentRoom() {
	return currentRoom;
    }
}
