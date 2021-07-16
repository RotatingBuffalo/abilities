package mc.bop.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import mc.bop.uniqueItems.ItemList;

public class BopTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("givebopitem")) {
            return Arrays.asList((String[]) ItemList.customItems.keySet().toArray());
        }
        return null;
    }

}
