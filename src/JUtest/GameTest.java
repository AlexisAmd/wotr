package JUtest;
import static org.junit.Assert.*;

import org.junit.Test;
import wotr.*;

public class GameTest {

	    private Parser parser;
    private Room currentRoom;
    private Player currentPlayer;
    
        Room roomOutside, roomTheatre, roomPub, roomLab;

        ExitRoom doorOutsideLab, doorOutsidePub, doorLabOutside, doorOfficeLab;

        PasswordLockedExitRoom doorPubOutside;

        KeyLockedExitRoom doorOutsideTheatre, doorTheatreOutside;

        //INSTANCIATION

        // create the rooms
        roomOutside = new Room("main entrance of the university");
        roomTheatre = new Room("lecture theatre");
        roomPub = new Room("campus pub");
        roomLab = new Room("computing lab");
        //create items
        Key keyTheatre = new Key("KeyTheatre","Allow to go to theatre",1);
        Food lambas = new Food("Lambas","miaaaam", 2, 30);

        //adding item to rooms
        roomPub.addItem(keyTheatre);
        roomTheatre.addItem(lambas);

        // initialise room exits (doors)
        doorOutsidePub = new PasswordLockedExitRoom(roomOutside, roomPub, "azertyuiop");
        doorPubOutside = new PasswordLockedExitRoom(roomPub, roomOutside, "azertyuiop");

        doorOutsideTheatre = new KeyLockedExitRoom(roomOutside, roomTheatre, keyTheatre);
        doorTheatreOutside = new KeyLockedExitRoom(roomTheatre, roomOutside, keyTheatre);
        doorOutsideLab = new ExitRoom(roomOutside, roomLab);

        //associating doors with rooms
        roomOutside.addExit("north", doorOutsideTheatre);
        roomOutside.addExit("south", doorOutsidePub);
        roomOutside.addExit("east", doorOutsideLab);

        roomTheatre.addExit("south",doorTheatreOutside);
        roomPub.addExit("north",doorPubOutside);

        currentRoom = roomOutside; // start game outside


	@Test
	public void testGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testGoRoom() {
currentPlayer.goRoom("south");
		assertSame(roomPub,currentPlayer.getRoom());
        

	}

	@Test
	public void testPickUpItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testPickUpNPC() {
		fail("Not yet implemented");
	}

}
