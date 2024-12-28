package uk.co.nikodem.dFChatImprovements;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DFChatImprovements extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e) {
        // chat modifications

        if (e.isCancelled()) return;

        String msg = e.getMessage();
        for (String word : msg.split("\\s+")){
            // pinging
            if (word.startsWith("@")) {
                String name = word.substring(1);
                for (Player mentioned : Bukkit.getOnlinePlayers()) {
                    if (mentioned.getDisplayName().equals(name)) {
                        mentioned.playSound(mentioned.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
                        msg = msg.replace(word, ChatColor.translateAlternateColorCodes('&', "&3"+word+"&r"));
                    }
                }

                // emoji
            } else if (word.startsWith(":") && word.endsWith(":")) {
                // emoji
                String emojiName = word.substring(1, word.length()-1).toLowerCase();
                switch (emojiName) {
                    case "skull" -> msg = msg.replace(word, "\uE900");
                    case "cold_sunglasses" -> msg = msg.replace(word, "\uE901");
                    case "sob" -> msg = msg.replace(word, "\uE902");
                    case "flag_pl" -> msg = msg.replace(word, "\uE903");
                    case "sunglasses" -> msg = msg.replace(word, "\uE904");
                    case "smile" -> msg = msg.replace(word, "\uE905");
                    case "money_mouth", "money_mouth_face" -> msg = msg.replace(word, "\uE906");
                    case "pray", "folded_hands" -> msg = msg.replace(word, "\uE907");
                    case "smiling_face_with_3_hearts", "3_hearts" -> msg = msg.replace(word, "\uE908");
                    case "smirk_cat" -> msg = msg.replace(word, "\uE909");
                    case "cold_face" -> msg = msg.replace(word, "\uE90A");
                    case "speaking_head", "speaking_head_in_silhouette" -> msg = msg.replace(word, "\uE90B");
                    case "fire", "flame" -> msg = msg.replace(word, "\uE90C");
                    case "fish" -> msg = msg.replace(word, "\uE90D");
                    case "moai", "moyai" -> msg = msg.replace(word, "\uE90E");
                    case "thumbs_up" -> msg = msg.replace(word, "\uE90F");
                    case "salute" -> msg = msg.replace(word, "\uE910");
                    case "shrug" -> msg = msg.replace(word, "\uE911");
                    case "wompwomp" -> msg = msg.replace(word, "\uE912");

                    case null, default -> {

                    }
                }
            }
        }

        // make \: replace with : so you can say things like :skull: without it turning into an emoji
        msg = msg.replace("\\:", ":");

        e.setMessage(msg);
    }
}
