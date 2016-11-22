package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;

import wotr.*;
import wotr.Item;
import org.junit.Test;
import org.junit.After;

/**
 * Test class of the class Item.
 * Tests the methods of the class Item.
 * @author GR1
 * @version 22/11/2016
 */


public class ItemTest<myItem> {

	private Item myItem;
	private Player currentPlayer;
	
	/**
	 * Default constructor for the ItemTest class.
	 */
	public ItemTest()
	{
		
	}
	
	/**
	 * Sets up the test.
	 * Called before every test case method.
	 * Creates an Item instance.
	 */
	@Before
	public void setUp()
	{
		currentPlayer = new Player();
		itemBier = new Item("Bier","I give health points.",10, currentPlayer);
	}

	/**
	 * Tears down the current test.
	 * This method is called after every test case method.
	 */
	@After
	public void tearDown()
	{
		
	}

	@Test
	public void testItem() {
		assertNotNull("Instance is not created.", myItem);
	}

	@Test
	public void testGetName() {
		assertEquals("Bier",myItem.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("I give health points.",myItem.getDescription());
	}

	@Test
	public void testGetWeight() {
		assertEquals(10,myItem.getWeight());
	}

	@Test
	public void testToString() {
		assertEquals("Name : Bier\nDescription : I give health points.\nWeight : 10",myItem.toString());
	}

	@Test
	public void testUse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetCurrentPlayer() {
		fail("Not yet implemented");
	}	
}