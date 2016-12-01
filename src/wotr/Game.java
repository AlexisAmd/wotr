/**

 * This class is the main class of the "World of The ring" application.
 * "World of the ring" is a very simple adventure gamee.  
 *
 * You are Frodo Baggins of the Shire. You must bring the Ring to Mordor to destroy it into the flames of Orodruin, the volcano at the north east of the mordor, house of the evil Sauron. Our game is a basic survival game. You must explore Middle Earth in order to find your way to Orodruin. Their will be many foes and obstacles on your way. But you carry the Ring which grants you the ability to be invisible.
 *
 * This main class creates and initialises all the others: it creates all
 * rooms, NPC, items and starts the game.  
 *
 * @author  GR1
 * @version 22/11/2016
 */
package wotr;

import java.util.HashMap;
import javax.swing.*;
import gui.Window;

public class Game {
	private Player currentPlayer;
	private Room startRoom;
	private Window window;
	private boolean win;

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game(Window window) {
		createRooms();
		currentPlayer = new Player();
		currentPlayer.setCurrentRoom(startRoom);
		this.window = window;
	}

	/**
	 * Main of the game
	 */
	public static void main(String[] args) {
		Window window = new Window();
		Game game = new Game(window); // instantiate a game
		game.play();
	}

	/**
	 * Create all the rooms, doors, items and NPCs and link them them together.
	 */
	private void createRooms() {
		// *********************LEVEL 1 - THE SHIRE*****************************
		// Declare rooms and doors
		Room roomBilboHouseStart = null, roomBagginsStreet1, roomBagginsStreet2, roomGreenDragonInn, roomSamHouse,
		room111thBirthday, roomRoadToBree;
		Door doorBagginsStreet1BilboHouse, doorBilboHouseBagginsStreet1, doorBagginsStreet1GreenDragonInn,
		doorGreenDragonInnBagginsStreet1, doorBagginsStreet1111thBirthdayParty,
		door111thBirthdayPartyBagginsStreet1, doorBagginsStreet1BagginsStreet2,
		doorBagginsStreet2BagginsStreet1, doorBagginsStreet2RoadToBree, doorSamHouseBagginsStreet2;
		KeyLockedDoor doorBagginsStreet2SamHouse;
		
		startRoom = roomBilboHouseStart; // start game to the BagginsStreet
		
		// Create rooms (description, script, image)
		roomBilboHouseStart = new Room("Bilbo’s house", "-script-", "src/gui/image/roomBilboHouseStart.jpg");
		roomBagginsStreet1 = new Room("The main street of the Hobbiton, your place of birth.", "-script-",
				"src/gui/image/roomBagginsStreet1.jpg");
		roomBagginsStreet2 = new Room("The main street of the Hobbiton, your place of birth.", "-script-",
				"src/gui/image/roomBagginsStreet2.jpg");
		roomGreenDragonInn = new Room("A popular inn in the Shire", "-script-", "src/gui/image/roomGreenDragonInn.jpg");
		roomSamHouse = new Room("Sam is your gardener and also a close friend. His house looks clean and tidy.",
				"-script-", "src/gui/image/roomSamHouse.jpg");
		room111thBirthday = new Room("The aftermaths of your uncle’s 111th birthday party. It’s a mess.", "-script-",
				"src/gui/image/room111thBirthday.jpg");
		roomRoadToBree = new Room("Onward starts your journey to save the world.", "-script-",
				"src/gui/image/roomRoadToBree.jpg");
		// Create doors
		doorBagginsStreet1BilboHouse = new Door(roomBagginsStreet1, roomBilboHouseStart);
		doorBilboHouseBagginsStreet1 = new Door(roomBilboHouseStart, roomBagginsStreet1);
		doorBagginsStreet1GreenDragonInn = new Door(roomBagginsStreet1, roomGreenDragonInn);
		doorGreenDragonInnBagginsStreet1 = new Door(roomGreenDragonInn, roomBagginsStreet1);
		doorBagginsStreet1111thBirthdayParty = new Door(roomBagginsStreet1, room111thBirthday);
		door111thBirthdayPartyBagginsStreet1 = new Door(room111thBirthday, roomBagginsStreet1);
		doorBagginsStreet1BagginsStreet2 = new Door(roomBagginsStreet1, roomBagginsStreet2);
		doorBagginsStreet2BagginsStreet1 = new Door(roomBagginsStreet2, roomBagginsStreet1);
		doorBagginsStreet2SamHouse = new KeyLockedDoor(roomBagginsStreet2, roomSamHouse);
		doorSamHouseBagginsStreet2 = new Door(roomSamHouse, roomBagginsStreet2);
		doorBagginsStreet2RoadToBree = new Door(roomBagginsStreet2, roomRoadToBree);
		// Associate doors with rooms
		roomBagginsStreet1.addExit("north", doorBagginsStreet1GreenDragonInn);
		roomBagginsStreet1.addExit("south", doorBagginsStreet1BagginsStreet2);
		roomBagginsStreet1.addExit("east", doorBagginsStreet1111thBirthdayParty);
		roomBagginsStreet1.addExit("west", doorBagginsStreet1BilboHouse);
		roomBilboHouseStart.addExit("east", doorBilboHouseBagginsStreet1);
		roomGreenDragonInn.addExit("north", doorGreenDragonInnBagginsStreet1);
		room111thBirthday.addExit("west", door111thBirthdayPartyBagginsStreet1);
		roomBagginsStreet2.addExit("north", doorBagginsStreet2BagginsStreet1);
		roomBagginsStreet2.addExit("west", doorBagginsStreet2SamHouse);
		roomBagginsStreet2.addExit("south", doorBagginsStreet2RoadToBree);
		roomSamHouse.addExit("east", doorSamHouseBagginsStreet2);
		roomBilboHouseStart.addExit("east", doorBilboHouseBagginsStreet1);
		startRoom = roomBilboHouseStart;

		// Declare items
		Key keyToSamHouse;
		Food foodPint, foodWine, foodCarrots, foodGrilledChicken, foodMeltCheese, foodSalad;
		Potion potionElixir;
		// Create items
		foodMeltCheese = new Food("Melted cheese sandwich", "A rather... HEAVY meal.", 90, 10, currentPlayer);
		foodPint = new Food("Large beer pint", "description", 10, 10, currentPlayer);
		foodWine = new Food("Large glass of wine", "description", 5, 10, currentPlayer);
		foodGrilledChicken = new Food("Grilled chicken", "description", 30, 10, currentPlayer);
		foodSalad = new Food("Copious Salad", "description", 20, 10, currentPlayer);
		foodCarrots = new Food("Crunchy carrots", "description", 4, 10, currentPlayer);
		potionElixir = new Potion("Gandalf’s elixir", "Gandalf created beverage that replicates his"
				+ "power. This elixir is used all over Middle Earth to restore the power of"
				+ "companions. Use this item wisely.", 5, currentPlayer);
		keyToSamHouse = new Key("keyToSamHouse", "Unlocked Sam' house", 2, currentPlayer, doorBagginsStreet2SamHouse);
		// Add items to rooms
		roomBilboHouseStart.addItem(foodMeltCheese);
		roomGreenDragonInn.addItem(foodPint);
		roomGreenDragonInn.addItem(foodWine);
		roomGreenDragonInn.addItem(foodGrilledChicken);
		roomSamHouse.addItem(foodSalad);
		roomRoadToBree.addItem(foodCarrots);
		room111thBirthday.addItem(potionElixir);
		room111thBirthday.addItem(keyToSamHouse);
		
		// Declare NPCs
		Magician npcGandalf;
		Hobbit npcSam, npcPipin, npcMerry;
		Warrior npcDrunkHobbit;
		// Create NPCs
		npcGandalf = new Magician("Gandalf the Grey", "description", 0, 0, currentPlayer);
		npcSam = new Hobbit("Samwise Gamgee", "description", -20, 0, currentPlayer);
		npcDrunkHobbit = new Warrior("Drunk hobbit", "description", 0, -5, currentPlayer);
		npcPipin = new Hobbit("Perigirn Took", "description", -10, 0, currentPlayer);
		npcMerry = new Hobbit("Meriadoc Brandibouc", "description", -10, 0, currentPlayer);
		// Add NPC to rooms
		roomBilboHouseStart.addNPC(npcGandalf);
		roomSamHouse.addNPC(npcSam);
		room111thBirthday.addNPC(npcDrunkHobbit);
		roomRoadToBree.addNPC(npcPipin);
		roomRoadToBree.addNPC(npcMerry);

		// *********************LEVEL 2 - BREE************************************
		// Declare rooms and doors
		Room roomBuckleburyFerry = null;
		WorldDoor worlddoorShireToBree;
		// Link the previous exit world
		worlddoorShireToBree = new WorldDoor(roomRoadToBree, roomBuckleburyFerry);
		roomRoadToBree.addExit("north", worlddoorShireToBree);
		// Create rooms (description, script, image)
		roomBuckleburyFerry = new Room("Taking the ferry will allow you to avoid dark riders along the way", "-script-",
				"src/gui/image/roomBuckleburyFerry.jpg");
		// Create doors
		// Associate doors with rooms
		
		// Declare items
		// Create items
		// Add items to rooms
		
		// Declare NPCs
		// Create NPCs
		// Add NPCs


		// *********************LEVEL 3 - RIVENDELL************************************


	}

