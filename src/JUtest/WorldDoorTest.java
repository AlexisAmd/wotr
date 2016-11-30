/**
 * 
 */
package JUtest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wotr.Door;
import wotr.Room;
import wotr.WorldDoor;

/**
 * @author pc
 *
 */
public class WorldDoorTest {
    private Door room;
	private Room currentRoom;
	private Room nextRoom;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	currentRoom = new Room("salle1");
	nextRoom = new Room ("salle2");
	room = new Door(currentRoom,nextRoom);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link wotr.WorldDoor#WorldDoor(wotr.Room, wotr.Room)}.
     */
    @Test
    public void testWorldDoor() {
	assertNotNull("not null",room.getNextRoom(currentRoom));
    }
    
	

}

