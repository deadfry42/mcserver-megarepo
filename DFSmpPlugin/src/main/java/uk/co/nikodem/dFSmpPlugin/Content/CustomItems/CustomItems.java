package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.*;

public class CustomItems {

//    IdItemType.ETC

    public static ItemStack createMagicMirror() {
        return hideEnchantments(enchantItem(createCustomItem(
                Material.COMPASS,
                "&5Magic Mirror",
                getCustomID(IdItemType.ETC, IdItemClass.MAGICMIRROR),
                ChatColor.translateAlternateColorCodes('&', "&6Teleports you back to your bed."),
                ChatColor.translateAlternateColorCodes('&', "&cWill not work in combat.")
        ), Enchantment.LOYALTY, 100));
    }

    public static ItemStack createEntityBucket() {
        return createCustomItem(
                Material.BUCKET,
                "Entity Bucket",
                getCustomID(IdItemType.ETC, IdItemClass.ENTITYBUCKET)
        );
    }

//    IdItemType.PLANTS

    public static ItemStack createWarpedWart() {
        return createCustomItem(
                Material.NETHER_WART,
                "Warped Wart",
                getCustomID(IdItemType.PLANTS, IdItemClass.WARPEDWART)
        );
    }

//    IdItemType.CALCITE

    public static ItemStack createCalciteSword() {
        return enchantItem(createCustomItem(
                Material.STONE_SWORD,
                "Calcite Sword",
                getCustomID(IdItemType.CALCITE, IdItemClass.SWORD),
                "A very light sword."
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteAxe() {
        return enchantItem(createCustomItem(
                Material.STONE_AXE,
                "Calcite Axe",
                getCustomID(IdItemType.CALCITE, IdItemClass.AXE),
                "A very light axe."
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalcitePickaxe() {
        return enchantItem(createCustomItem(
                Material.STONE_PICKAXE,
                "Calcite Pickaxe",
                getCustomID(IdItemType.CALCITE, IdItemClass.PICKAXE),
                "A very light pickaxe."
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteShovel() {
        return enchantItem(createCustomItem(
                Material.STONE_SHOVEL,
                "Calcite Shovel",
                getCustomID(IdItemType.CALCITE, IdItemClass.SHOVEL),
                "A very light shovel."
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteHoe() {
        return enchantItem(createCustomItem(
                Material.STONE_HOE,
                "Calcite Hoe",
                getCustomID(IdItemType.CALCITE, IdItemClass.HOE),
                "A very light hoe."
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteHelmet() {
        return enchantItem(createCustomItem(
                Material.CHAINMAIL_HELMET,
                "Calcite Helmet",
                getCustomID(IdItemType.CALCITE, IdItemClass.HELMET),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Chainmail Helmet)")
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteChestplate() {
        return enchantItem(createCustomItem(
                Material.CHAINMAIL_CHESTPLATE,
                "Calcite Chestplate",
                getCustomID(IdItemType.CALCITE, IdItemClass.CHESTPLATE),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Chainmail Chestplate)")
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteLeggings() {
        return enchantItem(createCustomItem(
                Material.CHAINMAIL_LEGGINGS,
                "Calcite Leggings",
                getCustomID(IdItemType.CALCITE, IdItemClass.LEGGINGS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Chainmail Leggings)")
        ), Enchantment.UNBREAKING, 1);
    }

    public static ItemStack createCalciteBoots() {
        return enchantItem(createCustomItem(
                Material.CHAINMAIL_BOOTS,
                "Calcite Boots",
                getCustomID(IdItemType.CALCITE, IdItemClass.BOOTS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Chainmail Boots)")
        ), Enchantment.UNBREAKING, 1);
    }

//    IdItemType.OBSIDIAN

    public static ItemStack createObsidianSword() {
        return enchantItem(createCustomItem(
                Material.NETHERITE_SWORD,
                "&5Obsidian Sword",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.SWORD)
        ), Enchantment.UNBREAKING, 10);
    }

    public static ItemStack createObsidianAxe() {
        return enchantItem(createCustomItem(
                Material.NETHERITE_AXE,
                "&5Obsidian Axe",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.AXE)
        ), Enchantment.UNBREAKING, 10);
    }

    public static ItemStack createObsidianPickaxe() {
        return enchantItem(createCustomItem(
                Material.NETHERITE_PICKAXE,
                "&5Obsidian Pickaxe",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.PICKAXE)
        ), Enchantment.UNBREAKING, 10);
    }

    public static ItemStack createObsidianShovel() {
        return enchantItem(createCustomItem(
                Material.NETHERITE_SHOVEL,
                "&5Obsidian Shovel",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.SHOVEL)
        ), Enchantment.UNBREAKING, 10);
    }

    public static ItemStack createObsidianHoe() {
        return enchantItem(createCustomItem(
                Material.NETHERITE_HOE,
                "&5Obsidian Hoe",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.HOE)
        ), Enchantment.UNBREAKING, 10);
    }
    public static ItemStack createObsidianHelmet() {
        return setModel(enchantItem(createCustomItem(
                Material.NETHERITE_HELMET,
                "&5Obsidian Helmet",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.HELMET),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Helmet)")
        ), Enchantment.UNBREAKING, 10),
                "obsidian", EquipmentSlot.HEAD, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createObsidianChestplate() {
        return setModel(enchantItem(createCustomItem(
                Material.NETHERITE_CHESTPLATE,
                "&5Obsidian Chestplate",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.CHESTPLATE),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Chestplate)")
        ), Enchantment.UNBREAKING, 10),
        "obsidian", EquipmentSlot.CHEST, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createObsidianLeggings() {
        return setModel(enchantItem(createCustomItem(
                Material.NETHERITE_LEGGINGS,
                "&5Obsidian Leggings",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.LEGGINGS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Leggings)")
        ), Enchantment.UNBREAKING, 10),
        "obsidian", EquipmentSlot.LEGS, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createObsidianBoots() {
        return setModel(enchantItem(createCustomItem(
                Material.NETHERITE_BOOTS,
                "&5Obsidian Boots",
                getCustomID(IdItemType.OBSIDIAN, IdItemClass.BOOTS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Boots)")
        ), Enchantment.UNBREAKING, 10),
        "obsidian", EquipmentSlot.FEET, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

//    IdItemType.AUTOSMELT

    public static ItemStack createAutosmeltSword() {
        return enchantItem(createCustomItem(
                Material.IRON_SWORD,
                "Firidium Sword",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.SWORD),
                ChatColor.translateAlternateColorCodes('&', "&cHeated to 1000°c")
        ), Enchantment.FIRE_ASPECT, 1);
    }

    public static ItemStack createAutosmeltAxe() {
        return enchantItem(createCustomItem(
                Material.IRON_AXE,
                "Firidium Axe",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.AXE),
                ChatColor.translateAlternateColorCodes('&', "&cHeated to 1000°c")
        ), Enchantment.FIRE_ASPECT, 1);
    }

    public static ItemStack createAutosmeltPickaxe() {
        return enchantItem(createCustomItem(
                Material.IRON_PICKAXE,
                "Firidium Pickaxe",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.PICKAXE),
                ChatColor.translateAlternateColorCodes('&', "&cHeated to 1000°c")
        ), Enchantment.FIRE_ASPECT, 1);
    }

    public static ItemStack createAutosmeltShovel() {
        return enchantItem(createCustomItem(
                Material.IRON_SHOVEL,
                "Firidium Shovel",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.SHOVEL),
                ChatColor.translateAlternateColorCodes('&', "&cHeated to 1000°c")
        ), Enchantment.FIRE_ASPECT, 1);
    }

    public static ItemStack createAutosmeltHoe() {
        return enchantItem(createCustomItem(
                Material.IRON_HOE,
                "Firidium Hoe",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.HOE),
                ChatColor.translateAlternateColorCodes('&', "&cHeated to 1000°c")
        ), Enchantment.FIRE_ASPECT, 1);
    }

    public static ItemStack createAutosmeltHelmet() {
        return setModel(enchantItem(createCustomItem(
                Material.IRON_HELMET,
                "Firidum Helmet",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.HELMET),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Helmet)")
        ), Enchantment.FIRE_ASPECT, 1),
                "firidium", EquipmentSlot.HEAD);
    }

    public static ItemStack createAutosmeltChestplate() {
        return setModel(enchantItem(createCustomItem(
                Material.IRON_CHESTPLATE,
                "Firidium Chestplate",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.CHESTPLATE),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Chestplate)")
        ), Enchantment.FIRE_ASPECT, 1),
                "firidium", EquipmentSlot.CHEST);
    }

    public static ItemStack createAutosmeltLeggings() {
        return setModel(enchantItem(createCustomItem(
                Material.IRON_LEGGINGS,
                "Firidium Leggings",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.LEGGINGS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Leggings)")
        ), Enchantment.FIRE_ASPECT, 1),
                "firidium", EquipmentSlot.LEGS);
    }

    public static ItemStack createAutosmeltBoots() {
        return setModel(enchantItem(createCustomItem(
                Material.IRON_BOOTS,
                "Firidium Boots",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.BOOTS),
                ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Boots)")
        ), Enchantment.FIRE_ASPECT, 1),
                "firidium", EquipmentSlot.FEET);
    }

    public static ItemStack createAutosmeltIngot() {
        return createCustomItem(
                Material.IRON_INGOT,
                "Firidium Ingot",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.WARPEDWART)
        );
    }

    public static ItemStack createAutosmeltNugget() {
        return createCustomItem(
                Material.IRON_NUGGET,
                "Firidium Nugget",
                getCustomID(IdItemType.AUTOSMELT, IdItemClass.MAGICMIRROR)
            );
    }

//    IdItemType.VEIN

    public static ItemStack createVeinAxe() {
        return createCustomItem(
                Material.IRON_AXE,
                "&5Vein Miner's Axe",
                getCustomID(IdItemType.VEIN, IdItemClass.AXE),
                ChatColor.translateAlternateColorCodes('&', "&dA powerful axe from a well-respected miner.")
        );
    }

    public static ItemStack createVeinPickaxe() {
        return createCustomItem(
                Material.IRON_PICKAXE,
                "&5Vein Miner's Pickaxe",
                getCustomID(IdItemType.VEIN, IdItemClass.PICKAXE),
                ChatColor.translateAlternateColorCodes('&', "&dA powerful pickaxe from a well-respected miner.")
        );
    }

//    IdItemType.SILK

    public static ItemStack createSilkSword() {
        return enchantItem(createCustomItem(
                Material.WOODEN_SWORD,
                "Silk Sword",
                getCustomID(IdItemType.SILK, IdItemClass.SWORD)
        ), Enchantment.SILK_TOUCH, 1);
    }

    public static ItemStack createSilkAxe() {
        return enchantItem(createCustomItem(
                Material.WOODEN_AXE,
                "Silk Axe",
                getCustomID(IdItemType.SILK, IdItemClass.AXE)
        ), Enchantment.SILK_TOUCH, 1);
    }

    public static ItemStack createSilkPickaxe() {
        return enchantItem(createCustomItem(
                Material.WOODEN_PICKAXE,
                "Silk Pickaxe",
                getCustomID(IdItemType.SILK, IdItemClass.PICKAXE)
        ), Enchantment.SILK_TOUCH, 1);
    }

    public static ItemStack createSilkShovel() {
        return enchantItem(createCustomItem(
                Material.WOODEN_SHOVEL,
                "Silk Shovel",
                getCustomID(IdItemType.SILK, IdItemClass.SHOVEL)
        ), Enchantment.SILK_TOUCH, 1);
    }

    public static ItemStack createSilkHoe() {
        return enchantItem(createCustomItem(
                Material.WOODEN_HOE,
                "Silk Hoe",
                getCustomID(IdItemType.SILK, IdItemClass.HOE)
        ), Enchantment.SILK_TOUCH, 1);
    }

//    IdItemType.PROGRESS_SWORD

    public static ItemStack createVampireSword() {
        // stage 0 vampire sword
        NamespacedKey key = new NamespacedKey("dfsmp", "vampiresword");
        return addMarkedForUUID(enchantItem(modifyAttribute(createCustomItem(
                Material.WOODEN_SWORD,
                "Vampire Sword",
                getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.SWORD),
                ChatColor.translateAlternateColorCodes('&', "&4With every kill, this sword gets stronger and stronger.")
        ), Attribute.ATTACK_DAMAGE, new AttributeModifier(key,
                1,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND)),
                Enchantment.UNBREAKING));
    }

    public static boolean isVampireSword(ItemStack sword) {
        int stage0 = getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.SWORD);
        int stage9 = getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.MAGICMIRROR);
        ItemMeta m = sword.getItemMeta();
        if (m == null) {
            return false;
        }
        if (!m.hasCustomModelData()) return false;
        int cid = m.getCustomModelData();
        if (cid >= stage0 && cid < stage9) {
            return true;
        } else {
            return false;
        }
    }

    public static ItemStack upgradeVampireSword(ItemStack sword) {
        int stage0 = getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.SWORD);
        int stage9 = getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.MAGICMIRROR);

