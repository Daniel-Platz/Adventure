import ItemPackage.EatStatus;

public class Adventure {
    private Player player;
    private UserInterface ui;

    public Adventure() {
        Map map = new Map();
        Rooms startingRoom = map.createRooms();
        player = new Player(startingRoom);
        ui = new UserInterface(this);
    }

    public void startGame() {
        ui.print("""
                Welcome to Guardians of the Nexus!
                Before we get started, here is a list of useful commands:
                look
                take
                drop
                eat
                health
                inventory
                equip
                go [north, south, east, west]
                exit
                help
                """);
        ui.print("You currently find yourself in " + player.getCurrentRoom().getRoomName() + " " + player.getCurrentRoom().getRoomDescription());

        boolean isRunning = true;

        while (isRunning) {
            String userInput = ui.getInput();
            String[] userChoice = userInput.split(" ");
            String command = userChoice[0];

            switch (command.toLowerCase()) {
                case "exit" -> {
                    ui.print("Exiting game");
                    isRunning = false;
                }
                case "help" -> {
                    ui.print("Here is a list of commands: look, take, drop, eat, health, inventory, equip, go [north, south, east, west], exit, help");
                }
                case "look" -> {
                    ui.print(player.getCurrentRoom().getRoomDescription());
                }
                case "go" -> {
                    if (userChoice.length > 1) {
                        ui.print(movePlayer(userChoice[1]));
                    } else {
                        ui.print("Please specify a direction (north, east, south, west).");
                    }
                }
                case "take" -> {
                    if (userChoice.length > 1) {
                        ui.print(player.takeItem(userChoice[1]));
                    } else {
                        ui.print("Please specify the item you want to take.");
                    }
                }
                case "drop" -> {
                    if (userChoice.length > 1) {
                        ui.print(player.dropItem(userChoice[1]));
                    } else {
                        ui.print("Please specify the item you want to drop.");
                    }
                }
                case "eat" -> {
                    if (userChoice.length > 1) {
                        EatStatus status = player.eat(userChoice[1]);
                        handleEatStatus(status);
                    } else {
                        ui.print("Please specify the item you want to eat.");
                    }
                }
                case "equip" -> {
                    if (userChoice.length > 1) {
                        ui.print(player.equipWeapon(userChoice[1]));
                    } else {
                        ui.print("Please specify the weapon you want to equip");
                    }
                }
                case "attack" -> {
                    ui.print(player.attack());
                }
                case "health" -> {
                    ui.print("Your current health is at: " + player.getCurrentHealth() + "/100");
                }
                case "inventory", "inv", "i" -> {
                    ui.print(player.showInventory());
                }
                default -> {
                    ui.print("Unknown command. Type 'help' for a list of commands.");
                }
            }
        }
    }

    public String movePlayer(String direction) {
        boolean moved = player.move(direction);
        if (moved) {
            return "You are now in: " + player.getCurrentRoom().getRoomName() + "\n" + player.getCurrentRoom().getRoomDescription();
        } else {
            return "That way is blocked.";
        }
    }

    public void handleEatStatus(EatStatus status) {
        switch (status) {
            case SUCCESS ->
                    ui.print("You ate " + status.getItemLongName() + " and restored " + status.getHealthRestored() + " health. Current health: " + player.getCurrentHealth() + "/100.");
            case ITEM_NOT_FOUND -> ui.print("There's nothing like that to eat.");
            case NOT_EDIBLE -> ui.print("You cannot eat that.");
        }
    }
}
