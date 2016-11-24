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
    private Potion myPotion, myHeavyObject;
    private Player Frodo;
    private Room myRoom;
    private Bag myBag;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	Frodo = new Player();
	myRoom = new Room("laRoom");
	myPotion = new Potion("myPotion", "description", 1, Frodo); // weight = 1
	myHeavyObject = new Potion("myPotion", "description", 100, Frodo); // weight = 100
	myRoom.addItem(myPotion);
	myBag = new Bag("mybag");
	Frodo.setCurrentRoom(myRoom);
	

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
	myBag.addItem(myPotion);
	assertEquals(1, myBag.getWeight());
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
	myBag.addItem(myPotion);
	assertTrue(myBag.getInventory().contains(myPotion));
	myBag.delItem(myPotion);
	assertFalse(myBag.getInventory().contains(myPotion));
    }
    
    /**
     * Add test, to be sure we cannot add a too heavy object (max bag weight = 20, item weiht = 100)
     */
	public void testAddHeavyItem(){
	    assertFalse(myBag.addItem(myHeavyObject));
    
}
}
