package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class ExtraAdvancementManager {
    public static DFSmpPlugin plugin;

    public static void init(DFSmpPlugin plugin) {
        ExtraAdvancementManager.plugin = plugin;
    }

    public static int getKeyValue(Player plr, String KEY) {
        String uuid = plr.getUniqueId().toString();
        return ConfigManager.otherData.getInt("advancements."+uuid+"."+KEY);
    }

    public static void setKeyValue(Player plr, String KEY, int val) {
        String uuid = plr.getUniqueId().toString();
        ConfigManager.otherData.set("advancements."+uuid+"."+KEY, val);
        ConfigManager.saveData(ConfigManager.DataFiles.OTHER);
    }

    public static void incrementKeyValue(Player plr, String KEY, int amnt) {
        int val = getKeyValue(plr, KEY);
        val += amnt;
        setKeyValue(plr, KEY, val);
    }

    public static void setIndecisiveWardrobeProgression(Player plr) {
        if (plugin.ca.IndecisiveWardrobe.isGranted(plr)) return;
        int prevamnt = getStoredWornAmount(plr);
        int amnt = getWornAmount(plr);
        if (prevamnt == amnt) return;
        setStoredWornAmount(plr, amnt);
        if (amnt > plugin.ca.IndecisiveWardrobe.getMaxProgression()) {
            plugin.ca.IndecisiveWardrobe.setProgression(
                    plr,
                    plugin.ca.IndecisiveWardrobe.getMaxProgression()
            );
        } else {
            plugin.ca.IndecisiveWardrobe.setProgression(
                    plr,
                    amnt
            );
        }
    }

    public static int getStoredWornAmount(Player plr) {
        String uuid = plr.getUniqueId().toString();
        return ConfigManager.otherData.getInt("advancements."+uuid+"."+ plugin.ca.IndecisiveWardrobe.getKey()+"-wornAmnt");
    }

    public static void setStoredWornAmount(Player plr, int amnt) {
        String uuid = plr.getUniqueId().toString();
        ConfigManager.otherData.set("advancements."+uuid+"."+ plugin.ca.IndecisiveWardrobe.getKey()+"-wornAmnt", amnt);
        ConfigManager.saveData(ConfigManager.DataFiles.OTHER);
    }

    public static int getWornAmount(Player plr) {
        String uuid = plr.getUniqueId().toString();
        int i = 0;
        ConfigurationSection sec = ConfigManager.otherData.getConfigurationSection("advancements."+uuid+"."+ plugin.ca.IndecisiveWardrobe.getKey()+"-worn");
        if (sec != null) {
            for (String a : sec.getKeys(false)) {
                i++;
            }
        }
        return i;
    }

    public static void setSetWorn(Player plr, String type) {
        String uuid = plr.getUniqueId().toString();
        ConfigManager.otherData.set("advancements."+uuid+"."+ plugin.ca.IndecisiveWardrobe.getKey()+"-worn."+type, true);
        ConfigManager.saveData(ConfigManager.DataFiles.OTHER);
    }

    public static void loadKeys(Player plr) {
        int amnt = getWornAmount(plr);
        if (amnt <= plugin.ca.IndecisiveWardrobe.getMaxProgression()) {
            plugin.ca.IndecisiveWardrobe.setProgression(
                    plr,
                    getWornAmount(plr)
            );
        } else {
            plugin.ca.IndecisiveWardrobe.setProgression(
                    plr,
                    plugin.ca.IndecisiveWardrobe.getMaxProgression()
            );
        }
    }
}
