package mc.bop.util;

import org.bukkit.entity.Player;

public class BopPlayer {
    private Player me;
    private boolean owoActive;
    private boolean insomniac;

    public BopPlayer(Player p) {
        me = p;
        owoActive = false;
        insomniac = false;
    }

    public BopPlayer(Player p, boolean owo, boolean insomnia) {
        me = p;
        owoActive = owo;
        insomniac = insomnia;
    }

    public boolean isOwOActive() {
        return owoActive;
    }

    public boolean isInsomniac() {
        return insomniac;
    }

    public Player getPlayer() {
        return me;
    }
}
