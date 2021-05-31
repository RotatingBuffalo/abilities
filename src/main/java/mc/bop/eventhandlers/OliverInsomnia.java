package mc.bop.eventhandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class OliverInsomnia implements Listener {
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e) {
        if (e.getPlayer().getDisplayName().equals("OliverTheCrow_")) {
            new PlayerBedLeaveEvent(e.getPlayer(), e.getBed(), true);
            e.setCancelled(true);
        }
    }
}
