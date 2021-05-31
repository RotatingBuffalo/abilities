package mc.bop.eventhandlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import mc.bop.uniqueItems.ExcaliburItem;

public class Excalibur implements Listener {
    @EventHandler
    public static void onInteract(PlayerInteractEvent e) {
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
            if (itemUsed.getItemMeta().getLore().get(0).equals(ExcaliburItem.itemLore)) {
                Player p = e.getPlayer();
                p.getWorld().strikeLightning(p.getTargetBlock(null, 31).getLocation());
                return;
            }
        }
    }
}