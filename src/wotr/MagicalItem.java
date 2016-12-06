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
    
    /**
     * Constructor of the MagicalItem class
     * @param name (name of the magicalItem)
     * @param description (its description)
     * @param weight (its weight)
     * @param corruptionPower (its corruptionPower)
     * @param player (the player associated)
     */
    public MagicalItem(String name, String description, int weight, int corruptionPower, Player currentPlayer) {
	super(name, description, weight, currentPlayer);
	this.corruptionPower = corruptionPower;
    }

    /**
     * Give all the attributes of the magicalItem
     * 
     * @return name (name of the food)
     * @return description (its description)
     * @return weight (its weight)
     * @return corruptionPower (its corruptionPower)
     */
    public String toString() {
	return "Name : " + getName() + "\n" + "Description : " + getDescription() + "\n" + "Weight : " + getWeight()
		+ "\n" + "Corruption power :" + corruptionPower + "\n";
    }

    /**
     * get the corruptionPower of magicalItem
     * @return corruptionPower
     */
    public int getCorruptionPower() {
	return this.corruptionPower;
    }

    /**
     * When you use a magicalITem, your corruption points can be increased or decreased
     */
    public void use() {
	getCurrentPlayer().addCorruption(this.corruptionPower);
    }
}
