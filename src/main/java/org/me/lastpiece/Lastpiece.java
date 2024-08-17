package org.me.lastpiece;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.me.lastpiece.Command.editCap;
import org.me.lastpiece.Command.editMana;
import org.me.lastpiece.Events.Mana;
import org.me.lastpiece.Events.playerJoin;
import org.me.lastpiece.Events.playerLeave;
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
        getCommand("editManaCap").setExecutor(new editCap());
        getCommand("editPlayerMana").setExecutor(new editMana());

        //Item Interact
        getServer().getPluginManager().registerEvents(new onInteract(), this);

        //Player Join
        getServer().getPluginManager().registerEvents(new playerJoin(), this);

        //Player Leave
        getServer().getPluginManager().registerEvents(new playerLeave(), this);

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
