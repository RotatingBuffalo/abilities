package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExcaliburItem extends ItemStack implements BopItem {
    public String itemName = "Excalibur";
    public String itemLore = "\"Perhaps this thing is a little too flashy?\"";

    public ExcaliburItem() {
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
