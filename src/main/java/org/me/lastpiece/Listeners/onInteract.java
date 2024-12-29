package org.me.lastpiece.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.me.lastpiece.Lastpiece;

public class onInteract implements Listener {

    @EventHandler
    public void onInteracted(PlayerInteractEvent e){
        Player player = e.getPlayer();

        if(getSpecificAction(e).equals(Action.RIGHT_CLICK_AIR) || getSpecificAction(e).equals(Action.RIGHT_CLICK_BLOCK)){
            if (e.hasItem()){
                //Call different abilities and functions of items
                if(e.getItem().getItemMeta() == Lastpiece.getItems().boomWand.getWand().getItemMeta()){
                    if(getSpecificAction(e).equals(Action.RIGHT_CLICK_AIR)){
                        player.getWorld().createExplosion(player.getLocation(), 10);
                    }
                    else{
                        player.getWorld().createExplosion(e.getClickedBlock().getLocation(),10);
                    }
                }
            }
        }
    }

    @EventHandler
    private Action getSpecificAction (PlayerInteractEvent e){
        return e.getAction();
    }
}
