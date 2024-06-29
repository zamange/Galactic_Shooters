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
    public static double width = Bomber.getWidth();
    private static double height = Bomber.getHeight();
    private double x;
    private double y;

    private int layer = 1;

    private static BufferedImage spaceship;
    private double speed = 200;

    public Spaceship(double x, double y) throws IOException {
        this.x = x;
        this.y = y;

        spaceship = ImageIO.read(new File("assets/Spaceship.png"));
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObject(this);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return spaceship;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }



    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public void update() {
        if(Input.keys[Input.RIGHT]  && x<= Widget.getFrameWidth() - width)
            x += speed * FramesPerSecond.getDeltaTime();
        if(Input.keys[Input.LEFT]&& x>=0)
            x -= speed * FramesPerSecond.getDeltaTime();
        if(Input.keys[Input.UP] && y>=0)
            y -= speed * FramesPerSecond.getDeltaTime();
        if(Input.keys[Input.DOWN] && y<= Widget.getFrameHeight() - height)
            y += speed * FramesPerSecond.getDeltaTime();
    }
}
