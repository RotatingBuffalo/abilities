package mc.bop.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.inventory.ItemStack;

import mc.bop.uniqueItems.DimensionalCompassItem;
import mc.bop.uniqueItems.ExcaliburItem;
import mc.bop.uniqueItems.FeedingHoeItem;
import mc.bop.uniqueItems.SoupStaff;
import mc.bop.uniqueItems.WhipItem;

public class ItemList {

        public static Map<String, ItemStack> customItems = Stream
                        .of(new Object[][] { { "lightningSword", new ExcaliburItem() }, { "whip", new WhipItem() },
                                        { "dimShifter", new DimensionalCompassItem() },
                                        { "feedingHoe", new FeedingHoeItem() }, { "soupStaff", new SoupStaff() } })
                        .collect(Collectors.toMap(data -> (String) data[0], data -> (ItemStack) data[1]));

}
