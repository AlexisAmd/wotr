
package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;

import wotr.*;
import org.junit.Test;

public class PotionTest {
	private NPC npcSam;
	private Potion potionLife;
	private Player Frodo;

	
	/*
	 * Sets up the test fixture 
	 * Initialize one potion for each test, whose name is "Potion1", description is "restore power", weight is "12", player is Frodo.
	 * Acts on a NPC, whose name is Sam, description is "Best friend of Frodo, corruption power is 5, hp power is 2, and player is Frodo.
	 */
	@Before
	public void setUp()
	{
		potionLife = new Potion("Potion1", "restore power", 12, Frodo);
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo, "script");

	}
	
	/*
	 * Method testUse
	 * Check if after use a potion, the NPC power is restored
	 */
	@Test
	public void testUse() {
		potionLife.use();
		assertEquals(false, npcSam.getAlreadyUsed());
	}
	
	/*
	 * Method testName
	 * Check if the name given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testName() {
	  
		assertEquals("Potion1", potionLife.getName());
	}
	
	/*
	 * Method testDescription
	 * Check if the description given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testDescription() {
		assertEquals("restore power", potionLife.getDescription());
	}
	
	/*
	 * Method testWeight
	 * Check if the weight given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testWeight() {
		assertEquals(12, potionLife.getWeight());
	}
	
	/*
	 * Method testPlayer
	 * Check if the player given as parameter in the constructor is correctly set to the attribute
	 */
	@Test
	public void testPlayer() {
		assertEquals(Frodo, potionLife.getCurrentPlayer());
	}
	
	

}
