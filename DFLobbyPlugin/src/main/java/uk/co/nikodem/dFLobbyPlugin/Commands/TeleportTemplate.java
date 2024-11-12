package uk.co.nikodem.dFLobbyPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFLobbyPlugin.Handlers.BungeeUtils;

public class TeleportTemplate implements CommandExecutor {
    private final BungeeUtils bu;
    public final String serverName;

    public TeleportTemplate(BungeeUtils bu, String serverName) {
        this.bu = bu;
        this.serverName = serverName;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            bu.sendPlayerToServer((Player) commandSender, serverName);
        } else {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You are not a player!"));
        }

        return true;
    }
}
