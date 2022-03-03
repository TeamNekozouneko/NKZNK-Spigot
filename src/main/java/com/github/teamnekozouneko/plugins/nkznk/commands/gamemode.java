package com.github.teamnekozouneko.plugins.nkznk.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gamemode implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public gamemode(JavaPlugin javaPlugin) {
        this.plugin = javaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameMode setg;
        switch (args[0]) {
            case "a","adventure","2" -> setg = GameMode.ADVENTURE;
            case "c","creative","1" -> setg = GameMode.CREATIVE;
            case "s","survival","0" -> setg = GameMode.SURVIVAL;
            case "sp","spectator","3" -> setg = GameMode.SPECTATOR;
            default -> {
                sender.sendMessage("§cゲームモードが入力されていません。");
                return true;
            }
        }

        Player target;
        if (args.length == 2) {
            target = this.plugin.getServer().getPlayer(args[1]);
        } else {
            target = (Player) sender;
        }

        target.setGameMode(setg);

        String name;
        if (sender.getName().equalsIgnoreCase(target.getName())) {
            name = "あなた";
        } else {
            name = target.getName();
        }

        switch (setg) {
            case CREATIVE -> sender.sendMessage("§8[§3§lNKZNK§8]§r "+name+"のゲームモードを§7§oクリエイティブモード§rに変更しました。");
            case SURVIVAL -> sender.sendMessage("§8[§3§lNKZNK§8]§r "+name+"のゲームモードを§7§oサバイバルモード§rに変更しました。");
            case ADVENTURE -> sender.sendMessage("§8[§3§lNKZNK§8]§r "+name+"のゲームモードを§7§oアドベンチャーモード§rに変更しました。");
            case SPECTATOR -> sender.sendMessage("§8[§3§lNKZNK§8]§r "+name+"のゲームモードを§7§oスペクテイターモード§rに変更しました。");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabList = new ArrayList<>();
        if (args.length == 1) {
            List<String> gamemodeTab = Arrays.asList("0", "1", "2", "3", "a", "adventure", "c", "creative", "s", "survival", "sp", "spectator");
            for (String t : gamemodeTab) {
                if (t.startsWith(args[0])) {
                    tabList.add(t);
                }
            }
        } else if (args.length == 2) {
            for (Player p : this.plugin.getServer().getOnlinePlayers()) {
                if (p.getName().startsWith(args[1])) {
                    tabList.add(p.getName());
                }
            }
        }
        return tabList;
    }
}
