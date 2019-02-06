package rocks.inspectit.oce.core.utils;

import java.util.Set;

/**
 * A generic utility class.
 */
public class CommonUtils {

    /**
     * Return true if the JVM is shutting down.
     * Note: This method is expensive! Only call it in destructions methods and don't call it within loops!
     *
     * @return true if the JVM is shutting down, false otherwise
     */
    public static boolean isJVMShuttingDown() {
        Thread dummyHook = new Thread(() -> {
        });
        try {
            Runtime.getRuntime().addShutdownHook(dummyHook);
            Runtime.getRuntime().removeShutdownHook(dummyHook);
        } catch (IllegalStateException e) {
            return true;
        }
        return false;
    }

    public static boolean contentsEqual(Set<?> setA, Set<?> setB) {
        if (setA.size() != setB.size()) {
            return false;
        }
        return !setA.stream().anyMatch(elem -> !setB.contains(elem));
    }

}