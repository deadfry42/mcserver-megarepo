package uk.co.nikodem.dFInhibition.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import uk.co.nikodem.dFInhibition.DFInhibition;

public class milestones implements CommandExecutor {
    public final DFInhibition plugin;
    public final FileConfiguration config;

    public milestones(DFInhibition plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Disabled features:"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3PVP: "+config.getString("milestones.pvp")));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Nether: "+config.getString("milestones.nether")));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3End: "+config.getString("milestones.end")));
        return true;
    }
}
