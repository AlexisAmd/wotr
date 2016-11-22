
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
package wotr;

/*
 * This class represent a door. 
 * This door is characterized by the current room (room where the player is) and the next room (room behind the door).
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
    public Room getNextRoom(Room nextRoom)
    {
        if (this.currentRoom!=nextRoom){
            return this.currentRoom;
        }
        else{
            return this.nextRoom;
        }
    }
}
