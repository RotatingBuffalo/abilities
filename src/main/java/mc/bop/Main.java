package mc.bop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import mc.bop.commands.BopTabCompleter;
import mc.bop.commands.GiveBopItem;
import mc.bop.util.BopPlayer;

public class Main extends JavaPlugin {
    private static ArrayList<BopPlayer> pBopPlayers = new ArrayList<BopPlayer>(new LinkedHashSet<BopPlayer>());

    public static ArrayList<BopPlayer> getBopPlayersList() {
        return pBopPlayers;
    }

    public static boolean addPlayer(BopPlayer p) {
        return pBopPlayers.add(p);
    }

    public static BopPlayer getBopPlayer(UUID id) {
        for (int i = 0; i < pBopPlayers.size(); i++) {
            if (pBopPlayers.get(i).getOfflinePlayer().equals(Bukkit.getOfflinePlayer(id))) {
                return pBopPlayers.get(i);
            }
        }
        return null;
    }

    @Override
    public void onEnable() {
        // create a BopPlayer object for every file in $(PluginDirectory)/PlayerData/
        // add the loaded BopPlayers to pBopPlayers
        // finally, call .load() for every element in pBopPlayers
        File datFolder = new File(this.getDataFolder() + File.separator + "PlayerData" + File.separator);
        if (datFolder.listFiles() != null) {
            for (int i = 0; i < datFolder.listFiles().length; i++) {
                File currentFile = datFolder.listFiles()[i];
                String id = currentFile.getName().substring(0, currentFile.getName().indexOf('.'));

                // Wrapped this in an if statement in case somehow we try to load the same thing
                // twice.
                if (pBopPlayers.add(new BopPlayer(Bukkit.getOfflinePlayer((UUID.fromString(id))).getPlayer()))) {
                    pBopPlayers.get(i).load(currentFile);
                }
            }
        }

        getLogger().info("BOPSMP PLUGIN v1.2 ACTIVATING");
        this.getCommand("giveBopItem").setExecutor(new GiveBopItem());
        this.getCommand("giveBopItem").setTabCompleter(new BopTabCompleter());
        getServer().getPluginManager().registerEvents(new EventHandlers(), this);
    }

    @Override
    public void onDisable() {
        // save pBopPlayers to $(PluginDirectory)/PlayerData/*.dat, naming each file the
        // player's UUID.

        File datFolder = this.getDataFolder();
        File playerData = new File(datFolder + File.separator + "PlayerData");
        if (!playerData.exists()) {
            playerData.mkdir();
        }
        for (int i = 0; i < pBopPlayers.size(); i++) {
            BopPlayer currentPlayer = pBopPlayers.get(i);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(playerData + File.separator
                        + currentPlayer.getOfflinePlayer().getUniqueId().toString() + ".bopdat"));
                writer.write(currentPlayer.save());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        getLogger().info("BOPSMP PLUGIN v1.1 SHUTTING DOWN");
    }
}
