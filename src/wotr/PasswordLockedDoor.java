package wotr;
import java.util.Scanner;

import javax.swing.JOptionPane;

/** This class represent a door locked by a password.
 * The door will be characterized by the current room, the next room (room behind the door), and a password.
 * The user will enter a password and then there are two cases:
 * 	- it is the good password, the door is opened, the player can go forward
 * 	- it is not the good password, the door is still locked, the player is blocked in the room until he find the correct password.
 * 
 * @author G1
 * 
 *
 */


public class PasswordLockedDoor extends LockedDoor{
    private String password; //the password to cross the door


    /*
     * Constructor of the PasswordLockedDoor class
     * @param currentRoom : room where the player is
     * @param nextRoom : room behind the door
     * @param password: paswword required to open the door
     */
    public PasswordLockedDoor(Room currentRoom,Room nextRoom, String password)
    {
        super(currentRoom, nextRoom);
        this.password=password;
    }

    /*
     * Compare if the password entered by the player is the correct password
     * @param userPassword : password entered by the player
     * @return bool is true if the password is correct.
     */
    public boolean isCorrectPassword(String userPassword){
        return password.equals(userPassword);
    }

    /**
     * Ask user to confirm something by writing yes or no.
     * @return true if the user input yes. Else returns false .
     */
    public String inputUserPassword(){
        Scanner sc = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Type the password  to go  "+ super.getNextRoom(super.currentRoom)+" : "+ "\n", "Password", JOptionPane.PLAIN_MESSAGE);
        return sc.nextLine();
    }

    /**
     * Permit to go in the next room if the door is unlocked.
     * @param currentRoom
     * @return the next room or the current room
     */
    public Room getNextRoom(Room currentRoom)
    {
        if(super.getLocked()){
            String userPassword = inputUserPassword();
            if(isCorrectPassword(userPassword)){
                if (this.currentRoom!=currentRoom){
                    super.setLocked(false); //door will be still opened
                    return this.currentRoom;
                }
                else{
                    super.setLocked(false);//door will be still opened
                    //System.out.println("You opened the door with the password \"" + getPassword()+"\"");                  
                    return nextRoom;
                } 
            }
            else{
                //System.out.println("Wrong password, the door is still locked !");
                return null;
            }
        }
        else{//unlocked room 
            if (this.currentRoom!=currentRoom){
                return this.currentRoom;
            }
            else{
                return nextRoom;
            }
        }
    }

    /*
     * Return the password related to the door
     * @return the correct password.
     */
    public String getPassword(){
        return this.password;
    }
}
