package org.me.lastpiece;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.me.lastpiece.Events.Mana;
import org.me.lastpiece.Events.playerJoin;
import org.me.lastpiece.Listeners.onInteract;

public final class Lastpiece extends JavaPlugin {

    private static Lastpiece plugin;
    private static Mana manaInstance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //Mana
        manaInstance = new Mana();
        manaInstance.init();

        //Item Interact
        getServer().getPluginManager().registerEvents(new onInteract(), this);

        //Player Join
        getServer().getPluginManager().registerEvents(new playerJoin(), this);

        Bukkit.broadcastMessage(ChatColor.RED + "[SERVER] " + ChatColor.GREEN + "Lastpiece Plugin ");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Lastpiece getPlugin() {
        return plugin;
    }

    public static Mana getManaInstance() {
        return manaInstance;
    }

}
