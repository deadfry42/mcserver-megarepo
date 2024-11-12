package uk.co.nikodem.dFSmpPlugin.Content.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.material.MaterialData;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class RecipeCreator {
    List<Recipe> recipesToAdd = new ArrayList<Recipe>();
    static List<NamespacedKey> namespacedKeysToDiscover = new ArrayList<NamespacedKey>();

    private final DFSmpPlugin plugin;

    public RecipeCreator(DFSmpPlugin plugin) {
        this.plugin = plugin;

        populateRecipesList(); // add the recipes to the list

        for (Recipe recipe : recipesToAdd) { // add the recipes from the list :)
            Bukkit.addRecipe(recipe);
        }
        recipesToAdd = null;
    }

    public static void discoverRecipes(Player plr) { // autodiscovery
        // no auto discovery
        for (NamespacedKey namespacedKey : namespacedKeysToDiscover) { // add the recipes from the list :)
            plr.discoverRecipe(namespacedKey);
        }
    }

    private void populateRecipesList() {
        createCoralRecipes();
        createHorseRecipes();
        createWeaponRecipes();
        createBlastFurnaceRecipes();
        createChainmailRecipes();
        createEtcRecipes();

        // custom item recipes
        createWarpedWartRecipes();
        createEntityBucketRecipe();
        createMagicMirrorRecipe();
//        createMiningHelmetRecipe();
        createCalciteSetRecipe();
        createObsidianToolRecipes();
        createVeinToolRecipes();
        createSilkToolRecipes();
    }

    // custom item recipes

    private void createWarpedWartRecipes() {
        ItemStack warpedWart = CustomItemManager.createWarpedWart();
        ShapelessRecipe recipeww = new ShapelessRecipe(MakeNamespacedKey(plugin, MakeId(warpedWart, "warped")), warpedWart);
        recipeww.addIngredient(Material.WARPED_WART_BLOCK);
        recipesToAdd.add(recipeww);

        ItemStack warpedWartBlock = new ItemStack(Material.WARPED_WART_BLOCK);
        ShapedRecipe recipewwb = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(warpedWartBlock, "warped")), warpedWartBlock)
                .shape("WWW", "WWW", "WWW")
                .setIngredient('W', new RecipeChoice.ExactChoice(CustomItemManager.createWarpedWart()));
        recipesToAdd.add(recipewwb);

        Iterator<Recipe> it = getServer().recipeIterator();
        Recipe recipe;
        while(it.hasNext()) {
            recipe = it.next();
            if (recipe != null && recipe.getResult().getType() == Material.NETHER_WART_BLOCK) {
                it.remove();
            }
        }

        ItemStack netherWartBlock = new ItemStack(Material.NETHER_WART_BLOCK);
        ShapedRecipe recipenwb = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(netherWartBlock)), netherWartBlock)
                .shape("WWW", "WWW", "WWW")
                .setIngredient('W', new RecipeChoice.ExactChoice(new ItemStack(Material.NETHER_WART)));
        recipesToAdd.add(recipenwb);
    }

    private void createEntityBucketRecipe() {
        ItemStack entityBucket = CustomItemManager.createEntityBucket();
        ShapedRecipe recipeeb = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(entityBucket)), entityBucket)
                .shape("IXI", " I ")
                .setIngredient('I', Material.IRON_INGOT)
                .setIngredient('X', Material.COBWEB);
        recipesToAdd.add(recipeeb);
    }

    private void createMagicMirrorRecipe() {
        ItemStack magicMirror = CustomItemManager.createMagicMirror();
        ShapedRecipe recipemm = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(magicMirror)), magicMirror)
                .shape("GNG", "NDN", "GNG")
                .setIngredient('G', Material.GLASS_PANE)
                .setIngredient('N', Material.IRON_NUGGET)
                .setIngredient('D', Material.DIAMOND);
        recipesToAdd.add(recipemm);
    }

