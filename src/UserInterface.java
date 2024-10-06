import java.util.Scanner;

public class UserInterface {

    public UserInterface(Adventure game){
    }

    public String getInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a command: ");
        return userInput.nextLine();
    }
    public void print(String message) {
        System.out.println(message);
    }
}



