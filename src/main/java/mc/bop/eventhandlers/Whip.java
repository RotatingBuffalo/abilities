package mc.bop.eventhandlers;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import mc.bop.uniqueItems.WhipItem;

public class Whip implements Listener {
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER) {
            Player damager = (Player) e.getDamager();
            if (e.getEntity() instanceof LivingEntity) {
                LivingEntity damagee = (LivingEntity) e.getEntity();
                ItemStack itemUsed = damager.getInventory().getItemInMainHand();
                if (itemUsed == null) {
                    return;
                }
                if (itemUsed.getItemMeta() == null) {
                    return;
                }
                if (itemUsed.getItemMeta().getLore() == null) {
                    return;
                }
                if (itemUsed.getItemMeta().getLore().get(0).equals(WhipItem.itemLore)) {
                    double randomXpos = damagee.getLocation().getX() + Math.random() * 31 - 16;
                    double randomZpos = damagee.getLocation().getZ() + Math.random() * 31 - 16;
                    if (randomXpos < 0) {
                        randomXpos -= 16;
                    } else {
                        randomXpos += 16;
                    }
                    if (randomZpos < 0) {
                        randomZpos -= 16;
                    } else {
                        randomZpos += 16;
                    }
                    Location randomLocation = new Location(damagee.getWorld(), randomXpos,
                            damagee.getWorld().getHighestBlockYAt((int) randomXpos, (int) randomZpos) + 2, randomZpos);
                    damagee.teleport(randomLocation);
                }
            }
        }
    }
}
