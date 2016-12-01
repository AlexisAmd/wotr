package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;
import wotr.*;

import org.junit.Test;

public class HobbitTest {
	
	private Player playerFrodo;
	private Hobbit npcSam;
	
	/*
	 * Sets up the test fixture 
	 * Initialize one hobbit for each test, whose name is "Lambas", description is "Yellow", weight is "12", calory is "40" and currentPlayer is myPlayer
	 */
	@Before
	public void setUp()
	{
		playerFrodo = new Player();
		playerFrodo.setCorruption(30); //Set the percent corruption of the player
		npcSam = new Hobbit("Samwise Gamgee", "Description", -20, 0, playerFrodo);
	}
	
		@Test
	public void testUseHobbit() {
		npcSam.use();
		assertEquals(10,playerFrodo.getCorruption());
		assertEquals(true, npcSam.getAlreadyUsed());
	}

}
