package objects;

//import java.io.IOException;

import java.io.IOException;

public class Bomber extends Spaceship {
    public Bomber(double x, double y)  throws IOException {
        super(60, 20, "src/main/java/assets/Bomber-removebg-preview.png");
        setWidth(100);
        setHeight(100);
        setHealth(200);
        setShield(100);
        setSpeed(100);
        setDamage(50);
        setFireRate(0.5);
        setAgility("Low");
        setSpecialAbility("Shield Boost");
        setWeaponType("Bombs");
        setArmor("Heavy");
        setSize("Large");
    }
}