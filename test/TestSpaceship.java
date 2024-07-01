package test;
import objects.Bomber;
import objects.Fighter;
import org.testng.annotations.Test;
import objects.Spaceship;

import java.io.IOException;

public class TestSpaceship {

    @Test
    public void testBomberAttributes() throws IOException {
        Spaceship spaceship = new Spaceship(100, 100, "assets/Bomber-removebg-preview.png");
        Bomber bomber = new Bomber(200, 200);
        System.out.println("Bomber created at position (" + bomber.getX() + ", " + bomber.getY() + ")");
        System.out.println("Bomber Health: " + bomber.getHealth());
        System.out.println("Bomber Shield: " + bomber.getShield());
        System.out.println("Bomber Speed: " + bomber.getSpeed());
        System.out.println("Bomber Damage: " + bomber.getDamage());
        System.out.println("Bomber Fire Rate: " + bomber.getFireRate());
        System.out.println("Bomber Agility: " + bomber.getAgility());
        System.out.println("Bomber Special Ability: " + bomber.getSpecialAbility());
        System.out.println("Bomber Weapon Type: " + bomber.getWeaponType());
        System.out.println("Bomber Armor: " + bomber.getArmor());
        System.out.println("Bomber Size: " + bomber.getSize());

    }

    @Test
    public void testFighterAttributes() throws IOException {
        Spaceship spaceship = new Spaceship(100, 100, "assets/Spaceship.png");
        Fighter fighter = new Fighter(80, 80);
        System.out.println("Fighter created at position (" + fighter.getX() + ", " + fighter.getY() + ")");
        System.out.println("Fighter Health: " + fighter.getHealth());
        System.out.println("Fighter Shield: " + fighter.getShield());
        System.out.println("Fighter Speed: " + fighter.getSpeed());
        System.out.println("Fighter Damage: " + fighter.getDamage());
        System.out.println("Fighter Fire Rate: " + fighter.getFireRate());
        System.out.println("Fighter Agility: " + fighter.getAgility());
        System.out.println("Fighter Special Ability: " + fighter.getSpecialAbility());
        System.out.println("Fighter Weapon Type: " + fighter.getWeaponType());
        System.out.println("Fighter Armor: " + fighter.getArmor());
        System.out.println("Fighter Size: " + fighter.getSize());


    }
}

