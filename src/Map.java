public class Map {

    private Room startingRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {

        Room room1 = new Room("The Outer Watchtower", "A tall, crumbling tower overlooking the distant lands. The wind howls through the open windows, carrying whispers of danger ahead. ");
        Room room2 = new Room("The Forgotten Armory", "Rusted weapons and shattered shields lie scattered. A faint glow emanates from a weapon long forgotten, but something feels off. ");
        Room room3 = new Room("The Warden’s Quarters", "An abandoned room with overturned furniture. A strange marking on the wall hints at a secret once kept here. ");
        Room room4 = new Room("The Hall of Chains", "Rusty chains dangle from the ceiling, and the walls are covered with ancient inscriptions. The air is thick with past suffering. ");
        Room room5 = new Room("The Vault of Eternity", "This treasure room is vast and illuminated by an eerie golden light. A massive chest sits in the center, but reaching it feels like disturbing something sacred. ");
        Room room6 = new Room("The Echoing Tunnels", "Dark, winding tunnels that stretch endlessly. Every sound bounces back twice as loud, making it impossible to tell where the danger lies. ");
        Room room7 = new Room("The Keeper’s Chamber", "The personal quarters of a long-forgotten guardian. It’s as if someone was here recently, and their presence lingers. ");
        Room room8 = new Room("The Guardian’s Passage", "A narrow, dimly lit corridor with carvings warning of dangers ahead. This passage is the only way into the Vault of Eternity. ");
        Room room9 = new Room("The Fallen Bastion", "Once a great fortress, now crumbled into ruins. The floor is littered with debris, and signs of a fierce battle still remain. ");

        room1.addItemToRoom("A cracked spyglass");
        room1.addItemToRoom("A rusted telescope");

        room2.addItemToRoom("A glowing sword");
        room2.addItemToRoom("A forgotten helmet");

        room3.addItemToRoom("A cracked mirror");

        room4.addItemToRoom("A broken ceremonial dagger");

        room5.addItemToRoom("A massive treasure chest");
        room5.addItemToRoom("A glowing orb");
        room5.addItemToRoom("A jeweled crown");

        room7.addItemToRoom("A dusty cloak");

        room8.addItemToRoom("A cracked shield");

        room9.addItemToRoom("A shattered sword");


        room1.setSouth(room4);
        room1.setEast(room2);

        room2.setEast(room3);
        room2.setWest(room1);

        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);

        startingRoom = room1;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }
}
