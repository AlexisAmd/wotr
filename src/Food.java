
/**
 * Décrivez votre classe Food ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Food extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int calory;

    /**
     * Constructeur d'objets de classe Food
     */
    public Food(String name, String description, int weight, int calory)
    {
        super(name, description,  weight);
        this.calory = calory;
    }

    public String toString()
    {
        return "Name : "+getName()+"\n"+"Description : "+getDescription()+"\n"+"Weight : "+getWeight()+"\n" +"Calory : "+getCalory();

    }
    
    public int getCalory(){
        return this.calory;
    }
    
    public int use(){
        return this.calory;
    }
}
