package wotr;

public class Hobbit extends NPC {
    /**
     * A hobbit is a specific npc. As like other npc he cans act on Frodo's healt points or corruption points.
     * When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
     * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship (because humans used to bury their dead friends...) 
     */
    private int corruptionPower;

    /**
     * Constructor of class Hobbit 
     *@param name : of the NPC
    *@param description : a short description of the player ex : "dwarfs are sprinters, they are fast on short distances but long distances tires them."
    *@param corruptionPower : /corruption points that the NPC can remove from Frodo
    *@param currentPlayer : //frodo
     */
    public Hobbit(String name, String description, int corruptionPower, int hpPower) {
	super(name, description, corruptionPower, hpPower);
    }

    /**
        *Use method, removes a certain amount of corruptionPower.
        *@return true if the power is used
        *@return false if the powers cannot be used
        */
    public boolean use(NPC npc) {
	if (getPlayer().getFellowship().contains(npc)) {
	    npc.setAlreadyUsed(true); // NPC used
	    getPlayer().addCorruption(this.corruptionPower);
	    this.setAlreadyUsed(true);
	    return true;
	} else {
	    return false;
	}
    }
}
