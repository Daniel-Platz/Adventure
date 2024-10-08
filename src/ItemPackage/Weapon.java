package ItemPackage;

public class Weapon extends Items {

    private int damage;
    private int remainingUses;

    public Weapon(String shortName, String longName, int damage, int remainingUses) {
        super(shortName, longName);
        this.damage = damage;
        this.remainingUses = remainingUses;

    }

    public int getDamage() {
        return damage;
    }

    public int remainingUses() {
        return remainingUses;
    }

    public void use() {
        if (remainingUses > 0) {
            remainingUses--;
        }
    }


}
