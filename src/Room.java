public class Room {

    private final String ROOMNAME;
    private final String DESCRIPTION;
    private Room north, south, east, west;

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
}