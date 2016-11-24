//WIP Antoine
package wotr;

/*
 * This class represent a door locked by a key. 
 * There are two cases:
 * 	- the player has a key, the door is unlocked, then he can go to the next room
 * 	- the player hasn't a key, he can't go to the next room
 */

public class KeyLockedExitRoom extends LockedExitRoom {


	/**
	 * Constructor for locked doors
	 * 
	 * @param this.currentRoom
	 * @param nextRoom
	 * @param key
	 */
	public KeyLockedExitRoom(Room currentRoom, Room nextRoom) {
		super(currentRoom, nextRoom);
		
	}

	/**
	 * getNextRoom
	 * 
	 * @param currentRoom
	 * @return
	 */
	public Room getNextRoom(Room currentRoom) {
		if (super.getLocked()) {

			
			return null; //locked
		} else {
			if (this.currentRoom != currentRoom) {
				return this.currentRoom;
			} else {
				return this.nextRoom; // ok
			}
		}
	}

	public void setUnlocked() {
		super.setLocked(false);
		// System.out.println(nextRoom.getDescription() + " is now unlock");
	}
}