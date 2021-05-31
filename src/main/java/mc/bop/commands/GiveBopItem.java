package mc.bop.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.bop.uniqueItems.ItemList;

public class GiveBopItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            for (int x = 0; x < args.length; x++) {
                if (ItemList.customItems.containsKey(args[x])) {
                    p.getInventory().addItem(ItemList.customItems.get(args[x]));
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "The item given either does not exist or was improperly typed.");
                }
            }
            return true;
        } else

        {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return false;
        }
    }
}
