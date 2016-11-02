
/**
 * Décrivez votre classe Key ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Key extends Item{
    //the key have to have an Lock attributes in order to have a bidirectionnal independance, like that only one key can open a lock and a locked can be unlocked by only one key
    private KeyLockedExitRoom door;

    public Key(String name, String description, int weight)
    {
        super(name, description, weight);
  
    }
    
    public int use(){
        door.setUnlocked();
        return 0;//unused value...
    }
}
