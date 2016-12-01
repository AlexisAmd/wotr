package JUtest;
import static org.junit.Assert.*;

import org.junit.Before;
import wotr.*;

import org.junit.Test;

public class HobbitTest {
	
	private Player frodo;
	private Hobbit sam;
	
	/*
	 * Sets up the test fixture 
	 * Initialize one hobbit for each test, whose name is "Lambas", description is "Yellow", weight is "12", calory is "40" and currentPlayer is myPlayer
	 */
	@Before
	public void setUp()
	{
		frodo = new Player();
		frodo.setCorruption(30); //Set the percent corruption of the player
		sam = new Hobbit("Samwise Gamgee", "Description", -20, 0, frodo);
	}
	
		@Test
	public void testUseHobbit() {
		sam.use();
		assertEquals(10,Hobbit.getCorruptionPower());
	}

}
