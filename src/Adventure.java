public class Adventure {

    private Player player;

    public Adventure(Map map) {
        this.player = new Player(map.getStartingRoom());
    }

    public String look() {
        return "You are in " + player.getCurrentRoom().getROOMNAME() + "\n" + player.getCurrentRoom().getDESCRIPTION();
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
            return "You moved to " + player.getCurrentRoom().getROOMNAME();
        } else {
            return "You cannot go that way!";
        }
    }
}