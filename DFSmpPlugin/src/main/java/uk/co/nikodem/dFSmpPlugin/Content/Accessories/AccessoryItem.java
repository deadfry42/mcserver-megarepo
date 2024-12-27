package uk.co.nikodem.dFSmpPlugin.Content.Accessories;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;

public class AccessoryItem {
//    @Nullable
//    public static ItemStack createItemFromAccessoryData(AccessoryData ad) {
//        if (ad.getIcon() == null) return null;
//        ItemStack i = ad.getIcon();
//        ItemMeta m = i.getItemMeta();
//        if (m == null) return i;
//        m.setDisplayName(ad.getName());
//        m.setLore(Arrays.asList(ad.getDescription().split("LORESPLIT")));
//        m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//        m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//        i.setItemMeta(m);
//        return i;
//    }
//
//    @Nullable
//    public static AccessoryData getAccessoryDataFromItem(ItemStack i) {
//        ItemMeta m = i.getItemMeta();
//        if (m == null) return null;
//        if (!m.hasCustomModelData()) return null;
//        int id = m.getCustomModelData();
//        for (AccessoryData a : AccessoryData.accessories) {
//            if (a.getId() == id) return a;
//        }
//        return null;
//    }
}
