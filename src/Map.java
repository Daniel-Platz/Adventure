import ItemPackage.*;

public class Map {
    // Method to create and connect rooms
    public Rooms createRooms() {

        // Define all the rooms with their names and descriptions
        Rooms room1 = new Rooms("The Sanctum Tower", "A towering, ancient structure reminiscent of Doctor Strange’s Sanctum Sanctorum. Mystical energies swirl through the air, with the faint hum of otherworldly magic.");
        Rooms room2 = new Rooms("Stark Tech Lab", "A cutting-edge laboratory filled with glowing screens, advanced gadgets, and Iron Man suits in various stages of construction. The hum of arc reactors fills the air, and you can almost hear Tony Stark’s voice guiding you through the latest tech marvels.");
        Rooms room3 = new Rooms("The Bifrost Bridge", "A shimmering, rainbow bridge stretches across the void, connecting realms beyond imagination. The air crackles with the power of Asgardian magic, and the distant sound of Thor's hammer echoes from unseen battlefields.");
        Rooms room4 = new Rooms("The Savage Land Jungle", "Thick, prehistoric foliage surrounds you as the dense jungle of the Savage Land comes alive with the sounds of ancient beasts. A subtle warmth in the air suggests the presence of life — or danger — nearby.");
        Rooms room5 = new Rooms("The Vault of Infinity", "A grand treasure room filled with the most sought-after relics of the universe. The Infinity Gauntlet sits on a pedestal at the center, glowing faintly. Gold and gems line the walls, but the true power here lies in the artifacts of unimaginable cosmic force.");
        Rooms room6 = new Rooms("The Helicarrier Hangar", "High above the clouds, the S.H.I.E.L.D. Helicarrier floats silently. The hangar bay opens up to a vast sky, with jet fighters and high-tech weaponry at the ready. The sense of duty and covert missions fills the air, as agents move about on secret assignments.");
        Rooms room7 = new Rooms("Wakandan Panther Shrine", "The sacred heart of Wakanda, where the spirit of the Black Panther reigns. Statues of panthers guard the shrine, and vibrant, glowing vibranium illuminates the ancient stone carvings. A sense of honor and responsibility permeates this hallowed ground.");
        Rooms room8 = new Rooms("Quantum Realm Nexus", "Time and space bend around you in this surreal, mind-bending environment. Floating objects and distorted light shift unpredictably as if reality itself is being unraveled. Ant-Man's experiments with the quantum realm left this nexus as a gateway to possibilities untold.");
        Rooms room9 = new Rooms("The Dark Dimension", "The dark and twisted dimension ruled by Dormammu. Strange, chaotic forces pull at your very being, and shadows seem to move of their own");

        //Generic items
        room1.addItemToRoom(new Items("scroll", "An ancient scroll filled with arcane runes."));
        room2.addItemToRoom(new Items("reactor", "A glowing arc reactor, pulsating with energy."));
        room3.addItemToRoom(new Items("sword", "A shard of Heimdall’s sword, still resonating with power."));
        room4.addItemToRoom(new Items("bone", "A large, fossilized bone from a prehistoric creature."));
        room5.addItemToRoom(new Items("shard", "A shard of one of the fabled Infinity Stones, radiating immense power."));
        room6.addItemToRoom(new Items("shield", "A folder of classified S.H.I.E.L.D. documents."));
        room7.addItemToRoom(new Items("statue", "A small panther statue made of pure vibranium."));
        room8.addItemToRoom(new Items("vial", "A vial containing a mysterious quantum substance."));
        room9.addItemToRoom(new Items("mirror", "A cursed mirror from the Dark Dimension, distorting reflections."));

        //Food items
        room1.addItemToRoom(new Food("apple", "A glowing apple imbued with magical properties.", 20));
        room2.addItemToRoom(new Food("bar", "A high-tech energy bar, providing a quick boost of stamina.", 15));
        room3.addItemToRoom(new Food("ale", "A strong drink from Asgard, known to heal minor wounds.", 10));
        room4.addItemToRoom(new Food("meat", "Cooked meat from a prehistoric beast, restoring energy.", 30));
        room5.addItemToRoom(new Food("bread", "A loaf of bread that shimmers with cosmic energy.", 25));
        room6.addItemToRoom(new Food("rations", "Standard issue S.H.I.E.L.D. field rations, practical but effective.", 15));
        room7.addItemToRoom(new Food("herb", "A rare herb from Wakanda, known for its healing properties.", 40));
        room8.addItemToRoom(new Food("soup", "A swirling bowl of quantum particles, strangely nutritious.", 20));
        room9.addItemToRoom(new Food("fruit", "A fruit from the Dark Dimension, both dangerous and invigorating.", 35));

        //Ranged weapons
        room1.addItemToRoom(new RangedWeapon("blast", "A weaponized magical artifact capable of firing energy blasts.", 25, 5));
        room2.addItemToRoom(new RangedWeapon("glove", "A glove that shoots out repulsor beams, designed by Tony Stark.", 20, 6));
        room3.addItemToRoom(new RangedWeapon("arrow", "An arrow imbued with Bifrost energy, capable of hitting enemies from great distances.", 30, 3));
        room6.addItemToRoom(new RangedWeapon("pistol", "A standard-issue S.H.I.E.L.D. pistol, lightweight and effective.", 15, 10));
        room8.addItemToRoom(new RangedWeapon("blaster", "A blaster that shoots quantum particles, warping time and space.", 25, 4));

        //Melee weapons
        room3.addItemToRoom(new MeleeWeapon("hammer", "A powerful hammer forged in Asgard, capable of crushing enemies.", 35, -1));
        room4.addItemToRoom(new MeleeWeapon("axe", "A crude axe made from the bone of a prehistoric beast.", 20, -1));
        room5.addItemToRoom(new MeleeWeapon("blade", "A blade forged from the power of the Infinity Stones, capable of devastating attacks.", 40, -1));
        room7.addItemToRoom(new MeleeWeapon("spear", "A lightweight but powerful spear made from vibranium, favored by Wakandan warriors.", 30, -1));
        room9.addItemToRoom(new MeleeWeapon("scythe", "A cursed scythe from the Dark Dimension, pulsing with malevolent energy.", 35, -1));

        //Enemies
        room1.addEnemyToRoom(new Enemies("Sorcerer", "A master of the mystic arts, drawing power from the Sanctum.", 50, new MeleeWeapon("arcane_staff", "A staff infused with magical energy.", 20, -1)));
        room2.addEnemyToRoom(new Enemies("Iron Drone", "A rogue Stark drone, designed for battle.", 40, new RangedWeapon("drone_cannon", "A powerful energy cannon mounted on the drone.", 25, 3)));
        room3.addEnemyToRoom(new Enemies("Asgardian Warrior", "A fierce warrior from Asgard, armed with godlike strength.", 60, new MeleeWeapon("warrior_sword", "A sword forged in Asgardian flames.", 30, -1)));
        room4.addEnemyToRoom(new Enemies("Savage Beast", "A prehistoric beast with razor-sharp claws, roaming the jungle.", 55, new MeleeWeapon("claws", "The razor-sharp claws of the beast.", 20, -1)));
        room6.addEnemyToRoom(new Enemies("S.H.I.E.L.D. Agent", "A highly trained agent, ready to defend the Helicarrier.", 45, new RangedWeapon("agent_gun", "A standard-issue firearm.", 15, 6)));
        room7.addEnemyToRoom(new Enemies("Wakandan Guard", "A loyal guard of the Panther Shrine, armed with vibranium weapons.", 50, new MeleeWeapon("vibranium_dagger", "A short but deadly vibranium dagger.", 25, -1)));
        room8.addEnemyToRoom(new Enemies("Quantum Wraith", "A creature born from the quantum realm, flickering in and out of existence.", 60, new RangedWeapon("wraith_bolt", "A bolt of quantum energy that distorts time.", 20, 5)));
        room9.addEnemyToRoom(new Enemies("Dark Minion", "A twisted being from the Dark Dimension, serving Dormammu.", 65, new MeleeWeapon("shadow_blade", "A blade of pure darkness.", 30, -1)));

        // Method to connect rooms
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