import static org.junit.Assert.*;
package JUtest;
import org.junit.Test;
import wort.*;

public class ItemTest {

	private Item myItem;

	protected void setUp() {
		myItem = new Item ("Bier","I give health points.",10,player1);
	}

	@Test
	public void testItem() {
		assertNotNull("Instance is not created.", myItem);
	}

	@Test
	public void testGetName() {
		assertEquals("Bier",myItem.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("I give health points.",myItem.getDescription());
	}

	@Test
	public void testGetWeight() {
		assertEquals(10,myItem.getWeight());
	}

	@Test
	public void testToString() {
		assertEquals("Name : Bier\nDescription : I give health points.\nWeight : 10",myItem.toString());
	}

	@Test
	public void testUse() {
		fail("Not yet implemented");
	}

}