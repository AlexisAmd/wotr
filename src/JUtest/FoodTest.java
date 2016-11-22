package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;
import wotr.*;

import org.junit.Test;

public class FoodTest {

	private Player myPlayer;
	private Food food;
	private Item item;
    
	/* 
	 * Sets up the test fixture 
	 * Initialize one food for each test, whose name is "Lambas", description is "Yellow", weight is "12", calory is "40" and currentPlayer is myPlayer
	 */
	@Before
	public void setUp()
	{
		myPlayer = new Player();
		myPlayer.setHp(30); //Set the hp of the player
		food = new Food("Lambas", "Yellow", 12, 40, myPlayer);
	}
	
	/*
	 * Method testName
	 * Check if the name given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testName() {
		assertEquals("Lambas", item.getName());
	}

	/*
	 * Method testDescription
	 * Check if the description given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testDescription() {
		assertEquals("Yellow", item.getDescription());
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
	 * Method testCalory
	 * Check if the calory given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testCalory() {
		assertEquals(40, food.getCalory());
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
		assertEquals("Name : Lambas"+"\n"+"Description : Yellow"+"\n"+"Weight : 12"+"\n" +"Calory : 100", food.toString());
	}

	/*
	 * Method testUse
	 * Check if the hp of the player are well upgraded
	 */
	@Test
	public void testUse() {
		food.use();
		assertEquals(70, myPlayer.getHp());
	}

	/*
	 * Method testGetCalory
	 * Check if the calory given as parameter in the constructor is correctly set to the attribute
	 * Check if the return value is the good one
	 */
	@Test
	public void testGetCalory() {
		assertEquals(40, food.getCalory());
	}
}
