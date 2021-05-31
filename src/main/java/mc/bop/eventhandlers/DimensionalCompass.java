package mc.bop.eventhandlers;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import mc.bop.uniqueItems.DimensionalCompassItem;

public class DimensionalCompass implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getLore() == null) {
            return;
        }
        if (e.getAction() == null) {
            return;
        }
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack itemUsed = e.getItem();
            if (itemUsed.getItemMeta().getLore().get(0).equals(DimensionalCompassItem.itemLore)) {
                Player p = e.getPlayer();
                if (p.getWorld().getName().endsWith("_Nether")) {
                    return;
                }
                for (int i = 0; i < 31; i++) {
                    p.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, p.getLocation(), 6, Math.random() - 0.5,
                            Math.random() * 3 - 1, Math.random() - 0.5);
                }
                p.performCommand("world world_nether");
                return;
            }
        }
    }
}
