package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import org.junit.Test;

public class PlayerTest {

	private Player player;
	
	protected void setUp() {
		player = new Player();
	}
	
	@Test
	public void testGame() {
		assertNotNull("Instance is not created!", player);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Player's name is not Frodo!", "Frodo", player.getName());
	}

	@Test
	public void testGetHp() {
		assertEquals("Player's HP does not match!", 100, player.getHp());
	}

	@Test
	public void testGetPercentCorruption() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddHp() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCorruption() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFellowship() {
		fail("Not yet implemented");
	}

	@Test
	public void testHadNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInventory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInventoryWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaximumInventoryWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testUseItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testUseNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
