

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
        if(super.locked){
  
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
        super.locked=false;
        System.out.println(nextRoom.getDescription() + " is now unlock");
    }
}