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
    private Room myRoom;
    private Bag myBag;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	Player Frodo = new Player();
	Potion myPotion = new Potion("myPotion", "description", 1, Frodo); // weight = 10
	Room myRoom = new Room("laRoom");
	Bag myBag = new Bag("mybag");
	Frodo.setCurrentRoom(myRoom);
	myRoom.addItem(myPotion);

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
	assertEquals(1, Frodo.getWeight());
    }

    /**
     * Test method for {@link wotr.Bag#addItem(wotr.Item)}.
     */
    @Test
    public void testAddItem() {
	myBag.addItem(myPotion);
	assertTrue(myBag.getInventory().contains(myPotion));
    }

    /**
     * Test method for {@link wotr.Bag#delItem(wotr.Item)}.
     */
    @Test
    public void testDelItem() {
	Frodo.pickUpItem(myPotion);
	Frodo.dropItem(myPotion);
	assertFalse(Frodo.hasItem(myPotion));
    }
}
