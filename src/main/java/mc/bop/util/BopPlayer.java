package mc.bop.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class BopPlayer {
    private OfflinePlayer whoami;
    private Boolean OwOtoggled = Boolean.valueOf(false);

    public OfflinePlayer getOfflinePlayer() {
        return whoami;
    }

    public boolean getOwOtoggle() {
        return OwOtoggled.booleanValue();
    }

    public void toggleOwO() {
        OwOtoggled = !OwOtoggled;
    }

    public BopPlayer(Player p) {
        whoami = p;
    }

    public String save() {
        String owoState = OwOtoggled.toString();
        String p = whoami.getUniqueId().toString();
        String result = "owoState:" + owoState + "\n" + "player:" + p;
        return result;
    }

    public void load(File f) {
        Scanner s;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        String[] states = { "", "" };
        while (s.hasNextLine()) {
            String currentLine = s.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.charAt(i) == ':') {
                    String attribute = currentLine.substring(i);
                    states[i] = attribute;
                }
            }
        }
        this.whoami = Bukkit.getOfflinePlayer(UUID.fromString(states[0]));
        this.OwOtoggled = Boolean.valueOf(states[1]);
        s.close();
    }
}
