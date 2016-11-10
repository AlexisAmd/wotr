
/**
 * Décrivez votre classe Food ici.
 *
 * @author GR1
 * @version (un numéro de version ou une date)
 */
package wotr;
public class Food extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int calory;

    /**
     * Constructeur d'objets de classe Food
     */
    public Food(String name, String description, int weight, int calory, Player currentPlayer)
    {
        super(name, description,  weight, currentPlayer);
        this.calory = calory;
    }

    public String toString()
    {
        return "Name : "+getName()+"\n"+"Description : "+getDescription()+"\n"+"Weight : "+getWeight()+"\n" +"Calory : "+getCalory();

    }
    
    public int getCalory(){
        return this.calory;
    }

    //a faire
    public void use(){
        //currentPlayer.set etc etc
    }
}
