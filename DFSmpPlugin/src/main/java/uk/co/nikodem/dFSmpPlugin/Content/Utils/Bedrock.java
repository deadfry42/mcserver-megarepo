package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.entity.Player;

public class Bedrock {
    public static boolean isBedrockPlayer(Player plr) {
        // TODO: implement a better way to detect bedrock players
        // this only detects floodgate players, and only if the prefix is "."
        // which in my use case it is, but it might not work for others

        // too lazy to add geysermc as a dependency, so I might make this talk to the proxy plugin

        return plr.getName().startsWith(".");
    }

    public static boolean isJavaPlayer(Player plr) {

        return !isBedrockPlayer(plr);
    }
}
