package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundManager {
    public static void PlayFailedSound(Player plr) {
        plr.playSound(plr.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 0.3F);
    }

    public static void PlayAskSound(Player plr) {
        plr.playSound(plr.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1F);
    }

    public static void PlaySucceedSound(Player plr) {
        plr.getWorld().playSound(plr.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
    }
}
