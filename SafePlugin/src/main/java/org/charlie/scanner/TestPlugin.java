package org.charlie.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("✅ TestPlugin has been enabled.");
        getCommand("hello").setExecutor(new TestCommand(this));
        getCommand("testplugin").setExecutor(new TestCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("❌ TestPlugin has been disabled.");
    }
}
