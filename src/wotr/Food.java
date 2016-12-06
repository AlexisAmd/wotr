/**
 * Food class
 * This class allows the player to get hp when he is low
 * The player has to eat food to up his hp 
 *
 * @author GR1
 * @version (un numÃ©ro de version ou une date)
 */
package wotr;
public class Food extends Item
{
    
    private int calory; //positive integer

    /**
     * Constructor of the class food
     * @param name (name of the food)
     * @param description (its description)
     * @param weight (its weight)
     * @param calory (its calory)
     * @param player (the player associated)
     */
    public Food(String name, String description, int weight, int calory, Player currentPlayer)
    {
        super(name, description,  weight, currentPlayer);
        this.calory = calory; //CANT BE A NEGATIVE VALUE
    }

    /**
     * Give all the attributes of the food
     * @return name (name of the food)
     * @return  description (its description)
     * @return  weight (its weight)
     * @return calory (its calory) 
     */
    public String toString()
    {
        return "Name : "+getName()+"\n"+"Description : "+getDescription()+"\n"+"Weight : "+getWeight()+"\n" +"Calory : "+getCalory();
    }
    
    /**
     * get calory of food
     * @return calory the calory of the food
     */
    public int getCalory(){
        return this.calory;
    }

    /**
     * When you use a food, your hp is upgraded depending on calories
     */
    public void use(){
        super.getCurrentPlayer().addHp(this.calory); //n'est pas trop sensé marcher
    }
}
