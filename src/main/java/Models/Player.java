package Models;

public class Player {
    public org.bukkit.entity.Player player;
    public Mana mana;

    public Player(org.bukkit.entity.Player player){
        this.player = player;
        mana = new Mana(100, 100, player.getUniqueId(), player);
    }
}
