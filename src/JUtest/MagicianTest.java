package JUtest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import wotr.Magician;
import wotr.NPC;
import wotr.Player;

public class MagicianTest {
	private NPC npcSam;
	private Magician magicianGandalf;
	private Player Frodo;
	


	@Before
	public void setUp() {
		Frodo = new Player();
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
		magicianGandalf = new Magician("Gandalf", "A huge magician", 10, 10, Frodo);
	}


	
	@Test
	public void testUseNPC(){
		npcSam.use(); //boolean alreadyUsed for sam goes to true
		assertEquals(true, npcSam.getAlreadyUsed()); //verify the previous action
		magicianGandalf.use(npcSam); //should restore powers of sam
		assertEquals(false, npcSam.getAlreadyUsed()); //verifying that the powers of sam are restored
		
	}
		

}
