package uk.co.nikodem.dFSmpPlugin.Content.CustomItems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;

public class FullArmourSet {

    // Vanilla armour sets

    public static final FullArmourSet Leather = new FullArmourSet("Leather")
            .setHelmet(Material.LEATHER_HELMET)
            .setChestplate(Material.LEATHER_CHESTPLATE)
            .setLeggings(Material.LEATHER_LEGGINGS)
            .setBoots(Material.LEATHER_BOOTS)
            .setSetBonus("Stops hunger from naturally depleting");

    public static final FullArmourSet Chainmail = new FullArmourSet("Chainmail")
            .setHelmet(Material.CHAINMAIL_HELMET)
            .setChestplate(Material.CHAINMAIL_CHESTPLATE)
            .setLeggings(Material.CHAINMAIL_LEGGINGS)
            .setBoots(Material.CHAINMAIL_BOOTS)
            .setSetBonus("Allows you to mine faster");

    public static final FullArmourSet Iron = new FullArmourSet("Iron")
            .setHelmet(Material.IRON_HELMET)
            .setChestplate(Material.IRON_CHESTPLATE)
            .setLeggings(Material.IRON_LEGGINGS)
            .setBoots(Material.IRON_BOOTS)
            .setSetBonus(false);

    public static final FullArmourSet Golden = new FullArmourSet("Golden")
            .setHelmet(Material.GOLDEN_HELMET)
            .setChestplate(Material.GOLDEN_CHESTPLATE)
            .setLeggings(Material.GOLDEN_LEGGINGS)
            .setBoots(Material.GOLDEN_BOOTS)
            .setSetBonus("Allows you to move faster");

    public static final FullArmourSet Diamond = new FullArmourSet("Diamond")
            .setHelmet(Material.DIAMOND_HELMET)
            .setChestplate(Material.DIAMOND_CHESTPLATE)
            .setLeggings(Material.DIAMOND_LEGGINGS)
            .setBoots(Material.DIAMOND_BOOTS)
            .setSetBonus(false);

    public static final FullArmourSet Netherite = new FullArmourSet("Netherite")
            .setHelmet(Material.NETHERITE_HELMET)
            .setChestplate(Material.NETHERITE_CHESTPLATE)
            .setLeggings(Material.NETHERITE_LEGGINGS)
            .setBoots(Material.NETHERITE_BOOTS)
            .setSetBonus("Makes you immune to fire");

    // Custom armour sets

    public static final FullArmourSet Firidium = new FullArmourSet("Firidium")
            .setHelmet(CustomItems.createAutosmeltHelmet())
            .setChestplate(CustomItems.createAutosmeltChestplate())
            .setLeggings(CustomItems.createAutosmeltLeggings())
            .setBoots(CustomItems.createAutosmeltBoots())
            .setBase(Iron)
            .setSetBonus("Attackers get set on fire.");

    public static final FullArmourSet Copper = new FullArmourSet("Copper")
            .setHelmet(CustomItems.createCopperHelmet())
            .setChestplate(CustomItems.createCopperChestplate())
            .setLeggings(CustomItems.createCopperLeggings())
            .setBoots(CustomItems.createCopperBoots())
            .setBase(Iron)
            .setSetBonus("Has a low chance to strike lightning at enemies during the rain.");

    public static final FullArmourSet Calcite = new FullArmourSet("Calcite")
            .setHelmet(CustomItems.createCalciteHelmet())
            .setChestplate(CustomItems.createCalciteChestplate())
            .setLeggings(CustomItems.createCalciteLeggings())
            .setBoots(CustomItems.createCalciteBoots())
            .setBase(Chainmail)
            .setSetBonus("Allows you to move faster and gives you more max health.");

    public static final FullArmourSet Obsidian = new FullArmourSet("Obsidian")
            .setHelmet(CustomItems.createObsidianHelmet())
            .setChestplate(CustomItems.createObsidianChestplate())
            .setLeggings(CustomItems.createObsidianLeggings())
            .setBoots(CustomItems.createObsidianBoots())
            .setBase(Netherite)
            .setSetBonus("Gives you resistance I.");

    public static final FullArmourSet Sculk = new FullArmourSet("Sculk")
            .setHelmet(CustomItems.createSculkHelmet())
            .setChestplate(CustomItems.createSculkChestplate())
            .setLeggings(CustomItems.createSculkLeggings())
            .setBoots(CustomItems.createSculkBoots())
            .setBase(Netherite)
            .setSetBonus("When hit, your opponent is blinded and you become invisible.");

    public final static FullArmourSet[] armourSets = {
            Leather,
            Chainmail,
            Calcite,
            Iron,
            Firidium,
            Copper,
            Golden,
            Diamond,
            Netherite,
            Obsidian,
            Sculk
    };

    public static boolean hasArmourSetEquipped(Player plr, FullArmourSet set) {
        return hasArmourSetEquipped(plr.getInventory(), set);
    }

