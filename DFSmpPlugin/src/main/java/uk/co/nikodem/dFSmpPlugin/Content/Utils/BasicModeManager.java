package uk.co.nikodem.dFSmpPlugin.Content.Utils;

public class BasicModeManager {
    private static boolean basicMode;

    public static void initBasicMode() {
        basicMode = ConfigManager.otherData.getBoolean("basicMode");
    }

    public static boolean isBasicMode() {
        return basicMode;
    }
}
