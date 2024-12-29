package org.me.lastpiece.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.me.lastpiece.Lastpiece;

import java.io.IOException;
import java.util.UUID;

public class playerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        //Instances

        //if New Player

        //Setup All features
        Lastpiece.getPlayers().put(uuid, new Models.Player(player));
    }

}
