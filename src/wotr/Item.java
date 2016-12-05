/**
* The Item class is an abstract class. An item can be food or key.
* It is picked by the player in a room.
*
* @author Grp1
* @version 22/11/2016
*/
package wotr;
public abstract class Item {
    // name of the item
    private String name;
    // description of the item
    private String description;
    // weight of the item
    private int weight;
    // player who is owning the item
    private Player currentPlayer;

    /**
    * Constructor for objects of class Item
    * @param name
    * @param description
    * @param weight
    * @param currentplayer
    */
    public Item(String name, String description, int weight, Player currentPlayer) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.currentPlayer = currentPlayer;
    }

    /**
     * get the name of the item
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * get the description of the item
     * @return description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the weight of the item
     * @return weight of the item
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * displays name, description and weight of the item
     * @return a string with the name, the description and the weight of the item
     */
    public String toString() {
        return "Name : "+getName() + "\n"+"Description : "+getDescription() + "\n"+"Weight : "+getWeight() + "\n";

    }
    
    /**
     * get the current player
     * @return the current player
     */
     public Player getCurrentPlayer(){
    	 return currentPlayer;
     }
    
    /**
    *Common method to use item. When used, an item performs an action on a door or on a player or on a NPC
    */
    public void use(){
    }

    /**
     * @param player
     */
    public void setPlayer(Player player) {
	currentPlayer = player;
	
    }
}
