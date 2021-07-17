package mc.bop.commands;

import java.util.List;
import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import mc.bop.util.ItemList;

public class BopTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("givebopitem")) {
            List<String> results = new ArrayList<String>();
            for (int i = 0; i < ItemList.customItems.keySet().size(); i++) {
                results.add((String) ItemList.customItems.keySet().toArray()[i]);
            }
            return results;
        }
        return null;
    }

}
