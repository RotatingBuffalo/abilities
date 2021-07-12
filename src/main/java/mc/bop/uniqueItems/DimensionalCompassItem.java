package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DimensionalCompassItem extends ItemStack implements BopItem {
    public String itemName = "Hellbound Compass";
    public String itemLore = "\"Vanish in smoke.\"";

    public DimensionalCompassItem() {
        super(Material.COMPASS);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

    public String getLore() {
        return itemLore;
    }

}
