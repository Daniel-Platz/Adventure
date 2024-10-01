import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> itemsInInventory = new ArrayList<>();

    public Player(Room startingRoom) {
        currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    public ArrayList<Item> getItemsInInventory() {
        return itemsInInventory;
    }

    public Item dropItem(String partialName) {
        for (Item item : new ArrayList<>(itemsInInventory)) {
            if (item.getItemName().toLowerCase().contains(partialName.toLowerCase())) {
                itemsInInventory.remove(item);
                currentRoom.addItemToRoom(item.getItemName());
                return item;
            }
        }
        return null;
    }
}