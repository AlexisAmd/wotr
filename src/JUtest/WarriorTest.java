//WIP Alexis
package JUtest;
import wotr.Warrior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import wotr.NPC;
import wotr.Player;
import wotr.Room;

/**
 * 	
 * A warrior is a specific npc. As like other npc he cans act on Frodo's health points or corruption points. However he can also kill a npc.
 * When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
 * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship (because humans used to bury their dead friends...) 

 * @author GR1
 * @version 22/11/2016
 *
 */
public class WarriorTest {
	private Player Frodo;
	private NPC npcSam;
	private Warrior Aragorn;
	private Room Forest;
	
	@Before
	public void setUp() {
		Frodo = new Player(); //hp = 100, corruption = 0
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
		Aragorn = new Warrior("Aragorn", "Brave", -2, 0, Frodo);
		Forest = new Room("forest");
		Forest.addNPC(npcSam);
		Frodo.pickUpNPC(npcSam);

	}
	
	@Test //already tested in class player but checked again here
	public void testAddSam(){
		assertTrue(Frodo.getFellowship().contains(npcSam));//verify than sam is a member of frodo's fellowship
	}
	
	@Test
	/**
	 * If aragorn uses his powers on Sam we expect sam to be dead so to be out of the frodos inventory and without his powers
	 * 
	 * 	
	 * */
	public void testKillSam(){
		Aragorn.use(npcSam);
		assertTrue(npcSam.getAlreadyUsed()); //sam is dead, he does not have any powers now...
		assertFalse(Frodo.getFellowship().contains(npcSam)); //sam is dead, he leaves to frodo's fellowship
		
	}
	
	@Test
	/**
	 * We want to know where the body of Sam is after killing him, it should be in the same place as frodo before frodo moves.
	 */
	public void testSamIsInTheForrest(){
		Aragorn.use(npcSam);
		assertTrue(Forest.getNPCList().contains(npcSam)); 
	}

}
