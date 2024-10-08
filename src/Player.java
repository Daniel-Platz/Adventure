import ItemPackage.EatStatus;
import ItemPackage.Food;
import ItemPackage.Items;
import ItemPackage.Weapon;

import java.util.ArrayList;

public class Player {
    private Rooms currentRoom;
    private ArrayList<Items> itemsInInventory;
    private int currentHealth;
    private Weapon equippedWeapon;

    public Player(Rooms startRoom) {
        this.currentRoom = startRoom;
        this.itemsInInventory = new ArrayList<>();
        this.currentHealth = 100;
        this.equippedWeapon = null;
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
            String inventoryList = "You have the following items in your inventory:\n";
            for (Items item : itemsInInventory) {
                inventoryList += "- " + item.getLongName() + "\n";
            }
            return inventoryList;
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public EatStatus eat(String itemName) {
        Items item = findItem(itemName);
        if (item == null) {
            item = currentRoom.findItem(itemName);
        }

        if (item == null) {
            return EatStatus.ITEM_NOT_FOUND;
        }

        if (item instanceof Food foodItem) {
            int healthRestored = foodItem.getHealthRestored();
            int actualHealthRestored = Math.min(healthRestored, 100 - currentHealth);  // Limit health restoration to 100

            currentHealth += actualHealthRestored;

            if (itemsInInventory.contains(item)) {
                itemsInInventory.remove(item);
            } else {
                currentRoom.removeItem(item);
            }

            return EatStatus.SUCCESS.setDetails(item.getLongName(), actualHealthRestored);
        } else {
            return EatStatus.NOT_EDIBLE;
        }
    }

    public String equipWeapon(String weaponName) {
        Items item = findItem(weaponName);

        if (item instanceof Weapon weaponItem) {
            equippedWeapon = weaponItem;
            return "You have equipped " + weaponItem.getLongName();
        } else {
            return weaponName + " can not be equipped - make sure you have the item in your inventory and that it is a weapon";
        }
    }

    public String attack() {
        if (equippedWeapon == null) {
            return "You don't have a weapon equipped";
        }
        if (equippedWeapon.remainingUses() == 0) {
            return "Your weapon is out of ammunition";
        }
        int damage = equippedWeapon.getDamage();
        equippedWeapon.use();

        return "You attacked with " + equippedWeapon.getLongName() + " for " + damage + " damage";

    }

    public Rooms getCurrentRoom() {
        return currentRoom;
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

    public Items findItem(String itemName) {
        for (Items item : itemsInInventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}