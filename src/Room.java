import java.util.ArrayList;

public class Room {

    private final String ROOMNAME;
    private final String DESCRIPTION;
    private Room north, south, east, west;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();

    public Room(String roomName, String description) {
        this.ROOMNAME = roomName;
        this.DESCRIPTION = description;
    }

    public String getROOMNAME() {
        return ROOMNAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public void addItemToRoom(String itemName) {
        itemsInRoom.add(new Item(itemName));
    }

    public Item findItem(String partialName) {
        for (Item item : itemsInRoom) {
            if (item.getItemName().toLowerCase().contains(partialName.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public Item takeItem(String itemName) {
        for (Item item : new ArrayList<>(itemsInRoom)) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemsInRoom.remove(item);
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
}