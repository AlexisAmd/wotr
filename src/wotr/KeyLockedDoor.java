package wotr;

import javax.swing.JOptionPane;

/**
 * This class represent a door locked by a key. 
 * There are two cases:
 * 	- the player has a key, the door is unlocked, then he can go to the next room
 * 	- the player hasn't a key, he can't go to the next room
 * 
 * @author GR1
 */

public class KeyLockedDoor extends LockedDoor {


	/**
	 * Constructor for locked doors
	 * 
	 * @param this.currentRoom
	 * @param nextRoom
	 * @param key
	 */
	public KeyLockedDoor(Room currentRoom, Room nextRoom) {
		super(currentRoom, nextRoom);
		
	}

	/**
	 * Method which return the NextRoom
	 * 
	 * @param currentRoom
	 * @return null if the door is locked
	 * @return nextRoom the nextRoom can be the current Room
	 */
	public Room getNextRoom(Room currentRoom) {
		if (super.getLocked()) {
			JOptionPane.showMessageDialog(null, "You need a key to open this door!", 
				    "LockedDoor", JOptionPane.WARNING_MESSAGE);
			return null; //locked
		} else {
			if (this.currentRoom != currentRoom) {
				return this.currentRoom;
			} else {
				return this.nextRoom; // ok
			}
		}
	}

	/**
	 * Method which unlock the door
	 */
	public void setUnlocked() {
		super.setLocked(false);
	}
}