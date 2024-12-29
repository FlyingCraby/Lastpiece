package Models;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class Mana {
    public int cap;
    public int currentMana;
    public UUID playerId;
    public Player player;

    public Mana(int cap, int currentMana, UUID uuid, Player player){
        this.cap = cap;
        this.currentMana = currentMana;
        this.playerId = uuid;
        this.player = player;
        regenMana();
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public boolean editMana (int edit){
        //Checks if added Mana is over cap
        if(currentMana + edit > cap){
            setCurrentMana(cap);
        }
        else if(currentMana + edit < 0){
            return false;
        }
        else{
            setCurrentMana(currentMana + edit);
        }
        display();
        return true;
    }

    private void display(){
        String message = ChatColor.AQUA + "Mana: " + currentMana + "/" + cap;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    private void regenMana(){
        //Runs a scheduler to add Mana per 2 sec
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask((Plugin) this, new Runnable() {
            @Override
            public void run() {
                //increase MANA
                int increasePerSec = 5;
                setCurrentMana(Math.min(currentMana + increasePerSec, cap));
                display();
            }
        }, 0L, 20L);
    }
}
