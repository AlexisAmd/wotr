/**
 * WIP Agathe
 */
package JUtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wotr.Bag;
import wotr.Player;
import wotr.Potion;
import wotr.Room;

/**
 * @author GR1
 * @Version 23/11/2016
 *
 */
public class BagTest {
    private Potion myPotion;
    private Player Frodo;
    private Bag myBag;
    private Room myRoom;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    Player Frodo = new Player();
		    Bag myBag = new Bag();
		    Potion myPotion = new Potion("myPotion", "description", 10, Frodo); //weight = 10
		    Room myRoom = new Room("laRoom");
		    myRoom.addItem(myPotion);
		    Frodo.pickUpItem(myPotion);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}



	/**
	 * Test method for {@link wotr.Bag#getInventoryWeight()}.
	 */
	@Test
	public void testGetInventoryWeight() {
		Frodo.pickUpItem(myPotion);
		assertEquals(10, Frodo.getWeight());
	}

	/**
	 * Test method for {@link wotr.Bag#addItem(wotr.Item)}.
	 */
	@Test
	public void testAddItem() {
		Frodo.pickUpItem(myPotion);
		assertTrue(Frodo.hasItem(myPotion));
	}

	/**
	 * Test method for {@link wotr.Bag#contains(wotr.Item)}.
	 */
	@Test
	public void testContains() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link wotr.Bag#delItem(wotr.Item)}.
	 */
	@Test
	public void testDelItem() {
		fail("Not yet implemented"); // TODO
	}

}
