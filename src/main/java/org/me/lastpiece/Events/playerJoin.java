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
    public void onJoin(PlayerJoinEvent e) throws IOException {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        //Instances
        Mana mana = Lastpiece.getManaInstance();

        //if New Player
        if (!player.hasPlayedBefore()){
            mana.createPlayer(player);
        }

        //Setup All features

        mana.adPlayer(uuid);
    }

}
