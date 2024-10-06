package ItemPackage;

public enum EatStatus {
    SUCCESS,
    ITEM_NOT_FOUND,
    NOT_EDIBLE;

    private String itemLongName;
    private int healthRestored;


    public EatStatus setDetails(String itemLongName, int healthRestored) {
        this.itemLongName = itemLongName;
        this.healthRestored = healthRestored;
        return this;
    }

    public String getItemLongName() {
        return itemLongName;
    }

    public int getHealthRestored() {
        return healthRestored;
    }
}