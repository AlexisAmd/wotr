
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
    private Player currentPlayer; // act like a reference to the parent current item in order to use the method use() without breaking encapsulation with a get

    /**
     * Constructeur d'objets de classe Food
     * @param name (name of the food), description (its description), weight (its weight), calory (its calory), player (the player associated)
     */
    public Food(String name, String description, int weight, int calory, Player currentPlayer)
    {
        super(name, description,  weight, currentPlayer);
        this.currentPlayer = currentPlayer;
        
        this.calory = calory; //CANT BE A NEGATIVE VALUE
    }

    /*
     * Give all the attributes of the food(non-Javadoc)
     * @return name (name of the food), description (its description), weight (its weight), calory (its calory) 
     */
    public String toString()
    {
        return "Name : "+getName()+"\n"+"Description : "+getDescription()+"\n"+"Weight : "+getWeight()+"\n" +"Calory : "+getCalory();
    }
    
    /* 
     * get calory of food
     * @return calory
     */
    public int getCalory(){
        return this.calory;
    }

    //When you use a food, your hp is upgraded depending on calories
    public void use(){
        currentPlayer.addHp(this.calory); //n'est pas trop sensé marcher
    }
}
