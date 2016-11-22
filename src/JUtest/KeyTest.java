package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;

import wotr.*;
import org.junit.Test;

public class KeyTest {

	private Player myPlayer;
	private Key key;
	private Item item;
	private LockedExitRoom locked;
	
	/*
	 * Sets up the test fixture 
	 * Initialize one key for each test, whose name is "Key1", description is "open the door", weight is "12", currentPlayer is myPlayer
	 */
	@Before
	public void setUp()
	{
		key = new Key("Key1", "open the door", 12, myPlayer);
	}
	
	@Test
	public void testUse() {
		key.use();
		assertEquals(false, locked.getLocked());
	}

	@Test
	public void testName() {
		assertEquals("Key1", item.getName());
	}

	@Test
	public void testDescription() {
		assertEquals("open the door", item.getDescription());
	}

	@Test
	public void testWeight() {
		assertEquals(12, item.getWeight());
	}

	@Test
	public void testPlayer() {
		assertEquals(myPlayer, item.getCurrentPlayer());
	}
}
