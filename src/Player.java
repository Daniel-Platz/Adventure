import java.util.ArrayList;

public class Player {
    private Rooms currentRoom;
    private ArrayList<Items> itemsInInventory;

    public Player(Rooms startRoom) {
        this.currentRoom = startRoom;
        this.itemsInInventory = new ArrayList<>();
    }

    public String takeItem(String itemName) {
        Items item = currentRoom.findItem(itemName);
        if (item != null) {
            itemsInInventory.add(item);
            currentRoom.removeItem(item);
            return "You took: " + item.getLongName();
        } else {
            return "There is nothing like " + itemName + " in this room.";
        }
    }

    public String dropItem(String itemName) {
        Items item = findItem(itemName);
        if (item != null) {
            itemsInInventory.remove(item);
            currentRoom.addItemToRoom(item);
            return "You dropped: " + item.getLongName();
        } else {
            return "There is nothing like " + itemName + " in your inventory.";
        }
    }

    public String showInventory() {
        if (itemsInInventory.isEmpty()) {
            return "There are no items in your inventory.";
        } else {
            StringBuilder inventoryList = new StringBuilder("You have the following items in your inventory:\n");
            for (Items item : itemsInInventory) {
                inventoryList.append("- ").append(item.getLongName()).append("\n");
            }
            return inventoryList.toString();
        }
    }

    public Rooms getCurrentRoom() {
        return currentRoom;
    }

    public Items findItem(String itemName) {
        for (Items item : itemsInInventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public boolean move(String direction) {
        Rooms nextRoom = null;

        switch (direction.toLowerCase()) {
            case "north", "n" -> nextRoom = currentRoom.getNorth();
            case "east", "e" -> nextRoom = currentRoom.getEast();
            case "south", "s" -> nextRoom = currentRoom.getSouth();
            case "west", "w" -> nextRoom = currentRoom.getWest();
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        } else {
            return false;
        }
    }
}