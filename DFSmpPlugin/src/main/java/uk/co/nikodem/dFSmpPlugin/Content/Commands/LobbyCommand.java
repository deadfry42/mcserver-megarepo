package uk.co.nikodem.dFSmpPlugin.Content.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BungeeUtils;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.logging.Level;

public class LobbyCommand implements CommandExecutor {
    private final DFSmpPlugin plugin;
    private final BungeeUtils bu;

    public LobbyCommand(DFSmpPlugin plugin, BungeeUtils bu) {
        this.plugin = plugin;
        this.bu = bu;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player plr = (Player) commandSender;
        if (CombatLoggingManager.playerInCombat(plr)) {
            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You are currently in combat!"));
        } else {
            plugin.getLogger().log(Level.INFO, commandSender.getName()+" teleporting to lobby!");
            bu.sendPlayerToServer(plr, "lobby");
        }
        return true;
    }
}
