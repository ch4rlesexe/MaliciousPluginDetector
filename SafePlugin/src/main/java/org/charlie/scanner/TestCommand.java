package org.charlie.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {

    private final TestPlugin plugin;

    public TestCommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            sender.sendMessage("§aHello, world!");
            return true;
        }

        if (label.equalsIgnoreCase("testplugin")) {
            sender.sendMessage("§bTestPlugin §fv" + plugin.getDescription().getVersion()
                    + " by " + plugin.getDescription().getAuthors());
            return true;
        }

        return false;
    }
}
