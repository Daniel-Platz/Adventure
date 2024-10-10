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

    // Method for taking an item from the current room
    public String takeItem(String itemName) {
        Items item = currentRoom.findItem(itemName);
        if (item != null) {
            itemsInInventory.add(item);
            currentRoom.removeItem(item);
            return "You carefully pick up " + item.getLongName() + " and stash it into your inventory.";
        } else {
            return "After searching the room, you find no trace of " + itemName + ". Perhaps you missed it.";
        }
    }

    // Method for dropping an item from inventory into the current room
    public String dropItem(String itemName) {
        Items item = findItem(itemName);
        if (item != null) {
            itemsInInventory.remove(item);
            currentRoom.addItemToRoom(item);
            return "You drop " + item.getLongName() + " to the floor. It lands with a soft thud.";
        } else {
            return "You rummage through your inventory but cannot find anything called " + itemName + ".";
        }
    }

    // Displays player's inventory with equipped weapon (if any)
    public String showInventory() {
        if (itemsInInventory.isEmpty()) {
            return "Your inventory is empty. Perhaps it's time to collect some items.";
        } else {
            String inventoryList = "You glance into your inventory and see the following items:\n";
            for (Items item : itemsInInventory) {
                inventoryList += "- " + item.getLongName() + "\n";
            }
            if (equippedWeapon != null) {
                inventoryList += "You are wielding " + equippedWeapon.getLongName() + " as your primary weapon.";
            } else {
                inventoryList += "You currently have no weapon equipped.";
            }
            return inventoryList;
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    // Method for eating food, if found, and restoring health
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

            // Remove food from inventory or room after eating
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

    // Equips a weapon if found in the inventory
    public String equipWeapon(String weaponName) {
        Items item = findItem(weaponName);

        if (item instanceof Weapon weaponItem) {
            equippedWeapon = weaponItem;
            return "You equip " + weaponItem.getLongName() + ", feeling its weight settle comfortably in your grip.";
        } else {
            return weaponName + " doesn't seem to be a weapon, or it's not in your inventory. Check again.";
        }
    }

    // Attack method for dealing damage to an enemy and managing combat
    public String attack(String enemyName) {
        Enemies enemy;
        if (enemyName != null && !enemyName.isEmpty()) {
            enemy = currentRoom.findEnemy(enemyName);
            if (enemy == null) {
                return "You search the room, but there’s no sign of " + enemyName + ". Shadows flicker, but nothing emerges.";
            }
        } else {
            if (currentRoom.getEnemiesInRoom().isEmpty()) {
                equippedWeapon.use();
                return "Your attack hits nothing but empty air.";
            }
            enemy = currentRoom.getEnemiesInRoom().get(0);
        }

        if (equippedWeapon == null) {
            return "You don't have a weapon equipped. Fighting unarmed could be deadly.";
        }
        if (equippedWeapon.remainingUses() == 0) {
            return "Your " + equippedWeapon.getLongName() + " is out of ammunition, leaving you vulnerable.";
        }

        int damage = equippedWeapon.getDamage();
        int currentEnemyHealth = enemy.getEnemyHealth() - damage;
        equippedWeapon.use();
        enemy.setEnemyHealth(currentEnemyHealth);

        String result;

        if (currentEnemyHealth > 0) {
            result = "You strike " + enemy.getEnemyName() + " with " + equippedWeapon.getLongName()
                    + ", dealing " + damage + " damage. "
                    + enemy.getEnemyName() + " now has " + currentEnemyHealth + " health remaining.";

            int enemyDamage = enemy.getWeapon().getDamage();
            currentHealth -= enemyDamage;

            if (currentHealth > 0) {
                result += " The " + enemy.getEnemyName() + " counterattacks, landing a blow that deals " + enemyDamage
                        + " damage. You now have " + getCurrentHealth() + " health left.";
            } else {
                result += " The " + enemy.getEnemyName() + " strikes back viciously and you fall to the ground, defeated.";
            }

        } else {
            currentRoom.addItemToRoom(enemy.getWeapon());
            currentRoom.removeEnemy(enemy);
            result = "With a final blow, you defeat " + enemy.getEnemyName()
                    + ". Their weapon, " + enemy.getWeapon().getLongName() + ", drops to the ground.";
        }

        return result;
    }

    public Rooms getCurrentRoom() {
        return currentRoom;
    }

    // Moves player in the specified direction
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

    // Finds an item in the player's inventory
    public Items findItem(String itemName) {
        for (Items item : itemsInInventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}