	/**
	 * Main play routine.  Loops until end of play.
	 */
	public void play() {
		boolean bNorth, bEast, bSouth, bWest;
		printWelcome();
		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.
		bNorth = currentPlayer.getCurrentRoom().getExits().containsKey("north");
		bSouth = currentPlayer.getCurrentRoom().getExits().containsKey("south");
		bWest = currentPlayer.getCurrentRoom().getExits().containsKey("west");
		bEast = currentPlayer.getCurrentRoom().getExits().containsKey("east");
		window.updateAll(bEast, bNorth, bWest, bSouth, currentPlayer.getHp(), currentPlayer.getCorruption(),
				currentPlayer.getFellowship(), currentPlayer.getInventory(), currentPlayer.getCurrentRoom().getImg(),
				currentPlayer.getCurrentRoom().getDescription());
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		window.setScript(
				"Welcome to the World of the Ring: Frodo's Choice. You are Frodo Baggins of the Shire. Your uncle Bilbo gave you a strange ring. Your friend Gandalf revealed that it is the One Ring, a powerful artifact which makes allows its bearer to remain unseen. But at what cost? The ring belongs to Sauron, the Lord of Mordor, and its influence grows on you. You must bring the Ring to Mordor to destroy it into the flames of Orodruin, the volcano where it was created. You must act with caution for the shadow of Sauron affects your will and you become weaker with every step. There will be many foes and obstacles on your way and the odds are against you, prepare to give your life for this quest. Fortunately, your friends are here to help you. Use their power wisely. Now go! You must explore Middle Earth and find your way to Orodruin.");
	}

	public void win() {
		JOptionPane.showMessageDialog(null,
				"You dropped the Ring in the Mount Doom and you defeated Sauron and his armies. You accomplished your journey. Congratulations.",
				"Congratulations", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * @return
	 */
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return currentPlayer;
	}
}
