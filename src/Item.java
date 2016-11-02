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

    /**
    * Constructor for objects of class Items
    * @param name
    * @param description
    * @param weight
    */
    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
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
    
    public int use(){
        return 0;
    }
}
