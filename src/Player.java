import java.util.*;

/**
 * Player class
 */
public class Player
{

    private String name;
    private int hp;//health points
    private int percentCorruption; //percentage of corruption, player's die if percentage is >=100
    private ArrayList<Item> inventory; //list of all items stored in the player's inventory
    private ArrayList<NPC> fellowship; //list of all friends of our hero
    private int inventoryWeight; //current weigh of the inventory
    private int maximumInventoryWeight;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        name = "Bilbo";
        hp= 100;
        percentCorruption = 0;
        inventory = new ArrayList<>();
        fellowship = new ArrayList<>();

    }

    /**
     * getName
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * getHp : return the number of healthpoints
     * @return
     */
    public int getHp(){
        return hp;
    }

    /**
     * getHp : return the perentage of corruption of the player
     * @return
     */
    public int getPercentCorruption(){
        return percentCorruption;
    }

    /**
     * Manage the gain of one life
     * @param nb the number of health points to gain, can be a negative value
     */
    public void addHp(int nb){
        hp+=nb;
    }

    /**
     * Manage the loose of  life
     * @param nb the number of corruption to loose, can be a negative value
     */
    public void addCorruption(int nb){
        percentCorruption+=nb;
    }

    //fellowship managment
    /**
     * Method to return the feelowship of the hero
     * @return the fellowship of the hero
     */
    public ArrayList<NPC> getFellowship(){
        return fellowship;
    }

    /**
     * Check if the player have this friend
     * @param npc, the npc you want to find
     * @return true if the player have this npc
     */
    public boolean hadNPC(NPC npc){
        return fellowship.contains(npc);
    }

    /**
     * Add a friend to the player's fellowship
     * @param npc the non player character you just met
     */
    public void meetFriend(NPC npc){
        if (!hadNPC(npc)){    
            fellowship.add(npc); //add the this new friend to the fellowship
            System.out.println(npc.getName()+" is now a member of the fellowship of the ring.");}
        else{
            System.out.println(npc.getName()+" is already a member of the fellowship of the ring.");
        }
    }

    //Item managment : 

    /**
     * getinventory : return the items's list
     * @return the inventory of our hero
     */
    public ArrayList<Item> getInventory(){
        return inventory;
    }

    /**
     * getWeight : return the sum of the weight of the items
     * @return
     */
    public int getInventoryWeight(){
        return inventoryWeight;
    }

    /**
     * getMaximumWeight : return the maximum weight
     * @return
     */
    public int getMaximumInventoryWeight(){
        return maximumInventoryWeight;
    }

    /**
     * Check if the player have this item
     * @param item the item you want to check
     * @return true if the player have this item
     */
    public boolean hadItem(Item item){
        return inventory.contains(item);
    }

    /**
     * Add the item to the player's list
     * @param newItem
     * @return
     */
    public boolean addItem(Item newItem){
        if(newItem.getWeight()+inventoryWeight>maximumInventoryWeight){
            System.out.println("Objet too heavy for your inventory (item weight : "+newItem.getWeight()+" ) !");
            return false;
        }
        else{
            inventory.add(newItem); //add the item to the inventory
            inventoryWeight+=newItem.getWeight(); //update the actual weight of th inventory
            return true;
        }
    }

    /**
     * Remove a specified item from the player's inventory
     * @param item item to remove
     * @return false if not done
     */
    private boolean dropItem(Item item)
    {
        if (inventory.contains(item)){
            inventoryWeight-=item.getWeight();
        }
        return inventory.remove(item);//retrun false if not deleted
    }



    
    public void use(Item item){
        this.hp+=item.use();//used for food
        this.percentCorruption+=item.use();//used for magical object
        item.use();//usefull for keys
        
        if (!item.getClass().getName().equals("Key")){//keys can be used more than one time
            dropItem(item);
        }
    }
    
    public void use(NPC npc){
        npc.use();
    }

    //description : 
    /**
     * Return the player's informations
     * @return description of the player
     */
    public String toString(){
        String str;    
        str=" - "+name+" - "+"\n"+
        "Inventory capacity : "+inventoryWeight+"/"+maximumInventoryWeight+"\n"+
        "Item List : "+"\n";
        for(Item item : inventory){
            str+=" - "+item.toString()+"\n";
        }
        str+="Fellowship : "+"\n";
        for(NPC npc : fellowship){
            str+=" - "+npc.toString()+"\n";
        }
        return str;
    }
}
