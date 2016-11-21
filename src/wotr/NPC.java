package wotr;
import java.util.*;

/**
 * This class describes Non player characters. Non player characters can use their power on the player (frodo) by letting him loose or gain healt points and/or corruption points.
 * They can use their power only one time except if their powers are restored (by a magician)
 * they can have multiples items (i.e the ncp "dragon" own a key to unlock a door)
 */
public  class NPC
{
    // instance variables - replace the example below with your own
    protected String name;
    protected String description; //a short description of th player ex : dwarfs are sprinters, they fast on short discantes but long distances tires them

   protected int corruptionPower;
   protected int hpPower;
   protected Player currentPlayer;
   protected boolean alreadyUsed;
   protected ArrayList<Item> itemList;


    /**
     * Constructor for objects of class Players
     * @param name
     */
    public NPC(String name, String description, int corruptionPower, int hpPower, Player currentPlayer)
    {
        // initialise instance variables
        this.name = name;
        this.description = description;
        this.corruptionPower = corruptionPower;
        this.hpPower= hpPower;
        this.currentPlayer = currentPlayer;
        this.alreadyUsed = false;
        this.itemList = new ArrayList<>();

    }

    
    /**
     * get name 
     * @return 
     */
    public String getName()
    {
       return name;
    }
    
        /**
     * get name 
     * @return 
     */
    public String getDescription()
    {
       return description;
    }
    

    /**
     * Print a NPC
     * @return the name and the description of the NPC
     */
    public String toString()
    {
        return getName()+" : "+this.getDescription();
    }
    
    /**
    *COmmon method use to all npc
    */
    public void use(){
        if (!alreadyUsed){
        currentPlayer.addHp(hpPower);
        currentPlayer.addCorruption(corruptionPower);
        alreadyUsed= true;}
        else{
            System.out.println("You already used the powers of "+ name);
        }
    }
    

}
