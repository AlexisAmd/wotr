
package wotr;

/**
 * This class represent locked doors. It's a super class for password locked doors and key locked doors.
 * This door is characterized by the current room (room where the player is) and the next room (room behind the door)and by a password or a key depending on the kind of 
 * door. There are two cases: 
 * 	- if the player have the good thing (password or key) to unlock the door, he can go through
 * 	- the player haven't the good thing, the door remains locked.
 *
 * @author Gr1
 * @version 22/11/2016
 */
public class LockedExitRoom extends ExitRoom
{
    private boolean locked;
    
    /**
     * Constructor for locked doors
     * @param this.currentRoom
     * @param nextRoom

     */
    public LockedExitRoom(Room currentRoom,Room nextRoom)
    {
        super(currentRoom, nextRoom);
        this.locked = true;
    }

    /**
     * Return the lock statut of the door, it is true if the door is locked.
     * @return locked
     */
    public boolean getLocked(){
        return locked;
    }
    
    /*
     * Permit to modify the boolean, and then to unlock the door.
     * @param bool: boolean which represent if the door is locked, false: the door is unlocked
     */
    public void setLocked(Boolean bool){
        locked=bool;
    }
}
