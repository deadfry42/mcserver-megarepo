package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.ExtraAdvancementManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.*;

public class SetBonuses {

    public static DFSmpPlugin plugin;

    public static void ApplySetBonuses(Player plr) {
        // leather armour has it's set bonus managed by HungerChange
        // firidium armour has it's set bonus managed by OnHit
        // copper armour has it's set bonus managed by OnHit

        if (FullArmourSet.hasArmourSetEquippedWithSetBonus(plr)) {
            if (!plugin.ca.MatchingAttire.isGranted(plr)) plugin.ca.MatchingAttire.grant(plr);
        }

        FullArmourSet setEquipped = FullArmourSet.getArmourSetEquipped(plr);

        if (setEquipped != null && setEquipped.hasSetBonus()) {
            ExtraAdvancementManager.setSetWorn(plr, setEquipped.getName());

            if (FullArmourSet.Chainmail.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 25, 1, true, false));
            } else if (FullArmourSet.Calcite.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, true, false));
                plr.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 25, 0, true, false));
            } else if (FullArmourSet.Golden.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, true, false));
            } else if (FullArmourSet.Diamond.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 25, 2, true, false));
            }else if (FullArmourSet.Netherite.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 25, 1, true, false));
            } else if (FullArmourSet.Obsidian.playerHasEquipped(plr)) {
                plr.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 25, 0, true, false));
            }
        }

        // i have made the arbitrary decision to put (some of) the
        // accessory effects here due to my midnight fog kicking in

        if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.hermes, plr)) {
            if (FullArmourSet.Calcite.playerHasEquipped(plr)
            || FullArmourSet.Golden.playerHasEquipped(plr)) plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 2, true, false));
            else plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 0, true, false));
        }

        ExtraAdvancementManager.setIndecisiveWardrobeProgression(plr);
    }

    public static Boolean HasSetBonusText(ItemStack item) {
        if (item == null) return false;
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return false;
        if (itemMeta.hasLore()) {
            ListIterator<String> it = Objects.requireNonNull(itemMeta.getLore()).listIterator();
            String lore;
            while(it.hasNext()) {
                lore = it.next();
                if (lore != null && lore.startsWith("Set Bonus:")) {
                    return true;
                }
            }
        }
        item.setItemMeta(itemMeta);
        return false;
    }

    public static ItemStack ApplySetBonusText(ItemStack item) {
        String text = getSetBonusText(item);
        if (text == null || text.isEmpty()) return item;
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;
        if (HasSetBonusText(item)) return item;
        List<String> lores;
        if (itemMeta.hasLore()) lores = itemMeta.getLore();
        else lores = new ArrayList<>();
        if (lores == null) return item;
        lores.add(text);
        itemMeta.setLore(lores);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack RemoveSetBonusText(ItemStack item) {
        if (item == null) return null;
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
        for (FullArmourSet set : FullArmourSet.armourSets) {
            if (!set.hasSetBonus()) continue;
            if (set.itemInSet(item)) {
                return SetBonusTextTemplate(set.getSetBonusText());
            }
        }
        return "";
    }
}
