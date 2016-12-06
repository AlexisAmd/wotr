/**

* This class is the main class of the "World of The ring" application.
* "World of the ring" is a very simple adventure game.  
*
* You are Frodo Baggins of the Shire. You must bring the Ring to Mordor to destroy it into the flames of Orodruin, 
* the volcano at the north east of the mordor, house of the evil Sauron. Our game is a basic survival game. 
* You must explore Middle Earth in order to find your way to Orodruin. Their will be many foes and obstacles on your way. 
* But you carry the Ring which grants you the ability to be invisible.
*
* This main class creates and initialises all the others: it creates all
* rooms, NPC, items and starts the game.  
*
* @author  GR1
* @version 22/11/2016
*/
package wotr;
import gui.Window;

public class Game {
    private Player currentPlayer;
    private Room startRoom;
    private Window window;
    private MagicalItem magicalItemRing;

    /**
    * Create the game and initialise its internal map.
    * @param window the GUI associated
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
	window.setGame(game); 
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
	roomBilboHouseStart = new Room("Bilbo’s house", "This house keeps a lot of secret and foreign stories", "/roomBilboHouseStart.jpg");
	roomBagginsStreet1 = new Room("Hobbiton main's street north", "The main street of the Hobbiton, your place of birth.",
		"/roomBagginsStreet1.jpg");
	roomBagginsStreet2 = new Room("Hobbiton main's street south" , "You should visit your friend Sam, someone left his keys to Bilbo's birthday party...",
		"/roomBagginsStreet2.jpg");
	roomGreenDragonInn = new Room("The Fancy Poney", "A popular inn in the Shire", "/roomGreenDragonInn.jpg");
	roomSamHouse = new Room("Sam's house. ",
		"Sam is your gardenner but also a good friend.", "/roomSamHouse.jpg");
	room111thBirthday = new Room("Bilbo's party", "The aftermaths of your uncle’s 111th birthday party. It’s a mess.",
		"/room111thBirthday.jpg");
	roomRoadToBree = new Room("Road to bree", "Onward starts your journey to save the world.",
		"/roomRoadToBree.jpg");
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
	
	// Create all the items and binds them to their rooms.
	Key keyToSamHouse;
	Food foodPint, foodWine, foodCarrots, foodGrilledChicken, foodMeltCheese, foodSalad;
	Potion potionElixir;
	
	// Create items
	magicalItemRing = new MagicalItem("Ring of power", "One ring to rules them all", 10, - 10, currentPlayer);
	foodMeltCheese = new Food("Melted cheese sandwich", "A rather... HEAVY meal.", 4, 6, currentPlayer);
	foodPint = new Food("Beer pint", "A good pint for a good beverage !", 10, 10, currentPlayer);
	foodWine = new Food("Large glass of wine", "The better wine of the shire", 5, 10, currentPlayer);
	foodGrilledChicken = new Food("Grilled chicken", "A grilled chicken", 15, 10, currentPlayer);
	foodSalad = new Food("Copious Salad", "Salad", 5, 3, currentPlayer);
	foodCarrots = new Food("Crunchy carrots", "Carrots", 4, 3, currentPlayer);
	potionElixir = new Potion("Gandalf’s elixir",
		"Gandalf created beverage that replicates his power. This elixir is used all over Middle Earth to restore the power of companions. Use this item wisely.",
		3, currentPlayer);
	keyToSamHouse = new Key("Sam's keys", "Unlocked Sam' house", 2, currentPlayer, doorBagginsStreet2SamHouse);
	// Add items to rooms
	roomBilboHouseStart.addItem(foodMeltCheese);
	roomBilboHouseStart.addItem(magicalItemRing);
	
	roomGreenDragonInn.addItem(foodPint);
	roomGreenDragonInn.addItem(foodWine);
	roomGreenDragonInn.addItem(foodGrilledChicken);
	roomSamHouse.addItem(foodSalad);
	roomRoadToBree.addItem(foodCarrots);
	room111thBirthday.addItem(potionElixir);
	room111thBirthday.addItem(keyToSamHouse);
	//D&lcare npc
	Magician npcGandalf;
	Hobbit npcSam, npcPipin, npcMerry;
	Enemy npcDrunkHobbit;
	Warrior warriorBraveHobbit;
	
	// Create NPC
	npcGandalf = new Magician("Gandalf the Grey", "It is Gandalf ! The better magician !", 0, 10);
	warriorBraveHobbit = new Warrior("Mr Brandbouc", "A old bilb'os friends", 0, 0);
	//Enemy sauron = new Enemy("Sauron", "the lord of the ring", 65, -50);
	
	npcSam = new Hobbit("Samwise Gamgee", "The Frodo's bestfriend", -20, 0);
	npcDrunkHobbit = new Enemy("Drunk hobbit", "Just an unknow drunk who wants to fight with you because he saws you looking after is beer...", 1, -5);
	npcPipin = new Hobbit("Perigirn Took", "Pipin is a good friend, he can remove 5 corruption points thank to the power friendship ! ", -5, 0);
	npcMerry = new Hobbit("Meriadoc Brandibouc", "Merry is a good friend, he can remove 5 corruptions points thank to the power friendship ! ", -5, 0);
	// Add NPC to rooms
	roomBagginsStreet1.addNPC(npcGandalf);
	roomSamHouse.addNPC(npcSam);
	room111thBirthday.addNPC(npcDrunkHobbit);
	roomRoadToBree.addNPC(npcPipin);
	roomRoadToBree.addNPC(npcMerry);
	roomGreenDragonInn.addNPC(warriorBraveHobbit);
	
	
	
	// *********************LEVEL 2 - BREE************************************
	// Declare rooms and doors
	Room roomBuckleburyFerry, roomCityEntrance, roomCityCenter, roomPPBar, roomPPDormitory, roomPPGandalf,
		roomPPStrider, roomDarkAlley1, roomDarkAlley2; // PP = PrncingPoney
	Door doorBuckleburyFerryCityEntrance, doorCityEntranceBuckleburyFerry, doorCityEntranceCityCenter, doorCityEntranceDarkAlley2,
		doorCityCenterCityEntrance, doorCityCenterDarkAlley1, doorDarkAlley1DarkAlley2, doorDarkAlley1CityCenter,doorDarkAlley2DarkAlley1,
		doorDarkAlley2CityEntrance, doorCityCenterPPBar, doorPPBarCityCenter, doorPPBarPPDormitory,
		doorPPDormitoryPPBar, doorPPGandalfPPBar, doorPPBarPPStrider, doorPPStriderPPBar;
	KeyLockedDoor doorPPBarPPGandalf;
	WorldDoor worlddoorShireToBree;
	// Create rooms (description, script, image)
	roomBuckleburyFerry = new Room("Bucklebury Ferry", "Taking the ferry will allow you to avoid dark riders along the way",
			"/roomBuckleburyFerry.jpg");
	roomCityCenter = new Room("City center", "The center of the city of Bree", "/BreeCityCenter.jpg");
	roomCityEntrance = new Room("City Entrance", "The entrance of the city of Bree", "/BreeCityEntrance.jpg");
	roomPPBar = new Room("Prancing Pony Bar", "It is the most famous bar of Bree", "/PPBar.jpg");
	roomPPDormitory = new Room("Prancing Pony Dormitory", "You can sleep in the dormitory... Or maybe not", "/PPDormitory.png"); //Nazgul in a dormitory?
	roomPPGandalf = new Room("Prancing Pony Gandalf's Room", "You are in the Gandalf's Room", "/PPGandalf.jpg");
	roomPPStrider = new Room("Prancing Pony Strider's Room", "You are in the Strider's Room", "/PPStrider.jpg");
	roomDarkAlley1 = new Room("DarK Alley East", "A scary dark alley", "/darkAlley1.jpg");
	roomDarkAlley2 = new Room("Dark Alley West", "A scary dark alley", "/DarkAlley2.png");
	// Create doors
	worlddoorShireToBree = new WorldDoor(roomRoadToBree, roomBuckleburyFerry);
	doorBuckleburyFerryCityEntrance = new Door(roomBuckleburyFerry, roomCityEntrance);
	doorCityEntranceBuckleburyFerry = new Door(roomCityEntrance, roomBuckleburyFerry);
	doorCityEntranceCityCenter = new Door(roomCityEntrance, roomCityCenter);
	doorCityEntranceDarkAlley2 = new Door(roomCityEntrance, roomDarkAlley2);
	doorCityCenterCityEntrance = new Door(roomCityCenter, roomCityEntrance);
	doorCityCenterPPBar = new Door(roomCityCenter, roomPPBar);
	doorCityCenterDarkAlley1 = new Door(roomCityCenter, roomDarkAlley1);
	doorDarkAlley1CityCenter = new Door(roomDarkAlley1, roomCityCenter);
	doorDarkAlley1DarkAlley2 = new Door(roomDarkAlley1, roomDarkAlley2);
	doorDarkAlley2DarkAlley1 = new Door(roomDarkAlley2, roomDarkAlley1);
	doorDarkAlley2CityEntrance = new Door(roomDarkAlley2, roomCityEntrance);
	doorPPBarCityCenter = new Door(roomPPBar, roomCityCenter);
	doorPPBarPPDormitory = new Door(roomPPBar, roomPPDormitory);
	doorPPDormitoryPPBar = new Door(roomPPDormitory, roomPPBar);
	doorPPBarPPGandalf = new KeyLockedDoor(roomPPBar, roomPPGandalf);
	doorPPGandalfPPBar = new Door(roomPPGandalf, roomPPBar);
	doorPPBarPPStrider = new Door(roomPPBar, roomPPStrider);
	doorPPStriderPPBar = new Door(roomPPStrider, roomPPBar);
	// Link the exit world to previous level
	roomRoadToBree.addExit("south", worlddoorShireToBree);
	// Associate doors with rooms
	roomBuckleburyFerry.addExit("east", doorBuckleburyFerryCityEntrance);
	roomCityEntrance.addExit("west", doorCityEntranceBuckleburyFerry);
	roomCityEntrance.addExit("east", doorCityEntranceCityCenter);
	roomCityEntrance.addExit("south", doorCityEntranceDarkAlley2);
	roomCityCenter.addExit("west", doorCityCenterCityEntrance);
	roomCityCenter.addExit("east", doorCityCenterPPBar);
	roomCityCenter.addExit("south", doorCityCenterDarkAlley1);
	roomDarkAlley1.addExit("west", doorDarkAlley1DarkAlley2);
	roomDarkAlley1.addExit("north", doorDarkAlley1CityCenter);
	roomDarkAlley2.addExit("north", doorDarkAlley2CityEntrance);
	roomDarkAlley2.addExit("east", doorDarkAlley2DarkAlley1);
	roomPPBar.addExit("west", doorPPBarCityCenter);
	roomPPBar.addExit("north", doorPPBarPPDormitory);
	roomPPBar.addExit("east", doorPPBarPPGandalf);
	roomPPBar.addExit("south", doorPPBarPPStrider);
	roomPPDormitory.addExit("south", doorPPDormitoryPPBar);
	roomPPGandalf.addExit("west", doorPPGandalfPPBar);
	roomPPStrider.addExit("north", doorPPStriderPPBar);
	
	// Declare items
	Key keyGandalfRoom;
	Food foodBeer50, foodBeer75, foodBeer100, foodFries;
	// Instanciate items
	foodBeer50 = new Food ("Beer", "It is a good beer (50cL)", 10, 10, currentPlayer);
	foodBeer75 = new Food ("Pint", "It is a good beer (75cL)", 12, 12, currentPlayer);
	foodBeer100 = new Food ("Big Beer", "It is a good beer (100cL)", 15, 15, currentPlayer);
	foodFries = new Food ("foodFries", "French fries", 10, 15, currentPlayer);
	keyGandalfRoom = new Key("key of Gandalf's Room", "This key unlock Gandalf' s room", 2, currentPlayer, doorPPBarPPGandalf);
	// Add items to rooms
	roomPPBar.addItem(foodFries);
	roomPPBar.addItem(keyGandalfRoom);
	roomPPGandalf.addItem(foodBeer100);
	roomPPGandalf.addItem(foodBeer75);
	roomPPGandalf.addItem(foodBeer50);
	// Declare NPCs
	Enemy enemyNazgulSmall, enemyNazgulMedium, enemyNazgulBig, enemyThief;
	Warrior warriorAragorn, warriorFaramir;
	// Instanciate NPCs
	enemyNazgulSmall = new Enemy("Baby Nazgul", "The Fear that they inspire is their best weapon", 10, -5);
	enemyNazgulMedium = new Enemy("Medium Nazgul", "The Fear that they inspire is their best weapon", 16, -10);
	enemyNazgulBig = new Enemy("Biggest Nazgul", "The Fear that they inspire is their best weapon", 23, -15);
	enemyThief = new Enemy("Thief", "He will steal you without realizing it", 10, 0);
	warriorAragorn = new Warrior("Aragorn", "He can protect you against ennemies by killing them all.", 0, 0);
	warriorFaramir = new Warrior("Faramir", "He can protect you against ennemies by killing them all. Faramir is Boromir's brother but lives the shadow of him...", 0, 0);
	// Add NPCs
	roomBuckleburyFerry.addNPC(enemyNazgulSmall);
	roomDarkAlley2.addNPC(enemyThief);
	roomPPStrider.addNPC(warriorAragorn);
	roomPPBar.addNPC(warriorFaramir);
	roomPPDormitory.addNPC(enemyNazgulMedium);
	roomPPGandalf.addNPC(enemyNazgulBig);
	
	//===LAST LEVEL====
	// Declare rooms and doors
	Room roomMuddyRoad1of350,roomMuddyRoad2of350,roomMuddyRoad3of350,roomPortal,roomSauronsForge;
	Door doorPPStriderroomMuddiRoad1of350,doorroomMuddyRoad1of350roomMuddyRoad2of350,doorroomMuddyRoad2of350roomMuddyRoad3of350,
	doorroomMuddyRoad3of350roomPortal,doorroomPortalroomSauronsForge;
	// Create rooms (description, script, image)
	roomMuddyRoad1of350 = new Room("Muddy Road 1 of 350","Good Luck","/MuddyRoad1.jpg");
	roomMuddyRoad2of350 = new Room("Muddy Road 2 of 350","wow the same boring room","/MuddyRoad2.jpg");
	roomMuddyRoad3of350 = new Room("Muddy Road 3 of 350", "Borrrrrrrrrringgggg", "/MuddyRoad3.jpg");
	roomPortal = new Room("Portaaaaaaaal","WOW Where is it going to lead me ?","portal.gif");
	roomSauronsForge = new Room("Sauron's forge","OMG the legendary volcano of Sauron !","Volcan.jpg");
			
	// Create doors
	doorPPStriderroomMuddiRoad1of350 = new Door(roomPPStrider, roomMuddyRoad1of350);
	doorroomMuddyRoad1of350roomMuddyRoad2of350 = new Door(roomMuddyRoad1of350, roomMuddyRoad2of350);
	doorroomMuddyRoad2of350roomMuddyRoad3of350 = new Door(roomMuddyRoad2of350, roomMuddyRoad3of350);
	doorroomMuddyRoad3of350roomPortal = new Door(roomMuddyRoad3of350, roomPortal);
	doorroomPortalroomSauronsForge = new Door(roomPortal, roomSauronsForge);
		
	// Associate doors with rooms
	roomPPStrider.addExit("south", doorPPStriderroomMuddiRoad1of350);
	roomMuddyRoad1of350.addExit("east", doorroomMuddyRoad1of350roomMuddyRoad2of350);
	roomMuddyRoad2of350.addExit("east", doorroomMuddyRoad2of350roomMuddyRoad3of350);
	roomMuddyRoad3of350.addExit("north", doorroomMuddyRoad3of350roomPortal);
	roomPortal.addExit("east", doorroomPortalroomSauronsForge);
	
	// Declare items
	// Create items
	// Add items to rooms
	roomMuddyRoad1of350.addItem(foodSalad);
	roomMuddyRoad2of350.addItem(foodCarrots);
	// Declare NPCs
	NPC HUGENazgul,TheBrotherOfTheHugeNazgul;
	// Create NPCs
	HUGENazgul = new Enemy("HUGE Nazgul", "A f****king huge nazgul", 15, 20);
	TheBrotherOfTheHugeNazgul = new Enemy("The Brother of the HUGE nazgul","WOOOOW he's also huge AF",20,20);
	// Add NPCs
	roomMuddyRoad2of350.addNPC(HUGENazgul);
	roomMuddyRoad3of350.addNPC(TheBrotherOfTheHugeNazgul);
	//====================END=================
	startRoom = roomBilboHouseStart; //set the startroom
    }
    /**
     * Check if Frodo droped the ring in the vlocano and if he is always alive
     */
    public boolean win() {
	
	return (currentPlayer.isAlive() && currentPlayer.getCurrentRoom().getItemList().contains(magicalItemRing) && currentPlayer.getCurrentRoom().getDescription().equalsIgnoreCase("Sauron's Forge") );
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
	window.setScript("Welcome to the Lord of the Ring: A Frodo's"
		+ " Journey. You are Frodo and Bilbo gave you a strange ring."
		+ " Gandalf revealed that it is the One Ring, the most powerful"
		+ " ring which belongs to Sauron, the Lord of Mordor."
		+ " You are Frodo Baggins of the Shire. You must bring"
		+ " the Ring to Mordor to destroy it into the flames"
		+ " of Orodruin, the volcano at the north east of the"
		+ " mordor, house of the evil Sauron. Our game is a basic survival"
		+ " game. You must explore Middle Earth in order to find your"
		+ " way to Orodruin. Their will be many foes and obstacles"
		+ " on your way. But you carry the Ring which grants you the "
		+ "ability to be invisible. You need to be careful, "
		+ "prepare yourself to commit you");
		}

    /**
     * @return currentPlayer the player associated to the game (Frodo)
     */
    public Player getPlayer() {
	return currentPlayer;
    }
}
