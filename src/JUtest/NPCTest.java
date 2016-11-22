//WIP - Alexis

package JUtest;
import wotr.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 * This class describes Non player characters. They can be added to a room of the WOTR (done in class room addNPC()) and join the fellowship of frodo (see class game pickUpNPC())
 * Non player characters can use their power on the player (frodo) by letting him loose or gain healt points and/or corruption points.
 * They can use their power only one time except if their powers are restored (by a magician)
 * They can have multiples items (i.e the ncp "dragon" owns a key to unlock a door, the magican owns food and keys etc etc)
 * Specifics NPC (see subclasses) can act with other objects (items, doors, other NPC ...)
 */


public class NPCTest {
	private NPC npcSam;
	private Player Frodo;
	


	@Before
	public void setUp() {
		Frodo = new Player();
		
	    /**
	     * Constructor for objects of class NPC.
	     *@param name : of the NPC
	     *@param description : a short description of th player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
	     *@param corruptionPower : /corruption power owned by the NPC, they are used to give corruption points to frodo
	     *@param hpPower : health points wich will be given or retrieved to Frodo
	     *@param currentPlayer : //frodo
	     */
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
	}

	@Test
	public void testGetName() {
		assertEquals("Sam", npcSam.getName());
	}
	
	@Test
    /**
 * get alreadyUsed
 * @return true if the NPC already used is powrers
 *@return false, if the NPC never used is powers (or if they had been restored since the first time he used them)
 */
	public void testAlreadyUsed(){
		assertEquals(false, npcSam.getAlreadyUsed());
	}
	
	@Test
	/**
	*Method to set the alreadyused attributes to true or false. Mostly used by object from class "Magician"
	*/
	public void testSetAlreadyUsed(){
		npcSam.setAlreadyUsed(true);
		assertEquals(true, npcSam.getAlreadyUsed());
	}
	
	@Test
	/**
	    *Restore the power of this NPC (used by the magician)
	    */
	public void testRestorePower(){
		npcSam.setAlreadyUsed(true);
		npcSam.restorePower();
		assertEquals(false, npcSam.getAlreadyUsed());
	}
	
	@Test
    /**
    *COmmon method use to all npc. A npc can at least, give or retrive hp or corruption points to Frodo
    *@return true if the NPC is used
    *@return false if the npc is  already used
    */
	public void testUseNPC(){//a comment
		npcSam.use();
		assertEquals(100, Frodo.getHp()); //hp is limited to 100hp
		assertEquals(5, Frodo.getCorruption());
		
	}
		
	




}
