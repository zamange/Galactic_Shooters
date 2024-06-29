package entry;

import java.time.Duration;
import java.time.Instant;

public class FramesPerSecond { //this class is public meaning
    // it can be accessed from other classes

    private FramesPerSecond() {} //however the constructor is private,
    // so all methods and variables should be used in a static context

    private static Duration fpsDeltaTime = Duration.ZERO; //tracks the duration between the
    // last frame and the current frame. Initialized to ZERO (no time has elapsed initially)

    private static Duration LastTime = Duration.ZERO; //tracks the last recorded time

    private static Instant beginTime = Instant.now(); //represents the beginning time of
    //the current time calculation. Initialized to Instant.now()
    //which is a static method in the Instant class that captures the current point in time

    private static double deltaTime = fpsDeltaTime.toMillis() - LastTime.toMillis();

    public static void calcBeginTime() {
        /* sets begin time to the current time and resets
        fpsDeltaTime to zero (called at the start of a frame to reset the time for the new frame
         */
        beginTime = Instant.now();
        fpsDeltaTime = Duration.ZERO;
    }


    public static void calcDeltaTime() {
        /* updates fpsDeltaTime to the duration between beginTime and the current time
        Calculates deltaTime as the difference in milliseconds between fpsDeltaTime and LastTime.
        called at the end of a frame to calculate the time taken for that frame
         */
        fpsDeltaTime = Duration.between(beginTime, Instant.now());
        deltaTime = (double)fpsDeltaTime.toMillis() - LastTime.toMillis();
        LastTime = fpsDeltaTime;
    }

    public static double getDeltaTime() {
        return deltaTime / 1000;
    }
}
