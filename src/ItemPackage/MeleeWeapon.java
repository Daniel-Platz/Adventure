

package ItemPackage;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName, int damage, int remainingUses) {
        super(shortName, longName, damage, remainingUses);
    }

    @Override
    public int remainingUses () {
        return -1;
    }
}