        ItemMeta m = sword.getItemMeta();
        if (m == null) {
            return sword;
        }
        if (m.hasCustomModelData()) {
            int cid = m.getCustomModelData();
            if (cid >= stage0 && cid < stage9) {
                // if model data is stage0 or above and below stage9
                m.setCustomModelData(cid+1);

                NamespacedKey key = new NamespacedKey("dfsmp", "vampiresword");

                m.removeAttributeModifier(Attribute.ATTACK_DAMAGE);

                int attk = cid - stage0 + 1;

                m.addAttributeModifier(
                        Attribute.ATTACK_DAMAGE,
                        new AttributeModifier(key, attk,
                                AttributeModifier.Operation.ADD_NUMBER,
                                EquipmentSlotGroup.HAND)
                );

                sword.setItemMeta(m);

                return sword;
            } else {
                return sword;
            }
        } else {
            return sword;
        }
    }

//    IdItemType.REQUESTED

    public static ItemStack createBloodyTear() {
        return createCustomItem(
                Material.GHAST_TEAR,
                "haha funny",
                getCustomID(IdItemType.REQUESTED, IdItemClass.OTHERMELEE)
        );
    }

    public static ItemStack createKnockbackStick() {
        return enchantItem(createCustomItem(
                Material.STICK,
                "stick",
                getCustomID(IdItemType.REQUESTED, IdItemClass.AXE)
        ), Enchantment.KNOCKBACK, 25);
    }

    public static ItemStack createWildBow() {
        return createCustomItem(
                Material.BOW,
                "Wild Bow",
                getCustomID(IdItemType.REQUESTED, IdItemClass.BOW),
                ChatColor.translateAlternateColorCodes('&', "&3A bow that can be turned into a sword."),
                ChatColor.translateAlternateColorCodes('&', "Left click to turn into a sword."),
                ChatColor.translateAlternateColorCodes('&', "Right click to turn into a bow.")
        );
    }

    public static ItemStack createWildBowSword() {
        return convertToWildBowSword(
                createWildBow()
        );
    }

    public static ItemStack convertToWildBowSword(ItemStack bow) {
        return convertToWildBowSword(bow, true);
    }

    public static ItemStack convertToWildBowSword(ItemStack bow, boolean setDurability) {
        ItemMeta im = bow.getItemMeta();
        Damageable dm = (Damageable) im;
        int damage = dm.getDamage();
        if (setDurability) im.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "bowdurability"), PersistentDataType.INTEGER, damage);
        var sworddurability = im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "sworddurability"), PersistentDataType.INTEGER);
        if (sworddurability != null && sworddurability == -1) {
            return bow;
        } else if (sworddurability != null) {
            dm.setDamage(sworddurability);
        }
        bow.setType(Material.GOLDEN_SWORD);
        bow.setItemMeta(dm);
        return bow;
    }

    public static ItemStack convertToWildBow(ItemStack sword) {
        return convertToWildBow(sword, true);
    }

    public static ItemStack convertToWildBow(ItemStack sword, boolean setDurability) {
        ItemMeta im = sword.getItemMeta();
        Damageable dm = (Damageable) im;
        int damage = dm.getDamage();
        if (setDurability) im.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "sworddurability"), PersistentDataType.INTEGER, damage);
        var bowdurability = im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "bowdurability"), PersistentDataType.INTEGER);
        if (bowdurability != null && bowdurability == -1) {
            return sword;
        } else if (bowdurability != null) {
            dm.setDamage(bowdurability);
        }
        sword.setType(Material.BOW);
        sword.setItemMeta(dm);
        return sword;
    }

    public static ItemStack createBluebellsarStick() {
        NamespacedKey key = new NamespacedKey("dfsmp", "bluebellsarstick");
        return modifyAttribute(massEnchantItem(createCustomItem(
                Material.STICK,
                "&3Bluebellsar Stick",
                getCustomID(IdItemType.REQUESTED, IdItemClass.OTHERMELEE),
                        ChatColor.translateAlternateColorCodes('&', "&3Using this item shrivels shrieks from past souls."),
                ChatColor.translateAlternateColorCodes('&', "&cWill not work in combat.")
                ), Enchantment.LOOTING, Enchantment.UNBREAKING, Enchantment.MENDING, Enchantment.AQUA_AFFINITY, Enchantment.LUCK_OF_THE_SEA),
                Attribute.ATTACK_DAMAGE,
                new AttributeModifier(key, 10,
                        AttributeModifier.Operation.ADD_NUMBER,
                        EquipmentSlotGroup.HAND));
    }

