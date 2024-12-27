package uk.co.nikodem.dFSmpPlugin.Content.Recipes;

import org.bukkit.Material;
import org.bukkit.inventory.*;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class CustomItemRecipes extends RecipeCreator {

    public CustomItemRecipes(DFSmpPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void createRecipes() {
        // tools
        silkTools();
        veinTools();
        obsidianTools();
        calciteTools();
        firidiumTools();
        copperTools();

        // cool weapons
        vampireSword();
        wildBow();
        stick();

        // armour
        firidiumArmour();
        calciteArmour();
        copperArmour();
        obsidianArmour();
        sculkArmour();

        // etc
        firidiumOthers();
        customTotems();
        bluebellsarStick();

        // random etc
        magicMirror();
        entityBucket();
        warpedWart();
    }

    private void customTotems() {

        // i have to do the recipes like this for bedrock support
        // bedrock handles stone cutters weirdly
        // so i have to make the reversion only in the crafting table

        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createAmongus(), "Normal-Amongus")
        );
        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createLegacyTotem(), "Normal-LegacyTotem")
        );
        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createDanTDMTotem(), "Normal-DanTDMTotem")
        );
        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createTechnoTotem(), "Normal-TechnoTotem")
        );
        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createCreeperTotem(), "Normal-CreeperTotem")
        );
        RegisterRecipe(
                createStonecuttingRecipe(new RecipeChoice.ExactChoice(new ItemStack(Material.TOTEM_OF_UNDYING)), CustomItems.createHerobrineTotem(), "Normal-HerobrineTotem")
        );

        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "Amongus-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createAmongus()))
        );
        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "LegacyTotem-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createLegacyTotem()))
        );
        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "DanTDMTotem-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createDanTDMTotem()))
        );
        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "TechnoTotem-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createTechnoTotem()))
        );
        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "CreeperTotem-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createCreeperTotem()))
        );
        RegisterRecipe(
                createShapelessRecipe(Material.TOTEM_OF_UNDYING, "HerobrineTotem-Normal")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createHerobrineTotem()))
        );
    }

    private void sculkArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSculkHelmet(), "SculkArmour")
                        .shape("SES", "S S")
                        .setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.createSculkPiece()))
                        .setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(Material.ECHO_SHARD)))
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSculkChestplate(), "SculkArmour")
                        .shape("S S", "SES", "ESE")
                        .setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.createSculkPiece()))
                        .setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(Material.ECHO_SHARD)))
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSculkLeggings(), "SculkArmour")
                        .shape("SSS", "E E", "S S")
                        .setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.createSculkPiece()))
                        .setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(Material.ECHO_SHARD)))
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSculkBoots(), "SculkArmour")
                        .shape("S S", "E E")
                        .setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.createSculkPiece()))
                        .setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(Material.ECHO_SHARD)))
        );
    }

    private void wildBow() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createWildBow(), "WildBow")
                        .shape("VSV", "SIV", "VSV")
                        .setIngredient('S', Material.STICK)
                        .setIngredient('V', Material.VINE)
                        .setIngredient('I', Material.GOLD_INGOT)
        );
    }

    private void stick() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createKnockbackStick(), "KnockbackStick")
                        .shape(" SB", "SBS", "BS ")
                        .setIngredient('S', Material.STICK)
                        .setIngredient('B', Material.BREEZE_ROD)
        );
    }

    private void vampireSword() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createVampireSword(), "VampireSword")
                        .shape("B", "F", "S")
                        .setIngredient('B', Material.BREEZE_ROD)
                        .setIngredient('S', Material.STICK)
                        .setIngredient('F', Material.FLINT)
        );
    }

    private void warpedWart() {
        RegisterRecipe(
                createShapelessRecipe(CustomItems.createWarpedWart(), "WarpedWart")
                        .addIngredient(Material.WARPED_WART_BLOCK)
        );
        RegisterRecipe(
                createShapedRecipe(Material.WARPED_WART_BLOCK)
                        .shape("WWW", "WWW", "WWW")
                        .setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.createWarpedWart()))
        );

        RemoveRecipesWithResult(
                RecipeType.ANYCRAFTING,
                Material.NETHER_WART_BLOCK
        );

        RegisterRecipe(
                createShapedRecipe(Material.NETHER_WART_BLOCK)
                        .shape("WWW", "WWW", "WWW")
                        .setIngredient('W', new RecipeChoice.ExactChoice(new ItemStack(Material.NETHER_WART)))
        );
    }

    private void bluebellsarStick() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createBluebellsarStick())
                        .shape("ADA", " SD", "S A")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('D', Material.DIAMOND)
                        .setIngredient('S', Material.STICK)
        );
    }

    private void magicMirror() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createMagicMirror())
                        .shape("GNG", "NDN", "GNG")
                        .setIngredient('G', Material.GLASS_PANE)
                        .setIngredient('D', Material.DIAMOND)
                        .setIngredient('N', new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_NUGGET)))
        );
    }

    private void entityBucket() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createEntityBucket())
                        .shape("IXI", " I ")
                        .setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_INGOT)))
                        .setIngredient('X', Material.COBWEB)
        );
    }

    private void copperArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperHelmet(), "CopperArmour")
                        .shape("CCC", "C C")
                        .setIngredient('C', Material.COPPER_INGOT)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperChestplate(), "CopperArmour")
                        .shape("C C", "CCC", "CCC")
                        .setIngredient('C', Material.COPPER_INGOT)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperLeggings(), "CopperArmour")
                        .shape("CCC", "C C", "C C")
                        .setIngredient('C', Material.COPPER_INGOT)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperBoots(), "CopperArmour")
                        .shape("C C", "C C")
                        .setIngredient('C', Material.COPPER_INGOT)
        );
    }

    private void calciteArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteHelmet(), "CalciteArmour")
                        .shape("CCC", "C C")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteChestplate(), "CalciteArmour")
                        .shape("C C", "CCC", "CCC")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteLeggings(), "CalciteArmour")
                        .shape("CCC", "C C", "C C")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteBoots(), "CalciteArmour")
                        .shape("C C", "C C")
                        .setIngredient('C', Material.CALCITE)
        );
    }

    private void calciteTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteSword())
                        .shape("C", "C", "S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteAxe(), "Axe1")
                        .shape("CC", "CS", " S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteAxe(), "Axe2")
                        .shape("CC", "SC", "S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalcitePickaxe())
                        .shape("CCC", " S ", " S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteShovel())
                        .shape("C", "S", "S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteHoe(), "Hoe1")
                        .shape("CC", "S ", "S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCalciteHoe(), "Hoe2")
                        .shape("CC", " S", " S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
    }

    private void veinTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createVeinPickaxe(), "Vein")
                        .shape("AAA", "ASA", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createVeinAxe(), "VeinAxe1")
                        .shape("AAA", " SA", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createVeinAxe(), "VeinAxe2")
                        .shape("AAA", "AS ", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('S', Material.STICK)
        );
    }

    private void firidiumArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltHelmet(), "Firidium")
                        .shape("BBB", "B B")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltChestplate(), "Firidium")
                        .shape("B B", "BBB", "BBB")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltLeggings(), "Firidium")
                        .shape("BBB", "B B", "B B")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltBoots(), "Firidium")
                        .shape("B B", "B B")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
        );
    }

    private void firidiumOthers() {
        RemoveRecipesWithIngredients(
                RecipeType.BLASTING,
                Material.IRON_AXE, Material.IRON_PICKAXE, Material.IRON_SHOVEL, Material.IRON_SWORD, Material.IRON_HOE,
                Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS
        );

        RegisterRecipe(
                createBlastingRecipe(
                        new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_INGOT)),
                        CustomItems.createAutosmeltIngot()
                )
        );

        RegisterRecipe(
                createBlastingRecipe(
                        new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_NUGGET)),
                        CustomItems.createAutosmeltNugget()
                )
        );

        RegisterRecipe(
                createShapelessRecipe(CustomItemManager.setAmount(CustomItems.createAutosmeltNugget(), 9), "Firidium")
                        .addIngredient(new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltIngot(), "Firidium")
                        .shape("NNN", "NNN", "NNN")
                        .setIngredient('N', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltNugget()))
        );
    }

    private void firidiumTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltSword(), "Firidium")
                        .shape("B", "B", "S")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltAxe(), "FiridiumAxe1")
                        .shape("BB", "BS", " S")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltAxe(), "FiridiumAxe2")
                        .shape("BB", "SB", "S ")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltPickaxe(), "Firidium")
                        .shape("BBB", " S ", " S ")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltShovel(), "Firidium")
                        .shape("B", "S", "S")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltHoe(), "FiridiumHoe1")
                        .shape("BB", " S", " S")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createAutosmeltHoe(), "FiridiumHoe2")
                        .shape("BB", "S ", "S ")
                        .setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltIngot()))
                        .setIngredient('S', Material.IRON_BARS)
        );
    }

    private void obsidianTools() {

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianSword())
                        .shape(" N ", "ONO", " C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianAxe(), "Axe1")
                        .shape("NO", "NC", " C")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianAxe(), "Axe2")
                        .shape("ON", "CN", "C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianPickaxe())
                        .shape("NON", " C ", " C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianShovel())
                        .shape("O", "N", "C")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianHoe(), "Hoe1")
                        .shape("NO", " C", " C")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianHoe(), "Hoe2")
                        .shape("ON", "C ", "C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );
    }

    private void obsidianArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianHelmet(), "Obsidian")
                        .shape("NON", "N N")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianChestplate(), "Obsidian")
                        .shape("N N", "NON", "NNN")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianLeggings(), "Obsidian")
                        .shape("NNN", "O O", "N N")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createObsidianBoots(), "Obsidian")
                        .shape("N N", "O O")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
        );
    }

    private void copperTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperSword())
                        .shape("C", "C", "S")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperAxe(), "Axe1")
                        .shape("CC", "CS", " S")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperAxe(), "Axe2")
                        .shape("CC", "SC", "S ")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperPickaxe())
                        .shape("CCC", " S ", " S ")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperShovel())
                        .shape("C", "S", "S")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperHoe(), "Hoe1")
                        .shape("CC", " S", " S")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createCopperHoe(), "Hoe2")
                        .shape("CC", "S ", "S ")
                        .setIngredient('C', Material.COPPER_INGOT)
                        .setIngredient('S', Material.STICK)
        );
    }

    private void silkTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkSword())
                        .shape("C", "C", "S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkAxe(), "Axe1")
                        .shape("CC", "CS", " S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkAxe(), "Axe2")
                        .shape("CC", "SC", "S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkPickaxe())
                        .shape("CCC", " S ", " S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkShovel())
                        .shape("C", "S", "S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkHoe(), "Hoe1")
                        .shape("CC", " S", " S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItems.createSilkHoe(), "Hoe2")
                        .shape("CC", "S ", "S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
    }
}