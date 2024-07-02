package update;

import java.util.ArrayList;

public class Updater {
    private static ArrayList<Updatable> updatableObjects = new ArrayList<Updatable>();
    private static ArrayList<Updatable> addUpdatableObjects = new ArrayList<Updatable>();
    private static ArrayList<Updatable> removeUpdatableObjects = new ArrayList<Updatable>();

    public static void update() {
        for(Updatable object: updatableObjects)
            object.update();

        updatableObjects.removeAll(removeUpdatableObjects);
        updatableObjects.addAll(addUpdatableObjects);

        addUpdatableObjects.clear();
        removeUpdatableObjects.clear();

    }

    public static void addUpdatableObject(Updatable object) {
        addUpdatableObjects.add(object);
    }

    public static void removeUpdatableObject(Updatable object) {
        removeUpdatableObjects.add(object);
    }

}