//    IdItemType.COPPER

    public static ItemStack createCopperHelmet() {
        return setModel(createCustomItem(
                        Material.IRON_HELMET,
                        "Copper Helmet",
                        getCustomID(IdItemType.COPPER, IdItemClass.HELMET),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Helmet)")
                ),
                "copper", EquipmentSlot.HEAD);
    }

    public static ItemStack createCopperChestplate() {
        return setModel(createCustomItem(
                        Material.IRON_CHESTPLATE,
                        "Copper Chestplate",
                        getCustomID(IdItemType.COPPER, IdItemClass.CHESTPLATE),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Chestplate)")
                ),
                "copper", EquipmentSlot.CHEST);
    }

    public static ItemStack createCopperLeggings() {
        return setModel(createCustomItem(
                        Material.IRON_LEGGINGS,
                        "Copper Leggings",
                        getCustomID(IdItemType.COPPER, IdItemClass.LEGGINGS),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Leggings)")
                ),
                "copper", EquipmentSlot.LEGS);
    }

    public static ItemStack createCopperBoots() {
        return setModel(createCustomItem(
                        Material.IRON_BOOTS,
                        "Copper Boots",
                        getCustomID(IdItemType.COPPER, IdItemClass.BOOTS),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Iron Boots)")
                ),
                "copper", EquipmentSlot.FEET);
    }

    public static ItemStack createCopperSword() {
        return createCustomItem(
                Material.IRON_SWORD,
                "Copper Sword",
                getCustomID(IdItemType.COPPER, IdItemClass.SWORD)
        );
    }

    public static ItemStack createCopperAxe() {
        return createCustomItem(
                Material.IRON_AXE,
                "Copper Axe",
                getCustomID(IdItemType.COPPER, IdItemClass.AXE)
        );
    }

    public static ItemStack createCopperPickaxe() {
        return createCustomItem(
                Material.IRON_PICKAXE,
                "Copper Pickaxe",
                getCustomID(IdItemType.COPPER, IdItemClass.PICKAXE)
        );
    }

    public static ItemStack createCopperShovel() {
        return createCustomItem(
                Material.IRON_SHOVEL,
                "Copper Shovel",
                getCustomID(IdItemType.COPPER, IdItemClass.SHOVEL)
        );
    }

    public static ItemStack createCopperHoe() {
        return createCustomItem(
                Material.IRON_HOE,
                "Copper Hoe",
                getCustomID(IdItemType.COPPER, IdItemClass.HOE)
        );
    }

    public static boolean isCopperTool(ItemStack i) {
        return CustomItemManager.IsItem(i, createCopperSword())
                ||CustomItemManager.IsItem(i, createCopperAxe())
                ||CustomItemManager.IsItem(i, createCopperPickaxe())
                ||CustomItemManager.IsItem(i, createCopperShovel())
                ||CustomItemManager.IsItem(i, createCopperHoe());
    }

