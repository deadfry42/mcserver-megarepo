package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;

import javax.annotation.Nullable;

import static java.util.Map.entry;
import java.util.Map;

public class AbilityBlocks {
    public final static Material[] veinMinableOres = new Material[] {
            Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE, Material.AMETHYST_BLOCK,
    };
    public final static Material[] veinMinableLogs = new Material[] {
            Material.ACACIA_LOG, Material.BIRCH_LOG, Material.CHERRY_LOG, Material.JUNGLE_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.OAK_LOG, Material.SPRUCE_LOG, Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_CHERRY_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_MANGROVE_LOG, Material.STRIPPED_OAK_LOG, Material.STRIPPED_SPRUCE_LOG, Material.WARPED_STEM, Material.CRIMSON_STEM, Material.STRIPPED_WARPED_STEM, Material.STRIPPED_CRIMSON_STEM
    };

    public final static Material[] cookableLogs = new Material[] {
            Material.ACACIA_LOG, Material.BIRCH_LOG, Material.CHERRY_LOG, Material.JUNGLE_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.OAK_LOG, Material.SPRUCE_LOG, Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_CHERRY_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_MANGROVE_LOG, Material.STRIPPED_OAK_LOG, Material.STRIPPED_SPRUCE_LOG
    };

    public final static Map<Material, Material> cookableOres = Map.ofEntries(
            entry(Material.IRON_ORE, Material.IRON_INGOT),
            entry(Material.GOLD_ORE, Material.GOLD_INGOT),
            entry(Material.COPPER_ORE, Material.COPPER_INGOT),
            entry(Material.DEEPSLATE_IRON_ORE, Material.IRON_INGOT),
            entry(Material.DEEPSLATE_GOLD_ORE, Material.GOLD_INGOT),
            entry(Material.DEEPSLATE_COPPER_ORE, Material.COPPER_INGOT),

            entry(Material.COBBLESTONE, Material.STONE),
            entry(Material.COBBLESTONE_SLAB, Material.STONE_SLAB),
            entry(Material.COBBLESTONE_STAIRS, Material.STONE_STAIRS),

            entry(Material.STONE, Material.SMOOTH_STONE),
            entry(Material.STONE_SLAB, Material.SMOOTH_STONE_SLAB),

            entry(Material.COBBLED_DEEPSLATE, Material.DEEPSLATE)
    );

    public final static Map<Material, Material> cookableShovel = Map.ofEntries(
            entry(Material.SAND, Material.GLASS),
            entry(Material.RED_SAND, Material.GLASS),
            entry(Material.GRAVEL, Material.FLINT)
    );

    public static boolean isVeinMinable(Material material) {
        for (Material ore : veinMinableOres) {
            if (material == ore) {
                return true;
            }
        }

        return false;
    }

    public static boolean isVeinLogMinable(Material material) {
        for (Material ore : veinMinableLogs) {
            if (material == ore) {
                return true;
            }
        }

        return false;
    }

    public static boolean isLogCookable(Material material) {
        for (Material ore : cookableLogs) {
            if (material == ore) {
                return true;
            }
        }

        return false;
    }

    @Nullable
    public static Material getCookableOre(Material material) {
        for (Map.Entry<Material, Material> entry : cookableOres.entrySet()) {
            if (entry.getKey() == material) return entry.getValue();
        }

        return null;
    }

    @Nullable
    public static Material getCookableShovel(Material material) {
        for (Map.Entry<Material, Material> entry : cookableShovel.entrySet()) {
            if (entry.getKey() == material) return entry.getValue();
        }

        return null;
    }

    public static boolean isPickaxe(ItemStack item) {
        // this accounts for custom pickaxes
        // cuz they're just reskins at their core
        if (item.getType() == Material.WOODEN_PICKAXE
                || item.getType() == Material.STONE_PICKAXE
                || item.getType() == Material.IRON_PICKAXE
                || item.getType() == Material.GOLDEN_PICKAXE
                || item.getType() == Material.DIAMOND_PICKAXE
                || item.getType() == Material.NETHERITE_PICKAXE) return true;
        return false;
    }

    public static boolean isAxe(ItemStack item) {
        // this accounts for custom axes
        // cuz they're just reskins at their core
        if (item.getType() == Material.WOODEN_AXE
                || item.getType() == Material.STONE_AXE
                || item.getType() == Material.IRON_AXE
                || item.getType() == Material.GOLDEN_AXE
                || item.getType() == Material.DIAMOND_AXE
                || item.getType() == Material.NETHERITE_AXE) return true;
        return false;
    }

    public static boolean isShovel(ItemStack item) {
        // this accounts for custom shovels
        // cuz they're just reskins at their core
        if (item.getType() == Material.WOODEN_SHOVEL
                || item.getType() == Material.STONE_SHOVEL
                || item.getType() == Material.IRON_SHOVEL
                || item.getType() == Material.GOLDEN_SHOVEL
                || item.getType() == Material.DIAMOND_SHOVEL
                || item.getType() == Material.NETHERITE_SHOVEL) return true;
        return false;
    }

    public static boolean viableVeinPickaxe(Player plr, ItemStack item) {
        if (CustomItemManager.IsItem(item, CustomItems.createVeinPickaxe())) return true;
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.vmessence, plr)) {
            if (plr.isSneaking()) {
                if (isPickaxe(item)) return true;
            }
        }
        return false;
    }

    public static boolean viableVeinAxe(Player plr, ItemStack item) {
        if (CustomItemManager.IsItem(item, CustomItems.createVeinAxe())) return true;
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.vmessence, plr)) {
            if (plr.isSneaking()) {
                if (isAxe(item)) return true;
            }
        }
        return false;
    }

    public static boolean viableAutosmeltPickaxe(Player plr, ItemStack item) {
        if (CustomItemManager.IsItem(item, CustomItems.createAutosmeltPickaxe())) return true;
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.asessence, plr)) {
            if (plr.isSneaking()) {
                if (isPickaxe(item)) return true;
            }
        }
        return false;
    }

    public static boolean viableAutosmeltAxe(Player plr, ItemStack item) {
        if (CustomItemManager.IsItem(item, CustomItems.createAutosmeltAxe())) return true;
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.asessence, plr)) {
            if (plr.isSneaking()) {
                if (isAxe(item)) return true;
            }
        }
        return false;
    }

    public static boolean viableAutosmeltShovel(Player plr, ItemStack item) {
        if (CustomItemManager.IsItem(item, CustomItems.createAutosmeltShovel())) return true;
        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.asessence, plr)) {
            if (plr.isSneaking()) {
                if (isShovel(item)) return true;
            }
        }
        return false;
    }
}
