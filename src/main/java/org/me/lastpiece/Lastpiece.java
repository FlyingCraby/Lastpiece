package org.me.lastpiece;

import org.me.lastpiece.Command.getBoomWand;
import org.me.lastpiece.Items.itemManager;
import org.me.lastpiece.Models.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.me.lastpiece.Command.editCap;
import org.me.lastpiece.Command.editMana;
import org.me.lastpiece.Events.playerJoin;
import org.me.lastpiece.Events.playerLeave;
import org.me.lastpiece.Listeners.onInteract;

import java.util.TreeMap;
import java.util.UUID;

public final class Lastpiece extends JavaPlugin {
    private static Lastpiece plugin;

    private static TreeMap<UUID, Player> players = new TreeMap<>();
    private static itemManager items;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //Commands
        getCommand("editManaCap").setExecutor(new editCap());
        getCommand("editPlayerMana").setExecutor(new editMana());
        getCommand("getBoomWand").setExecutor(new getBoomWand());

        //Events
        getServer().getPluginManager().registerEvents(new onInteract(), this);

        //Player Join
        getServer().getPluginManager().registerEvents(new playerJoin(), this);

        //Player Leave
        getServer().getPluginManager().registerEvents(new playerLeave(), this);

        //Custom Items
        items = new itemManager();

        Bukkit.broadcastMessage(ChatColor.RED + "[SERVER] " + ChatColor.GREEN + "Lastpiece Plugin ");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Lastpiece getPlugin() {
        return plugin;
    }

    public static TreeMap<UUID, Player> getPlayers(){return players;}

    public static itemManager getItems(){return items;}
}
