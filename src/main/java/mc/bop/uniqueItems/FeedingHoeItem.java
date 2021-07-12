package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FeedingHoeItem extends ItemStack implements BopItem {
    static String itemName = "Lil' Debbie's Snack Cakes";
    public static String itemLore = "\"Unwrap a smile!~\"";

    public FeedingHoeItem() {
        super(Material.NETHERITE_SWORD);

        ItemMeta im = this.getItemMeta();
        im.setDisplayName(itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

    public String getLore() {
        return itemLore;
    }
}
