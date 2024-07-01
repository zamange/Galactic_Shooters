package objects;

import java.io.IOException;

public class Fighter extends Spaceship {
    public Fighter(double x, double y) throws IOException {
        super(0, 0, "assets/Spaceship.png");
        setWidth(80);
        setHeight(80);
        setHealth(100);
        setShield(50);
        setSpeed(200);
        setDamage(20);
        setFireRate(1); //shot per second
        setAgility("High"); //quick turns and maneuvers
        setSpecialAbility("Rapid Fire");
        setWeaponType("Laser beams");
        setArmor("Light");
        setSize("Small");
    }
}