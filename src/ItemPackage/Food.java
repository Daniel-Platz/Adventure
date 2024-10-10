package ItemPackage;

public class Food extends Items {

    private int healthRestored;

    public Food(String shortName, String longName, int healthRestored) {
        super(shortName, longName);
        this.healthRestored = healthRestored;
    }

    public int getHealthRestored() {
        return healthRestored;
    }
}