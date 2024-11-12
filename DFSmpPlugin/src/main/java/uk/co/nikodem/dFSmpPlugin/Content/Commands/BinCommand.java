package uk.co.nikodem.dFSmpPlugin.Content.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class BinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player plr = (Player) commandSender;

            Inventory bin = Bukkit.createInventory(null, 54, "bin-dfsmp");
            InventoryView view = plr.openInventory(bin);
            view.setTitle("Bin");
        } else {
            commandSender.sendMessage("Consoles cannot run this command!");
        }
        return true;
    }
}
