package mc.bop;

import org.bukkit.plugin.java.JavaPlugin;

import mc.bop.commands.GiveBopItem;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BOPSMP PLUGIN v1.2 ACTIVATING");
        this.getCommand("giveBopItem").setExecutor(new GiveBopItem());
        getServer().getPluginManager().registerEvents(new EventHandlers(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BOPSMP PLUGIN v1.1 SHUTTING DOWN");
    }
}
