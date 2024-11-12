package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItemManager {
    public static ItemStack createMagicMirror() {
        ItemStack magicMirror = new ItemStack(Material.COMPASS);
        ItemMeta magicMirrorMeta = magicMirror.getItemMeta();
        assert magicMirrorMeta != null;
        List<String> lores = new ArrayList<String>();
        magicMirrorMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Magic Mirror"));
        lores.add(ChatColor.translateAlternateColorCodes('&', "&6Teleports you back to your bed."));
        lores.add(ChatColor.translateAlternateColorCodes('&', "&cWill not work in combat."));
        magicMirrorMeta.setLore(lores);
        magicMirrorMeta.setCustomModelData(10101);
        magicMirrorMeta.addEnchant(Enchantment.LOYALTY, 100, true);
        magicMirrorMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        magicMirror.setItemMeta(magicMirrorMeta);
        return magicMirror;
    }

    public static ItemStack createWarpedWart() {
        ItemStack warpedWart = new ItemStack(Material.NETHER_WART);
        ItemMeta warpedWartMeta = warpedWart.getItemMeta();
        assert warpedWartMeta != null;
        List<String> lores = new ArrayList<String>();
        warpedWartMeta.setDisplayName("Warped Wart");
        warpedWartMeta.setLore(lores);
        warpedWartMeta.setCustomModelData(6969);
        warpedWart.setItemMeta(warpedWartMeta);
        return warpedWart;
    }

    public static ItemStack createEntityBucket() {
        ItemStack entityBucket = new ItemStack(Material.BUCKET);
        ItemMeta entityBucketMeta = entityBucket.getItemMeta();
        assert entityBucketMeta != null;
        List<String> lores = new ArrayList<String>();
        entityBucketMeta.setDisplayName("Entity Bucket");
        entityBucketMeta.setLore(lores);
        entityBucketMeta.setCustomModelData(6969);
        entityBucket.setItemMeta(entityBucketMeta);
        return entityBucket;
    }

//    public static ItemStack createMiningHelmet() {
//        ItemStack miningHelmet = new ItemStack(Material.LEATHER_HELMET);
//        LeatherArmorMeta miningHelmetMeta = (LeatherArmorMeta) miningHelmet.getItemMeta();
//        assert miningHelmetMeta != null;
//        miningHelmetMeta.setColor(Color.YELLOW);
//        List<String> lores = new ArrayList<String>();
//        miningHelmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Mining Helmet"));
//        lores.add(ChatColor.translateAlternateColorCodes('&', "&5Lights up the area."));
//        miningHelmetMeta.setLore(lores);
//        miningHelmetMeta.setCustomModelData(8008);
//        miningHelmet.setItemMeta(miningHelmetMeta);
//        return miningHelmet;
//    }

    public static ItemStack createCalciteSword() {
        ItemStack calciteSword = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta calciteSwordMeta = calciteSword.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteSwordMeta != null;
        calciteSwordMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Sword"));
        lores.add("A very light sword.");
        calciteSwordMeta.setLore(lores);
        calciteSwordMeta.setCustomModelData(6969);
        calciteSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        calciteSword.setItemMeta(calciteSwordMeta);
        return calciteSword;
    }

    public static ItemStack createCalciteAxe() {
        ItemStack calciteAxe = new ItemStack(Material.STONE_AXE, 1);
        ItemMeta calciteAxeMeta = calciteAxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteAxeMeta != null;
        calciteAxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Axe"));
        lores.add("A very light axe.");
        calciteAxeMeta.setLore(lores);
        calciteAxeMeta.setCustomModelData(6969);
        calciteAxeMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        calciteAxe.setItemMeta(calciteAxeMeta);
        return calciteAxe;
    }

    public static ItemStack createCalcitePickaxe() {
        ItemStack calcitePickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta calcitePickaxeMeta = calcitePickaxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calcitePickaxeMeta != null;
        calcitePickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Pickaxe"));
        lores.add("A very light pickaxe.");
        calcitePickaxeMeta.setLore(lores);
        calcitePickaxeMeta.setCustomModelData(6969);
        calcitePickaxeMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        calcitePickaxe.setItemMeta(calcitePickaxeMeta);
        return calcitePickaxe;
    }

    public static ItemStack createCalciteShovel() {
        ItemStack calciteShovel = new ItemStack(Material.STONE_SHOVEL, 1);
        ItemMeta calciteShovelMeta = calciteShovel.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteShovelMeta != null;
        calciteShovelMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Shovel"));
        lores.add("A very light shovel.");
        calciteShovelMeta.setLore(lores);
        calciteShovelMeta.setCustomModelData(6969);
        calciteShovelMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        calciteShovel.setItemMeta(calciteShovelMeta);
        return calciteShovel;
    }

    public static ItemStack createCalciteHoe() {
        ItemStack calciteHoe = new ItemStack(Material.STONE_HOE, 1);
        ItemMeta calciteHoeMeta = calciteHoe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteHoeMeta != null;
        calciteHoeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Hoe"));
        lores.add("A very light hoe.");
        calciteHoeMeta.setLore(lores);
        calciteHoeMeta.setCustomModelData(6969);
        calciteHoeMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        calciteHoe.setItemMeta(calciteHoeMeta);
        return calciteHoe;
    }

    public static ItemStack createCalciteHelmet() {
        ItemStack calciteHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemMeta calciteHelmetMeta = calciteHelmet.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteHelmetMeta != null;
        calciteHelmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Helmet"));
        lores.add("Has a set bonus.");
        calciteHelmetMeta.setLore(lores);
        calciteHelmetMeta.setCustomModelData(6969);
        calciteHelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        calciteHelmet.setItemMeta(calciteHelmetMeta);
        return calciteHelmet;
    }

    public static ItemStack createCalciteChestplate() {
        ItemStack calciteChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta calciteChestplateMeta = calciteChestplate.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteChestplateMeta != null;
        calciteChestplateMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Chestplate"));
        lores.add("Has a set bonus.");
        calciteChestplateMeta.setLore(lores);
        calciteChestplateMeta.setCustomModelData(6969);
        calciteChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        calciteChestplate.setItemMeta(calciteChestplateMeta);
        return calciteChestplate;
    }

    public static ItemStack createCalciteLeggings() {
        ItemStack calciteLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemMeta calciteLeggingsMeta = calciteLeggings.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteLeggingsMeta != null;
        calciteLeggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Leggings"));
        lores.add("Has a set bonus.");
        calciteLeggingsMeta.setLore(lores);
        calciteLeggingsMeta.setCustomModelData(6969);
        calciteLeggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        calciteLeggings.setItemMeta(calciteLeggingsMeta);
        return calciteLeggings;
    }

    public static ItemStack createCalciteBoots() {
        ItemStack calciteBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta calciteBootsMeta = calciteBoots.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert calciteBootsMeta != null;
        calciteBootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Calcite Boots"));
        lores.add("Has a set bonus.");
        calciteBootsMeta.setLore(lores);
        calciteBootsMeta.setCustomModelData(6969);
        calciteBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        calciteBoots.setItemMeta(calciteBootsMeta);
        return calciteBoots;
    }

    public static ItemStack createObsidianPickaxe() {
        ItemStack obsidianPickaxe = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta obsidianPickaxeMeta = obsidianPickaxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert obsidianPickaxeMeta != null;
        obsidianPickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Obsidian Pickaxe"));
        obsidianPickaxeMeta.setLore(lores);
        obsidianPickaxeMeta.setCustomModelData(8008);
        obsidianPickaxeMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        obsidianPickaxe.setItemMeta(obsidianPickaxeMeta);
        return obsidianPickaxe;
    }

    public static ItemStack createObsidianAxe() {
        ItemStack obsidianAxe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta obsidianAxeMeta = obsidianAxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert obsidianAxeMeta != null;
        obsidianAxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Obsidian Axe"));
        obsidianAxeMeta.setLore(lores);
        obsidianAxeMeta.setCustomModelData(8008);
        obsidianAxeMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        obsidianAxe.setItemMeta(obsidianAxeMeta);
        return obsidianAxe;
    }

    public static ItemStack createVeinPickaxe() {
        ItemStack veinPickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta veinPickaxeMeta = veinPickaxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert veinPickaxeMeta != null;
        veinPickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Vein Miner's Pickaxe"));
        lores.add(ChatColor.translateAlternateColorCodes('&', "&dA powerful pickaxe from a well-respected miner."));
        veinPickaxeMeta.setLore(lores);
        veinPickaxeMeta.setCustomModelData(8008);
        veinPickaxe.setItemMeta(veinPickaxeMeta);
        return veinPickaxe;
    }

    public static ItemStack createVeinAxe() {
        ItemStack veinAxe = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta veinAxeMeta = veinAxe.getItemMeta();
        List<String> lores = new ArrayList<String>();
        assert veinAxeMeta != null;
        veinAxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Vein Miner's Axe"));
        lores.add(ChatColor.translateAlternateColorCodes('&', "&dA powerful axe from a well-respected miner."));
        veinAxeMeta.setLore(lores);
        veinAxeMeta.setCustomModelData(8008);
        veinAxe.setItemMeta(veinAxeMeta);
        return veinAxe;
    }

    public static ItemStack createSilkSword() {
        ItemStack silkSword = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta silSwordMeta = silkSword.getItemMeta();
        assert silSwordMeta != null;
        silSwordMeta.setDisplayName("Silk Sword");
        silSwordMeta.setCustomModelData(8008);
        silSwordMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        silkSword.setItemMeta(silSwordMeta);
        return silkSword;
    }

    public static ItemStack createSilkAxe() {
        ItemStack silkAxe = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta silkAxeMeta = silkAxe.getItemMeta();
        assert silkAxeMeta != null;
        silkAxeMeta.setDisplayName("Silk Axe");
        silkAxeMeta.setCustomModelData(8008);
        silkAxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        silkAxe.setItemMeta(silkAxeMeta);
        return silkAxe;
    }

    public static ItemStack createSilkPickaxe() {
        ItemStack silkPickaxe = new ItemStack(Material.WOODEN_PICKAXE, 1);
        ItemMeta silkPickaxeMeta = silkPickaxe.getItemMeta();
        assert silkPickaxeMeta != null;
        silkPickaxeMeta.setDisplayName("Silk Pickaxe");
        silkPickaxeMeta.setCustomModelData(8008);
        silkPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        silkPickaxe.setItemMeta(silkPickaxeMeta);
        return silkPickaxe;
    }

    public static ItemStack createSilkShovel() {
        ItemStack silkShovel = new ItemStack(Material.WOODEN_SHOVEL, 1);
        ItemMeta silkShovelMeta = silkShovel.getItemMeta();
        assert silkShovelMeta != null;
        silkShovelMeta.setDisplayName("Silk Shovel");
        silkShovelMeta.setCustomModelData(8008);
        silkShovelMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        silkShovel.setItemMeta(silkShovelMeta);
        return silkShovel;
    }

    public static ItemStack createSilkHoe() {
        ItemStack silkHoe = new ItemStack(Material.WOODEN_HOE, 1);
        ItemMeta silkHoeMeta = silkHoe.getItemMeta();
        assert silkHoeMeta != null;
        silkHoeMeta.setDisplayName("Silk Hoe");
        silkHoeMeta.setCustomModelData(8008);
        silkHoeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        silkHoe.setItemMeta(silkHoeMeta);
        return silkHoe;
    }

    public static boolean IsItem(ItemStack itemToCheck, ItemStack customItem) {
        if (itemToCheck.getType() != customItem.getType()) return false;
        ItemMeta MetaA = itemToCheck.getItemMeta();
        ItemMeta MetaB = customItem.getItemMeta();

        assert MetaA != null;
        assert MetaB != null;

        if (MetaA == MetaB) {
            // identification through meta
            return true;
        }
        if (MetaA.hasLore() && MetaB.hasLore()) {
            // identification through lore
            if (MetaA.getLore() == MetaB.getLore()) {
                return true;
            }
        }
        if (MetaA.hasCustomModelData() && MetaB.hasCustomModelData()) {
            // identification through custom model data (last resort)
            if (MetaA.getCustomModelData() == MetaB.getCustomModelData()) {
                return true;
            }
        }

        return false;
    }
}