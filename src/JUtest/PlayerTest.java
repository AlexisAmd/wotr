package JUtest;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlyerTest.
 * Tests the methods of the clas "Player".
 * 
 * @author GR1
 * @version 22/11/2016
 */

public class PlayerTest {

	private Player myPlayer;
	
	/**
	 * Default constructor for the PlayerTest class.
	 */
	public PlayerTest()
	{
		
	}
	
	/**
	 * Sets up the test.
	 * Called before every test case method.
	 * Creates a Player instance.
	 */
	@Before
	public void setUp()
	{
		player = new Player();
	}
	
	/**
	 * Tears down the current test.
	 * This method is called after every test case method.
	 */
	@Before
	public void tearDown()
	{
		
	}
	
	/**
	 * Method to simulate the player's death.
	 * Player receives a big amount of damage.
	 * testIsALive then check if he is considered as dead.
	 */
	public void testIsAlive()
	{
		myPlayer.addHP(-1000);
		// Assuming that 
	}
	
	@Test
	public void testGetHp()
	{
		assertEquals("Player's HP does not match!", 100, player.getHp());
	}
	
	@Test
	public void testSetHp()
	{
		player.setHp(50)
		assertEquals("Player's HP was not set correctly!", 50, player.getHp());
	}
	
	@Test
	public void testGetPercentCorruption()
	{
		assertEquals("Player's corruption does not match!", 0, player.getCorruption());
	}
	
	@Test
	public void testAddHp()
	{
		player.setHp(50);
		player.addHp(10);
		assertEquals("Healing does not work as intended", 60, player.getHp());
	}

	@Test
	public void testAddCorruption()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetFellowship()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testHadNPC()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddNPC()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetInventory()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetInventoryWeight()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaximumInventoryWeight()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testHasItem()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddItem()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testUseItem()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testUseNPC()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testToString()
	{
		fail("Not yet implemented");
	}

}