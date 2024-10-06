import ItemPackage.Items;

import java.util.ArrayList;

public class Rooms {

    private String roomName;
    private String roomDescription;
    private Rooms north, south, east, west;
    private ArrayList<Items> itemsInRoom;

    public Rooms(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.itemsInRoom = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        String description = roomDescription;

        if (!itemsInRoom.isEmpty()) {
            description += "\nItems in the room:\n\t";
            for (Items item : itemsInRoom) {
                description += item.getLongName() + "\n\t";
            }
        } else {
            description += "\nThere are no items in this room.";
        }
        return description;
    }

    public void addItemToRoom(Items item) {
        itemsInRoom.add(item);
    }

    public void removeItem(Items item) {
        itemsInRoom.remove(item);
    }

    public Items findItem(String itemName) {
        for (Items item : itemsInRoom) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void setNorth(Rooms north) {
        this.north = north;
    }

    public void setSouth(Rooms south) {
        this.south = south;
    }

    public void setEast(Rooms east) {
        this.east = east;
    }

    public void setWest(Rooms west) {
        this.west = west;
    }

    public Rooms getNorth() {
        return north;
    }

    public Rooms getSouth() {
        return south;
    }

    public Rooms getEast() {
        return east;
    }

    public Rooms getWest() {
        return west;
    }
}