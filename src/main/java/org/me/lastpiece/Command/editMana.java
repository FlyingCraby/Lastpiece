package org.me.lastpiece.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.me.lastpiece.Lastpiece;

public class editMana implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;

            try{
                Player target = Bukkit.getPlayer(args[0]);

                if(target == null){
                    p.sendMessage(ChatColor.RED + "Player Not Online");
                }
                else{
                    Lastpiece.getPlayers().get(p.getUniqueId()).mana.editMana(Integer.parseInt(args[1]));
                }
            }
            catch (Exception e){
                p.sendMessage(ChatColor.RED + "An Error Occurred When Running This Command");
                if(p.isOp()){
                    p.sendMessage(ChatColor.RED + e.getMessage());
                }
            }

        }

        return true;
    }
}
