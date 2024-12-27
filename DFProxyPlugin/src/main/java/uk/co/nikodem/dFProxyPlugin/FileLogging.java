package uk.co.nikodem.dFProxyPlugin;

import com.velocitypowered.api.proxy.Player;

import java.util.Objects;

public class FileLogging {
    public static DFProxyPlugin plugin;

    public static void IncrementGlobalJoinCount(LoginAttempt attempt) {
        int getJoins = plugin.logs.getInt("totalConnections.total");
        plugin.logs.set("totalConnections.total", getJoins+1);

        String path = attempt.bedrock ? "bedrock" : "java";
        String type = Objects.equals(attempt.type, "Success") ? "success" : "failure";

        int joins = plugin.logs.getInt("totalConnections."+path+"."+type);
        plugin.logs.set("totalConnections."+path+"."+type, joins+1);
    }

    public static void SetMostRecentAttempt(LoginAttempt attempt) {
        Player plr = attempt.plr;
        String uuid = plr.getUniqueId().toString();
        int getJoins = plugin.logs.getInt("players."+uuid+".connectionCount");
        plugin.logs.set("players."+uuid+".connectionCount", getJoins+1);

        plugin.logs.set("players."+uuid+".username", attempt.username);
        plugin.logs.set("players."+uuid+".latestPlatform", attempt.platform);

        plugin.logs.set("players."+uuid+".latestJoinTime", attempt.readableTime);
        plugin.logs.set("players."+uuid+".latestJoinTimestamp", attempt.time);

        plugin.logs.set("players."+uuid+".latestVersion", attempt.readableVer);
        plugin.logs.set("players."+uuid+".latestBedrock", attempt.bedrock);

        plugin.logs.set("players."+uuid+".latestType", attempt.type);
    }

    public static void LogAttempt(String path, LoginAttempt attempt) {
        Player plr = attempt.plr;

        plugin.logs.set(path+".username", attempt.username);
        plugin.logs.set(path+".platform", attempt.platform);

        plugin.logs.set(path+".joinTime", attempt.readableTime);
        plugin.logs.set(path+".joinTimestamp", attempt.time);

        plugin.logs.set(path+".version", attempt.readableVer);
        plugin.logs.set(path+".bedrock", attempt.bedrock);

        plugin.logs.set(path+".type", attempt.type);

        try {
            plugin.logs.save();
        } catch (final java.io.IOException e) {
            System.out.println("Error logging attempt!");
        }
    }

    public static void AddAttemptToUser(LoginAttempt attempt) {
        IncrementGlobalJoinCount(attempt);

        Player plr = attempt.plr;
        String uuid = plr.getUniqueId().toString();

        int getJoins = plugin.logs.getInt("players."+uuid+".connectionCount");
        SetMostRecentAttempt(attempt);

        LogAttempt("players."+uuid+".attempts.attempt-"+getJoins, attempt);
    }
}
