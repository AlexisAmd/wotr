/**
 * This class is the enemy class
 * Thanks to this class, we can add enemy in the world.
 * They can damage the player (reduce the hp and corruption points)
 * 
 * @author G1
 *
 */
package wotr;

public class Enemy extends NPC {
    /**
     * The constructor of the Enemy class
     * @param name the name of the enemy
     * @param description the description of the enemy
     * @param corruptionPower the corruption power (how many corruption points he reduce to the player)
     * @param hpPower the hp power (how many hp he reduce to the player)
     */
    public Enemy(String name, String description, int corruptionPower, int hpPower) {
	super(name, description, corruptionPower, hpPower);
    }

    /**
     * An enemy is automatically use when the player enter in a piece of the world where the enemy is.
     * The enemy will reduce the hp and corruptions points depending on his hp power and corruption power if the player don't use anything.	 * 
     */
    public boolean use() {
	if (!this.getAlreadyUsed()) {
	    super.getPlayer().addHp(super.getHpPower()); // we will put a number below 0 to make the player loose health points.
	    super.getPlayer().addCorruption(super.getCpPower());
	    // this.setAlreadyUsed(true);
	    return true;
	} else
	    return false;
    }
}
