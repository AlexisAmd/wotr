//WIP ALEXIS
package JUtest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import wotr.*;

/**
 * The test class PlyerTest.
 * Tests the methods of the clas "Player".
 * 
 * @author GR1
 * @version 22/11/2016
 */

public class PlayerTest {

	private Player myPlayer;
	private NPC myNPC;
	private Food myFood;
	private Room myRoom;
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
		myPlayer = new Player();
		myNPC = new NPC("Gandalf", "Malicious magician", 0, 100, null);
		myFood = new Food("Beer", "Tasty Beverage", 1, 30, null);
		myRoom = new Room("kithen");
		myRoom.addItem(myFood);
		myPlayer.setCurrentRoom(myRoom);
		
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
	@Test
	public void testIsAlive()
	{
		myPlayer.addHp(-101);
		// Assuming that the player starts with 100 HP, the player should be considered dead.
		assertFalse(myPlayer.isAlive());
	}
	
	/**
	 * Method testing addHp in a healing context.
	 */
	@Test
	public void testAddHpHeal()
	{
		myPlayer.setHp(50);
		myPlayer.addHp(10);
		// Assuming healing works as intended, the player should have 50 + 10 HP.
		assertEquals(60, myPlayer.getHp());
	}

	/**
	 * Method testing addHp in a damaging context.
	 */
	@Test
	public void testAddHpDamage()
	{
		myPlayer.addHp(-10);
		// Assuming addHp works as intended, the player should have 100 - 10 HP.
		assertEquals(90, myPlayer.getHp());
	}
	
	/**
	 * Tests the gain of HP resulting in a HP value potentially superior to 100.
	 * Player's HP starts at 100.
	 * Healing from this point should have no effect.
	 */
	@Test
	public void testAddHpOver()
	{
		myPlayer.addHp(10);
		// Assuming addHp works as intended, the player HP value should stay at 100.
		assertEquals(100, myPlayer.getHp());
	}

	/**
	 * Tests the loss of HP resulting in a HP value potentially inferior to 100.
	 * Player's HP starts at 100.
	 * Receiving more damage than 100 should set the HP to 0, no less.
	 */
	@Test
	public void testAddHpUnder()
	{
		myPlayer.addHp(-150);
		// Assuming addHp works as intended, the player HP value should stay at 100.
		assertEquals(0, myPlayer.getHp());
	}
	
	/**
	 * Method testing addCorruption.
	 * Gaining corruption in this case.
	 */
	@Test
	public void testAddCorruptionGain()
	{
		myPlayer.setCorruption(50);
		myPlayer.addCorruption(10);
		// Assuming addCorruption works as intended, the player's corruption value should be 50 + 10.
		assertEquals(60, myPlayer.getCorruption());
	}
	
	/**
	 * Testing addCorruption.
	 * Loosing corruption in this case.
	 */
	@Test
	public void testAddCorruptionLoss()
	{
		myPlayer.setCorruption(50);
		myPlayer.addCorruption(-10);
		// Assuming addCorruption works as intended, the player's corruption value should be 50 - 10.
		assertEquals(40, myPlayer.getCorruption());
	}
	
	/**
	 * Testing addCorruption in a case where the player receives more corruption than needed to reach 100.
	 * Player's percentCorruption starts at 0.
	 * Corruption value should stay at 100.
	 */
	@Test
	public void testAddCorruptionOver()
	{
		myPlayer.addCorruption(150);
		// Assuming addCorruption works as intended, the player's corruption value should be 100.
		assertEquals(100, myPlayer.getCorruption());
	}
	
	/**
	 * Testing addCorruption in a case where the player recovers more sanity than needed to reach 0.
	 * Player's percentCorruption starts at 0.
	 * Corruption value should stay at 0.
	 */
	@Test
	public void testAddCorruptionUnder()
	{
		myPlayer.addCorruption(-50);
		// Assuming addCorruption works as intended, the player's corruption value should be 0.
		assertEquals(0, myPlayer.getCorruption());
	}
	
	/**
	 * Testing the addNPC method.
	 */
	@Test
	public void testpickUpNPC()
	{
		myPlayer.pickUpNPC(myNPC);
		//The player should receive an NPC and hasNPC should return the value true.
		assertEquals(true, myPlayer.hasNPC(myNPC));
	}
	
	/**
	 * Add food
	 */
	
	/**
	 * Testing the addNPC method.
	 */
	@Test
	public void testpickUpItem()
	{
		myPlayer.pickUpItem(myFood);
		//The player should receive an NPC and hasNPC should return the value true.
		assertEquals(true, myPlayer.hasItem(myFood));
	}
	
	/**
	 * addNPC does not allow to add the same NPC twice.
	 * It retuns the velue false if we try.
	 */
	@Test
	public void testAddNPCSame()
	{
		myPlayer.pickUpNPC(myNPC);
		//When adding the same NPC, the addNPC method should return false.
		assertEquals(false, myPlayer.pickUpNPC(myNPC));
	}
	
	
}