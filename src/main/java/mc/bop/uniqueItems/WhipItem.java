package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WhipItem extends ItemStack implements BopItem {
    static String itemName = "The Whip";
    public static String itemLore = "\"The beatings shall continue until morale improves...\"";

    public WhipItem() {
        super(Material.FISHING_ROD);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

    public String getLore() {
        return itemLore;
    }
}
