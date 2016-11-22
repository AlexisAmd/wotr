//WIP Antoine
package wotr;

/*
 * This class represent a door locked by a key. 
 * There are two cases:
 * 	- the player has a key, the door is unlocked, then he can go to the next room
 * 	- the player hasn't a key, he can't go to the next room
 */


public class KeyLockedExitRoom extends LockedExitRoom
{   private Player player;
    private Key key;

    /**
     * Constructor for locked doors
     * @param this.currentRoom
     * @param nextRoom
     * @param key
     */
    public KeyLockedExitRoom(Room currentRoom,Room nextRoom, Key key)
    {
        super(currentRoom, nextRoom);
        this.key=key;
    }

    
    

    
    /**
     * getNextRoom
     * @param currentRoom
     * @return 
     */
    public Room getNextRoom(Room currentRoom)
    {
        if(super.getLocked()){
  
                System.out.println("Locked door ! You need to open it with the key :" +key.getName()+" before pass it");
                return null;
        }
        else{
            if (this.currentRoom!=currentRoom){
                return this.currentRoom;
            }
            else{
                return this.nextRoom; //ok
            }
        }
    }
    
    public void setUnlocked(){
        super.setLocked(false) ;
        System.out.println(nextRoom.getDescription() + " is now unlock");
    }
}