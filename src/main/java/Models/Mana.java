package Models;

import org.bukkit.entity.Player;

import java.util.UUID;

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
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }
}
