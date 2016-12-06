package wotr;

import java.util.ArrayList;
/**
 * A warrior is a specific npc. As like other npc he cans act on Frodo's healt points or corruption points. 
 * However he can also kill a npc.When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
 * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship 
 * (because humans used to bury their dead friends...) 
 */

public class Warrior extends NPC {

	/**
	 * A warrior is a specific npc. As like other npc he cans act on Frodo's healt points or corruption points. 
	 * However he can also kill a npc. When a npc is dead, he is removed from the frodo's fellowship and stay in the room where he died.
	 * NPC can reanimate by a magician. A dead NPC can also be picked up again by frodo and his fellowship 
	 * (because humans used to bury their dead friends...) 
	 *@param name : of the warrior
	 *@param description : a short description of the warrior
	 *@param corruptionPower : corruption power owned by the warrior, they are used to give corruption points to frodo
	 *@param hpPower : health points which will be given or retrieved to Frodo
	 */
	public Warrior(String name, String description, int corruptionPower, int hpPower) {
		super(name, description, corruptionPower, hpPower);
	}

	/**
	 *Use method, kill a specified npc. 
	 *When the npc is dead, he leaves the inventory of frodo to stay in the current room
	 *@return true if the npc is killed
	 *@return false if the powers cannot be used
	 */
	public boolean use(NPC npc) {
		if (super.getPlayer().getFellowship().contains(npc)) {
			npc.setAlreadyUsed(true); // in order to don't pick him again and use his powers because he is dead. Possible if a magician restoreshis powers
			super.getPlayer().dropNPC(npc); // drop the n
			this.setAlreadyUsed(true);
			return true;
		} else {
			return false;
		}
	}

	/**
	 *Use method, kills all npc which are present in this room. this dead npc disappear from the current room
	 *@return true if the npc is killed
	 *@return false if the powers cannot be used/have not been used (because nobody to kill here)
	 */
	public boolean use() {
		boolean bool = false;
		if (!getAlreadyUsed()) {
			for (NPC npc : new ArrayList<NPC>(super.getPlayer().getCurrentRoom().getNPCList())) {
				System.out.println(npc.getName() + " is in the room");
				if (npc.getClass().getSimpleName().equals("Enemy")) {
					bool = super.getPlayer().getCurrentRoom().delNPC(npc);
					System.out.println(npc.getName() + "doit etre mort si tout va bien");
				}
			}
		}
		this.setAlreadyUsed(true);
		return bool;
	}
}
