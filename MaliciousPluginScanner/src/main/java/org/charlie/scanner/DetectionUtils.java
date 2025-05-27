package org.charlie.scanner;

public class DetectionUtils {
    public static boolean isObfuscated(String className) {
        return className.matches("^[a-z]{1,2}\\.class$");
    }
    public static boolean containsDangerousCode(String text) {
        return text.contains("java/net")
            || text.contains("javax/crypto")
            || text.contains("sun/misc/Unsafe")
            || text.contains("Class.forName")
            || text.contains("Method.invoke");
    }
}

