package uk.co.nikodem.dFSmpPlugin.Content.Accessories;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccessoryData {
    private final int id;
    private final String name;
    private final String desc;

    private ItemStack icon;

    private final List<Integer> conflictingAccessories = new ArrayList<>();

    public final static AccessoryData hermes = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.BOOTS),
            "Hermes Boots",
            "Allows the wearer to run super fast.LORESPLITDefinitely not stolen from terraria.")
            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData flowerBoots = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.HELMET),
            "Flower Boots",
            "Allows the wearer to jump on crops without breaking them.LORESPLITDefinitely not stolen from terraria.")
            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData htbook = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.OTHERMELEE),
            "Hitman Techniques Book",
            "Allows the wearer to silently kill someone, and silence them temporarily.LORESPLITReduces your damage output by 25%.")
            .setIcon(Material.BOOK);

    public final static AccessoryData cobaltshield = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.CHESTPLATE),
            "Cobalt Shield",
            "Greatly reduces knockback, but can result in the player being flung.LORESPLITDefinitely not stolen from terraria.")
            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData phantomRepellant = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.MAGICMIRROR),
            "Contaminated Membrane",
            "Prevents phantoms from attacking you.")
            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData luckyHorseshoe = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.HOE),
            "Lucky Horseshoe",
            "Prevents all fall damage.LORESPLITDefinitely not stolen from terraria.")
            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData pacifistAccessory = new AccessoryData(
            getCustomID(IdItemType.ACCESSORY, IdItemClass.OTHERMELEE),
            "",
            "Prevents you from starting combat.LORESPLITGives you Resistance when someone attacks you.")
            .setIcon(Material.FIREWORK_STAR);


    // too buggy
    // maybe revisit later
//    public final static AccessoryData cloudInABottle = new AccessoryData(
//            getCustomID(IdItemType.ACCESSORY, IdItemClass.LEGGINGS),
//            "Cloud in a Bottle",
//            "Allows the holder to double jump.LORESPLITPress jump twice mid-air to activate.LORESPLITDoes not prevent fall damage.")
//            .setIcon(Material.FIREWORK_STAR);

    public final static AccessoryData vmessence = new AccessoryData(
            getCustomID(IdItemType.VEIN, IdItemClass.PICKAXE),
            "Vein Miner's essence",
            "Allows the wearer to vein mine with any tool when sneaking.LORESPLITIncompatible with Firidium Essence.")
            .setIcon(Material.FIREWORK_STAR)
            .setConflictingAccessories(getCustomID(IdItemType.AUTOSMELT, IdItemClass.PICKAXE));
    public final static AccessoryData asessence = new AccessoryData(
            getCustomID(IdItemType.AUTOSMELT, IdItemClass.PICKAXE),
            "Firidium essence",
            "Allows the wearer to auto smelt with any tool when sneaking.LORESPLITIncompatible with Vein Miner's Essence.")
            .setIcon(Material.FIREWORK_STAR)
            .setConflictingAccessories(getCustomID(IdItemType.VEIN, IdItemClass.PICKAXE));

    public final static AccessoryData[] accessories = {
            hermes,
            flowerBoots,
            htbook,

            phantomRepellant,
            pacifistAccessory,

            cobaltshield,
            luckyHorseshoe,
//            cloudInABottle,

            vmessence,
            asessence,
    };

    public AccessoryData(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    private AccessoryData setConflictingAccessories(Integer... accessoryIds) {
        for (Integer aid : accessoryIds) {
            this.conflictingAccessories.add(aid);
        }
        return this;
    }

    private AccessoryData setIcon(ItemStack icon) {
        this.icon = icon;
        return this;
    }

    private AccessoryData setIcon(Material icon) {
        return setIcon(icon, this.id);
    }

    private AccessoryData setIcon(Material icon, int customId) {
        ItemStack i = new ItemStack(icon);
        ItemMeta m = i.getItemMeta();
        if (m == null) return this;
        m.setCustomModelData(customId);
        i.setItemMeta(m);
        return setIcon(i);
    }

    public ItemStack getAccessoryItem() {
        String name = this.getName();
        String loreString = this.getDescription();
        ItemStack base = this.getIcon();

        ItemMeta im = base.getItemMeta();
        assert im != null;

        im.setDisplayName(ChatColor.RESET + name);

        List<String> lores = new ArrayList<>();

        lores.add(ChatColor.GRAY + "Accessory item. Use /accessory to equip.");

        lores.addAll(Arrays.asList(loreString.split("LORESPLIT")));

        im.setLore(lores);

        base.setItemMeta(im);

        base = addAccessoryId(base);
        base = addMarkedForUUID(base); // for 1 stack

        return base;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.desc;
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public List<Integer> getConflicts() {
        return this.conflictingAccessories;
    }
}
