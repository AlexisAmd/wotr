//**************WIP************
package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;

import wotr.*;
import org.junit.Test;

public class KeyTest {

	private Player Frodo;
	private Key key;
	private Item item;
	private LockedExitRoom locked;
	private KeyLockedExitRoom door;
	private Room currentRoom, nextRoom;
	//private Bag myBag;
	
	/*
	 * Sets up the test fixture 
	 * Initialize one key for each test, whose name is "Key1", description is "open the door", weight is "12", currentPlayer is Frodo
	 */
	@Before
	public void setUp()
	{
		Player Frodo = new Player();
	    //Bag myBag = new Bag("myBagDescription");
		Key key = new Key("Key1", "open the door", 12, Frodo);
		KeyLockedExitRoom door = new KeyLockedExitRoom(currentRoom,nextRoom,key);
		Room currentRoom = new Room("this is the current room");
		currentRoom.addItem(key);
	    Frodo.setCurrentRoom(currentRoom);
		Frodo.pickUpItem(key);
	}

	
	/*
	 * Method testUse
	 * Check if after use a key, the door is unlocked
	 */
	@Test
	public void testUse() {
		key.use();
		assertEquals(false, door.getLocked());
	}

	/*
	 * Method testName
	 * Check if the name given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testName() {
		assertEquals("Key1", key.getName());
	}

	/*
	 * Method testDescription
	 * Check if the description given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testDescription() {
		assertEquals("open the door", key.getDescription());
	}

	/*
	 * Method testWeight
	 * Check if the weight given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testWeight() {
		assertEquals(12, key.getWeight());
	}

	/*
	 * Method testPlayer
	 * Check if the player given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testPlayer() {
		assertEquals(Frodo, key.getCurrentPlayer());
	}
}
