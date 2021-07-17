package mc.bop;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import mc.bop.commands.BopTabCompleter;
import mc.bop.commands.GiveBopItem;
import mc.bop.util.BopData;

public class Main extends JavaPlugin {
    private static BopData bd = new BopData();

    public static void addBopData(Player p) {
        bd.addPlayerToData(p);
    }

    @Override
    public void onEnable() {
        getLogger().info("BOPSMP PLUGIN v1.2 ACTIVATING");
        bd = BopData.loadData(getDataFolder() + File.separator + "BopData.dat");
        this.getCommand("giveBopItem").setExecutor(new GiveBopItem());
        this.getCommand("giveBopItem").setTabCompleter(new BopTabCompleter());
        getServer().getPluginManager().registerEvents(new EventHandlers(), this);
    }

    @Override
    public void onDisable() {
        bd.saveData(getDataFolder() + File.separator + "BopData.dat");
        getLogger().info("BOPSMP PLUGIN v1.1 SHUTTING DOWN");
    }
}
