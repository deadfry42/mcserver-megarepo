package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.ArrayList;
import java.util.List;

import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.AbilityBlocks.*;

public class BreakBlock {
    public static DFSmpPlugin plugin;

    public static void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        if (!event.isDropItems()) return;
        Block origin = event.getBlock();
        Player plr = event.getPlayer();
        ItemStack item = plr.getInventory().getItemInMainHand();

        if (origin.getType() == Material.GRAVEL) {
            if (!CustomItemManager.IsItem(item, CustomItems.createAutosmeltShovel())) {
                event.setDropItems(false);
                plr.getWorld().dropItemNaturally(origin.getLocation().add(new Location(origin.getWorld(), 0.5, 0.5, 0.5)), new ItemStack(Material.GRAVEL));
            }
        }

        if (viableVeinPickaxe(plr, item)) {
            if (isVeinMinable(origin.getType())) {
                if (!plugin.ca.VeinMinedALot.isGranted(plr)) plugin.ca.VeinMinedALot.incrementProgression(plr);
                List<Block> veinBlocks = new ArrayList<>();
                veinBlocks.add(origin);
                findVeinBlocks(origin, origin.getType(), veinBlocks);

                Damageable im = (Damageable) item.getItemMeta();
                if (im == null) return;
                int damage = im.getDamage() + 1;
                im.setDamage(damage);
                item.setItemMeta(im);

                for (Block block : veinBlocks) {
                    block.breakNaturally(item);
                }
            }
        } else if (viableVeinAxe(plr, item)) {
            if (isVeinLogMinable(origin.getType())) {
                if (!plugin.ca.VeinMinedALot.isGranted(plr)) plugin.ca.VeinMinedALot.incrementProgression(plr);
                List<Block> veinLogs = new ArrayList<>();
                veinLogs.add(origin);
                findVeinLogs(origin, origin.getType(), veinLogs);

                Damageable im = (Damageable) item.getItemMeta();
                if (im == null) return;
                int damage = im.getDamage() + 1;
                im.setDamage(damage);
                item.setItemMeta(im);

                for (Block block : veinLogs) {
                    block.breakNaturally(item);
                }
            }
        } else if (viableAutosmeltAxe(plr, item)) {
            if (isLogCookable(origin.getType())) {
                event.setDropItems(false);

                plr.getWorld().playSound(plr, Sound.BLOCK_FIRE_EXTINGUISH, 0.3F, 1F);
                for (var drop : origin.getDrops(item)) {
                    ItemStack newDrop = drop;
                    newDrop.setType(Material.CHARCOAL);
                    plr.getWorld().dropItemNaturally(origin.getLocation().add(new Location(origin.getWorld(), 0.5, 0.5, 0.5)), newDrop);
                }

                if (!plugin.ca.AutoSmeltedALot.isGranted(plr)) plugin.ca.AutoSmeltedALot.incrementProgression(plr);
            }
        } else if (viableAutosmeltPickaxe(plr, item)) {
            Material drop = getCookableOre(origin.getType());
            if (drop != null) {
                event.setDropItems(false);
                plr.getWorld().playSound(plr, Sound.BLOCK_FIRE_EXTINGUISH, 0.3F, 1F);

                for (var a : origin.getDrops(item)) {
                    ItemStack newDrop = a;
                    newDrop.setType(drop);
                    plr.getWorld().dropItemNaturally(origin.getLocation().add(new Location(origin.getWorld(), 0.5, 0.5, 0.5)), newDrop);
                }

                if (!plugin.ca.AutoSmeltedALot.isGranted(plr)) plugin.ca.AutoSmeltedALot.incrementProgression(plr);
            }
        } else if (viableAutosmeltShovel(plr, item)) {
            Material drop = getCookableShovel(origin.getType());
            if (drop != null) {
                event.setDropItems(false);
                plr.getWorld().playSound(plr, Sound.BLOCK_FIRE_EXTINGUISH, 0.3F, 1F);

                for (var a : origin.getDrops(item)) {
                    ItemStack newDrop = a;
                    newDrop.setType(drop);
                    plr.getWorld().dropItemNaturally(origin.getLocation().add(new Location(origin.getWorld(), 0.5, 0.5, 0.5)), newDrop);
                }

                if (!plugin.ca.AutoSmeltedALot.isGranted(plr)) plugin.ca.AutoSmeltedALot.incrementProgression(plr);
            }
        }
    }

    private static void findVeinBlocks(Block origin, Material type, List<Block> veinBlocks) {
        BlockFace[] var4 = BlockFace.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            BlockFace face = var4[var6];
            Block relative = origin.getRelative(face);
            if (relative.getType() == type && !veinBlocks.contains(relative)) {
                veinBlocks.add(relative);
                findVeinBlocks(relative, type, veinBlocks);
            }
        }

    }

    private static void findVeinLogs(Block origin, Material type, List<Block> veinLogs) {
        BlockFace[] var4 = BlockFace.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            BlockFace face = var4[var6];
            Block relative = origin.getRelative(face);
            if (relative.getType() == type && !veinLogs.contains(relative)) {
                veinLogs.add(relative);
                findVeinLogs(relative, type, veinLogs);
            }
        }

    }
}
