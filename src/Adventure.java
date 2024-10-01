import java.util.ArrayList;

public class Adventure {

    private final Player player;

    public Adventure(Map map) {
        player = new Player(map.getStartingRoom());
    }

    public String look() {
        String itemsDescription;
        if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
            itemsDescription = "There are no items in this room";
        } else {
            itemsDescription = "The following items are in the room: " + player.getCurrentRoom().getItemsInRoom();
        }

        return "You are in " + player.getCurrentRoom().getROOMNAME() + "\n" + player.getCurrentRoom().getDESCRIPTION() + "\n" + itemsDescription;
    }

    public Item take(String itemName) {
        Item item = player.getCurrentRoom().findItem(itemName);
        if (item != null) {
            player.getCurrentRoom().getItemsInRoom().remove(item);
            player.getItemsInInventory().add(item);
            return item;
        }
        return null;
    }

    public Item drop(String itemName) {
        return player.dropItem(itemName);
    }

    public ArrayList<Item> inventory() {
        return player.getItemsInInventory();
    }

    public String move(String direction) {
        Room nextRoom;
        switch (direction) {
            case "north" -> {
                nextRoom = player.getCurrentRoom().getNorth();
            }
            case "south" -> {
                nextRoom = player.getCurrentRoom().getSouth();
            }
            case "east" -> {
                nextRoom = player.getCurrentRoom().getEast();
            }
            case "west" -> {
                nextRoom = player.getCurrentRoom().getWest();
            }
            default -> {
                return "Invalid direction.";
            }
        }

        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            String itemsDescription;
            if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                itemsDescription = "There are no items in this room.";
            } else {
                itemsDescription = "Items in this room: " + player.getCurrentRoom().getItemsInRoom().toString();
            }

            return "You moved to " + player.getCurrentRoom().getROOMNAME() + "\n"
                    + player.getCurrentRoom().getDESCRIPTION() + "\n" + itemsDescription;
        } else {
            return "You cannot go that way!";
        }
    }
}