package org.charlie.scanner;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarScanner {
    private final File pluginDir;
    private final JavaPlugin plugin;

    public JarScanner(File pluginDir, JavaPlugin plugin) {
        this.pluginDir = pluginDir;
        this.plugin = plugin;
    }

    public void scanAll() {
        File[] jars = pluginDir.listFiles((d, n) -> n.endsWith(".jar"));
        if (jars == null) return;

        for (File jar : jars) {
            plugin.getLogger().info("🔍 Scanning: " + jar.getName());
            try (JarFile jf = new JarFile(jar)) {
                boolean foundSomething = false;
                for (JarEntry entry : java.util.Collections.list(jf.entries())) {
                    String name = entry.getName();

                    if (DetectionUtils.isObfuscated(name)) {
                        foundSomething = true;
                        plugin.getLogger().warning("⚠ Obfuscated class: " + name);
                    }

                    if (name.endsWith(".class")) {
                        byte[] bytes = jf.getInputStream(entry).readAllBytes();
                        String content = new String(bytes);
                        if (DetectionUtils.containsDangerousCode(content)) {
                            foundSomething = true;
                            plugin.getLogger().warning("⚠ Dangerous code in: " + name);
                        }
                    }
                }
                if (!foundSomething) {
                    plugin.getLogger().info("✅ No threats in " + jar.getName());
                }
            } catch (IOException e) {
                plugin.getLogger().severe("❌ Failed to scan " + jar.getName() + ": " + e.getMessage());
            }
        }
    }
}

