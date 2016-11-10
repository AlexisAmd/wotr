package JUtest;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExitRoomTest extends TestCase {
	private ExitRoom room;
	private Room currentRoom;
	private Room nextRoom;

	public void testGetNextRoom() {
		currentRoom = new Room("salle1");
		nextRoom = new Room ("salle2");
		room = new ExitRoom(currentRoom,nextRoom);
		assertNotNull("not null",room.getNextRoom(currentRoom));
	}
}

}
