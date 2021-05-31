package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FeedingHoeItem extends ItemStack {
    static String itemName = "Lil' Debbie's Snack Cakes";
    public static String itemLore = "\"Unwrap a smile!~\"";

    public FeedingHoeItem() {
        super(Material.NETHERITE_SWORD, 1);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(ChatColor.RED + itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }
}
