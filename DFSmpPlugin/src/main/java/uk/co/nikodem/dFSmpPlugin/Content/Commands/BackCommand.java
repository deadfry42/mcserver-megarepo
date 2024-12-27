package uk.co.nikodem.dFSmpPlugin.Content.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.LastDeathManager;

import java.util.concurrent.TimeUnit;

public class BackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player plr) {

            long time = LastDeathManager.playerGetLastDeathTime(plr);

            long diff = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis()-time);

            if (time < (System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(5))) {
                return denyBack(plr, "you died "+diff+" "+(diff == 1 ? "minute" : "minutes")+" ago!");
            }

            if (CombatLoggingManager.playerInCombat(plr)) {
                return denyBack(plr, "you are in combat!");
            }

            Location loc = LastDeathManager.playerGetLastDeathLocation(plr);

            if (loc == null) {
                return denyBack(plr, "you haven't died recently!");
            }

            boolean used = LastDeathManager.playerGetUsedBack(plr);

            if (used) {
                return denyBack(plr, "you haven't died recently!");
            }

            boolean pvp = LastDeathManager.playerGetLastDeathPvp(plr);

            if (pvp) {
                return denyBack(plr, "you died in PVP!");
            }

            // all conditions checked

            plr.teleport(loc);
            LastDeathManager.playerSetUsedBack(plr);

            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Successfully teleported back!"));
        } else {
            commandSender.sendMessage("You are not a player!");
        }
        return false;
    }

    private boolean denyBack(Player plr, String reason) {
        plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You cannot teleport back because "+reason));
        return false;
    }
}
