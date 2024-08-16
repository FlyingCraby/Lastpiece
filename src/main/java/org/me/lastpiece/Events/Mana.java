package org.me.lastpiece.Events;

import com.google.gson.Gson;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.me.lastpiece.Lastpiece;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Mana extends JavaPlugin {
    ArrayList<Models.Mana> storage = new ArrayList<>();
    /*
    *              0                   1    2
    * Models.Mana[] >>> Flyingcrabs's UUID, Cap, Current Mana
    * Models.Mana[] >>> Goldsonic100's UUID, Cap, Current Mana
    * Models.Mana[] >>> Skiingwhale's UUID, Cap, Current Mana
    * Models.Mana[] >>> Derpy's UUID, Cap, Current Mana
    * */

    public void init(){
        regenMana();
        System.out.println("MANA INIT");
    }

    public void adPlayer(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(Lastpiece.getPlugin().getDataFolder().getAbsolutePath() + "/Mana.json");

        if (file.exists()){
            Reader reader = new FileReader(file);
            Models.Mana[] n = gson.fromJson(reader, Models.Mana[].class);

            //Find and add Player

            for(Models.Mana x : n){
                if(x.playerId == uuid){
                    storage.add(x);
                    break;
                }
            }
        }
    }

    private void saveLog() throws IOException {
        Gson gson = new Gson();
        File file = new File(Lastpiece.getPlugin().getDataFolder().getAbsolutePath() + "/Mana.json");
        file.getParentFile().mkdir();
        file.createNewFile();
        Writer writer = new FileWriter(file, false);
        gson.toJson(storage, writer);
        writer.flush();
        writer.close();
    }

    public void createPlayer(Player player) throws IOException {
        Models.Mana temp = new Models.Mana(100, 100, player.getUniqueId(), player);
        storage.add(temp);
        saveLog();
    }

    public void changeManaCap(UUID uuid, int change) throws IOException {
        for(int x = 0; x < storage.size(); x++){
            Models.Mana temp = storage.get(x);
            UUID id = temp.playerId;
            if(id == uuid){
                temp.setCap(change);
                storage.set(x, temp);
                saveLog();
                break;
            }
        }
    }

    private void display(Models.Mana mana){
        Player player = mana.player;
        int current = mana.currentMana;
        int cap = mana.cap;

        String message = ChatColor.AQUA + "Mana: " + current + "/" + cap;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public void removePlayer(UUID uuid){
        //Finding player
        for(int x = 0; x < storage.size(); x++){
            Models.Mana temp = storage.get(x);
            UUID id = temp.playerId;
            if(uuid == id){
                storage.remove(x);
                break;
            }
        }
    }

    public void editMana (UUID uuid, int edit){
        for(int x = 0; x < storage.size(); x++){
            Models.Mana temp = storage.get(x);
            UUID id = temp.playerId;
            int cap = temp.cap;
            int currentMana = temp.currentMana;

            //check for correct UUID/Player
            if(id == uuid){
                //Checks if added Mana is over cap
                if(currentMana + edit > cap){
                    temp.setCurrentMana(cap);
                    storage.set(x, temp);
                }
                //If Not add mana
                else{
                    temp.setCurrentMana(currentMana + edit);
                    storage.set(x, temp);
                }
                display(storage.get(x));
                break;
            }
        }
    }

    public void regenMana(){

        //Runs a scheduler to add Mana per 2 sec
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                //loops through all players
                for(int x = 0; x < storage.size(); x++){

                    //increase MANA
                    Models.Mana temp = storage.get(x);
                    int cap = temp.cap;
                    int currentMana = temp.currentMana;
                    int increasePerSec = 5;

                    if(currentMana + increasePerSec > cap){
                        temp.setCurrentMana(cap);
                        storage.set(x, temp);
                    }
                    else{
                        temp.setCurrentMana(currentMana + increasePerSec);
                        storage.set(x, temp);
                    }
                    display(storage.get(x));
                }
            }
        }, 0L, 20L);
    }
}
