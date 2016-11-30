
package JUtest;
import junit.framework.*;
import wotr.Door;
import wotr.Room;

public class DoorTest extends TestCase {
	private Door room;
	private Room currentRoom;
	private Room nextRoom;

	public void testGetNextRoom() {
		currentRoom = new Room("salle1");
		nextRoom = new Room ("salle2");
		room = new Door(currentRoom,nextRoom);
		assertNotNull("not null",room.getNextRoom(currentRoom));
	}
}