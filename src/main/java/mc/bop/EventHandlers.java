package mc.bop;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import mc.bop.uniqueItems.BopItem;
import mc.bop.uniqueItems.DimensionalCompassItem;
import mc.bop.uniqueItems.ExcaliburItem;
import mc.bop.uniqueItems.SoupStaff;
import mc.bop.uniqueItems.WhipItem;

public class EventHandlers implements Listener {

    // Some stuff I will use in these.
    private String dogString = "EVERY TIME I CLOSE MY EYES TO SLEEP AT NIGHT, I THINK OF THE LIVES I'VE CUT SHORT; THE PARROTS WHO HAD SO MUCH LEFT AHEAD OF THEM... WHY SHOULD I BE ANY DIFFERENT?";
    private String adrianString = "GARY! YOU ARE GONNA FINISH YOUR DESSERT, AND YOU ARE GONNA LIKE IT!";
    private ArrayList<Material> meats = new ArrayList<Material>(
            Arrays.asList(Material.COOKED_BEEF, Material.COOKED_SALMON, Material.COOKED_PORKCHOP,
                    Material.COOKED_CHICKEN, Material.COOKED_RABBIT, Material.COOKED_MUTTON, Material.COOKED_COD,
                    Material.BEEF, Material.SALMON, Material.PORKCHOP, Material.CHICKEN, Material.RABBIT,
                    Material.MUTTON, Material.COD, Material.RABBIT_STEW, Material.PUFFERFISH, Material.TROPICAL_FISH));

    private void explode(Player p) {
        for (int j = 0; j < 8; j++) {
            p.getWorld().createExplosion(p.getLocation(), 4f, false, false);
        }
    }

    private boolean actionVerify(Action a) {
        if (a == null) {
            return false;
        }
        if (a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean itemVerify(ItemStack eItem, BopItem itemToCheckAgainst) {
        if (eItem == null) {
            return false;
        }
        if (eItem.getItemMeta().getLore() == null) {
            return false;
        }
        if (eItem.getItemMeta().getLore().get(0).equals(itemToCheckAgainst.getLore())) {
            return true;
        } else {
            return false;
        }

    }

    private boolean nameCheck(String name, Player p) {
        return p.getDisplayName().equals(name);
    }

    // Adrian is a vegan.
    @EventHandler
    public void adrianVegan(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (nameCheck("Blackwood_Sama", p)) {
            Material item = e.getItem().getType();
            if (meats.contains(item)) {
                p.sendMessage(ChatColor.DARK_RED + adrianString);
                explode(p);
            }
        }
    }

    // Dog is a parrot.
    @EventHandler
    public void onDogEat(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (nameCheck("TheBasicDog", p)) {
            if (e.getItem().getType().equals(Material.COOKIE)) {
                p.sendMessage(ChatColor.DARK_RED + dogString);
                explode(p);
            }
        }
    }

    // Oliver is an insomniac.
    @EventHandler
    public void oliverInsomnia(PlayerBedEnterEvent e) {
        if (nameCheck("OliverTheCrow_", e.getPlayer())) {

            new PlayerBedLeaveEvent(e.getPlayer(), e.getBed(), true);
            e.setCancelled(true);

        }
    }

    // Dimensional Compass item.
    @EventHandler
    public void dimCompass(PlayerInteractEvent e) {
        if (itemVerify(e.getItem(), new DimensionalCompassItem()) && actionVerify(e.getAction())) {

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

    // Excalibur
    @EventHandler
    public void lightningSword(PlayerInteractEvent e) {
        if (itemVerify(e.getItem(), new ExcaliburItem()) && actionVerify(e.getAction())) {
            Player p = e.getPlayer();
            p.getWorld().strikeLightning(p.getTargetBlock(null, 31).getLocation());
            return;
        }
    }

    @EventHandler
    public void whipEventCheck(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER) {
            Player damager = (Player) e.getDamager();
            if (e.getEntity() instanceof LivingEntity) {
                LivingEntity damagee = (LivingEntity) e.getEntity();
                ItemStack itemUsed = damager.getInventory().getItemInMainHand();
                if (itemVerify(itemUsed, new WhipItem())) {
                    new PlayerItemConsumeEvent((Player) damagee, new ItemStack(Material.CHORUS_FRUIT));
                }
            }
        }
    }

    @EventHandler
    public void soupStaff(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER) {
            Player damager = (Player) e.getDamager();
            if (e.getEntity() instanceof LivingEntity) {
                LivingEntity damagee = (LivingEntity) e.getEntity();
                ItemStack itemUsed = damager.getInventory().getItemInMainHand();
                if (itemVerify(itemUsed, new SoupStaff())) {
                    damagee.addPotionEffect(new PotionEffect(
                            PotionEffectType.values()[(int) (Math.random() * PotionEffectType.values().length) + 1],
                            600, 0));
                }
            }
        }
    }
}
