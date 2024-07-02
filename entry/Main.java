package entry;

import objects.Background;
import objects.Bomber;
import objects.Fighter;
import objects.Spaceship;
import render.Renderer;
import update.Updater;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Widget widget = new Widget("SpaceInvasion", Widget.getFrameWidth(), Widget.getFrameHeight());
        Renderer renderer = new Renderer();
        Updater updater = new Updater();
        widget.addKeyListener(new Input()); //add key inputs to the widget
        widget.add(renderer);
        widget.packWidget();
        widget.setVisible(true);



        boolean runGame = true;
//        new Spaceship(Widget.getFrameWidth() / 2 - (Spaceship.getWidth() / 2) , Widget.getFrameHeight() -150);
        Bomber bomber = new Bomber(Widget.getFrameWidth() / 2 - 50, Widget.getFrameHeight() - 150); // Centered based on bomber width
        Fighter fighter = new Fighter(Widget.getFrameWidth() / 2 - 40, 150); // Centered based on fighter width, opposite y position
        new Background(0);
        new Background(-Widget.getFrameHeight());

        FramesPerSecond.calcBeginTime(); //begin time called at the start of a frame
        //to reset the beginning time
        while (runGame) {
            renderer.repaint();
            updater.update();

            FramesPerSecond.calcDeltaTime(); //recalculate the delta time

        }
    }
}
