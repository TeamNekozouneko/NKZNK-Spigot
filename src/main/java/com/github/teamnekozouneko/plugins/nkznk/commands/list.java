package com.github.teamnekozouneko.plugins.nkznk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class list implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public list(JavaPlugin javaPlugin) {
        this.plugin = javaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§8[§3§lNKZNK§8]§r 現在サーバーで以下のプレイヤーが参加中 §8(§7"+this.plugin.getServer().getOnlinePlayers().stream().count()+"§8/§7"+this.plugin.getServer().getMaxPlayers()+"§8)");
        for (Player p:this.plugin.getServer().getOnlinePlayers()) {
            sender.sendMessage("§a・"+p.getName()+"§r §8(§a"+p.getPing()+"§7ms§8)§r");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
