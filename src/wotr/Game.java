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

public class Game {

    private Player currentPlayer;
    private Room startRoom;

    /**
    * Create the game and initialise its internal map.
    */
    public Game() {
        createRooms();
        currentPlayer = new Player();
        currentPlayer.setCurrentRoom(startRoom);
        
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
        
        Key keyTheatreOutside, keyOutsideTheatre;

        //INSTANCIATION //THIS IS AN EXEMPLE (to define a syntax that we will use in the future)

        // create the rooms
        roomOutside=new Room("main entrance of the university");
        roomTheatre = new Room("lecture theatre");
        roomPub = new Room("campus pub");
        roomLab = new Room("computing lab");
        

        // initialise room exits (doors)
        doorOutsidePub = new PasswordLockedExitRoom(roomOutside, roomPub, "azertyuiop");
        doorPubOutside = new PasswordLockedExitRoom(roomPub, roomOutside, "azertyuiop");

        doorOutsideTheatre = new KeyLockedExitRoom(roomOutside, roomTheatre);
        doorTheatreOutside = new KeyLockedExitRoom(roomTheatre, roomOutside);
        doorOutsideLab = new ExitRoom(roomOutside, roomLab);
        doorLabOutside = new ExitRoom(roomLab, roomOutside);

        //associating doors with rooms
        roomOutside.addExit("north", doorOutsideTheatre);
        roomOutside.addExit("south", doorOutsidePub);
        roomOutside.addExit("east", doorOutsideLab);

        roomTheatre.addExit("south",doorTheatreOutside);
        roomPub.addExit("north",doorPubOutside);
        roomLab.addExit("west", doorLabOutside);
        
      //create items //DEV info : move this lines to a method named 'creteItems' then call it here
        keyTheatreOutside = new Key("KeyTheatre","Allow to go outside",1, currentPlayer, doorTheatreOutside );
        keyOutsideTheatre = new Key("KeyOutsideTheatre","Allow to go to theatre",1, currentPlayer, doorOutsideTheatre );
        Food lambas = new Food("Lambas","miaaaam", 2, 30, currentPlayer);

        //adding item to rooms
        roomPub.addItem(keyTheatreOutside);
        roomPub.addItem(keyOutsideTheatre);
        roomTheatre.addItem(lambas);

        startRoom = roomOutside; // start game outside

        

    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
    }

    /**
     * Print out the opening message for the player.
     */
      private void printWelcome() {
        JOptionPane.showMessageDialog(null, "Welcome to the Lord of the Ring: A Frodo's Journey. You are Frodo and Bilbo gave you a strange ring. Gandalf revealed that it is the One Ring, the most powerful ring which belongs to Sauron, the Lord of Mordor. You are Frodo Baggins of the Shire. You must bring the Ring to Mordor to destroy it into the flames of Orodruin, the volcano at the north east of the mordor, house of the evil Sauron. Our game is a basic survival game. You must explore Middle Earth in order to find your way to Orodruin. Their will be many foes and obstacles on your way. But you carry the Ring which grants you the ability to be invisible. You need to be careful, prepare yourself to commit your life.", "Welcome", JOptionPane.PLAIN_MESSAGE);
    }

    
    
    public void win(){
    JOptionPane.showMessageDialog(null, "You dropped the Ring in the Mount Doom and you defeated Sauron and his armies. You accomplished your journey. Congratulations","Congratulations", JOptionPane.PLAIN_MESSAGE);
    }

    
  

      
}
