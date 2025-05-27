package org.charlie.suspicious;

import org.bukkit.plugin.java.JavaPlugin;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class SuspiciousPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SuspiciousPlugin enabled (for testing only)");

        try {
            // Simulated suspicious behavior (harmless)
            Class<?> clazz = Class.forName("java.lang.String");
            Method method = clazz.getMethod("toString");
            method.invoke("test");

            URL url = new URL("https://example.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
        } catch (Exception e) {
            getLogger().warning("Simulated suspicious code ran.");
        }
    }
}
