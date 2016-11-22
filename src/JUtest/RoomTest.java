package JUtest;
import static org.junit.Assert.*;
import wotr.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

//WORKINPROGRESS Mathias

public class RoomTest extends TestCase {
	
	private Item myBeer;
	private Player currentPlayer;
	private ExitRoom doorMyRoomNextRoom,doorNextRoomMyRoom;
	private Room myRoom,nextRoom;
    private HashMap <String,ExitRoom> myroomHM; 
    private ArrayList<Item> myitemList;
    private ArrayList<NPC> myNPCList;
    
    @Before
	public void setUp()
	{
    	
		myBeer = new Food("beer","dexcription",12,5,currentPlayer);
    	nextRoom = new Room("nextroomdescription");
    	myRoom = new Room("description");
    	myitemList = new ArrayList<>();
		myNPCList = new ArrayList<>();
		myroomHM = new HashMap<>();
		
		//Doors
		doorMyRoomNextRoom = new ExitRoom(myRoom, nextRoom);
		doorNextRoomMyRoom = new ExitRoom(nextRoom, myRoom);

		
		
		
	}
	
    //Test the constructor. 
	@Test
	public void testRoom() {
		assertEquals("description",myRoom.getDescription());
	}

	 /**
	    * Add an exit in the roomHM
	    * @param direction direction of the exit
	    * @param exit next room after pass the door (exit room)
	    */
	@Test
	public void testAddExit() {
		//Add exit
		myRoom.addExit("south",doorMyRoomNextRoom);
		assertEquals(myroomHM,myRoom.getRoomHM()); //Marche pas. peut pas comparer 2 HashMap ?
	}

	@Test
	public void testAddItem() {
		//Add item
		myRoom.addItem(myBeer);
		assertEquals(myBeer, myRoom.getItemList());
	}
	

	@Test
	public void testDelItem() {
		myRoom.delItem(myBeer);
		assertEquals(myitemList,myRoom.getItemList());;
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
