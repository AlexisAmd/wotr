//WIP - Alexis

package JUtest;
import wotr.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;




public class NPCTest {
	private NPC npcSam;
	private Player Frodo;
	


	@Before
	public void setUp() {
		Frodo = new Player();
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
	}

	@Test
	public void testGetName() {
		assertEquals("Sam", npcSam.getName());
	}
	
	@Test
	public void testAlreadyUsed(){
		assertEquals(false, npcSam.getAlreadyUsed());
	}
	
	@Test
	public void testSetAlreadyUsed(){
		npcSam.setAlreadyUsed(true);
		assertEquals(true, npcSam.getAlreadyUsed());
	}
	
	@Test
	public void testRestorePower(){
		npcSam.setAlreadyUsed(true);
		npcSam.restorePower();
		assertEquals(false, npcSam.getAlreadyUsed());
	}
	
	@Test
	public void testUseNPC(){//a comment
		npcSam.use();
		assertEquals(100, Frodo.getHp()); //hp is limited to 100hp
		assertEquals(5, Frodo.getPercentCorruption());
		
	}
		
	




}
