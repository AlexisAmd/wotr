/*
 * This class permit to test methods of PasswordLockedExitRoom class.
 */
package JUtest;
import org.junit.Test;
import java.util.Scanner;
import wotr.*;
import static org.junit.Assert.*;
import org.junit.Before;

public class PasswordLockedExitRoomTest {
	
	private Room currentRoom, nextRoom;
	private PasswordLockedExitRoom passwordLocked;
	

	@Before
	/*
	 * Make an instance of objects we need for tests.
	 */
	public void setUp(){
		currentRoom = new Room("salle1");
		nextRoom = new Room("salle2");
		passwordLocked = new PasswordLockedExitRoom(currentRoom, nextRoom,"mdp");
	}
	@Test
	/*
	 * This test verify that the method return the next Room
	 */
	public void testGetNextRoom() {
		assertNotNull("not null", passwordLocked.getNextRoom(currentRoom));
	}
	

	@Test
	/*
	 * This test verify that hte method return the lock statut to us.
	 */
	public void testGetLocked() {
		assertEquals(true, passwordLocked.getLocked());
	}

	@Test
	/*
	 * This test permit to know if the method setLocked() which permit to modify the lock statut works
	 */
	public void testSetLocked() {
		passwordLocked.setLocked(false);
		assertEquals(false, passwordLocked.getLocked());
	}
	
	@Test
	/*
	 * This test verify that this method return us the correct password
	 */
	public void testGetPassword(){
		assertEquals("mdp", passwordLocked.getPassword());
	}
	
	@Test
	/*
	 * Verify that the method which compare the correct password and the user's password return a true value when both are equals.
	 */
	public void testIsCorrectPassword(){
		assertEquals(true, passwordLocked.isCorrectPassword("mdp"));
	}
	
	@Test
	/*
	 * Verify that the method which compare the two password return a false value when both are not equals.
	 */
	public void testIsCorrectPasswordBad(){
		assertEquals(false, passwordLocked.isCorrectPassword("motdepasse"));
	}

	
	@Test
	/*
	 * Verify that the method return us the currentRoom if the nextRoom doesn't exist.
	 */
	public void testGetNextRoomBad() {
		nextRoom = null;
		assertNotNull("not null", passwordLocked.getNextRoom(nextRoom));
	}

}
