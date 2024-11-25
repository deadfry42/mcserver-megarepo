package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class SetBonuses {

    public static void ApplySetBonuses(Player plr) {
        PlayerInventory inv = plr.getInventory();

        // leather armour has it's set bonus managed by HungerChange

        if (hasCalciteSet(inv)) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, true, false));
            plr.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 25, 0, true, false));
        } else if (hasGoldSet(inv)) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, true, false));
        } else if (hasDiamondSet(inv)) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 25, 1, true, false));
        } else if (hasNetheriteSet(inv)) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 25, 1, true, false));
        } else if (hasChainSet(inv)) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 25, 1, true, false));
        }
    }

    public static ItemStack ApplySetBonusText(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;
        if (itemMeta.hasLore()) {
            itemMeta.getLore().add(getSetBonusText(item));
        } else {
            List<String> lores = new ArrayList<>();
            lores.add(getSetBonusText(item));
            itemMeta.setLore(lores);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack RemoveSetBonusText(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;
        if (itemMeta.hasLore()) {
            ListIterator<String> it = Objects.requireNonNull(itemMeta.getLore()).listIterator();
            List<String> newLore = new ArrayList<>();
            String lore;
            while(it.hasNext()) {
                lore = it.next();
                if (lore != null && !lore.startsWith("Set Bonus:")) {
                    newLore.add(lore);
                }
            }
            if (newLore.isEmpty()) itemMeta.setLore(null);
            else itemMeta.setLore(newLore);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static String SetBonusTextTemplate(String setBonus) {
        return ChatColor.translateAlternateColorCodes('&', "Set Bonus: "+setBonus);
    }

    public static String getSetBonusText(ItemStack item) {
        String res = "";
        if (CustomItemManager.IsItem(item, CustomItemManager.createCalciteHelmet())
        || CustomItemManager.IsItem(item, CustomItemManager.createCalciteChestplate())
        || CustomItemManager.IsItem(item, CustomItemManager.createCalciteLeggings())
        || CustomItemManager.IsItem(item, CustomItemManager.createCalciteBoots())) {
            res = SetBonusTextTemplate("Allows you to move faster and gives you more health.");
            return res;
        }
        res = switch (item.getType()) {
            case LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS ->
                    SetBonusTextTemplate("Stops hunger");
            case CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS ->
                    SetBonusTextTemplate("Allows you to mine faster");
            case GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS ->
                    SetBonusTextTemplate("Allows you to move faster");
            case DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS ->
                    SetBonusTextTemplate("Gives you the power of conduits");
            case NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_BOOTS ->
                    SetBonusTextTemplate("Makes you immune to fire");
            default -> res;
        };
        return res;
    }

    public static boolean hasArmourEquipped(PlayerInventory inv, Material head, Material chest, Material legs, Material feet) {
        return Objects.requireNonNull(inv.getItem(EquipmentSlot.HEAD)).getType() == head
                && Objects.requireNonNull(inv.getItem(EquipmentSlot.CHEST)).getType() == chest
                && Objects.requireNonNull(inv.getItem(EquipmentSlot.LEGS)).getType() == legs
                && Objects.requireNonNull(inv.getItem(EquipmentSlot.FEET)).getType() == feet;
    }

    public static boolean hasNotCustomArmourButArmourEquipped(PlayerInventory inv, Material head, Material chest, Material legs, Material feet, ItemStack customhead, ItemStack customchest, ItemStack customlegs, ItemStack customfeet) {
        return (Objects.requireNonNull(inv.getItem(EquipmentSlot.HEAD)).getType() == head
                && !CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.HEAD)), customhead))
                && (Objects.requireNonNull(inv.getItem(EquipmentSlot.CHEST)).getType() == chest
                && !CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.CHEST)), customchest))
                && (Objects.requireNonNull(inv.getItem(EquipmentSlot.LEGS)).getType() == legs
                && !CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.LEGS)), customlegs))
                && (Objects.requireNonNull(inv.getItem(EquipmentSlot.FEET)).getType() == feet
                && !CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.FEET)), customfeet));
    }

    public static boolean hasCustomArmourEquipped(PlayerInventory inv, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet) {
        return CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.HEAD)), head)
                && CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.CHEST)), chest)
                && CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.LEGS)), legs)
                && CustomItemManager.IsItem(Objects.requireNonNull(inv.getItem(EquipmentSlot.FEET)), feet);
    }

    public static boolean hasSetBonus(PlayerInventory inv) {
        return hasLeatherSet(inv)
                || hasCalciteSet(inv)
                || hasChainSet(inv)
                || hasIronSet(inv)
                || hasGoldSet(inv)
                || hasNetheriteSet(inv)
                || hasDiamondSet(inv);
    }

    public static boolean hasLeatherSet(PlayerInventory inv) {
        return hasArmourEquipped(inv, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
    }

    public static boolean hasChainSet(PlayerInventory inv) {
        return hasNotCustomArmourButArmourEquipped(inv, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, CustomItemManager.createCalciteHelmet(), CustomItemManager.createCalciteChestplate(), CustomItemManager.createCalciteLeggings(), CustomItemManager.createCalciteBoots());
    }

    public static boolean hasCalciteSet(PlayerInventory inv) {
        return hasCustomArmourEquipped(inv, CustomItemManager.createCalciteHelmet(), CustomItemManager.createCalciteChestplate(), CustomItemManager.createCalciteLeggings(), CustomItemManager.createCalciteBoots());
    }

    public static boolean hasIronSet(PlayerInventory inv) {
        return hasArmourEquipped(inv, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS);
    }

    public static boolean hasGoldSet(PlayerInventory inv) {
        return hasArmourEquipped(inv, Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS);
    }

    public static boolean hasDiamondSet(PlayerInventory inv) {
        return hasArmourEquipped(inv, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
    }

    public static boolean hasNetheriteSet(PlayerInventory inv) {
        return hasArmourEquipped(inv, Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
    }

}
