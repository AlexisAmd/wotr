//WIP Antoine
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

import java.util.HashMap; //useless ?
import javax.swing.*;
import gui.Window;

public class Game {
    private Player currentPlayer;
    private Room startRoom;
    private Window window;
    private boolean win;

    /**
    * Create the game and initialise its internal map.
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
	Game game = new Game(window); // instanciate a game
	window.setGame(game); //cradde
	game.play();
    }


    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
	// *********************LEVEL 1 - THE SHIRE*****************************
	Room roomBilboHouseStart, roomBagginsStreet1, roomBagginsStreet2, roomGreenDragonInn, roomSamHouse,
		room111thBirthday, roomRoadToBree;
	Door doorBagginsStreet1BilboHouse, doorBilboHouseBagginsStreet1, doorBagginsStreet1GreenDragonInn,
		doorGreenDragonInnBagginsStreet1, doorBagginsStreet1111thBirthdayParty,
		door111thBirthdayPartyBagginsStreet1, doorBagginsStreet1BagginsStreet2,
		doorBagginsStreet2BagginsStreet1, doorBagginsStreet2RoadToBree, doorSamHouseBagginsStreet2;
	KeyLockedDoor doorBagginsStreet2SamHouse;
	// Create the rooms (description, script, image)
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
	roomGreenDragonInn.addExit("south", doorGreenDragonInnBagginsStreet1);
	room111thBirthday.addExit("west", door111thBirthdayPartyBagginsStreet1);
	roomBagginsStreet2.addExit("north", doorBagginsStreet2BagginsStreet1);
	roomBagginsStreet2.addExit("west", doorBagginsStreet2SamHouse);
	roomBagginsStreet2.addExit("south", doorBagginsStreet2RoadToBree);
	roomSamHouse.addExit("east", doorSamHouseBagginsStreet2);
	startRoom = roomBilboHouseStart;
		
	 // Create all the items and binds them to their rooms.

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
	potionElixir = new Potion("Gandalf’s elixir",
		"Gandalf created beverage that replicates his power. This elixir is used all over Middle Earth to restore the power of companions. Use this item wisely.",
		5, currentPlayer);
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
	Magician npcGandalf;
	Hobbit npcSam, npcPipin, npcMerry;
	Warrior npcDrunkHobbit;
	// Create NPC
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
		Room roomBuckleburyFerry,roomCityEntrance,roomCityCenter,roomPPBar,roomPPDormitory,
		roomPPGandalf,roomPPStrider,roomDarkAlley1,roomDarkalley2; //PP = PrncingPoney
		Door doorBuckleburyFerryCityEntrance,doorCityEntranceBuckleburyFerry,doorCityEntranceCityCenter,
		doorCityCenterCityEntrance,doorCityCenterDarkAlley1,doorDarkAlley1DarkAlley2,doorDarkAlley2CityEntrance,doorCityCenterPPBar,doorPPBarCityCenter,
		doorPPBarPPDormitory,doorPPDormitoryPPBar,doorPPBarPPGandalf,doorPPGandalfPPBar,doorPPBarPPStrider,doorPPStriderPPBar;
		WorldDoor worlddoorShireToBree;
				// Create rooms (description, script, image)
		roomBuckleburyFerry = new Room("Taking the ferry will allow you to avoid dark riders along the way", "-script-",
				"src/gui/image/roomBuckleburyFerry.jpg");
		roomCityCenter = new Room("","","");
		roomCityEntrance = new Room("","","");
		roomPPBar = new Room("","","");
		roomPPDormitory = new Room("","","");
		roomPPGandalf = new Room("","","");
		roomPPStrider = new Room("","","");
		roomDarkAlley1 = new Room("","","");
		roomDarkalley2 = new Room("","","");
		
				// Create doors
		worlddoorShireToBree = new WorldDoor(roomRoadToBree, roomBuckleburyFerry);
		doorBuckleburyFerryCityEntrance = new Door(roomBuckleburyFerry,roomCityEntrance);
		doorCityEntranceBuckleburyFerry = new Door(roomCityEntrance,roomBuckleburyFerry);
		doorCityEntranceCityCenter = new Door(roomCityEntrance, roomCityCenter);
		doorCityCenterCityEntrance = new Door(roomCityCenter, roomCityEntrance);
		doorCityCenterPPBar = new Door(roomCityCenter, roomPPBar);
		doorCityCenterDarkAlley1 = new Door(roomCityCenter, roomDarkAlley1);
		doorDarkAlley1DarkAlley2 = new Door(roomDarkAlley1, roomDarkalley2);
		doorDarkAlley2CityEntrance = new Door(roomDarkalley2, roomCityEntrance);
		doorPPBarCityCenter = new Door(roomPPBar, roomCityCenter);
		doorPPBarPPDormitory = new Door(roomPPBar, roomPPDormitory);
		doorPPDormitoryPPBar = new Door(roomPPDormitory, roomPPBar);
		doorPPBarPPGandalf = new Door(roomPPBar, roomPPGandalf);
		doorPPGandalfPPBar = new Door(roomPPGandalf, roomPPBar);
		doorPPBarPPStrider = new Door(roomPPBar, roomPPStrider);
		doorPPStriderPPBar = new Door(roomPPStrider, roomPPBar);
		
				// Link the exit world to previous level
		roomRoadToBree.addExit("north", worlddoorShireToBree);
		
				// Associate doors with rooms
		roomBuckleburyFerry.addExit("East", doorBuckleburyFerryCityEntrance);
		roomCityEntrance.addExit("west", doorCityEntranceBuckleburyFerry);
		roomCityEntrance.addExit("east", doorCityEntranceCityCenter);
		roomCityCenter.addExit("west", doorCityCenterCityEntrance);
		roomCityCenter.addExit("east", doorCityCenterPPBar);
		roomCityCenter.addExit("south", doorCityCenterDarkAlley1);
		roomDarkAlley1.addExit("west", doorDarkAlley1DarkAlley2);
		roomDarkalley2.addExit("north", doorDarkAlley2CityEntrance);
		roomPPBar.addExit("west", doorPPBarCityCenter);
		roomPPBar.addExit("north", doorPPBarPPDormitory);
		roomPPDormitory.addExit("south", doorPPDormitoryPPBar);
		roomPPBar.addExit("east", doorPPBarPPGandalf);
		roomPPGandalf.addExit("west", doorPPGandalfPPBar);
		roomPPBar.addExit("south", doorPPBarPPStrider);
		roomPPStrider.addExit("north", doorPPStriderPPBar);
		
				// Declare items
				// Create items
				// Add items to rooms
				
				// Declare NPCs
				// Create NPCs
				// Add NPCs
		
		// *********************LEVEL 3 - Rivendell************************************
				// Declare rooms and doors
				// Create rooms (description, script, image)
				// Create doors
				// Link the exit world to previous level
				// Associate doors with rooms
				
				// Declare items
				// Create items
				// Add items to rooms
				
				// Declare NPCs
				// Create NPCs
				// Add NPCs

	   
    }


    /**
     * 
     */
	public void win() {
		JOptionPane.showMessageDialog(null,
				"You dropped the Ring in the Mount Doom and you defeated Sauron and his armies. You accomplished your journey. Congratulations.",
				"Congratulations", JOptionPane.PLAIN_MESSAGE);
	}

/**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
	
	printWelcome();
	window.updateAll();
	// Enter the main command loop. Here we repeatedly read commands and
	// execute them until the game is over.
 
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
	window.setScript(
		"Welcome to the Lord of the Ring: A Frodo's Journey. You are Frodo and Bilbo gave you a strange ring. Gandalf revealed that it is the One Ring, the most powerful ring which belongs to Sauron, the Lord of Mordor. You are Frodo Baggins of the Shire. You must bring the Ring to Mordor to destroy it into the flames of Orodruin, the volcano at the north east of the mordor, house of the evil Sauron. Our game is a basic survival game. You must explore Middle Earth in order to find your way to Orodruin. Their will be many foes and obstacles on your way. But you carry the Ring which grants you the ability to be invisible. You need to be careful, prepare yourself to commit your life."
		+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    
    /**
     * @return
     */
    public Player getPlayer() {
	// TODO Auto-generated method stub
	return currentPlayer;
    }
}
