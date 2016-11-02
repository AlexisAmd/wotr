
/**
 * Class wich describes ExitRooms
 * 
 * @author GR1 - Alexis
 * @version (a version number or a date)
 */
/**
 * Class to manage exits (door)
 * 

 */
public class ExitRoom
{
    protected Room nextRoom;
    protected Room currentRoom;
    
    /**
     * Constructor for objects of class ExitRoom
     * @param currentRoom the current room
     * @param nextRoom the next room
     */
    public ExitRoom(Room currentRoom, Room nextRoom)
    {
        this.currentRoom=currentRoom;
        this.nextRoom=nextRoom;
    }

    /**
       *Methods to get the future current room after moving
     * @param currentRoom
     * @return the next room
     */
    public Room getNextRoom(Room currentRoom)
    {
        if (this.currentRoom!=currentRoom){
            return this.currentRoom;
        }
        else{
            return this.nextRoom;
        }
    }
}
