
/**
 * Décrivez votre classe Food ici.
 *
 * @author GR1
 * @version (un numéro de version ou une date)
 */
package wotr;
public class Food extends Item
{
    
    private int calory; //positive integer

    /**
     * Constructeur d'objets de classe Food
     * @param name (name of the food), description (its description), weight (its weight), calory (its calory), player (the player associated)
     */
    public Food(String name, String description, int weight, int calory, Player currentPlayer)
    {
        super(name, description,  weight, currentPlayer);
        this.calory = calory; //CANT BE A NEGATIVE VALUE
    }

    //Get all the attributes of the food
    public String toString()
    {
        return "Name : "+getName()+"\n"+"Description : "+getDescription()+"\n"+"Weight : "+getWeight()+"\n" +"Calory : "+getCalory();

    }
    
    /*
     * get calory of food
     * return calory
     */
    public int getCalory(){
        return this.calory;
    }

    //When you use a food, your hp is upgraded depending on calories
    public void use(){
        currentPlayer.addHp(calory)
    }
}
