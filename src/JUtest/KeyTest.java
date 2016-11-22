package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import org.junit.Test;

public class KeyTest {

	private Player myPlayer
	private Key key;
	private LockedExitRoom locked;
	
	/**
	 * Default constructor for test class KeyTest
	 */
	public KeyTest()
	{
	}
	
	/*
	 * Sets up the test fixture
	 * Initialize one key for each test, whose name is "Key1", description is "open the door", weight is "12", currentPlayer is myPlayer
	 */
	@Befoe
	public void setUp()
	{
		name = "Key1";
		description = "open the door";
		weight = 12;
		currentPlayer = myPlayer;
	}
	
	@Test
	public void testUse() {
		use();
		assertEquals(false, key.locked);
	}

	@Test
	public void testName() {
		assertEquals("Key1", key.name)
	}

	@Test
	public void testDescription() {
		assertEquals("open the door", key.)
	}

	@Test
	public void testWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlayer() {
		assertEquals("")
	}

}
