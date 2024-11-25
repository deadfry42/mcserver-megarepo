package uk.co.nikodem.dFSmpPlugin.Content.Recipes;

import org.bukkit.Material;
import org.bukkit.inventory.*;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class CustomItemRecipes extends RecipeCreator {

    public CustomItemRecipes(DFSmpPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void createRecipes() {
        //tools
        silkTools();
        veinTools();
        obsidianTools();
        calciteTools();

        //armour
        calciteArmour();

        //etc
        magicMirror();
        entityBucket();
        warpedWart();
    }

    private void warpedWart() {
        RegisterRecipe(
                createShapelessRecipe(CustomItemManager.createWarpedWart(), "WarpedWart")
                        .addIngredient(Material.WARPED_WART_BLOCK)
        );
        RegisterRecipe(
                createShapedRecipe(Material.WARPED_WART_BLOCK)
                        .shape("WWW", "WWW", "WWW")
                        .setIngredient('W', new RecipeChoice.ExactChoice(CustomItemManager.createWarpedWart()))
        );

        Iterator<Recipe> it = getServer().recipeIterator();
        Recipe recipe;
        while(it.hasNext()) {
            recipe = it.next();
            if (recipe != null && recipe.getResult().getType() == Material.NETHER_WART_BLOCK) {
                it.remove();
            }
        }

        RegisterRecipe(
                createShapedRecipe(Material.NETHER_WART_BLOCK)
                        .shape("WWW", "WWW", "WWW")
                        .setIngredient('W', new RecipeChoice.ExactChoice(new ItemStack(Material.NETHER_WART)))
        );
    }

    private void magicMirror() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createMagicMirror())
                        .shape("GNG", "NDN", "GNG")
                        .setIngredient('G', Material.GLASS_PANE)
                        .setIngredient('N', Material.IRON_NUGGET)
                        .setIngredient('D', Material.DIAMOND)
        );
    }

    private void entityBucket() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createEntityBucket())
                        .shape("IXI", " I ")
                        .setIngredient('I', Material.IRON_INGOT)
                        .setIngredient('X', Material.COBWEB)
        );
    }

    private void calciteArmour() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteHelmet(), "CalciteArmour")
                        .shape("CCC", "C C")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteChestplate(), "CalciteArmour")
                        .shape("C C", "CCC", "CCC")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteLeggings(), "CalciteArmour")
                        .shape("CCC", "C C", "C C")
                        .setIngredient('C', Material.CALCITE)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteBoots(), "CalciteArmour")
                        .shape("C C", "C C")
                        .setIngredient('C', Material.CALCITE)
        );
    }

    private void calciteTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteSword())
                        .shape("C", "C", "S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteAxe(), "Axe1")
                        .shape("CC", "CS", " S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteAxe(), "Axe2")
                        .shape("CC", "SC", "S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalcitePickaxe())
                        .shape("CCC", " S ", " S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteShovel())
                        .shape("C", "S", "S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteHoe(), "Hoe1")
                        .shape("CC", "S ", "S ")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createCalciteHoe(), "Hoe2")
                        .shape("CC", " S", " S")
                        .setIngredient('C', Material.CALCITE)
                        .setIngredient('S', Material.STICK)
        );
    }

    private void veinTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createVeinPickaxe())
                        .shape("AAA", "ASA", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('A', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createVeinAxe(), "Axe1")
                        .shape("AAA", " SA", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('A', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createVeinAxe(), "Axe2")
                        .shape("AAA", " SA", " S ")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('A', Material.STICK)
        );
    }

    private void obsidianTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createObsidianPickaxe())
                        .shape("NON", " C ", " C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createObsidianAxe(), "Axe1")
                        .shape("NO", "NC", " C")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createObsidianAxe(), "Axe2")
                        .shape("ON", "CN", "C ")
                        .setIngredient('N', Material.NETHERITE_INGOT)
                        .setIngredient('O', Material.CRYING_OBSIDIAN)
                        .setIngredient('C', Material.STICK)
        );
    }

    private void silkTools() {
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkSword())
                        .shape("C", "C", "S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkAxe(), "Axe1")
                        .shape("CC", "CS", " S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkAxe(), "Axe2")
                        .shape("CC", "SC", "S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkPickaxe())
                        .shape("CCC", " S ", " S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkShovel())
                        .shape("C", "S", "S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );

        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkHoe(), "Hoe1")
                        .shape("CC", " S", " S")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
        RegisterRecipe(
                createShapedRecipe(CustomItemManager.createSilkHoe(), "Hoe2")
                        .shape("CC", "S ", "S ")
                        .setIngredient('C', Material.COBWEB)
                        .setIngredient('S', Material.STICK)
        );
    }
}