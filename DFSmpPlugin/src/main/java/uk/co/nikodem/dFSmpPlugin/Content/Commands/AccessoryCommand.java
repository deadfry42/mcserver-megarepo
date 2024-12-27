package uk.co.nikodem.dFSmpPlugin.Content.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryGUI.OpenAccessoriesGUI;

public class AccessoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player plr) {
            OpenAccessoriesGUI(plr);
        } else {
            sender.sendMessage("You are not a player!");
        }
        return true;
    }
}
