//WIP Alexis
package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;

import wotr.*;
import org.junit.Test;

public class MagicalItemTest {

	private Player myPlayer;
	private MagicalItem magicalItem;
	private Item item;
	
	/*
	 * Sets up the test fixture 
	 * Initialize one magicalItem for each test, whose name is "Ring", description is "Dangerous", weight is "12", corruptionPower is "40" and currentPlayer is myPlayer
	 */
	@Before
	public void setUp()
	{
		myPlayer = new Player();
		myPlayer.setCorruption(30); //Set the hp of the player (se
		magicalItem = new MagicalItem("Ring", "Dangerous", 12, 40, myPlayer);
	}
	
	/*
	 * Method testName
	 * Check if the name given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testName() {
		assertEquals("Ring", item.getName());
	}

	/*
	 * Method testDescription
	 * Check if the description given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testDescription() {
		assertEquals("Dangerous", item.getDescription());
	}

	/*
	 * Method testWeight
	 * Check if the weight given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testWeight() {
		assertEquals(12, item.getWeight());
	}
	
	/*
	 * Method testCorruptionPower
	 * Check if the corruptionPower given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testCorruptionPower() {
		assertEquals(40, magicalItem.getCorruptionPower());
	}

	/*
	 * Method testPlayer
	 * Check if the player given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testPlayer() {
		assertEquals(myPlayer, item.getCurrentPlayer());
	}
	
	/*
	 * Method testToString
	 * Check if the information given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testToString() {
		assertEquals("Name : Ring"+"\n"+"Description : Dangerous"+"\n"+"Weight : 12"+"\n" +"Corruption power : 40", magicalItem.toString());
	}

	/*
	 * Method testUse
	 * Check if the hp of the player are well upgraded
	 */
	@Test
	public void testUse() {
		magicalItem.use();
		assertEquals(70, myPlayer.getPercentCorruption());
	}
	
	/*
	 * Method testGetCorruptionPower
	 * Check if the corruptionPower given as parameter in the constructor is correctly set to the attribute
	 * Check if the return value is the good one
	 */
	@Test
	public void testGetCorruptionPower() {
		assertEquals(40, magicalItem.getCorruptionPower());
	}
}