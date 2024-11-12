package uk.co.nikodem.dFInhibition.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import uk.co.nikodem.dFInhibition.DFInhibition;

import static org.bukkit.Bukkit.getServer;

public class StartSMP implements CommandExecutor {
    public final DFInhibition plugin;
    public final FileConfiguration config;

    public StartSMP(DFInhibition plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Only the console is permitted to run this command!"));
            return true;
        }
        // console only
        for(Player plr : Bukkit.getOnlinePlayers()){
            plr.sendTitle(ChatColor.translateAlternateColorCodes('&', "&7The SMP is starting!"), "("+ Bukkit.getOnlinePlayers().size()+" players online)");
        }
        final int[] i = {16};
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTaskTimer(plugin, (task) -> {
            // runs every second
            i[0] -= 1;
            if (i[0] < 0) {
                for (Player plr : Bukkit.getOnlinePlayers()) {
                    plr.playSound(plr, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2SMP has started!"));
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4PVP will be enabled in 1 day!"));
                    plr.sendTitle(ChatColor.translateAlternateColorCodes('&', "The SMP has begun!"), "good luck :)");
                }
                Bukkit.dispatchCommand(commandSender, "worldborder set 10000 10");
                Bukkit.dispatchCommand(commandSender, "clear @a");
                Bukkit.dispatchCommand(commandSender, "effect clear @a");
                config.set("locked", false);
                Bukkit.dispatchCommand(commandSender, "effect give @a minecraft:regeneration 1 255");
                Bukkit.dispatchCommand(commandSender, "effect give @a minecraft:saturation 1 255");
                Bukkit.dispatchCommand(commandSender, "effect give @a minecraft:resistance 5 255");
                Bukkit.dispatchCommand(commandSender, "time set day");
                Bukkit.dispatchCommand(commandSender, "weather clear");

                scheduler.cancelTask(task.getTaskId());
            } else {
                for (Player plr : Bukkit.getOnlinePlayers()) {
                    plr.playSound(plr, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    plr.sendMessage("Starting in " + Integer.toString(i[0]) + "!");
                }
            }
        }, 0, 20);
        return false;
    }
}
