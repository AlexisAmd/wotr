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
	
	private NPC myNPC;
	private Item myBeer;
	private Player currentPlayer;
	private ExitRoom doorMyRoomNextRoom,doorNextRoomMyRoom;
	private Room myRoom,nextRoom;
    private HashMap <String,ExitRoom> myRoomHM; 
    private ArrayList<Item> myItemList;
    private ArrayList<NPC> myNPCList;
    
    
    @Before
	public void setUp()
	{
    	//food
		myBeer = new Food("beer","description",12,5,currentPlayer);
    	//Room setup
		nextRoom = new Room("nextroomdescription");
    	myRoom = new Room("description");
    	myItemList = new ArrayList<>();
		myNPCList = new ArrayList<>();
		myRoomHM = new HashMap<>();
		
		//Doors
		doorMyRoomNextRoom = new ExitRoom(myRoom, nextRoom);
		doorNextRoomMyRoom = new ExitRoom(nextRoom, myRoom);
		//NPC
		myNPC = new NPC("NPCname","NPCdecription",15,50,currentPlayer);
		
		
		
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
		myRoom.getRoomHM().containsKey(myRoomHM);
	}

	@Test
	public void testAddItem() {
		//Add item
		myRoom.addItem(myBeer);
		myRoom.getItemList().contains(myBeer);
	}
	

	@Test
	public void testDelItem() {
		myRoom.delItem(myBeer);
		assertFalse(myRoom.getItemList().contains(myBeer));
	}

	@Test
	public void testAddNPC() {
		myRoom.addNPC(myNPC);
		myRoom.getNPCList().contains(myNPC);
	}

	@Test
	public void testDelNPC() {
		myRoom.delNPC(myNPC);
		assertFalse(myRoom.getNPCList().contains(myNPC));
	}

	@Test
	public void testGetDescription() {
		assertEquals("description",myRoom.getDescription());
	}

//	@Test
//	public void testPrintItems() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintNPC() {
//		fail("Not yet implemented");
//	}


	@Test
	public void testGetNextRoom() {
		//assertEquals(myNextRoom,);
	}

	@Test
	public void testPrintExits() {
		fail("Not yet implemented");
	}


}