//    private void createMiningHelmetRecipe() {
//        ItemStack miningHelmet = CustomItemManager.createMiningHelmet();
//        ShapedRecipe recipemh = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(miningHelmet)), miningHelmet)
//                .shape("GIG", "L L")
//                .setIngredient('L', Material.LEATHER)
//                .setIngredient('I', Material.LANTERN)
//                .setIngredient('G', Material.GOLD_INGOT);
//        recipesToAdd.add(recipemh);
//    }

    private void createCalciteSetRecipe() {
        ItemStack calciteHelmet = CustomItemManager.createCalciteHelmet();
        ShapedRecipe recipech = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteHelmet, "calcite")), calciteHelmet)
                .shape("CCC", "C C")
                .setIngredient('C', Material.CALCITE);
        recipesToAdd.add(recipech);

        ItemStack calciteChestplate = CustomItemManager.createCalciteChestplate();
        ShapedRecipe recipecc = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteChestplate, "calcite")), calciteChestplate)
                .shape("C C", "CCC", "CCC")
                .setIngredient('C', Material.CALCITE);
        recipesToAdd.add(recipecc);

        ItemStack calciteLeggings = CustomItemManager.createCalciteLeggings();
        ShapedRecipe recipecl = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteLeggings, "calcite")), calciteLeggings)
                .shape("CCC", "C C", "C C")
                .setIngredient('C', Material.CALCITE);
        recipesToAdd.add(recipecl);

        ItemStack calciteBoots = CustomItemManager.createCalciteBoots();
        ShapedRecipe recipecb = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteBoots, "calcite")), calciteBoots)
                .shape("C C", "C C")
                .setIngredient('C', Material.CALCITE);
        recipesToAdd.add(recipecb);

        ItemStack calciteSword = CustomItemManager.createCalciteSword();
        ShapedRecipe recipecs = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteSword, "calcite")), calciteSword)
                .shape("C", "C", "S")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipecs);

        ItemStack calciteAxe = CustomItemManager.createCalciteAxe();
        ShapedRecipe recipeca = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteAxe, "calcite")), calciteAxe)
                .shape("CC", "CS", " S")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipeca);

        ShapedRecipe recipeca2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteAxe, "calcite2")), calciteAxe)
                .shape("CC", "SC", "S ")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipeca2);

        ItemStack calcitePickaxe = CustomItemManager.createCalcitePickaxe();
        ShapedRecipe recipecp = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calcitePickaxe, "calcite")), calcitePickaxe)
                .shape("CCC", " S ", " S ")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipecp);

        ItemStack calciteShovel = CustomItemManager.createCalciteShovel();
        ShapedRecipe recipecsh = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteShovel, "calcite")), calciteShovel)
                .shape("C", "S", "S")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipecsh);

        ItemStack calciteHoe = CustomItemManager.createCalciteHoe();
        ShapedRecipe recipecho = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteHoe, "calcite")), calciteHoe)
                .shape("CC", "S ", "S ")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipecho);

        ShapedRecipe recipecho2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(calciteHoe, "calcite2")), calciteHoe)
                .shape("CC", " S", " S")
                .setIngredient('C', Material.CALCITE)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipecho2);
    }

    private void createObsidianToolRecipes() {
        ItemStack obsidianpick = CustomItemManager.createObsidianPickaxe();
        ShapedRecipe recipeop = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(obsidianpick)), obsidianpick)
                .shape("NON", " C ", " C ")
                .setIngredient('N', Material.NETHERITE_INGOT)
                .setIngredient('O', Material.CRYING_OBSIDIAN)
                .setIngredient('C', Material.STICK);
        recipesToAdd.add(recipeop);

        ItemStack obsidianaxe = CustomItemManager.createObsidianAxe();
        ShapedRecipe recipeoa = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(obsidianaxe)), obsidianaxe)
                .shape("NO", "NC", " C")
                .setIngredient('N', Material.NETHERITE_INGOT)
                .setIngredient('O', Material.CRYING_OBSIDIAN)
                .setIngredient('C', Material.STICK);
        recipesToAdd.add(recipeoa);
        ShapedRecipe recipeoa2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(obsidianaxe, "2")), obsidianaxe)
                .shape("ON", "CN", "C ")
                .setIngredient('N', Material.NETHERITE_INGOT)
                .setIngredient('O', Material.CRYING_OBSIDIAN)
                .setIngredient('C', Material.STICK);
        recipesToAdd.add(recipeoa2);
    }

    private void createVeinToolRecipes() {
        ItemStack veinpick = CustomItemManager.createVeinPickaxe();
        ShapedRecipe recipevp = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(veinpick)), veinpick)
                .shape("AAA", "ASA", " S ")
                .setIngredient('A', Material.AMETHYST_SHARD)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipevp);

        ItemStack veinaxe = CustomItemManager.createVeinAxe();
        ShapedRecipe recipeva = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(veinaxe)), veinaxe)
                .shape("AAA", "AS ", " S ")
                .setIngredient('A', Material.AMETHYST_SHARD)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipeva);
        ShapedRecipe recipeva2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(veinaxe, "2")), veinaxe)
                .shape("AAA", " SA", " S ")
                .setIngredient('A', Material.AMETHYST_SHARD)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(recipeva2);
    }

    private void createSilkToolRecipes() {
        ItemStack silksword = CustomItemManager.createSilkSword();
        ShapedRecipe silkswordrecipe = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silksword)), silksword)
                .shape("C", "C", "S")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkswordrecipe);

        ItemStack silkaxe = CustomItemManager.createSilkAxe();
        ShapedRecipe silkaxerecipe = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silkaxe)), silkaxe)
                .shape("CC", "CS", " S")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkaxerecipe);
        ShapedRecipe silkaxerecipe2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silkaxe, "2")), silkaxe)
                .shape("CC", "SC", "S ")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkaxerecipe2);

        ItemStack silkpickaxe = CustomItemManager.createSilkPickaxe();
        ShapedRecipe silkpickrecipe = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silkpickaxe)), silkpickaxe)
                .shape("CCC", " S ", " S ")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkpickrecipe);

        ItemStack silkshovel = CustomItemManager.createSilkShovel();
        ShapedRecipe silkshovelrecipe = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silkshovel)), silkshovel)
                .shape("C", "S", "S")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkshovelrecipe);

        ItemStack silkhoe = CustomItemManager.createSilkHoe();
        ShapedRecipe silkhoerecipe = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(silkhoe)), silkhoe)
                .shape("CC", " S", " S")
                .setIngredient('C', Material.COBWEB)
                .setIngredient('S', Material.STICK);
        recipesToAdd.add(silkhoerecipe);
    }

    // vanilla recipes

    private void createEtcRecipes() {
        ItemStack saddle = new ItemStack(Material.SADDLE, 1);
        ShapedRecipe recipesaddle = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(saddle)), saddle);
        recipesaddle.shape("III", "X X");
        recipesaddle.setIngredient('X', Material.CHAIN);
        recipesaddle.setIngredient('I', Material.LEATHER);
        recipesToAdd.add(recipesaddle);

        ItemStack nametag = new ItemStack(Material.NAME_TAG, 1);
        ShapedRecipe recipenametag = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(nametag)), nametag);
        recipenametag.shape(" SS", "PIS", "PPP");
        recipenametag.setIngredient('P', Material.PAPER);
        recipenametag.setIngredient('I', Material.INK_SAC);
        recipenametag.setIngredient('S', Material.STRING);
        recipesToAdd.add(recipenametag);

        ItemStack netherwart = new ItemStack(Material.NETHER_WART, 1);
        ShapelessRecipe recipewart = new ShapelessRecipe(MakeNamespacedKey(plugin, MakeId(netherwart)), netherwart);
        recipewart.addIngredient(Material.NETHER_WART_BLOCK);
        recipesToAdd.add(recipewart);

        ItemStack amethystCrystal = new ItemStack(Material.AMETHYST_SHARD, 1);
        ShapelessRecipe recipeAmethyst = new ShapelessRecipe(MakeNamespacedKey(plugin, MakeId(amethystCrystal)), amethystCrystal)
                .addIngredient(Material.AMETHYST_BLOCK);
        recipesToAdd.add(recipeAmethyst);
    }

    private void createChainmailRecipes() {
        ItemStack chainHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ShapedRecipe recipech = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(chainHelmet)), chainHelmet)
                .shape("CCC", "C C")
                .setIngredient('C', Material.CHAIN);
        recipesToAdd.add(recipech);

        ItemStack chainChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ShapedRecipe recipecc = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(chainChest)), chainChest)
                .shape("C C", "CCC", "CCC")
                .setIngredient('C', Material.CHAIN);
        recipesToAdd.add(recipecc);

        ItemStack chainLegs = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ShapedRecipe recipecl = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(chainLegs)), chainLegs)
                .shape("CCC", "C C", "C C")
                .setIngredient('C', Material.CHAIN);
        recipesToAdd.add(recipecl);

        ItemStack chainBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ShapedRecipe recipecb = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(chainBoots)), chainBoots)
                .shape("C C", "C C")
                .setIngredient('C', Material.CHAIN);
        recipesToAdd.add(recipecb);
    }

    private void createBlastFurnaceRecipes() {
        ItemStack stone = new ItemStack(Material.STONE, 1);
        BlastingRecipe recipestone = new BlastingRecipe(MakeNamespacedKey(plugin, MakeId(stone)), stone, Material.COBBLESTONE, 0.1F, 100);
        recipesToAdd.add(recipestone);

        ItemStack sstone = new ItemStack(Material.SMOOTH_STONE, 1);
        BlastingRecipe recipesstone = new BlastingRecipe(MakeNamespacedKey(plugin, MakeId(sstone)), sstone, Material.STONE, 0.1F, 100);
        recipesToAdd.add(recipesstone);

        ItemStack sand = new ItemStack(Material.GLASS, 1);
        BlastingRecipe recipesand = new BlastingRecipe(MakeNamespacedKey(plugin, MakeId(sand)), sand, Material.SAND, 0.1F, 100);
        recipesToAdd.add(recipesand);
    }

    private void createWeaponRecipes() {
        ItemStack trident = new ItemStack(Material.TRIDENT, 1);
        ShapedRecipe recipetrident = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(trident)), trident);
        recipetrident.shape("III", "DXD", " D ");
        recipetrident.setIngredient('D', Material.DIAMOND);
        recipetrident.setIngredient('X', Material.PRISMARINE_SHARD);
        recipetrident.setIngredient('I', Material.IRON_INGOT);
        recipesToAdd.add(recipetrident);
    }

    private void createHorseRecipes() {
        ItemStack leatherhorsearmour = new ItemStack(Material.LEATHER_HORSE_ARMOR, 1);
        ShapedRecipe recipeleatherhorsearmour = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(leatherhorsearmour)), leatherhorsearmour);
        recipeleatherhorsearmour.shape("  L", "LWL", "LLL");
        recipeleatherhorsearmour.setIngredient('L', Material.LEATHER);
        recipeleatherhorsearmour.setIngredient('W', Material.SADDLE);
        recipesToAdd.add(recipeleatherhorsearmour);

        ItemStack ironhorsearmour = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
        ShapedRecipe recipeironhorsearmour = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(ironhorsearmour)), ironhorsearmour);
        recipeironhorsearmour.shape("  L", "LWL", "LLL");
        recipeironhorsearmour.setIngredient('L', Material.IRON_INGOT);
        recipeironhorsearmour.setIngredient('W', Material.SADDLE);
        recipesToAdd.add(recipeironhorsearmour);

        ItemStack goldhorsearmour = new ItemStack(Material.GOLDEN_HORSE_ARMOR, 1);
        ShapedRecipe recipegoldhorsearmour = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(goldhorsearmour)), goldhorsearmour);
        recipegoldhorsearmour.shape("  L", "LWL", "LLL");
        recipegoldhorsearmour.setIngredient('L', Material.GOLD_INGOT);
        recipegoldhorsearmour.setIngredient('W', Material.SADDLE);
        recipesToAdd.add(recipegoldhorsearmour);

        ItemStack diamondhorsearmour = new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1);
        ShapedRecipe recipediamondhorsearmour = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(diamondhorsearmour)), diamondhorsearmour);
        recipediamondhorsearmour.shape("  L", "LWL", "LLL");
        recipediamondhorsearmour.setIngredient('L', Material.DIAMOND);
        recipediamondhorsearmour.setIngredient('W', Material.SADDLE);
        recipesToAdd.add(recipediamondhorsearmour);
    }

    private void createCoralRecipes() {
        ItemStack coral1 = new ItemStack(Material.BRAIN_CORAL, 1);
        ShapedRecipe recipecoral1 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1, "-normal")), coral1);
        recipecoral1.shape("W", "C");
        recipecoral1.setIngredient('C', Material.DEAD_BRAIN_CORAL);
        recipecoral1.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral1);

        ItemStack coral2 = new ItemStack(Material.BUBBLE_CORAL, 1);
        ShapedRecipe recipecoral2 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2, "-normal")), coral2);
        recipecoral2.shape("W", "C");
        recipecoral2.setIngredient('C', Material.DEAD_BUBBLE_CORAL);
        recipecoral2.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral2);

        ItemStack coral3 = new ItemStack(Material.FIRE_CORAL, 1);
        ShapedRecipe recipecoral3 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3, "-normal")), coral3);
        recipecoral3.shape("W", "C");
        recipecoral3.setIngredient('C', Material.DEAD_FIRE_CORAL);
        recipecoral3.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral3);

        ItemStack coral4 = new ItemStack(Material.TUBE_CORAL, 1);
        ShapedRecipe recipecoral4 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4, "-normal")), coral4);
        recipecoral4.shape("W", "C");
        recipecoral4.setIngredient('C', Material.DEAD_TUBE_CORAL);
        recipecoral4.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral4);

        ItemStack coral5 = new ItemStack(Material.HORN_CORAL, 1);
        ShapedRecipe recipecoral5 = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5, "-normal")), coral5);
        recipecoral5.shape("W", "C");
        recipecoral5.setIngredient('C', Material.DEAD_HORN_CORAL);
        recipecoral5.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral5);

        // fans

        ItemStack coral1fan = new ItemStack(Material.BRAIN_CORAL_FAN, 1);
        ShapedRecipe recipecoral1fan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1fan, "-fans")), coral1fan);
        recipecoral1fan.shape("W", "C");
        recipecoral1fan.setIngredient('C', Material.DEAD_BRAIN_CORAL_FAN);
        recipecoral1fan.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral1fan);

        ItemStack coral2fan = new ItemStack(Material.BUBBLE_CORAL_FAN, 1);
        ShapedRecipe recipecoral2fan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2fan, "-fans")), coral2fan);
        recipecoral2fan.shape("W", "C");
        recipecoral2fan.setIngredient('C', Material.DEAD_BUBBLE_CORAL_FAN);
        recipecoral2fan.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral2fan);

        ItemStack coral3fan = new ItemStack(Material.FIRE_CORAL_FAN, 1);
        ShapedRecipe recipecoral3fan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3fan, "-fans")), coral3fan);
        recipecoral3fan.shape("W", "C");
        recipecoral3fan.setIngredient('C', Material.DEAD_FIRE_CORAL_FAN);
        recipecoral3fan.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral3fan);

        ItemStack coral4fan = new ItemStack(Material.TUBE_CORAL_FAN, 1);
        ShapedRecipe recipecoral4fan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4fan, "-fans")), coral4fan);
        recipecoral4fan.shape("W", "C");
        recipecoral4fan.setIngredient('C', Material.DEAD_TUBE_CORAL_FAN);
        recipecoral4fan.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral4fan);

        ItemStack coral5fan = new ItemStack(Material.HORN_CORAL_FAN, 1);
        ShapedRecipe recipecoral5fan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5fan, "-fans")), coral5fan);
        recipecoral5fan.shape("W", "C");
        recipecoral5fan.setIngredient('C', Material.DEAD_HORN_CORAL_FAN);
        recipecoral5fan.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral5fan);

        // blocks

        ItemStack coral1block = new ItemStack(Material.BRAIN_CORAL_BLOCK, 1);
        ShapedRecipe recipecoral1block = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1block, "-blocks")), coral1block);
        recipecoral1block.shape("W", "C");
        recipecoral1block.setIngredient('C', Material.DEAD_BRAIN_CORAL_BLOCK);
        recipecoral1block.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral1block);

        ItemStack coral2block = new ItemStack(Material.BUBBLE_CORAL_BLOCK, 1);
        ShapedRecipe recipecoral2block = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2block, "-blocks")), coral2block);
        recipecoral2block.shape("W", "C");
        recipecoral2block.setIngredient('C', Material.DEAD_BUBBLE_CORAL_BLOCK);
        recipecoral2block.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral2block);

        ItemStack coral3block = new ItemStack(Material.FIRE_CORAL_BLOCK, 1);
        ShapedRecipe recipecoral3block = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3block, "-blocks")), coral3block);
        recipecoral3block.shape("W", "C");
        recipecoral3block.setIngredient('C', Material.DEAD_FIRE_CORAL_BLOCK);
        recipecoral3block.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral3block);

        ItemStack coral4block = new ItemStack(Material.TUBE_CORAL_BLOCK, 1);
        ShapedRecipe recipecoral4block = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4block, "-blocks")), coral4block);
        recipecoral4block.shape("W", "C");
        recipecoral4block.setIngredient('C', Material.DEAD_TUBE_CORAL_BLOCK);
        recipecoral4block.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral4block);

        ItemStack coral5block = new ItemStack(Material.HORN_CORAL_BLOCK, 1);
        ShapedRecipe recipecoral5block = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5block, "-blocks")), coral5block);
        recipecoral5block.shape("W", "C");
        recipecoral5block.setIngredient('C', Material.DEAD_HORN_CORAL_BLOCK);
        recipecoral5block.setIngredient('W', Material.WATER_BUCKET);
        recipesToAdd.add(recipecoral5block);

        // normal -> fans

        ItemStack coral1normalfan = new ItemStack(Material.BRAIN_CORAL_FAN, 1);
        ShapedRecipe recipecoral1normalfan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1normalfan, "-normalfans")), coral1normalfan);
        recipecoral1normalfan.shape("C");
        recipecoral1normalfan.setIngredient('C', Material.BRAIN_CORAL);
        recipesToAdd.add(recipecoral1normalfan);

        ItemStack coral2normalfan = new ItemStack(Material.BUBBLE_CORAL_FAN, 1);
        ShapedRecipe recipecoral2normalfan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2normalfan, "-normalfans")), coral2normalfan);
        recipecoral2normalfan.shape("C");
        recipecoral2normalfan.setIngredient('C', Material.BUBBLE_CORAL);
        recipesToAdd.add(recipecoral2normalfan);

        ItemStack coral3normalfan = new ItemStack(Material.FIRE_CORAL_FAN, 1);
        ShapedRecipe recipecoral3normalfan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3normalfan, "-normalfans")), coral3normalfan);
        recipecoral3normalfan.shape("C");
        recipecoral3normalfan.setIngredient('C', Material.FIRE_CORAL);
        recipesToAdd.add(recipecoral3normalfan);

        ItemStack coral4normalfan = new ItemStack(Material.TUBE_CORAL_FAN, 1);
        ShapedRecipe recipecoral4normalfan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4normalfan, "-normalfans")), coral4normalfan);
        recipecoral4normalfan.shape("C");
        recipecoral4normalfan.setIngredient('C', Material.TUBE_CORAL);
        recipesToAdd.add(recipecoral4normalfan);

        ItemStack coral5normalfan = new ItemStack(Material.HORN_CORAL_FAN, 1);
        ShapedRecipe recipecoral5normalfan = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5normalfan, "-normalfans")), coral5normalfan);
        recipecoral5normalfan.shape("C");
        recipecoral5normalfan.setIngredient('C', Material.HORN_CORAL);
        recipesToAdd.add(recipecoral5normalfan);

        // fans -> normal

        ItemStack coral1fannormal = new ItemStack(Material.BRAIN_CORAL, 1);
        ShapedRecipe recipecoral1fannormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1fannormal, "-fansnormal")), coral1fannormal);
        recipecoral1fannormal.shape("C");
        recipecoral1fannormal.setIngredient('C', Material.BRAIN_CORAL_FAN);
        recipesToAdd.add(recipecoral1fannormal);

        ItemStack coral2fannormal = new ItemStack(Material.BUBBLE_CORAL, 1);
        ShapedRecipe recipecoral2fannormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2fannormal, "-fansnormal")), coral2fannormal);
        recipecoral2fannormal.shape("C");
        recipecoral2fannormal.setIngredient('C', Material.BUBBLE_CORAL_FAN);
        recipesToAdd.add(recipecoral2fannormal);

        ItemStack coral3fannormal = new ItemStack(Material.FIRE_CORAL, 1);
        ShapedRecipe recipecoral3fannormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3fannormal, "-fansnormal")), coral3fannormal);
        recipecoral3fannormal.shape("C");
        recipecoral3fannormal.setIngredient('C', Material.FIRE_CORAL_FAN);
        recipesToAdd.add(recipecoral3fannormal);

        ItemStack coral4fannormal = new ItemStack(Material.TUBE_CORAL, 1);
        ShapedRecipe recipecoral4fannormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4fannormal, "-fansnormal")), coral4fannormal);
        recipecoral4fannormal.shape("C");
        recipecoral4fannormal.setIngredient('C', Material.TUBE_CORAL_FAN);
        recipesToAdd.add(recipecoral4fannormal);

        ItemStack coral5fannormal = new ItemStack(Material.HORN_CORAL, 1);
        ShapedRecipe recipecoral5fannormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5fannormal, "-fansnormal")), coral5fannormal);
        recipecoral5fannormal.shape("C");
        recipecoral5fannormal.setIngredient('C', Material.HORN_CORAL_FAN);
        recipesToAdd.add(recipecoral5fannormal);

        // blocks -> normal

        ItemStack coral1blocknormal = new ItemStack(Material.BRAIN_CORAL, 4);
        ShapedRecipe recipecoral1blocknormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral1blocknormal, "-blocksnormal")), coral1blocknormal);
        recipecoral1blocknormal.shape("C");
        recipecoral1blocknormal.setIngredient('C', Material.BRAIN_CORAL_BLOCK);
        recipesToAdd.add(recipecoral1blocknormal);

        ItemStack coral2blocknormal = new ItemStack(Material.BUBBLE_CORAL, 4);
        ShapedRecipe recipecoral2blocknormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral2blocknormal, "-blocksnormal")), coral2blocknormal);
        recipecoral2blocknormal.shape("C");
        recipecoral2blocknormal.setIngredient('C', Material.BUBBLE_CORAL_BLOCK);
        recipesToAdd.add(recipecoral2blocknormal);

        ItemStack coral3blocknormal = new ItemStack(Material.FIRE_CORAL, 4);
        ShapedRecipe recipecoral3blocknormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral3blocknormal, "-blocksnormal")), coral3blocknormal);
        recipecoral3blocknormal.shape("C");
        recipecoral3blocknormal.setIngredient('C', Material.FIRE_CORAL_BLOCK);
        recipesToAdd.add(recipecoral3blocknormal);

        ItemStack coral4blocknormal = new ItemStack(Material.TUBE_CORAL, 4);
        ShapedRecipe recipecoral4blocknormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral4blocknormal, "-blocksnormal")), coral4blocknormal);
        recipecoral4blocknormal.shape("C");
        recipecoral4blocknormal.setIngredient('C', Material.TUBE_CORAL_BLOCK);
        recipesToAdd.add(recipecoral4blocknormal);

        ItemStack coral5blocknormal = new ItemStack(Material.HORN_CORAL, 4);
        ShapedRecipe recipecoral5blocknormal = new ShapedRecipe(MakeNamespacedKey(plugin, MakeId(coral5blocknormal, "-blocksnormal")), coral5blocknormal);
        recipecoral5blocknormal.shape("C");
        recipecoral5blocknormal.setIngredient('C', Material.HORN_CORAL_BLOCK);
        recipesToAdd.add(recipecoral5blocknormal);
    }

    private String MakeId(ItemStack item, String extra) {
        return "recipe-"+item.getType().toString().toLowerCase().replace("_", "")+extra+"-dfsmprecipes";
    }

    private String MakeId(ItemStack item) {
        return MakeId(item, "");
    }

    public NamespacedKey MakeNamespacedKey(DFSmpPlugin plugin, String id) {
        NamespacedKey key = new NamespacedKey(plugin, id);
        namespacedKeysToDiscover.add(key);
        return key;
    }
}