    public static boolean hasArmourSetEquipped(PlayerInventory inv, FullArmourSet set) {
        return compareArmourPieces(inv.getHelmet(), set.getHelmet())
                && compareArmourPieces(inv.getChestplate(), set.getChestplate())
                && compareArmourPieces(inv.getLeggings(), set.getLeggings())
                && compareArmourPieces(inv.getBoots(), set.getBoots());
    }

    public static boolean compareArmourPieces(ItemStack item1, ItemStack item2) {
        if (item1 == null) return false;
        if (item2 == null) return false;

        ItemMeta im1 = item1.getItemMeta();
        ItemMeta im2 = item2.getItemMeta();

        if (im1 == null) return false;
        if (im2 == null) return false;


        if (item1.getType() == item2.getType()) {
            if (im1.hasCustomModelData() && im2.hasCustomModelData()) {
                return im1.getCustomModelData() == im2.getCustomModelData();
            } else return (!im1.hasCustomModelData() || im2.hasCustomModelData())
                    && (im1.hasCustomModelData() || !im2.hasCustomModelData());
        } else {
            return false;
        }
    }

    public static boolean hasArmourSetEquippedWithSetBonus(Player plr) {
        return hasArmourSetEquippedWithSetBonus(plr.getInventory());
    }

    public static boolean hasArmourSetEquippedWithSetBonus(PlayerInventory inv) {
        for (FullArmourSet set : FullArmourSet.armourSets) {
            if (!set.hasSetBonus()) continue;
            if (set.playerHasEquipped(inv)) {
                return true;
            }
        }
        return false;
    }

    public static FullArmourSet getArmourSetEquipped(Player plr) {
        return getArmourSetEquipped(plr.getInventory());
    }

    @Nullable
    public static FullArmourSet getArmourSetEquipped(PlayerInventory inv) {
        for (FullArmourSet set : armourSets) {
            if (hasArmourSetEquipped(inv, set)) return set;
        }
        return null;
    }

    private final String name;

    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private String base;

    private String setBonus;
    private boolean hasSetBonus;

    public FullArmourSet(String name) {
        this.name = name;
    }

    private FullArmourSet setHelmet(ItemStack helmet) {
       this.helmet = helmet;
       return this;
    }

    private FullArmourSet setHelmet(Material helmet) {
        this.helmet = new ItemStack(helmet);
        return this;
    }

    private FullArmourSet setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    private FullArmourSet setChestplate(Material chestplate) {
        this.chestplate = new ItemStack(chestplate);
        return this;
    }

    private FullArmourSet setLeggings(ItemStack leggings) {
        this.leggings = leggings;
        return this;
    }

    private FullArmourSet setLeggings(Material leggings) {
        this.leggings = new ItemStack(leggings);
        return this;
    }

    private FullArmourSet setBoots(ItemStack boots) {
        this.boots = boots;
        return this;
    }

    private FullArmourSet setBoots(Material boots) {
        this.boots = new ItemStack(boots);
        return this;
    }

    private FullArmourSet setBase(FullArmourSet base) {
        setBase(base.getName());
        return this;
    }

    private FullArmourSet setBase(String base) {
        this.base = base;
        return this;
    }

    private FullArmourSet setSetBonus(String setBonus) {
        this.setBonus = setBonus;
        this.hasSetBonus = true;
        return this;
    }

    private FullArmourSet setSetBonus(boolean setBonus) {
        this.setBonus = "";
        this.hasSetBonus = setBonus;
        return this;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public ItemStack getHelmet() {
        return this.helmet;
    }

    @Nullable
    public ItemStack getChestplate() {
        return this.chestplate;
    }

    @Nullable
    public ItemStack getLeggings() {
        return this.leggings;
    }

    @Nullable
    public ItemStack getBoots() {
        return this.boots;
    }

    @Nullable
    public String getBase() {
        return this.base;
    }

    @Nullable
    public String getSetBonusText() {
        return this.setBonus;
    }

    public boolean hasSetBonus() {
        return this.hasSetBonus;
    }

    public boolean isCustom() {
        return this.getBase() != null;
    }

    public boolean playerHasEquipped(Player plr) {
        return playerHasEquipped(plr.getInventory());
    }

    public boolean playerHasEquipped(PlayerInventory inv) {
        return hasArmourSetEquipped(inv, this);
    }

    public boolean itemInSet(ItemStack item) {
        return compareArmourPieces(item, this.getHelmet())
                || compareArmourPieces(item, this.getChestplate())
                || compareArmourPieces(item, this.getLeggings())
                || compareArmourPieces(item, this.getBoots());
    }

    public String toString() {
        // this was for debugging
        String customString = getBase() == null ? "vanilla" : getBase();
        return this.getName()+" set: ("+customString+")";
    }
}
