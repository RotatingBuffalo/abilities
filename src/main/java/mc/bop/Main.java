package mc.bop;

import org.bukkit.plugin.java.JavaPlugin;

import mc.bop.commands.GiveBopItem;
import mc.bop.eventhandlers.*;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BOPSMP PLUGIN v1.1 ACTIVATING");
        this.getCommand("giveBopItem").setExecutor(new GiveBopItem());
        getServer().getPluginManager().registerEvents(new Excalibur(), this);
        getServer().getPluginManager().registerEvents(new DogCookie(), this);
        getServer().getPluginManager().registerEvents(new DimensionalCompass(), this);
        getServer().getPluginManager().registerEvents(new Whip(), this);
        getServer().getPluginManager().registerEvents(new AdrianVeganism(), this);
        getServer().getPluginManager().registerEvents(new OliverInsomnia(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BOPSMP PLUGIN v1.1 SHUTTING DOWN");
    }
}
