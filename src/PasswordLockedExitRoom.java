import java.util.Scanner;
public class PasswordLockedExitRoom extends LockedExitRoom{
    private String password; //the password to cross the door



    public PasswordLockedExitRoom(Room currentRoom,Room nextRoom, String password)
    {
        super(currentRoom, nextRoom);
        this.password=password;
    }

    private boolean isCorrectPassword(String userPassword){
        return password.equals(userPassword);
    }

    /**
     * Ask user to confirm something by writing yes or no.
     * @return true if the user input yes. Else returns false .
     */
    public  String inputUserPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the password  to go  "+ super.getNextRoom(super.currentRoom)+" : "+ "\n");
        
        return sc.nextLine();
        
    }

    /**
     * getNextRoom
     * @param currentRoom
     * @return 
     */
    public Room getNextRoom(Room currentRoom)
    {
        if(super.locked){
            String userPassword = inputUserPassword();
            if(isCorrectPassword(userPassword)){
                if (this.currentRoom!=currentRoom){
                    super.locked=false; //door will be still opened
                    return this.currentRoom;
                }
                else{
                    super.locked=false;//door will be still opened
                    System.out.println("You opened the door with the password \"" + getPassword()+"\"");                  
                    return nextRoom;
                } 
            }
            else{
                System.out.println("Wrong password, the door is still locked !");
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

    private String getPassword(){
        return this.password;
    }
}
