package wotr;

public class WorldExit extends ExitRoom {

	private Player player;
	
	
	
	
	
	
	public WorldExit(Room currentRoom, Room nextRoom) {
		super(currentRoom, nextRoom);

	}

	 /**
     *Methods to get the future current room after moving, if the player has a magician and if his power was used, he recover his power.
   * @param currentRoom
   * @return the next room
   */
  public Room getNextRoom(Room nextRoom)
  {
      if (this.currentRoom!=nextRoom){
          return this.currentRoom;
      }
      else{
          return this.nextRoom;
      }
  }
	
	
	
	
	
}
