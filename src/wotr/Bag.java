//WIP Alexis
package wotr;

import java.util.ArrayList;

/**
 * 
*Bag class. A bag contains Items and his weight is defined by the sum of the weights of all items. A player have only one bag at a moment
 * 
 * @author GR1
 * @version 23/11/16
 */
public class Bag {
    private ArrayList<Item> inventory; // list of all items stored in the player's inventory
    private int currentWeight; // current weigh of the inventory
    private String description; // description the name of the bag (i.e. leather bag)

    /**
     * A bag contains Items and his weight is defined by the sum of the weights of all items. A player have only one bag at a moment
     * @param description the name of the bag (i.e. leather bag)
     */
    public void Bag(String description) {
	this.inventory = new ArrayList<Item>();
	this.currentWeight = 0;
	this.description = description;
    }

    /**
     * 
     * @return Current weight of the iventory
     */
    public int getInventoryWeight() {
	return currentWeight;
    }

    /**
     * Method to add an item to the bag. We can add multiples items with the same name. Once added,the total weight 
     * @param newItem that we want to add
     * @return true if added
     */
    public boolean addItem(Item newItem) {
	currentWeight += newItem.getWeight();
	return inventory.add(newItem);
    }

    /**
     * 
     * @param item we want to find
     * @return true if presnet in the ientory
     */
    public boolean contains(Item item) {
	return inventory.contains(item);
    }

    /**
     * Method to delete an iem from the bag,, when the item is deleted the total weight of the bag is updated
     * @param item
     * @return
     */
    public boolean delItem(Item item) {
	if (inventory.contains(item)) {
	    if (inventory.remove(item)) {
		currentWeight -= item.getWeight();
		return true;
	    } else
		return false; // item can't be removed
	} else
	    return false; // item is nt present on the inventory
    }
}
