package org.me.lastpiece.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteract implements Listener {

    @EventHandler
    public void onInteracted(PlayerInteractEvent e){
        Player player = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (e.hasItem()){
                //Call different abilities and functions of items
            }
        }
    }
}
