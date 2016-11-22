package wotr;
import java.util.*;

/**
 * Player class stands for a World of the Ring player able to explore many differents world. This player is named Frodo.
 * A player have health point and corruption points. When healt point is equal to 0 the player is dead. When the percentage of corruption of the player is equal to 100% the payer is dead.
 * A player have an inventory wich contains itms and a fellowship which contains NPC.
 * This inventory have a maximum weight.
 * By default, the player have 100 hp and 0 % of corruption
 * @author GR1
 * @version 21/11/16
 */


public class Player
{

    private String name; //name of the player, st to frodo by default
    private int hp;//health points of the player, can be >100 but if <=0, the player is dead
    private int percentCorruption; //percentage of corruption, cannot be <0, player's die if percentage is >=100
    private ArrayList<Item> inventory; //list of all items stored in the player's inventory
    private ArrayList<NPC> fellowship; //list of all friends currently following the hero
    private int inventoryWeight; //current weigh of the inventory
    private int maximumInventoryWeight; //maximum weight of th inventory

    /**
     * Constructor for objects of class Player
     * The player is named Fordo, have 100 hp and 0 corruption point. As his inventory, is fellowship is empty.
     *
     */
    public Player()
    {   
    	//constructeur sans parametres ?
        // initialise instance variables
        name = "Frodo";
        hp= 100;
        percentCorruption = 0;
        inventory = new ArrayList<>();
        fellowship = new ArrayList<>();
    }
    
    /**
     * Checks if the player is still alive.
     * Player is alive only if his HP are strictly superior to 0.
     * @return true if the player's HP are strictly higher than 0.
     */
    private boolean isAlive()
    {
    	return hp > 0;
    }

    /**
     * Returns the number of health points.
     * @return
     */
    public int getHp()
    {
        return hp;
    }
    
    /**
     * setHp : sets a new number of healthpoints
     * @param newHpValue The new value of the player's health points.
     */
    public void setHp(int newHpValue)
    {
    	if ((newHpValue < 0) || (newHpValue > 100))
    		throw new IllegalArgumentException("Value is out of range for newHpValue");
    	this.hp = newHpValue;
    }
	

    /**
     * getHp : return the perentage of corruption of the player
     * @return
     */
    public int getPercentCorruption()
    {
        return percentCorruption;
    }

    /**
	 * Manage the gain of one life
	 * @param nb The number of health points to gain, can be a negative value.
	 */
	public void addHp(int nb)
	{
		if ((100 - hp) <= nb)
			hp=100;
		else
			hp+=nb;
	}

    /**
     * Manage the loose and the of corruption
     * If corruption reach 100%, then the game is over
     * cannot be < 0
     * @param nb The number of corruption to loose, can be a negative value
     */
    public void addCorruption(int nb)
	{
        //verify if <0 or >100
        percentCorruption+=nb;
    }


    /**
     * Method to return the feelowship of the hero
     * @return the fellowship of the hero
     */
    public ArrayList<NPC> getFellowship()
    {
        return fellowship;
    }

    /**
     * Check if the player have this friend
     * @param npc The npc you want to find.
     * @return true if the player have this npc
     */
    public boolean hadNPC(NPC npc)
    {
        return fellowship.contains(npc);
    }

    /**
     * Add a friend to the player's fellowship
     * @param npc The non player character you just met.
     * @return true if added
     */
    public boolean addNPC(NPC npc)
    {
        if (!hadNPC(npc))
        {    
            fellowship.add(npc); //add the this new friend to the fellowship
            //System.out.println(npc.getName()+" is now a member of the fellowship of the ring.");
            return true;
        }
        else
        {
            //System.out.println(npc.getName()+" is already a member of the fellowship of the ring.");
            return false;
        }
    }


    /**
     * Returns the list of items
     * @return the inventory of our hero
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    /**
     * Returns the total weight of the items the player carries.
     * @return
     */
    public int getInventoryWeight()
    {
        return inventoryWeight;
    }

    /**
     * Returns the maximum weight that the player can carry.
     * @return the value of the maximum weight
     */
    public int getMaximumInventoryWeight()
    {
        return maximumInventoryWeight;
    }

    /**
     * Check if the player have a specific item.
     * @param item the item you want to check
     * @return true if the player has this item
     */
    public boolean hasItem(Item item)
    {
        return inventory.contains(item);
    }

    /**
     * Add the item to the player's inventory.
     * Only if its added weight does not make the total inventory weight
     * superior to the maximum weight.
     * A player can carry many items of the same type.
     * (i.e it can contains 6 beers)
     * @param newItem the new item in the player's inventory
     * @return true if the item has been added to the inventoru
     */
    public boolean addItem(Item newItem)
    {
        if(newItem.getWeight()+inventoryWeight>maximumInventoryWeight)
        {
            //System.out.println("Objet too heavy for your inventory (item weight : "+newItem.getWeight()+" ) !");
            return false;
        }
        else
        {
            inventory.add(newItem); //add the item to the inventory
            inventoryWeight+=newItem.getWeight(); //update the actual weight of th inventory
            return true;
        }
    }

    /**
     * Remove a specified item from the player's inventory.
     * If the item is deleted the total weight of the inventory decrease
     * according to the weight of the item.
     * @param item the item to remove
     * @return false if not done
     */
    private boolean dropItem (Item item)
    {
        if (inventory.contains(item))
        {
            inventoryWeight-=item.getWeight();
        }
        return inventory.remove(item);//retrun false if not deleted
    }




    
    /**
     * Allow the player to use an item.
     * Items can have an action on the world and/or on the player's HP and/or CP.
     * @param item the item that the player wants to use
     */
    public void use(Item item)
    {

        item.use(); //usefull for keys
        
        if (!item.getClass().getName().equals("Key"))
        {
        	//keys cannot be used more than one time
            dropItem(item);
        }
    }
    
    /**
	 * Allow the player to use a NPC.
	 * NPC can have act on the world and/or on the player's HP and/or CP.
	 * @param npc the NPC that the player wants to use.
	 */
    public void use(NPC npc)
    {
        npc.use();
    }

 
    /**
     * Return the player's informations as a string
     * @return description of the player
     */
    public String toString()
    {
        String str;    
        str=" - "+name+" - "+"\n"+
        "Inventory capacity : "+inventoryWeight+"/"+maximumInventoryWeight+"\n"+
        "Item List : "+"\n";
        for(Item item : inventory)
        {
            str+=" - "+item.toString()+"\n";
        }
        str+="Fellowship : "+"\n";
        for(NPC npc : fellowship)
        {
            str+=" - "+npc.toString()+"\n";
        }
        return str;
    }
}