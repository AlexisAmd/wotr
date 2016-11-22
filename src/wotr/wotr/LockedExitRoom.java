// Work in progress - Antoine

package wotr;
/**
 * Décrivez votre classe LockedExitRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LockedExitRoom extends ExitRoom
{
    protected boolean locked;
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
     * getLocked
     * @return locked
     */
    public boolean getLocked(){
        return locked;
    }
    
    public void setLocked(Boolean bool){
        locked=bool;
    }
}
