package render;

import entry.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Renderer extends JPanel { //swing panel used for custom painting

    private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>(); //list of objects that implement the Renderable interface, these objects will be drawn by the renderer


    @Override
    protected void paintComponent(Graphics g) { //overridden method to perform custom painting
        super.paintComponent(g); //ensures the panel is properly rendered before custom drawing
        Graphics2D g2d = (Graphics2D) g; //provides more control over geometry, color and text layout
        for(Renderable object: renderableObjects) //iterates through renderableObjects and calls their draw method
            object.drawSprite(g2d);
    }

    @Override
    public Dimension getPreferredSize() { //returns preferred size of the Renderer panel
        return new Dimension((int)Widget.getFrameHeight(), (int)Widget.getFrameWidth());
    }

    public static void addRenderableObjects(Renderable object) {
        renderableObjects.add(object);
        Collections.sort(renderableObjects);
    }

    public static void removeRenderableObjects(Renderable object) {
        renderableObjects.remove(object);
    }
}
