package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class BasicModeManager {
    public static boolean basicMode;

    public static void initBasicMode(DFSmpPlugin plugin) {
        basicMode = plugin.getConfig().getBoolean("basicMode");
    }
}
