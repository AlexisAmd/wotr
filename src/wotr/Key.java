
/**
 * Class Key, can unlock a LockedExit
 * If the key is used, the key is removed of the inventory of the player
 *
 * @author GR1
 * @version (un numéro de version ou une date)
 */
package wotr;
public class Key extends Item{
    //the key have to have an Lock attributes in order to have a bidirectionnal independance, like that only one key can open a lock and a locked can be unlocked by only one key
    private KeyLockedDoor door;

    /**
     * The constructor of the key     * 
     * @param name (the name of the key)
     * @param description (its description)
     * @param weight (its weight) 
     * @param current player (the player associated)
     */
    public Key(String name, String description, int weight, Player currentPlayer, KeyLockedDoor door)
    {
        super(name, description, weight, currentPlayer);
        this.door = door;
    }
    
    /**
     * When you use a key, you unlock a lockedExit if you are in the correct room
     */
    public void use(){
	//check room player
	if(getCurrentPlayer().getCurrentRoom() == door.getCurrentRoom()){
        door.setUnlocked();}
    }
    
    /**
     * Give all the attributes of the key
     * @return name (name of the key)
     * @return description (its description)
     * @return weight (its weight) 
     */
	public String toString() {
		return "Name : "+getName() + "\n"+
		        "Description : "+getDescription() + "\n"+
		        "Weight : "+getWeight() + "\n";
	}

	/**
	 * Method which return the door which is locked by the key
	 * @return the door which is locked by this key
	 */
	public Door getDoor() {
	    // TODO Auto-generated method stub
	    return door;
	}

}
