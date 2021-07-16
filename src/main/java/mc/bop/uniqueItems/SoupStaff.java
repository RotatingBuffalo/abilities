package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoupStaff extends ItemStack implements BopItem {
    public String itemName = "The Soup Staff";
    public String itemLore = "\"eat up moron\"";

    public SoupStaff() {
        super(Material.STICK);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

    public String getLore() {
        return itemLore;
    }

}
