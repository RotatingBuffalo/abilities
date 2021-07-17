package mc.bop.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

public class BopData implements Serializable {
    private static transient final long serialVersionUID = -1681012206529286330L;
    private static Set<BopPlayer> playerSet;

    public void addPlayerToData(Player p) {
        BopPlayer bp = new BopPlayer(p);
        playerSet.add(bp);
    }

    public boolean saveData(String filePath) {
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(
                    new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject(this);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static BopData loadData(String filePath) {
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream(
                    new GZIPInputStream(new FileInputStream(filePath)));
            BopData data = (BopData) in.readObject();
            in.close();
            return data;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
