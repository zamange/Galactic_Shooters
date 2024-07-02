package objects;

import render.Renderable;
import render.Renderer;
import update.Updatable;
import update.Updater;
import entry.FramesPerSecond;
import entry.Input;
import entry.Widget;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spaceship implements Renderable, Updatable {
    private double width;
    private double height;
    private double x;
    private double y;
    private int health;
    private int shield;
    private double speed;
    private double damage;
    private double fireRate;
    private String agility;
    private String specialAbility;
    private String weaponType;
    private String armor;
    private String size;

    private static BufferedImage spaceship;
    private int layer = 1;

    public Spaceship(double x, double y, String imagePath) throws IOException {
        this.x = x;
        this.y = y;
        spaceship = ImageIO.read(new File(imagePath));
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObject(this);
    }

    public double getWidth() {
        return width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    protected void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    protected void setY(double y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getShield() {
        return shield;
    }

    protected void setShield(int shield) {
        this.shield = shield;
    }

    public double getSpeed() {
        return speed;
    }

    protected void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDamage() {
        return damage;
    }

    protected void setDamage(double damage) {
        this.damage = damage;
    }

    public double getFireRate() {
        return fireRate;
    }

    protected void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    public String getAgility() {
        return agility;
    }

    protected void setAgility(String agility) {
        this.agility = agility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    protected void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public String getWeaponType() {
        return weaponType;
    }

    protected void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getArmor() {
        return armor;
    }

    protected void setArmor(String armor) {
        this.armor = armor;
    }

    public String getSize() {
        return size;
    }

    protected void setSize(String size) {
        this.size = size;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return spaceship;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public void update() {
        if (Input.keys[Input.RIGHT] && x <= Widget.getFrameWidth() - width)
            x += speed * FramesPerSecond.getDeltaTime();
        if (Input.keys[Input.LEFT] && x >= 0)
            x -= speed * FramesPerSecond.getDeltaTime();
        if (Input.keys[Input.UP] && y >= 0)
            y -= speed * FramesPerSecond.getDeltaTime();
        if (Input.keys[Input.DOWN] && y <= Widget.getFrameHeight() - height)
            y += speed * FramesPerSecond.getDeltaTime();
    }
}
