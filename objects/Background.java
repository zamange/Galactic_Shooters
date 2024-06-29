package objects;

import render.Renderable;
import render.Renderer;
import update.Updatable;
import update.Updater;
import entry.FramesPerSecond;
import entry.Widget;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background implements Renderable, Updatable {

    private final int layer = 0;
    private static double width = Widget.getFrameWidth();
    private static double height = Widget.getFrameHeight();
    private static double x;
    private double y;
    private static BufferedImage background;

    public double speed = 300;

    public Background(double y) throws IOException {

        this.y = y;

        background = ImageIO.read(new File("assets/Galaxy.jpg"));
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObject(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return background;
    }

    @Override
    public void update(){
        y += speed * FramesPerSecond.getDeltaTime();
        if(y >= Widget.getFrameHeight())
            y = -Widget.getFrameHeight();
    }
}
