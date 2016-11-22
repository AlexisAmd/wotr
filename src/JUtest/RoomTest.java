package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

//WORKINPROGRESS

public class RoomTest extends TestCase {
	 
	private ExitRoom myexitroom;
	private Room myroom,nextroom;
    private HashMap <String,ExitRoom> myroomHM; 
    private ArrayList<Item> myitemList;
    private ArrayList<NPC> myNPCList;
    
    @Before
	protected void setUp()
	{
		myexitroom = new ExitRoom(myroom, nextroom);
		myitemList = new ArrayList<>();
		myNPCList = new ArrayList<>();
		myroomHM = new HashMap<>();
		myroom = new Room("descrption");
	}
	
    //Test the constructor. 
	@Test
	public void testRoom() {
		assertEquals(this.getName(),"description");
	}

	@Test
	public void testAddExit() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintNPC() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNPCList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintExits() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
