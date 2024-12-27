package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CustomItemManager {

    public enum IdItemType {
        CALCITE,
        OBSIDIAN,
        VEIN,
        AUTOSMELT,
        SILK,
        ETC,
        PLANTS,
        REQUESTED,
        ACCESSORY,
        PROGRESS_SWORD,
        GUN,
        COPPER,
        TOTEMS,
        SCULK,
        UNDEFINED;
    }

    public enum IdItemClass {
        SWORD,
        AXE,
        PICKAXE,
        SHOVEL,
        HOE,
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        MAGICMIRROR,
        ENTITYBUCKET,
        WARPEDWART,
        OTHERMELEE,
        BOW,
        UNDEFINED;
    }

    public static int getCustomID(IdItemType iitype, IdItemClass iiclass) {
        int id = 10000000;
        switch (iitype) {
            case CALCITE -> id += 1000;
            case OBSIDIAN -> id += 1100;
            case VEIN -> id += 1200;
            case AUTOSMELT -> id += 1300;
            case SILK -> id += 1400;
            case ETC -> id += 1500;
            case PLANTS -> id += 1600;
            case REQUESTED -> id += 1700;
            case ACCESSORY -> id += 1800;
            case PROGRESS_SWORD -> id += 1900;
            case GUN -> id += 2000;
            case COPPER -> id += 2100;
            case TOTEMS -> id += 2200;
            case SCULK -> id += 2300;
            case UNDEFINED -> id += 9900;
        }
        switch (iiclass) {
            case SWORD -> id += 10;
            case AXE -> id += 11;
            case PICKAXE -> id += 12;
            case SHOVEL -> id += 13;
            case HOE -> id += 14;
            case HELMET -> id += 15;
            case CHESTPLATE -> id += 16;
            case LEGGINGS -> id += 17;
            case BOOTS -> id += 18;
            case MAGICMIRROR -> id += 19;
            case ENTITYBUCKET -> id += 20;
            case WARPEDWART -> id += 21;
            case OTHERMELEE -> id += 22;
            case BOW -> id += 23;
            case UNDEFINED -> id += 99;
        }
        return id;
    }

    public static ItemStack modifyAttribute(ItemStack i, Attribute a, AttributeModifier am) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.addAttributeModifier(a, am);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack enchantItem(ItemStack i, Enchantment e, int lvl) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.addEnchant(e, lvl, true);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack enchantItem(ItemStack i, Enchantment e) {
        return enchantItem(i, e, 1);
    }

    public static ItemStack massEnchantItem(ItemStack i, Enchantment... enchantments) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        for (Enchantment e : enchantments) {
            im.addEnchant(e, 1, true);
        }
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack hideEnchantments(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        return i;
    }

    public static boolean isMarkedForUUID(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return false;
        return Boolean.TRUE.equals(im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "markeduuid"), PersistentDataType.BOOLEAN));
    }

    public static ItemStack removeMarkedForUUID(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.getPersistentDataContainer().remove(new NamespacedKey("dfsmp", "markeduuid"));
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack addMarkedForUUID(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "markeduuid"), PersistentDataType.BOOLEAN, true);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack addUUIDToItem(ItemStack i, String uuid) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        if (uuid == null) uuid = UUID.randomUUID().toString();
        im.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "uuid"), PersistentDataType.STRING, uuid);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack addUUIDToItem(ItemStack i) {
        String uuid = UUID.randomUUID().toString();
        return addUUIDToItem(i, uuid);
    }

    public static ItemStack addAccessoryId(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        return im.hasCustomModelData() ? addAccessoryId(i, im.getCustomModelData()) : i;
    }

    public static ItemStack addAccessoryId(ItemStack i, int id) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.getPersistentDataContainer().set(new NamespacedKey("dfsmp", "isaccessory"), PersistentDataType.INTEGER, id);
        i.setItemMeta(im);
        return i;
    }

    @Nullable
    public static Integer getAccessoryId(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return null;
        return im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "isaccessory"), PersistentDataType.INTEGER);
    }

    @Nullable
    public static String getItemUUID(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return null;
        return im.getPersistentDataContainer().get(new NamespacedKey("dfsmp", "uuid"), PersistentDataType.STRING);
    }

    public static ItemStack setCustomId(ItemStack i, int id) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        im.setCustomModelData(id);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack setModel(ItemStack i, String key, EquipmentSlot slot) {
        return setModel(i, key, slot, Sound.ITEM_ARMOR_EQUIP_IRON);
    }

    public static ItemStack setModel(ItemStack i, String key, EquipmentSlot slot, Sound equipSound) {
        ItemMeta im = i.getItemMeta();
        if (im == null) return i;
        EquippableComponent e = im.getEquippable();
        if (e == null) return i;
        e.setModel(new NamespacedKey("dfjr", key));
        e.setSlot(slot);
        e.setEquipSound(equipSound);
        im.setEquippable(e);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack setAmount(ItemStack i, int amount) {
        i.setAmount(amount);
        return i;
    }

    public static ItemStack createCustomItem(ItemStack base, String name, int model, List<String> lores) {
        ItemStack customItem = base;
        ItemMeta customItemMeta = customItem.getItemMeta();
        assert customItemMeta != null;
        customItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.RESET + name));
        customItemMeta.setCustomModelData(model);
        customItemMeta.setLore(lores);
        customItem.setItemMeta(customItemMeta);
        return customItem;
    }

    public static ItemStack createCustomItem(ItemStack base, String name, int model) {
        ItemStack customItem = base;
        ItemMeta customItemMeta = customItem.getItemMeta();
        assert customItemMeta != null;
        customItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.RESET + name));
        customItemMeta.setCustomModelData(model);
        customItem.setItemMeta(customItemMeta);
        return customItem;
    }

    public static ItemStack createCustomItem(Material base, int amount, String name, int model, List<String> lores) {
        return createCustomItem(new ItemStack(base, amount), name, model, lores);
    }

    public static ItemStack createCustomItem(Material base, int amount, String name, int model, String... lores) {
        return createCustomItem(new ItemStack(base, amount), name, model, SDDtoList(lores));
    }

    public static ItemStack createCustomItem(Material base, String name, int model, String... lores) {
        return createCustomItem(new ItemStack(base), name, model, SDDtoList(lores));
    }

    public static ItemStack createCustomItem(Material base, int amount, String name, String... lores) {
        return createCustomItem(new ItemStack(base, amount), name, 0, SDDtoList(lores));
    }

    public static ItemStack createCustomItem(Material base, String name, String... lores) {
        return createCustomItem(new ItemStack(base), name, 0, SDDtoList(lores));
    }

    public static ItemStack createCustomItem(Material base, String... lores) {
        return createCustomItem(new ItemStack(base), base.name(), 0, SDDtoList(lores));
    }

    public static ItemStack createCustomItem(Material base) {
        return createCustomItem(new ItemStack(base), base.name(), 0);
    }

    public static List<String> SDDtoList(String... lores) {
        return new ArrayList<>(Arrays.asList(lores));
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