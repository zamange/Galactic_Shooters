package entry;

import javax.swing.*;

public class Widget extends JFrame {
    //static fields; constants belonging to the class itself rather than an instance
    private static double FrameWidth = 500;
    private static double FrameHeight = 500;
    private static String WidgetName;

    public Widget(String WidgetName, double FrameWidth, double FrameHeight) {
        super(WidgetName); // passes the widget name to the JFrame constructor which is also the name of the frame

        Widget.FrameWidth = FrameWidth;
        Widget.FrameHeight = FrameHeight;
        Widget.WidgetName = WidgetName;
        setWidgetAttributes();
    }

    private void setWidgetAttributes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on close specifies that the application should exit when the frame is closed
    }

    public void packWidget(){
        /* built-in JFrame method, sizes the frame so that all its contents are at or above their preferred sizes
        the window is adjusted to fit the size of its components rather than
        having to set the size manually.
         */
        pack();
        setResizable(false);
        setLocationRelativeTo(null); //setting the location as null centers the widget on the screen

    }

    public static double getFrameHeight() {
        return FrameHeight;
    }

    public static double getFrameWidth() {
        return FrameWidth;
    }

    public static String getWidgetName() {
        return WidgetName;
    }
}
