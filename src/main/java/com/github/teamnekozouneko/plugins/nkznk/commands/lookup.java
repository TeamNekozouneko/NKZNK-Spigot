// MIT License
//
// Copyright (c) 2022 Nekozouneko TEAM
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package com.github.teamnekozouneko.plugins.nkznk.commands;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class lookup implements CommandExecutor, TabCompleter {

    private JavaPlugin plugin;

    public lookup(JavaPlugin javaPlugin) {
        this.plugin = javaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if (args.length == 0) {
            player = (Player) sender;
        } else {
            player = this.plugin.getServer().getPlayer(args[0]);
        }

        sender.sendMessage("§8[§3§lNKZNK§8]§r §7ユーザー情報を取得中...");

        BaseComponent namemc = new TextComponent("§aユーザー名 §8-§r §9§n" + player.getName() + "§r");
        namemc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://ja.namemc.com/profile/"+player.getUniqueId()));
        sender.spigot().sendMessage(namemc);

        sender.sendMessage("§aUUID §8-§r §7§n" + player.getUniqueId());

        sender.sendMessage("§aネットワーク §8-§r  §9§n" + player.getAddress().getAddress() + "§r §8(§a" + player.getPing() + "§7ms§8)§r");
        sender.sendMessage("§a言語ID §8-§r §7" + player.getLocale());

        BaseComponent xyz = new TextComponent("§a位置（XYZ） §8-§r §7 " + String.format("%.3f", player.getLocation().getX()) + " §8/§7 " + String.format("%.3f", player.getLocation().getY()) + " §8/§7 " + String.format("%.3f", player.getLocation().getZ()) + " ");
        BaseComponent tp_button = new TextComponent("§8[§aTeleport§8]§r");

        tp_button.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + player.getLocation().getX() + " " + player.getLocation().getY() + " " + player.getLocation().getZ()));

        sender.spigot().sendMessage(xyz, tp_button);

        sender.sendMessage("§aレベル / EXP §8-§r §7Lv.§a"+String.valueOf(player.getLevel())+" §8/§r §a"+String.valueOf(player.getExp())+" §7Exp.");

        if (player.isOp()) {
            sender.sendMessage("§aオペレーターか? §8-§r §aはい");
        } else {
            sender.sendMessage("§aオペレーターか? §8-§r §aいいえ");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> tab = new ArrayList<>();
        for (Player online : this.plugin.getServer().getOnlinePlayers()) {
            tab.add(online.getName());
        }
        return tab;
    }
}
