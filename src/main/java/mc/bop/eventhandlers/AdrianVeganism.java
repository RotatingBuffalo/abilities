package mc.bop.eventhandlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class AdrianVeganism implements Listener {
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent e) {
        if (!e.getPlayer().getPlayerListName().equals("Blackwood_Sama")) {
            return;
        }
        ItemStack itemConsumed = e.getItem();
        Material[] blacklistedFoods = { Material.COOKED_BEEF, Material.COOKED_SALMON, Material.COOKED_PORKCHOP,
                Material.COOKED_CHICKEN, Material.COOKED_RABBIT, Material.COOKED_MUTTON, Material.COOKED_COD,
                Material.BEEF, Material.SALMON, Material.PORKCHOP, Material.CHICKEN, Material.RABBIT, Material.MUTTON,
                Material.COD, Material.RABBIT_STEW, Material.PUFFERFISH, Material.TROPICAL_FISH };
        for (int i = 0; i < blacklistedFoods.length; i++) {
            if (blacklistedFoods[i].equals(itemConsumed.getType())) {
                e.getPlayer().sendMessage(
                        ChatColor.DARK_RED + "GARY! YOU ARE GONNA FINISH YOUR DESSERT, AND YOU ARE GONNA LIKE IT!");
                for (int j = 0; j < 8; j++) {
                    e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 4f, false, false);
                }
            }
        }
    }
}