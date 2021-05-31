package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class DimensionalCompassItem extends ItemStack {
    static String itemName = "Hellbound Compass";
    public static String itemLore = "\"Vanish in smoke.\"";

    public DimensionalCompassItem() {
        super(Material.COMPASS, 1);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(ChatColor.YELLOW + itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

}
