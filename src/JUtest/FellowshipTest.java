
package JUtest;
import wotr.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;


/**
 * THis class test methods for Fellowship class
 * 
 * @author GR1
 *
 */
public class FellowshipTest {

	private Fellowship fellowship;
	private Player player;
	private NPC npc;
	
	
	@Before
	public void setUp(){
		player = new Player();
		npc = new NPC("Sam", "hobbit", 0, 100, player, "script");
		fellowship = new Fellowship();
		fellowship.addNPC(npc);
	}

	/**
	 * Verify that the method return the fellowship
	 */
	@Test
	public void testGetFellowship(){
		assertNotNull("not null",fellowship.getFellowship());
		
	}
	
	/**
	 * Verify that the method return true if the NPC searched is contained in the fellowship
	 */
	@Test
	public void testContains(){
		NPC gandalf = new NPC("Gandalf", "magician", 0, 2000, player, "script");
		fellowship.addNPC(gandalf);
		assertEquals(true, fellowship.contains(gandalf));
	}
	
	/**
	 * Verify that the method return false where the NPC searched is not contained in the fellowship
	 */
	@Test
	public void testNotContains(){
		NPC aragorn = new NPC("aragorn", "warrior", 0, 2000, player, "script");
		assertEquals(false, fellowship.contains(aragorn));
	}
	
	/**
	 * Verify that this method add a NPC to the fellowship
	 */
	@Test 
	public void testAddNpc(){
		NPC aragorn = new NPC("Aragorn", "warrior", 0, 2000, player, "script");
		fellowship.addNPC(aragorn);
		assertEquals(true, fellowship.contains(aragorn));
	}
	
	/**
	 * Verify that the method return the NPC chose
	 */
	@Test 
	public void testGetNpc(){
		NPC aragorn = new NPC("Aragorn", "warrior", 0, 2000, player, "script");
		fellowship.addNPC(aragorn);
		assertEquals(aragorn, fellowship.getNPC(1));
	}
	
}
