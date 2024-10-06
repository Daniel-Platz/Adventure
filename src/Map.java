import ItemPackage.Food;
import ItemPackage.Items;

public class Map {
    public Rooms createRooms() {

        Rooms room1 = new Rooms("The Sanctum Tower.", "A towering, ancient structure reminiscent of Doctor Strange’s Sanctum Sanctorum. Mystical energies swirl through the air, with the faint hum of otherworldly magic.");
        Rooms room2 = new Rooms("The Asgardian Armory.", "The once-grand armory of Asgard, filled with broken relics and discarded weapons of the mighty gods. A faint glow from Mjolnir’s forgotten shards illuminates the chamber.");
        Rooms room3 = new Rooms("The Stark Quarters.", "An abandoned room with overturned furniture, resembling Tony Stark's workshop. A mysterious holographic marking hints at a hidden project left behind.");
        Rooms room4 = new Rooms("The Hydra Chains.", "Rusty chains dangle from the ceiling, engraved with the Hydra emblem. The room reeks of treachery, its walls bearing symbols of a sinister organization.");
        Rooms room5 = new Rooms("The Wakandan Vault.", "A treasure room glowing with the light of vibranium. The walls are etched with ancient Wakandan symbols, and a mysterious artifact radiates immense power.");
        Rooms room6 = new Rooms("The Quantum Tunnels.", "Dark, winding tunnels that stretch endlessly like the quantum realm. The echoes distort as if bouncing through different dimensions, making it hard to find your way.");
        Rooms room7 = new Rooms("The Guardian's Chamber.", "The personal quarters of a powerful being, perhaps an Elder of the Universe. It feels as though someone or something has been here recently.");
        Rooms room8 = new Rooms("The Nexus Corridor.", "A dimly lit passage, adorned with warnings about the dangers of tampering with the multiverse. It leads straight to the Vault of Wakanda, where powerful forces await.");
        Rooms room9 = new Rooms("The Fallen Bastion.", "Once a great fortress, now resembling the ruins of a battle between the Avengers and Thanos. The remnants of the struggle for the Infinity Stones still echo in the air.");

// Sanctum Tower (Doctor Strange's Sanctum)
        room1.addItemToRoom(new Items("Eye", "Eye of Agamotto"));
        room1.addItemToRoom(new Items("Cloak", "Cloak of Levitation"));
        room1.addItemToRoom(new Items("Wand", "Wand of Watoomb"));
        room1.addItemToRoom(new Items("Orb", "Astral Orb"));
        room1.addItemToRoom(new Food("Berries", "Chitauri Berries", 10));

// Asgardian Armory (Asgardian relics)
        room2.addItemToRoom(new Items("Shards", "Mjolnir Shards"));
        room2.addItemToRoom(new Items("Helmet", "Asgardian Helmet"));
        room2.addItemToRoom(new Items("Spear", "Odin's Spear Fragment"));
        room2.addItemToRoom(new Items("Gauntlet", "Valkyrie’s Gauntlet"));
        room2.addItemToRoom(new Food("Bread", "Lembas Bread", 8));

// Stark Quarters (Tony Stark’s abandoned workshop)
        room3.addItemToRoom(new Items("Reactor", "Arc Reactor"));
        room3.addItemToRoom(new Items("Gauntlet", "Iron Man Gauntlet"));
        room3.addItemToRoom(new Items("Projector", "Hologram Projector"));
        room3.addItemToRoom(new Items("Glove", "Repulsor Glove"));
        room3.addItemToRoom(new Food("Cheese", "Stark Cheese", 15));

// Hydra Chains (Hydra's sinister secrets)
        room4.addItemToRoom(new Items("Dagger", "Hydra Dagger"));
        room4.addItemToRoom(new Items("Tesseract", "Tesseract Fragment"));
        room4.addItemToRoom(new Items("Arm", "Winter Soldier's Arm"));
        room4.addItemToRoom(new Food("Rations", "Hydra Rations", 5));

// Wakandan Vault (Vibranium treasures)
        room5.addItemToRoom(new Items("Chest", "Vibranium Chest"));
        room5.addItemToRoom(new Items("Orb", "Soul Orb"));
        room5.addItemToRoom(new Items("Crown", "Panther Crown"));
        room5.addItemToRoom(new Food("Herb", "Heart-Shaped Herb", 50));

// Quantum Tunnels (Quantum Realm exploration)
        room6.addItemToRoom(new Items("Vial", "Pym Particle Vial"));
        room6.addItemToRoom(new Items("Suit", "Quantum Suit"));
        room6.addItemToRoom(new Items("Helmet", "Ant-Man's Helmet"));
        room6.addItemToRoom(new Items("Map", "Time Vortex Map"));
        room6.addItemToRoom(new Food("Mushroom", "Quantum Mushroom", 10));

// Guardian’s Chamber (Cosmic entity’s chamber)
        room7.addItemToRoom(new Items("Necklace", "Ego’s Necklace"));
        room7.addItemToRoom(new Items("Box", "The Collector’s Box"));
        room7.addItemToRoom(new Food("Rations", "Celestial Ration Pack", 25));

// Nexus Corridor (Multiverse warnings)
        room8.addItemToRoom(new Items("Shield", "Captain America’s Shield"));
        room8.addItemToRoom(new Items("Key", "Multiverse Key"));
        room8.addItemToRoom(new Items("Compass", "Dimensional Compass"));
        room8.addItemToRoom(new Food("Root", "Bitter Root", 12));

// Fallen Bastion (Ruins of the Infinity War battle)
        room9.addItemToRoom(new Items("Gauntlet", "Infinity Gauntlet"));
        room9.addItemToRoom(new Items("Stone", "Broken Infinity Stone"));
        room9.addItemToRoom(new Items("Fragment", "Stormbreaker Fragment"));
        room9.addItemToRoom(new Items("Commlink", "Avengers Commlink"));
        room9.addItemToRoom(new Food("Provisions", "Battle Provisions", 18));


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

        return room1;
    }
}