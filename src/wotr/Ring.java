package wotr;

/**
 * Class RIng
 * This class allows the player to use a ring.
 * Only on ring can be created
 * Each time he is used you gain corruption
 * 
 * @author  G1
 * @version 23/11/2016
 */
public class Ring extends Item {
    private int corruption;

    /**
    * Constructor for objects of class Ring
    * @param player (the player associated)
    */
    public Ring(int corruption, Player currentPlayer) {
	super("Ring of Power",
		"This ring is the powerfull ring of the world. You need to destroy it to free middle earth against shadows. Don't loose is !!!",
		10, currentPlayer);
	this.corruption = corruption;
    }

    /**
        * When you use a ring, your cp is inclreased depending on corruption power of the ring
        */
    public void use() {
	super.getCurrentPlayer().addCorruption(this.corruption); // n'est pas trop sensé marcher
    }
}
