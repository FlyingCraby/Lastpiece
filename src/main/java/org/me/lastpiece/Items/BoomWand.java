package org.me.lastpiece.Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.me.lastpiece.Lastpiece;

import java.util.ArrayList;
import java.util.List;

public class BoomWand {
    public static ItemStack boomWand;

    public BoomWand(){
        ItemStack wand = new ItemStack(Material.STICK, 100);
        ItemMeta meta = wand.getItemMeta();
        meta.setDisplayName("Boom Boom Wand");
        List<String> lore = new ArrayList<>();
        lore.add("Things go");
        lore.add("boom boom");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        wand.setItemMeta(meta);
        boomWand = wand;
    }

    public ItemStack getWand(){return boomWand;}

    public void goBoom(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if(Lastpiece.getPlayers().get(player.getUniqueId()).mana.editMana(-10)){
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
                player.getWorld().createExplosion(player.getLocation(), 10);
            }
            else{
                player.getWorld().createExplosion(e.getClickedBlock().getLocation(),10);
            }
        }
    }
}
