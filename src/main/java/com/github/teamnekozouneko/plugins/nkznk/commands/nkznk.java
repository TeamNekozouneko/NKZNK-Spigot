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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class nkznk implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§8[§3§lNKZNK§8]§r §3NKZNK§r §8v§71.0.0 を実行中");
            sender.sendMessage("§8[§3§lNKZNK§8]§r §7\"/nkznk §bhelp§7\"で利用可能なコマンドを表示できます。");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
                sender.sendMessage("§m          §r §3NKZNK§r §m          §r");
                sender.sendMessage("§7/nkznk §b<help|version|?>§r §8- §fプラグインの情報系コマンドです。");
            } else if (args[0].equalsIgnoreCase("version")) {
                sender.sendMessage("§8[§3§lNKZNK§8]§r §3NKZNK§r §8v§71.0.0 を実行中");
                sender.sendMessage("§8[§3§lNKZNK§8]§r §7レポジトリ: https://github.com/TEAMNekozouneko");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1) {
            tab.add("help");
            tab.add("?");
            tab.add("version");
        }
        return tab;
    }
}
