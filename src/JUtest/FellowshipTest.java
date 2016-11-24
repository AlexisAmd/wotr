
package JUtest;
import wotr.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.*;

public class FellowshipTest {

	private Fellowship fellowship;
	private Player player;
	private NPC npc;
	
	
	@Before
	public void setUp(){
		player = new Player();
		npc = new NPC("Sam", "hobbit", 0, 100, player);
		fellowship = new Fellowship();
		fellowship.addNPC(npc);
	}

	@Test
	public void testGetFellowship(){
		assertNotNull("not null",fellowship.getFellowship());
		
	}
	
	@Test
	public void testContains(){
		NPC gandalf = new NPC("Gandalf", "magician", 0, 2000, player);
		fellowship.addNPC(gandalf);
		assertEquals(true, fellowship.contains(gandalf));
	}
	
	@Test
	public void testNotContains(){
		NPC aragorn = new NPC("aragorn", "warrior", 0, 2000, player);
		assertEquals(false, fellowship.contains(aragorn));
	}
	
	@Test 
	public void testAddNpc(){
		NPC aragorn = new NPC("Aragorn", "warrior", 0, 2000, player);
		fellowship.addNPC(aragorn);
		assertEquals(true, fellowship.contains(aragorn));
	}
	
}
