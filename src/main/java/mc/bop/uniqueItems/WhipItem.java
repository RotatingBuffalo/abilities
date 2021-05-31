package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WhipItem extends ItemStack {
    static String itemName = "The Whip";
    public static String itemLore = "\"The beatings shall continue until morale improves...\"";

    public WhipItem() {
        super(Material.FISHING_ROD, 1);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(ChatColor.RED + itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }
}