//    IdItemType.TOTEMS

    public static ItemStack createLegacyTotem() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.SWORD)
        );
    }

    public static ItemStack createAmongus() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.AXE)
        );
    }

    public static ItemStack createDanTDMTotem() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.PICKAXE)
        );
    }

    public static ItemStack createTechnoTotem() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.SHOVEL)
        );
    }

    public static ItemStack createCreeperTotem() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.HOE)
        );
    }

    public static ItemStack createHerobrineTotem() {
        return createCustomItem(
                Material.TOTEM_OF_UNDYING,
                "Totem of Undying",
                getCustomID(IdItemType.TOTEMS, IdItemClass.HELMET)
        );
    }

//    IdItemType.SCULK

    public static ItemStack createSculkHelmet() {
        return setModel(createCustomItem(
                        Material.NETHERITE_HELMET,
                        "&5Sculk Helmet",
                        getCustomID(IdItemType.SCULK, IdItemClass.HELMET),
                        ChatColor.translateAlternateColorCodes('&', "&3Derived from the Ancient Cities"),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Helmet)")
                ),
                "sculk", EquipmentSlot.HEAD, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createSculkChestplate() {
        return setModel(createCustomItem(
                        Material.NETHERITE_CHESTPLATE,
                        "&5Sculk Chestplate",
                        getCustomID(IdItemType.SCULK, IdItemClass.CHESTPLATE),
                        ChatColor.translateAlternateColorCodes('&', "&3Derived from the Ancient Cities"),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Chestplate)")
                ),
                "sculk", EquipmentSlot.CHEST, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createSculkLeggings() {
        return setModel(createCustomItem(
                        Material.NETHERITE_LEGGINGS,
                        "&5Sculk Leggings",
                        getCustomID(IdItemType.SCULK, IdItemClass.LEGGINGS),
                        ChatColor.translateAlternateColorCodes('&', "&3Derived from the Ancient Cities"),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Leggings)")
                ),
                "sculk", EquipmentSlot.LEGS, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createSculkBoots() {
        return setModel(createCustomItem(
                        Material.NETHERITE_BOOTS,
                        "&5Sculk Boots",
                        getCustomID(IdItemType.SCULK, IdItemClass.BOOTS),
                        ChatColor.translateAlternateColorCodes('&', "&3Derived from the Ancient Cities"),
                        ChatColor.translateAlternateColorCodes('&', "&7(Equivalent to Netherite Boots)")
                ),
                "sculk", EquipmentSlot.FEET, Sound.ITEM_ARMOR_EQUIP_NETHERITE);
    }

    public static ItemStack createSculkPiece() {
        return createCustomItem(
                Material.ECHO_SHARD,
                "Sculk Fragment",
                getCustomID(IdItemType.SCULK, IdItemClass.WARPEDWART)
        );
    }
}
