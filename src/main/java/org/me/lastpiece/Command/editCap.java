package org.me.lastpiece.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.me.lastpiece.Lastpiece;

public class editCap implements CommandExecutor {

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
                    Lastpiece.getManaInstance().changeManaCap(target.getUniqueId(), Integer.parseInt(args[1]));
                }
            }
            catch (Exception e){
                p.sendMessage(ChatColor.RED + "An Error Occurred When Running This Command");
            }

        }

        return true;
    }
}
