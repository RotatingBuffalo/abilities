package mc.bop.uniqueItems;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExcaliburItem extends ItemStack {
    static String itemName = "Excalibur";
    public static String itemLore = "\"Perhaps this thing is a little too flashy?\"";

    public ExcaliburItem() {
        super(Material.NETHERITE_SWORD, 1);
        ItemMeta im = this.getItemMeta();
        im.setDisplayName(ChatColor.RED + itemName);
        im.setLore(Arrays.asList(itemLore));
        this.setItemMeta(im);
    }

}
