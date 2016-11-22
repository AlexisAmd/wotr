package JUtest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import wotr.NPC;
import wotr.Player;

public class MagicianTest {
	private NPC npcSam;
	private NPC npcGandalf;
	private Player Frodo;
	


	@Before
	public void setUp() {
		Frodo = new Player();
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
		npcGandalf = new NPC("Gandalf", "A huge magician", 10, 10, Frodo);
	}


	
	@Test
	public void testUseNPC(){
		npcSam.use();
		assertEquals(102, Frodo.getHp());
		assertEquals(5, Frodo.getPercentCorruption());
		
	}
		

}
