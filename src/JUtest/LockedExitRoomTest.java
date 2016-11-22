/*Work in progress - Antoine*/


package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import org.junit.*;

public class LockedExitRoomTest {
	
	private Room currentRoom, nextRoom;
	private LockedExitRoom lockedExit;
	
	
	@Before
	/*
	 * Initialise vriables used for tests
	 */
	public void setUp(){
		
		currentRoom = new Room("salle 1");
		nextRoom = new Room("salle2");
	    lockedExit = new LockedExitRoom(currentRoom, nextRoom);
	}

	@Test
	/*
	 * Test that the method return a true value for locked variable
	 */
	public void testGetLocked() {
		assertEquals(true, lockedExit.getLocked());
	}

	@Test
	/*
	 * Test that the method which allow the modification of the lock status for the door works
	 */
	public void testSetLocked() {
		lockedExit.setLocked(false);
		assertEquals(false, lockedExit.getLocked());
	}

	@Test
	/*
	 * Test that the method return the next room 
	 */
	public void testGetNextRoom() {
		assertNotNull("not null", lockedExit.getNextRoom(nextRoom));
	}
	
	@Test
	/*Test that the getNextRoom return the current room if the nextroom is null
	 * 
	 */
	public void testGetNextRoomBad(){
		nextRoom = null;
		assertNotNull("not null", lockedExit.getNextRoom(nextRoom));
	}
}
