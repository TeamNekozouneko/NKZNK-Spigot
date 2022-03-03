package com.github.teamnekozouneko.plugins.nkznk.commands;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class gamemodegui implements CommandExecutor, TabCompleter, Listener {

    private JavaPlugin plugin;

    public gamemodegui(JavaPlugin javaPlugin) {
        this.plugin = javaPlugin;
    }

    private Inventory setInventory() {
        Inventory GameModeMenu = this.plugin.getServer().createInventory(null, 9, "ゲームモードを選択");

        ItemStack creative = new ItemStack(Material.GRASS_BLOCK, 1);
        ItemMeta creativeMeta = creative.getItemMeta();

        creativeMeta.setDisplayName("§r§aクリエイティブモード");
        creative.setItemMeta(creativeMeta);

        ItemStack survival = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta survivalMeta = creative.getItemMeta();

        survivalMeta.setDisplayName("§r§aサバイバルモード");
        survival.setItemMeta(survivalMeta);

        ItemStack adventure = new ItemStack(Material.MAP, 1);
        ItemMeta adventureMeta = creative.getItemMeta();

        adventureMeta.setDisplayName("§r§aアドベンチャーモード");
        adventure.setItemMeta(adventureMeta);

        ItemStack spectator = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta spectatorMeta = creative.getItemMeta();

        spectatorMeta.setDisplayName("§r§aスペクテイターモード");
        spectator.setItemMeta(spectatorMeta);

        ItemStack exit_button = new ItemStack(Material.BARRIER, 1);
        ItemMeta exitMeta = exit_button.getItemMeta();

        exitMeta.setDisplayName("§r§c閉じる");
        exit_button.setItemMeta(exitMeta);

        GameModeMenu.setItem(0, creative);
        GameModeMenu.setItem(2, survival);
        GameModeMenu.setItem(4, adventure);
        GameModeMenu.setItem(6, spectator);
        GameModeMenu.setItem(8, exit_button);

        return GameModeMenu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Inventory menu = setInventory();
        Player open = (Player) sender;

        open.openInventory(menu);
        open.playSound(open, Sound.BLOCK_CHEST_OPEN, 1f, 1f);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }

    @EventHandler
    public void invClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("ゲームモードを選択")) {
            e.setCancelled(true);
            Player openg = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§aクリエイティブモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oクリエイティブモード§rに変更しました。");
                    openg.setGameMode(GameMode.CREATIVE);
                }
                case "§aサバイバルモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oサバイバルモード§rに変更しました。");
                    openg.setGameMode(GameMode.SURVIVAL);
                }
                case "§aアドベンチャーモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oアドベンチャーモード§rに変更しました。");
                    openg.setGameMode(GameMode.ADVENTURE);
                }
                case "§aスペクテイターモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oスペクテイターモード§rに変更しました。");
                    openg.setGameMode(GameMode.SPECTATOR);
                }
                case "§c閉じる" -> openg.closeInventory();
            }
        }
    }

    @EventHandler
    public void invDrag(InventoryDragEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("ゲームモードを選択")) {
            e.setCancelled(true);
            Player openg = (Player) e.getWhoClicked();
            switch (e.getCursor().getItemMeta().getDisplayName()) {
                case "§aクリエイティブモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oクリエイティブモード§rに変更しました。");
                    openg.setGameMode(GameMode.CREATIVE);
                }
                case "§aサバイバルモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oサバイバルモード§rに変更しました。");
                    openg.setGameMode(GameMode.SURVIVAL);
                }
                case "§aアドベンチャーモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oアドベンチャーモード§rに変更しました。");
                    openg.setGameMode(GameMode.ADVENTURE);
                }
                case "§aスペクテイターモード" -> {
                    openg.sendMessage("§8[§3§lNKZNK§8]§r あなたののゲームモードを§7§oスペクテイターモード§rに変更しました。");
                    openg.setGameMode(GameMode.SPECTATOR);
                }
                case "§c閉じる" -> openg.closeInventory();
            }
        }
    }
}
