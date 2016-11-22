
package JUtest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import wotr.Magician;
import wotr.NPC;
import wotr.Player;

/**
 * A magician can restore powers of an other NPC only one time. He can also give hps or corruption points (negative or positives ones) to frodo.
 * For example Gandalf is a good magician, he decreases the corruption of frodo while saruman (the evil one) increase these corruption points but they can both restor the powers of an other npc.
 *
 * @author GR1
 * @version 21/11/016
 */

public class MagicianTest {
	private NPC npcSam;
	private Magician magicianGandalf;
	private Player Frodo;
	


	@Before
    /**
     * Constructor for Magicians.
     *@param name : of the NPC
     *@param description : a short description of th player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
     *@param corruptionPower : /corruption power owned by the NPC, they are used to give corruption points to frodo
     *@param hpPower : health points wich will be given or retrieved to Frodo
     *@param currentPlayer : //frodo
     */
	public void setUp() {
		Frodo = new Player(); //hp = 100, corruption = 0
		npcSam = new NPC("Sam", "Best Friend of Frodo", 5, 2, Frodo);
		magicianGandalf = new Magician("Gandalf", "A huge magician", 10, 10, Frodo);
	}


	
	@Test
    /**
    *Use method, restore hp of frodo (max=100) and restore power of an other npc
    *@return true if the power of the npc just have been used
    *@return false if the powers cannot be used
    */
	public void testUseMagician(){
		npcSam.use(); //boolean alreadyUsed for sam goes to true
		assertEquals(true, npcSam.getAlreadyUsed()); //verify the previous action
		magicianGandalf.use(npcSam); //should restore powers of sam
		assertEquals(false, npcSam.getAlreadyUsed()); //verifying that the powers of sam are restored
		
	}
		

}
