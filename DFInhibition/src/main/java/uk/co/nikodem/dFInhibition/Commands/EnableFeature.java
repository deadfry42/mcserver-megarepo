package uk.co.nikodem.dFInhibition.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFInhibition.DFInhibition;

public class EnableFeature implements CommandExecutor {
    public final DFInhibition plugin;
    public final FileConfiguration config;
    public final String featureString;

    public EnableFeature(DFInhibition plugin, String featureString) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.featureString = featureString;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Only the console is permitted to run this command!"));
            return true;
        }

        config.set(featureString, false);

        String title = "undefined";
        String subtitle = "good luck :)";

        if (featureString.equals("pvp")) {
            title = "PVP has been enabled!";
        } else if (featureString.equals("nether")) {
            title = "The Nether has been enabled!";
        } else if (featureString.equals("end")) {
            title = "The End has been enabled!";
        }

        for(Player plr : Bukkit.getOnlinePlayers()){
            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2"+title));
            plr.playSound(plr, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
            plr.sendTitle(ChatColor.translateAlternateColorCodes('&', title), "You can now lose hearts.");
        }

        return true;
    }
}
