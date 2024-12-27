package uk.co.nikodem.dFLobbyPlugin.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player plr) {
            PlayerInventory inv = plr.getInventory();
            inv.clear();
            inv.setHelmet((int) (Math.random() * 30 + 1) == 10 ? new ItemStack(Material.GLASS) : new ItemStack(Material.IRON_HELMET));
            inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            inv.setBoots(new ItemStack(Material.IRON_BOOTS));
            inv.setItemInOffHand((int) (Math.random() * 3 + 1) == 1 ? new ItemStack(Material.TOTEM_OF_UNDYING) : new ItemStack(Material.SHIELD));
            inv.addItem(new ItemStack(Material.IRON_SWORD), setAmnt(new ItemStack(Material.GOLDEN_APPLE), (int) (Math.random() * 5 + 1)));
        } else {
            // i've lost my sanity
            sender.sendMessage("you are not player !1!!");
        }
        return true;
    }

    public static ItemStack setAmnt(ItemStack i, int amnt) {
        i.setAmount(amnt);
        return i;
    }
}
