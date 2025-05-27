package org.charlie.scanner;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class MaliciousPluginScanner extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("📡 Starting plugin scan...");
        File pluginDir = getServer().getPluginsFolder();
        new JarScanner(pluginDir, this).scanAll();
    }
}

