
import java.util.Scanner;

public class UserInterface {

    public UserInterface(Adventure game){
    }

    public String getInput() {
        Scanner brugerInput = new Scanner(System.in);
        System.out.print("Enter a command: ");
        return brugerInput.nextLine();
    }
    public void print(String message) {
        System.out.println(message);
    }
}



