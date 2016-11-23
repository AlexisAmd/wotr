package wotr;

import java.util.ArrayList;

/**
 * 
*Bag class. A bag contains Items and his weight is defined by the sum of the weights of all items. A player have oly one bag a a moment
 * 
 * @author GR1
 * @version 21/11/16
 */

public class Bag {
	private ArrayList<Item> inventory; // list of all items stored in the player's inventory
	//private Player currentPlayer;
	private int currentWeight; // current weigh of the inventory
	private String description;
	
	public void Bag(String description){
		this.inventory = new ArrayList<Item>();
		this.currentWeight=0;
		this.description = description;
				
	}

	public int getInventoryWeight() {
		// TODO Auto-generated method stub
		return currentWeight;
	}

	public boolean addItem(Item newItem) {
		currentWeight+=newItem.getWeight();
		return inventory.add(newItem);
		
	}
	
	public boolean contains(Item item){
		return inventory.contains(item);
	}

	public boolean delItem(Item item) {
		if (inventory.contains(item)){
			if(inventory.remove(item)){
				currentWeight-=item.getWeight();
				return true;
				}else return false; //item can't be removed	
		}else return false; //item is nt present on the inventory
	}


}
