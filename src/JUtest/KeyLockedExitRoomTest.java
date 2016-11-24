//WIP Antoine
package JUtest;
import org.junit.Test;
import wotr.*;
import static org.junit.Assert.*;
import org.junit.Before;

/*
 * This class test methods for KeyLockedExitRoom class
 * @author Gr1
 * @version 22/11/2016 
 */

public class KeyLockedExitRoomTest {

	private Room currentRoom, nextRoom;
	private Player player;
	private Key key;
	private KeyLockedExitRoom keyLocked;
	
	
	@Before
	/*
	 * This class creates objects we need for test this class
	 */
	public void setUP(){
		player = new Player();
		currentRoom = new Room("salle1");
		nextRoom = new Room("salle2");
		key = new Key("magique", "blabla", 1, player, keyLocked);
		keyLocked = new KeyLockedExitRoom(currentRoom, nextRoom);
	}
	
	
	@Test
	/*
	 * Verify that using a key unlock the door
	 */
	public void testSetUnlocked(){
		keyLocked.setUnlocked();
		assertEquals(false, keyLocked.getLocked());
		
	}
	
	
	@Test
	/*
	 *  This test verify that the method return the next Room when the door is unlocked.
	 */
	public void testGetNextRoom(){
		keyLocked.setLocked(false);
		assertNotNull("not null", keyLocked.getNextRoom(currentRoom));
	}
	
}
