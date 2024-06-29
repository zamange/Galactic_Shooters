package entry;

/* event importS: KeyEvent describes keyboard events,
 KeyListener is an interface that listens for and handles keyboard events
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* public Input class (can be accessed from other classes), implements "KeyListener interface"
so, the KeyListener interface requires the implementing to provide its own implementations for
three methods: KeyTyped, KeyPressed and KeyReleased.
 */
public class Input implements KeyListener {
    //constants representing indices for different keys the user can input
    //declared as public static final == constants accessible by any class without creating an instance of Input class.
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int SPACE = 4;


    public static boolean[] keys = new boolean[5]; /*Key state Array: declares a static array of booleans named 'keys' with five elements
    each element corresponds to one of the keys defined by the constants
    The array tracks whether each key is currently pressed "true or false".*/



    @Override
    public void keyTyped(KeyEvent e) {
//used when a key is typed vs pressed
    }


    /*Called when a key is pressed, checks the key code of the event,
    (e.getKeycode()) and sets the corresponding element in the 'keys' array,
    to true.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            keys[LEFT] = true;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            keys[UP] = true;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            keys[DOWN] = true;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            keys[RIGHT] = true;
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            keys[SPACE] = true;


    }


    /*called whenever a key is released.
    checks the key code of the event(e.getKeyCode()) and sets the corresponding element
    in the keys array to false.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            keys[LEFT] = false;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            keys[UP] = false;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            keys[DOWN] = false;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            keys[RIGHT] = false;
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            keys[SPACE] = false;

    }
}
