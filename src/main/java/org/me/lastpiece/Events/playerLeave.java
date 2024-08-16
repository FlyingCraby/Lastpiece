package org.me.lastpiece.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.me.lastpiece.Lastpiece;

import java.util.UUID;

public class playerLeave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        //Leave stuff

        Lastpiece.getManaInstance().removePlayer(uuid);

    }
}
