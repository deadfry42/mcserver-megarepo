package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CustomItemManager;

import java.util.ArrayList;
import java.util.List;

import static uk.co.nikodem.dFSmpPlugin.Content.Utils.VeinMinableBlocks.veinMinableLogs;
import static uk.co.nikodem.dFSmpPlugin.Content.Utils.VeinMinableBlocks.veinMinableOres;

public class BreakBlock implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block origin = event.getBlock();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (CustomItemManager.IsItem(item, CustomItemManager.createVeinPickaxe())) {
            if (isVeinMinable(origin.getType())) {
                List<Block> veinBlocks = new ArrayList<>();
                veinBlocks.add(origin);
                this.findVeinBlocks(origin, origin.getType(), veinBlocks);

                Damageable im = (Damageable) item.getItemMeta();
                int damage = im.getDamage() + 1;
                im.setDamage(damage);
                item.setItemMeta(im);

                for (Block block : veinBlocks) {
                    block.breakNaturally(item);
                }
            }
        } else if (CustomItemManager.IsItem(item, CustomItemManager.createVeinAxe())) {
            if (isVeinLogMinable(origin.getType())) {
                List<Block> veinLogs = new ArrayList<>();
                veinLogs.add(origin);
                this.findVeinLogs(origin, origin.getType(), veinLogs);

                Damageable im = (Damageable) item.getItemMeta();
                int damage = im.getDamage() + 1;
                im.setDamage(damage);
                item.setItemMeta(im);

                for (Block block : veinLogs) {
                    block.breakNaturally(item);
                }
            }
        }
    }

    private void findVeinBlocks(Block origin, Material type, List<Block> veinBlocks) {
        BlockFace[] var4 = BlockFace.values();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            BlockFace face = var4[var6];
            Block relative = origin.getRelative(face);
            if (relative.getType() == type && !veinBlocks.contains(relative)) {
                veinBlocks.add(relative);
                this.findVeinBlocks(relative, type, veinBlocks);
            }
        }

    }

    private boolean isVeinMinable(Material material) {
        Material[] allOres = veinMinableOres;
        int oresLength = allOres.length;

        for(int i = 0; i < oresLength; i++) {
            Material ore = allOres[i];
            if (material == ore) {
                return true;
            }
        }

        return false;
    }

    private void findVeinLogs(Block origin, Material type, List<Block> veinLogs) {
        BlockFace[] var4 = BlockFace.values();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            BlockFace face = var4[var6];
            Block relative = origin.getRelative(face);
            if (relative.getType() == type && !veinLogs.contains(relative)) {
                veinLogs.add(relative);
                this.findVeinLogs(relative, type, veinLogs);
            }
        }

    }

    private boolean isVeinLogMinable(Material material) {
        Material[] allLogs = veinMinableLogs;
        int logsLength = allLogs.length;

        for(int i = 0; i < logsLength; i++) {
            Material ore = allLogs[i];
            if (material == ore) {
                return true;
            }
        }

        return false;
    }
}
