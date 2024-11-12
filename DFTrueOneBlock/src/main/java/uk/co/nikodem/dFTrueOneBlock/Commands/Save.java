package uk.co.nikodem.dFTrueOneBlock.Commands;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import uk.co.nikodem.dFTrueOneBlock.DFTrueOneBlock;
import uk.co.nikodem.dFTrueOneBlock.Data.*;

import java.util.ArrayList;
import java.util.List;

public class Save implements CommandExecutor {
    private final DFTrueOneBlock plugin;
    public Save(DFTrueOneBlock plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player plr) {
            SkyblockPlayer sbplr = plugin.skyblockData.getSkyblockPlayerFromUUID(String.valueOf(plr.getUniqueId()), true);
            SkyblockWorld exampleWorld = new SkyblockWorld(sbplr, (byte) 1, Gamemode.deathprogress);
            SkyblockWorldMember exampleMember = new SkyblockWorldMember(String.valueOf(plr.getUniqueId()));
//            ItemStack exampleItem = new ItemStack(Material.NETHER_WART, 69);
//            ItemMeta exampleMeta = exampleItem.getItemMeta();
//            exampleMeta.addEnchant(
//                    Enchantment.DURABILITY,
//                    1,
//                    true
//            );
//            exampleMeta.addItemFlags(
//                    ItemFlag.HIDE_ENCHANTS
//            );
//            exampleMeta.addAttributeModifier(
//                    Attribute.GENERIC_ATTACK_DAMAGE,
//                    new AttributeModifier("rizzySkibidi", 1000, AttributeModifier.Operation.ADD_NUMBER)
//            );
//            exampleMeta.setCustomModelData(696969);
//            exampleMeta.setDisplayName("Rizzler");
//            List<String> lores = new ArrayList<>();
//            lores.add("Skibidi toilet");
//            lores.add("Second line (this is pretty rizzy ohio)!");
//            exampleMeta.setLore(lores);
//            exampleItem.setItemMeta(exampleMeta);
//            exampleMember.setCursorItem(exampleItem);
            exampleMember.setToOwner();
            exampleMember.setInv(plr.getInventory().getContents());
            exampleWorld.registerMember(exampleMember);
            plugin.skyblockData.saveSkyblockWorld(exampleWorld);
            commandSender.sendMessage("Saved example world!");

            plugin.skyblockData.saveSkyblockPlayer(sbplr);
            commandSender.sendMessage("Saved example player!");
        }
        return true;
    }
}
