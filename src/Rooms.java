import ItemPackage.Items;
import java.util.ArrayList;

public class Rooms {

    private String roomName;
    private String roomDescription;
    private Rooms north, south, east, west;
    private ArrayList<Items> itemsInRoom;
    private ArrayList<Enemies> enemiesInRoom;

    public Rooms(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.itemsInRoom = new ArrayList<>();
        this.enemiesInRoom = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        String description = roomDescription;

        // Add items to description
        if (!itemsInRoom.isEmpty()) {
            description += "\n\nAs you scan the room, you notice the following items scattered around:";
            for (Items item : itemsInRoom) {
                description += "\n- " + item.getLongName() + " lies here, waiting to be taken.";
            }
        } else {
            description += "\nThere are no items in sight, but the room's atmosphere feels heavy with mystery.";
        }

        // Add enemies to description
        if (!enemiesInRoom.isEmpty()) {
            description += "\n\nYour eyes lock onto the following enemies in the room, each one a potential threat:";
            for (Enemies enemy : enemiesInRoom) {
                description += "\n- " + enemy.getEnemyName() + ", " + enemy.getEnemyDescription() + ". This enemy looks dangerous with " + enemy.getEnemyHealth() + " health remaining.";
            }
        } else {
            description += "\n\nThe room feels eerily quiet; no enemies seem to be present, for now.";
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

    public void addEnemyToRoom(Enemies enemy) {
        enemiesInRoom.add(enemy);
    }

    public ArrayList<Enemies> getEnemiesInRoom() {
        return enemiesInRoom;
    }

    public void removeEnemy(Enemies enemy) {
        enemiesInRoom.remove(enemy);
    }

    public Enemies findEnemy(String enemyName) {
        for (Enemies enemy : enemiesInRoom) {
            if (enemy.getEnemyName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    // Room navigation methods
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