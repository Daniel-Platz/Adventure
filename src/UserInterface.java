import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private Scanner scanner;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean isRunning = true;

        System.out.println("Welcome to the The Guardian’s Path!" + "\nHere is a list of commands which can be used in the game: look, go [north, south, east, west], exit." + "\nIn case you need any help - Type 'help' for a list of commands.");
        while (isRunning) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "look" -> {
                    System.out.println(adventure.look());
                }
                case "help" -> {
                    System.out.println("List of commands: look, go [north, south, east, west], exit");
                }
                case "exit" -> {
                    System.out.println("Exiting the game.");
                    isRunning = false;
                }
                case "go north", "north", "n" -> {
                    System.out.println(adventure.move("north"));
                }
                case "go south", "south", "s" -> {
                    System.out.println(adventure.move("south"));
                }
                case "go east", "east", "e" -> {
                    System.out.println(adventure.move("east"));
                }
                case "go west", "west", "w" -> {
                    System.out.println(adventure.move("west"));
                }
                default -> {
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
                }
            }
        }
    }
}