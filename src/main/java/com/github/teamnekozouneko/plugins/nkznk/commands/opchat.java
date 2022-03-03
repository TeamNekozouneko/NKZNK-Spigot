package com.github.teamnekozouneko.plugins.nkznk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class opchat implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public opchat(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String chat_content = String.join(" ", args);

        this.plugin.getLogger().info("§7[§6§lOP-Chat§7]§r " + sender.getName() + " §a:§r " + chat_content);

        for (Player p:this.plugin.getServer().getOnlinePlayers()) {
            if (p.isOp()) {
                p.sendMessage("§8[§3§lNKZNK§8]§r §7[§6§lOP-Chat§7]§r " + sender.getName() + " §a:§r " + chat_content);
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
