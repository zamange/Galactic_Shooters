package objects;

public class Bomber implements ShipAttributes{
    private static double health = 200;
    private static double shield = 100;
    private static int speed = 200;
    private static double damage = 10;
    private static  int width = 100;
    private static int height = 80;

//    @Override
//    public void Health() {
//
//
//    }

//    @Override
//    public void Shield() {
//
//    }
//
//    @Override
//    public void Speed() {
//
//    }
//
//    @Override
//    public void Damage() {
//
//    }

    @Override
    public void FireRate() {

    }

    @Override
    public void SpecialAbility() {

    }

    @Override
    public void WeaponType() {

    }



    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static int getSpeed() {
        return speed;
    }

    public static double getDamage() {
        return damage;
    }

    public static double getHealth() {
        return health;
    }

    public static double getShield() {
        return shield;
    }
}
