package org.me.lastpiece.Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
}
