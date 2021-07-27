package mc.bop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.bop.Main;
import mc.bop.util.BopPlayer;

public class OwOToggle implements CommandExecutor {
    public boolean onCommand(CommandSender p, Command cmd, String alias, String[] args) {
        if (p instanceof Player) {
            Player player = (Player) p;
            if (args.length == 0 && player.hasPermission("bop.owotoggle")) {
                return selfToggle(p);
            } else if (args.length != 0 && player.hasPermission("bop.owotoggle.others")) {
                return otherToggle(p, args);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private boolean selfToggle(CommandSender p) {
        if (p instanceof Player) {
            BopPlayer bp = new BopPlayer((Player) p);
            Main.addPlayer(bp);
            bp = Main.getBopPlayer(bp.getOfflinePlayer().getUniqueId());
            bp.toggleOwO();
            return true;
        }
        return false;
    }

    private boolean otherToggle(CommandSender p, String[] args) {
        BopPlayer bp = new BopPlayer(Bukkit.getPlayer(args[0]));
        Main.addPlayer(bp);
        bp = Main.getBopPlayer(bp.getOfflinePlayer().getUniqueId());
        bp.toggleOwO();
        return true;
    }
}