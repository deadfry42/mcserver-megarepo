package uk.co.nikodem.dFSmpPlugin.Content.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class RecipeCreator {
    private final String idTag = "-dfsmprecipes";
    List<Recipe> recipesToAdd = new ArrayList<Recipe>();
    static List<NamespacedKey> namespacedKeysToDiscover = new ArrayList<NamespacedKey>();

    public final DFSmpPlugin plugin;

    public RecipeCreator(DFSmpPlugin plugin) {
        this.plugin = plugin;

        createRecipes(); // add the recipes to the list

        for (Recipe recipe : recipesToAdd) { // add the recipes from the list :)
            Bukkit.addRecipe(recipe);
        }
        recipesToAdd = null;
    }

    protected void createRecipes() {

    }

    public void discoverRecipes(Player plr) { // autodiscovery
        // no auto discovery
        for (NamespacedKey namespacedKey : namespacedKeysToDiscover) { // add the recipes from the list :)
            plr.discoverRecipe(namespacedKey);
        }
    }

    public ShapedRecipe createShapedRecipe(ItemStack result, String extra) {
        return new ShapedRecipe(
                MakeNamespacedKey(
                        MakeId(result, extra)
                ),
                result
        );
    }

    public ShapedRecipe createShapedRecipe(ItemStack result) {
        return createShapedRecipe(result, "");
    }

    public ShapedRecipe createShapedRecipe(Material result, int amount, String extra) {
        return createShapedRecipe(new ItemStack(result, amount), extra);
    }

    public ShapedRecipe createShapedRecipe(Material result, int amount) {
        return createShapedRecipe(new ItemStack(result, amount), "");
    }

    public ShapedRecipe createShapedRecipe(Material result, String extra) {
        return createShapedRecipe(new ItemStack(result), extra);
    }

    public ShapedRecipe createShapedRecipe(Material result) {
        return createShapedRecipe(new ItemStack(result), "");
    }

    public ShapelessRecipe createShapelessRecipe(ItemStack result, String extra) {
        return new ShapelessRecipe(
                MakeNamespacedKey(
                        MakeId(result, extra)
                ),
                result
        );
    }

    public ShapelessRecipe createShapelessRecipe(ItemStack result) {
        return createShapelessRecipe(result, "");
    }

    public ShapelessRecipe createShapelessRecipe(Material result, int amount, String extra) {
        return createShapelessRecipe(new ItemStack(result, amount), extra);
    }

    public ShapelessRecipe createShapelessRecipe(Material result, int amount) {
        return createShapelessRecipe(new ItemStack(result, amount), "");
    }

    public ShapelessRecipe createShapelessRecipe(Material result) {
        return createShapelessRecipe(new ItemStack(result), "");
    }

    public ShapelessRecipe createShapelessRecipe(Material result, String extra) {
        return createShapelessRecipe(new ItemStack(result), extra);
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, ItemStack result, Float exp, int time, String extra) {
        return new FurnaceRecipe(
                MakeNamespacedKey(
                        MakeId(result, extra)
                ),
                result,
                source,
                exp,
                time
        );
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, Material result, Float exp, int time, String extra) {
        return createFurnaceRecipe(source, new ItemStack(result), exp, time, extra);
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, ItemStack result, String extra) {
        return createFurnaceRecipe(source, new ItemStack(result), 1F, 100, extra);
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, Material result, Float exp, int time) {
        return createFurnaceRecipe(source, new ItemStack(result), exp, time, "");
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, ItemStack result) {
        return createFurnaceRecipe(source, result, 1F, 100, "");
    }

    public FurnaceRecipe createFurnaceRecipe(Material source, Material result) {
        return createFurnaceRecipe(source, new ItemStack(result), 1F, 100, "");
    }

    public BlastingRecipe createBlastingRecipe(Material source, ItemStack result, Float exp, int time, String extra) {
        return new BlastingRecipe(
                MakeNamespacedKey(
                        MakeId(result, extra)
                ),
                result,
                source,
                exp,
                time
        );
    }

    public BlastingRecipe createBlastingRecipe(Material source, Material result, Float exp, int time, String extra) {
        return createBlastingRecipe(source, new ItemStack(result), exp, time, extra);
    }

    public BlastingRecipe createBlastingRecipe(Material source, ItemStack result, String extra) {
        return createBlastingRecipe(source, new ItemStack(result), 1F, 100, extra);
    }

    public BlastingRecipe createBlastingRecipe(Material source, Material result, Float exp, int time) {
        return createBlastingRecipe(source, new ItemStack(result), exp, time, "");
    }

    public BlastingRecipe createBlastingRecipe(Material source, ItemStack result) {
        return createBlastingRecipe(source, result, 1F, 100, "");
    }

    public BlastingRecipe createBlastingRecipe(Material source, Material result) {
        return createBlastingRecipe(source, new ItemStack(result), 1F, 100, "");
    }

    public SmithingTransformRecipe createSmithingTransformRecipe(Material source, ItemStack result, RecipeChoice template, RecipeChoice base, RecipeChoice addition, String extra) {
        return new SmithingTransformRecipe(
                MakeNamespacedKey(
                    MakeId(result, extra)
                ),
                result,
                template,
                base,
                addition
        );
    }

    public SmithingTransformRecipe createSmithingTransformRecipe(Material source, ItemStack result, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        return createSmithingTransformRecipe(source, result, template, base, addition, "");
    }

    public String MakeId(ItemStack item, String extra) {
        return "recipe-"+item.getType().toString().toLowerCase().replace("_", "")+extra+idTag;
    }

    public NamespacedKey MakeNamespacedKey(String id) {
        NamespacedKey key = new NamespacedKey(plugin, id);
        namespacedKeysToDiscover.add(key);
        return key;
    }

    public void RegisterRecipe(Recipe recipe) {
        recipesToAdd.add(recipe);
    }

    public void RegisterRecipe(ShapedRecipe recipe) {
        RegisterRecipe((Recipe) recipe);
    }

    public void RegisterRecipe(ShapelessRecipe recipe) {
        RegisterRecipe((Recipe) recipe);
    }

    public void RegisterRecipe(FurnaceRecipe recipe) {
        RegisterRecipe((Recipe) recipe);
    }

    public void RegisterRecipe(SmithingTransformRecipe recipe) {
        RegisterRecipe((Recipe) recipe);
    }

    public void RegisterRecipe(BlastingRecipe recipe) {
        RegisterRecipe((Recipe) recipe);
    }
}
