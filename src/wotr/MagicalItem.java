package wotr;

/**
 * Class MagicalItem
 * This class allows player to use magicalitem
 * Can add/remove corruption points
 * 
 * @author  G1
 * @version (un numéro de version ou une date)
 */
public class MagicalItem extends Item {
    private int corruptionPower; // Can be positive as negative
    //private Player currentPlayer; // act like a reference to the parent current item in order to use the method use() without breaking encapsulation with a get

    /**
     * Constructeur d'objets de classe MagicalItem
     * @param name (name of the magicalItem), description (its description), weight (its weight), corruptionPower (its corruptionPower), player (the player associated)
     */
    public MagicalItem(String name, String description, int weight, int corruptionPower, Player currentPlayer) {
	super(name, description, weight, currentPlayer);
	this.corruptionPower = corruptionPower;
    }

    /*
     * Give all the attributes of the magicalItem(non-Javadoc)
     * 
     * @return name (name of the food), description (its description), weight (its weight), corruptionPower (its corruptionPower)
     */
    public String toString() {
	return "Name : " + getName() + "\n" + "Description : " + getDescription() + "\n" + "Weight : " + getWeight()
		+ "\n" + "Corruption power :" + corruptionPower + "\n";
    }

    /*
     * get the corruptionPower of magicalItem
     * 
     * @return corruptionPower
     * 
     * 
     */
    public int getCorruptionPower() {
	return this.corruptionPower;
    }

    /**
     * When you use a magicalITem, your corruption points can be upgraded or downgraded
     */
    public void use() {
	getCurrentPlayer().addCorruption(this.corruptionPower);
    }
}
