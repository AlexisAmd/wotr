
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
	
}
