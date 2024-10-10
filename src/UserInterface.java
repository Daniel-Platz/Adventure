import java.util.Scanner;

public class UserInterface {

    public UserInterface(Adventure game) {
    }

    // Retrieves user input from the console
    public String getInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a command: ");
        return userInput.nextLine();
    }

    // Prints messages to the console
    public void print(String message) {
        System.out.println(message);
    }
}