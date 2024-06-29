package render;

import java.awt.*;
import java.awt.image.BufferedImage;

/*defines methods that must be implemented by any class that wants to be rendered by the 'Renderer'

 */
public interface Renderable extends Comparable<Object>{
    public int getLayer();// returns the layer of the object used for sorting and rendering order
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public BufferedImage getBufferedImage();

    public default void drawSprite(Graphics2D g){
        g.drawImage(getBufferedImage(), (int) getX(), (int) getY(), (int) getHeight(), (int) getWidth(), null);
    }

    public default int compareTo(Object o) { //default method to compare objects based on their layer by implementing the Comparable' interface
        // Allows 'Rendarable' objects to be sorted by layer
        Renderable object = (Renderable)o;
        if(getLayer() < object.getLayer())
            return -1;
        else if(getLayer() > object.getLayer())
            return 1;
        else
            return 0;
    }
}
