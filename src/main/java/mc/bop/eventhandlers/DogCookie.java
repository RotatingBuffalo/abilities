package mc.bop.eventhandlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class DogCookie implements Listener {
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent e) {
        if (e.getPlayer().getPlayerListName().equals("TheBasicDog") && e.getItem().getType().equals(Material.COOKIE)) {
            e.getPlayer().sendMessage(ChatColor.DARK_RED
                    + "EVERY TIME I CLOSE MY EYES TO SLEEP AT NIGHT, I THINK OF THE LIVES I'VE CUT SHORT; THE PARROTS WHO HAD SO MUCH LEFT AHEAD OF THEM... WHY SHOULD I BE ANY DIFFERENT?");
            for (int j = 0; j < 8; j++) {
                if (j == 1) {
                    e.getPlayer().sendMessage("if you see this, it means the plugin actually updated.");
                }
                e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 4f, false, false);
            }
        } else {
            return;
        }
    }
}
