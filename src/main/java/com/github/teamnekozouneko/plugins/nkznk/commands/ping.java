package com.github.teamnekozouneko.plugins.nkznk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ping implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public ping(JavaPlugin javaPlugin) {
        this.plugin = javaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player target;
        if (args.length == 1) {
            target = this.plugin.getServer().getPlayer(args[0]);
        } else {
            target = (Player) sender;
        }

        String name;
        if (sender.getName().equalsIgnoreCase(target.getName())) {
            name = "あなた";
        } else {
            name = target.getName();
        }

        String colorId;
        if (target.getPing() < 150) {
            colorId = "a";
        } else if (target.getPing() < 300) {
            colorId = "e";
        } else {
            colorId = "c";
        }
        sender.sendMessage("§8[§3§lNKZNK§8]§r " + name + "のPingは、§"+colorId+target.getPing()+"ms§rです。");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1) {
            for (Player online : this.plugin.getServer().getOnlinePlayers()) {
                if (online.getName().startsWith(args[0])) {
                    tab.add(online.getName());
                }
            }
        }
        return tab;
    }
}
