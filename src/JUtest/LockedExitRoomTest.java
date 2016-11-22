/*Work in progress*/


package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import org.junit.*;

public class LockedExitRoomTest {
	
	private Room currentRoom, nextRoom;
	private LockedExitRoom lockedExit;
	
	
	@Before
	public void setUp(){
		
		currentRoom = new Room("salle 1");
		nextRoom = new Room("salle2");
	    lockedExit = new LockedExitRoom(currentRoom, nextRoom);
	}
	
	
	@Test
	public void testLockedExitRoom() {
		
	}

	@Test
	public void testGetLocked() {
		assertEquals(true, lockedExit.getLocked());
	}

	@Test
	public void testSetLocked() {
		lockedExit.setLocked(false);
		assertEquals(false, lockedExit.getLocked());
	}

	@Test
	public void testExitRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextRoom() {
		AssertNotNull("not null", lockedExit.getNextRoom(currentRoom));
	}

}
