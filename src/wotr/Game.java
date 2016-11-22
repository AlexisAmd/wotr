
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

public class Game {
    private Parser parser; //will be deleted soon
    private Room currentRoom;
    private Player currentPlayer;

    /**
    * Create the game and initialise its internal map.
    */
    public Game() {
        createRooms();
        parser = new Parser();
        currentPlayer = new Player();
        
    }

    /**
     * Main of the game
     */
    public static void main(String[] args) {
        Game g = new Game(); //instanciate a game
        g.play(); //play the game
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        //DECLARATION
        Room roomOutside, roomTheatre, roomPub, roomLab;

        ExitRoom doorOutsideLab, doorOutsidePub, doorLabOutside;

        PasswordLockedExitRoom doorPubOutside;

        KeyLockedExitRoom doorOutsideTheatre, doorTheatreOutside;

        //INSTANCIATION //THIS IS AN EXEMPLE (to define a syntax that we will use in the future)

        // create the rooms
        roomOutside=new Room("main entrance of the university");
        roomTheatre = new Room("lecture theatre");
        roomPub = new Room("campus pub");
        roomLab = new Room("computing lab");
        //create items //DEV info : move this lines to a method named 'creteItems' then call it here
        Key keyTheatre = new Key("KeyTheatre","Allow to go to theatre",1, currentPlayer);
        Food lambas = new Food("Lambas","miaaaam", 2, 30, currentPlayer);

        //adding item to rooms
        roomPub.addItem(keyTheatre);
        roomTheatre.addItem(lambas);

        // initialise room exits (doors)
        doorOutsidePub = new PasswordLockedExitRoom(roomOutside, roomPub, "azertyuiop");
        doorPubOutside = new PasswordLockedExitRoom(roomPub, roomOutside, "azertyuiop");

        doorOutsideTheatre = new KeyLockedExitRoom(roomOutside, roomTheatre, keyTheatre);
        doorTheatreOutside = new KeyLockedExitRoom(roomTheatre, roomOutside, keyTheatre);
        doorOutsideLab = new ExitRoom(roomOutside, roomLab);
        doorLabOutside = new ExitRoom(roomLab, roomOutside);

        //associating doors with rooms
        roomOutside.addExit("north", doorOutsideTheatre);
        roomOutside.addExit("south", doorOutsidePub);
        roomOutside.addExit("east", doorOutsideLab);

        roomTheatre.addExit("south",doorTheatreOutside);
        roomPub.addExit("north",doorPubOutside);
        roomLab.addExit("west", doorLabOutside);

        currentRoom = roomOutside; // start game outside

        

    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while(!finished) {
            Command command = parser.getCommand(); //will be deleted
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");//will be deleted
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() { //will be deleted
        System.out.println();
        System.out.println("Welcome to the World of the Ring!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println("Exits: ");
        currentRoom.printExits();
        System.out.println("\n");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) { //will be deleted
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if(commandWord.equals("help"))
            printHelp();
        else if(commandWord.equals("go"))
            goRoom(command.toString());
        else if((commandWord.equals("quit") | commandWord.equals("exit")))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    /**
     * Try to go to one direction.
     * If there is a room in this direction, go to this room
     * Otherwise print an error message
     * @param direction the direction of the move
     */
    public void goRoom(String direction) {
        // Try to leave current room.
        Room nextRoom = null;

        nextRoom = currentRoom.getNextRoom(direction);
        if(nextRoom == null) {
            System.out.println("Can't move to "+direction + "\n");
        } else {
            currentRoom = nextRoom;
            System.out.println("Moved to "+direction + "\n");

        }
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are  "+currentRoom.getDescription());
        System.out.println("\n"+"Exits :");
        currentRoom.printExits();
        System.out.println("\n"+"Items :");
        currentRoom.printItems();
        System.out.println("\n"+ "Your command words are:");
        System.out.println("go, quit, help");
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }
  //COMMON METHODS

       /**
     * pickUp an Item, add it to the current player inventory if possible then remove it from the room
     * @param nameItem
     */  
    public void pickUpItem(Item item) 
    {
    Item moveItem=null;//temporary varaible to store the item
    boolean itemAdded=false;
    moveItem=item;
    currentRoom.delItem(item);
    if(moveItem!=null){
  
            if(!currentPlayer.addItem(moveItem)){
                currentRoom.addItem(moveItem); //si item pas ajouté au perso on le remet dans la piece
            }
        }

    }

       /**
     * pickUp an Item, add it to the current player inventory, remove it from the room
     * @param nameItem
     */  
    public void pickUpNPC(NPC npc) 
    {
    NPC moveNPC=null;//temporary varaible to store the item
    boolean NPCAdded=false;
    moveNPC=npc;
    currentRoom.delNPC(npc);
    if(moveNPC!=null){
  
            if(!currentPlayer.addNPC(moveNPC)){
                currentRoom.addNPC(moveNPC); //si item pas ajouté au perso on le remet dans la piece
            }
        }

    }
}
