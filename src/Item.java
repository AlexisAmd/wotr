/**
* Write a description of class Items here.
*
* @author (your name)
* @version (a version number or a date)
*/
public abstract class Item {
    // instance variables - replace the example below with your own
    protected String name;
    protected String description;
    protected int weight;
    protected Player currentPlayer;

    /**
    * Constructor for objects of class Items
    * @param name
    * @param description
    * @param weight
    */
    public Item(String name, String description, int weight, Player currentPlayer) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.currentPlayer = currentPlayer;
    }

    /**
     * get name of item
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * get description of item
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * get weight of item
     * @return
     */
    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Name : "+getName() + "\n"+"Description : "+getDescription() + "\n"+"Weight : "+getWeight() + "\n";

    }
    
    /**
    *Common method to use item. When used, an item performs an action on a door or on a player or on a npc
    */
    public void use(){
    }
}
