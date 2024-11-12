package uk.co.nikodem.dFTrueOneBlock.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uk.co.nikodem.dFTrueOneBlock.DFTrueOneBlock;
import uk.co.nikodem.dFTrueOneBlock.Data.SkyblockPlayer;
import uk.co.nikodem.dFTrueOneBlock.Data.SkyblockWorld;

public class Reconstruct implements CommandExecutor {
    private final DFTrueOneBlock plugin;

    public Reconstruct(DFTrueOneBlock plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player plr) {
            String uuid = String.valueOf(plr.getUniqueId());

            SkyblockPlayer skyblockPlayer = plugin.skyblockData.getSkyblockPlayerFromUUID(uuid);

            plr.sendMessage("Loaded worlds: ("+plugin.skyblockData.skyblockWorlds.size()+")");
            for (int i = 0; i < plugin.skyblockData.skyblockWorlds.size(); i++) {
                SkyblockWorld skyblockWorld = plugin.skyblockData.skyblockWorlds.get(i);
                plr.sendMessage("world "+skyblockWorld.getWorldId()+": "+skyblockWorld.getName());
            }

            plr.sendMessage("Loaded players: ("+plugin.skyblockData.skyblockPlayers.size()+")");
            for (int i = 0; i < plugin.skyblockData.skyblockPlayers.size(); i++) {
                SkyblockPlayer skyblockPlayer1 = plugin.skyblockData.skyblockPlayers.get(i);
                plr.sendMessage("player "+skyblockPlayer1.getUniqueId());
            }

//            if (skyblockPlayer != null) {
//                plr.sendMessage("Not Null!");
//            } else {
//                plr.sendMessage("Null!");
//            }

//            String plrPath = "skyblockworlds."+uuid+"--1.members."+uuid;
//
//            assert plugin.saveData.getWorldData() != null;
//            ItemStack reconstructedItem = plugin.saveData.createItemStackFromConfiguration(plugin.saveData.getWorldData(), plrPath+".cursorItem");
//            ItemStack[] inventory = plugin.saveData.createInventoryFromConfiguration(plugin.saveData.getWorldData(), plrPath+".inv");
//
//            plr.getInventory().setContents(inventory);
//            plr.setItemOnCursor(reconstructedItem);
        }

        return true;
    }
}
