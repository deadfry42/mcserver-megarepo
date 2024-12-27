package uk.co.nikodem.dFSmpPlugin.Content.Recipes;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class VanillaRecipes extends RecipeCreator {

    public VanillaRecipes(DFSmpPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void createRecipes() {
        blastFurnace();
        cobwebs();
        unobtainables();
        singleBlockConversions();
        chainmail();
        horseArmour();
        coral();
        slimeBlockChange();
        dispenserChange();
    }

    private void dispenserChange() {
        RemoveRecipesWithResult(RecipeType.ANYCRAFTING, Material.DISPENSER);
        RegisterRecipe(
                createShapedRecipe(Material.DISPENSER)
                        .shape("CCC", "CIC", "CSC")
                        .setIngredient('C', new RecipeChoice.MaterialChoice(Tag.ITEMS_STONE_TOOL_MATERIALS))
                        .setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_INGOT)))
                        .setIngredient('S', Material.REDSTONE)
        );
    }

    private void slimeBlockChange() {
        RemoveRecipesWithResult(RecipeType.ANYCRAFTING, Material.SLIME_BLOCK);
        RegisterRecipe(
                createShapedRecipe(Material.SLIME_BLOCK)
                        .shape("XX", "XX")
                        .setIngredient('X', Material.SLIME_BALL)
        );
    }

    private void chainmail() {
        RegisterRecipe(
                createShapedRecipe(Material.CHAINMAIL_HELMET)
                        .shape("CCC", "C C")
                        .setIngredient('C', Material.CHAIN)
        );

        RegisterRecipe(
                createShapedRecipe(Material.CHAINMAIL_CHESTPLATE)
                        .shape("C C", "CCC", "CCC")
                        .setIngredient('C', Material.CHAIN)
        );

        RegisterRecipe(
                createShapedRecipe(Material.CHAINMAIL_LEGGINGS)
                        .shape("CCC", "C C", "C C")
                        .setIngredient('C', Material.CHAIN)
        );

        RegisterRecipe(
                createShapedRecipe(Material.CHAINMAIL_BOOTS)
                        .shape("C C", "C C")
                        .setIngredient('C', Material.CHAIN)
        );
    }

    private void blastFurnace() {
        RegisterRecipe(
                createBlastingRecipe(Material.COBBLESTONE, Material.STONE)
        );
        RegisterRecipe(
                createBlastingRecipe(Material.STONE, Material.SMOOTH_STONE)
        );

        RegisterRecipe(
                createBlastingRecipe(Material.GLASS, Material.SAND)
        );
    }

    private void cobwebs() {
        RegisterRecipe(
                createShapelessRecipe(Material.COBWEB)
                        .addIngredient(2, Material.STRING)
        );
    }

    private void unobtainables() {
        RegisterRecipe(
                createShapedRecipe(Material.SADDLE)
                        .shape("III", "X X")
                        .setIngredient('X', Material.CHAIN)
                        .setIngredient('I', Material.LEATHER)
        );

        RegisterRecipe(
                createShapedRecipe(Material.NAME_TAG)
                        .shape(" SS", "PIS", "PPP")
                        .setIngredient('P', Material.PAPER)
                        .setIngredient('I', Material.INK_SAC)
                        .setIngredient('S', Material.STRING)
        );

        RegisterRecipe(
                createShapedRecipe(Material.TRIDENT)
                        .shape("DID", "DSD", " S ")
                        .setIngredient('D', Material.DIAMOND)
                        .setIngredient('S', Material.STICK)
                        .setIngredient('I', Material.IRON_NUGGET)
        );
    }

    private void singleBlockConversions() {
        RegisterRecipe(
                createShapelessRecipe(Material.NETHER_WART)
                        .addIngredient(Material.NETHER_WART_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.AMETHYST_SHARD)
                        .addIngredient(Material.AMETHYST_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.FLINT)
                        .addIngredient(Material.GRAVEL)
        );
    }

    private void horseArmour() {
        RegisterRecipe(
                createShapedRecipe(Material.LEATHER_HORSE_ARMOR)
                        .shape("  L", "LWL", "LLL")
                        .setIngredient('L', Material.LEATHER)
                        .setIngredient('W', Material.SADDLE)
        );

        RegisterRecipe(
                createShapedRecipe(Material.IRON_HORSE_ARMOR)
                        .shape("  L", "LWL", "LLL")
                        .setIngredient('L', Material.IRON_INGOT)
                        .setIngredient('W', Material.SADDLE)
        );

        RegisterRecipe(
                createShapedRecipe(Material.GOLDEN_HORSE_ARMOR)
                        .shape("  L", "LWL", "LLL")
                        .setIngredient('L', Material.GOLD_INGOT)
                        .setIngredient('W', Material.SADDLE)
        );

        RegisterRecipe(
                createShapedRecipe(Material.DIAMOND_HORSE_ARMOR)
                        .shape("  L", "LWL", "LLL")
                        .setIngredient('L', Material.DIAMOND)
                        .setIngredient('W', Material.SADDLE)
        );
    }

    private void coral() {

        // NORMAL CORAL
        // WATER BUCKET + DEAD CORAL = CORAL

        RegisterRecipe(
                createShapedRecipe(Material.BRAIN_CORAL, "Normal")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BRAIN_CORAL)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.BUBBLE_CORAL, "Normal")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BUBBLE_CORAL)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.FIRE_CORAL, "Normal")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_FIRE_CORAL)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.TUBE_CORAL, "Normal")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_TUBE_CORAL)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.HORN_CORAL, "Normal")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_HORN_CORAL)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        // CORAL FANS
        // WATER BUCKET + DEAD CORAL FAN = CORAL FAN

        RegisterRecipe(
                createShapedRecipe(Material.BRAIN_CORAL_FAN, "Fans")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BRAIN_CORAL_FAN)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.BUBBLE_CORAL_FAN, "Fans")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BUBBLE_CORAL_FAN)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.FIRE_CORAL_FAN, "Fans")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_FIRE_CORAL_FAN)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.TUBE_CORAL_FAN, "Fans")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_TUBE_CORAL_FAN)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.HORN_CORAL_FAN, "Fans")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_HORN_CORAL_FAN)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        // CORAL BLOCKS
        // WATER BUCKET + DEAD CORAL BLOCK = CORAL BLOCK

        RegisterRecipe(
                createShapedRecipe(Material.BRAIN_CORAL_BLOCK, "Blocks")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BRAIN_CORAL_BLOCK)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.BUBBLE_CORAL_BLOCK, "Blocks")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_BUBBLE_CORAL_BLOCK)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.FIRE_CORAL_BLOCK, "Blocks")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_FIRE_CORAL_BLOCK)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.TUBE_CORAL_BLOCK, "Blocks")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_TUBE_CORAL_BLOCK)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        RegisterRecipe(
                createShapedRecipe(Material.HORN_CORAL_BLOCK, "Blocks")
                        .shape("W", "C")
                        .setIngredient('C', Material.DEAD_HORN_CORAL_BLOCK)
                        .setIngredient('W', Material.WATER_BUCKET)
        );

        // CORAL -> CORAL FANS
        // CORAL = CORAL FANS

        RegisterRecipe(
                createShapelessRecipe(Material.BRAIN_CORAL_FAN, "NormalToFans")
                        .addIngredient(Material.BRAIN_CORAL)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.BUBBLE_CORAL_FAN, "NormalToFans")
                        .addIngredient(Material.BUBBLE_CORAL)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.FIRE_CORAL_FAN, "NormalToFans")
                        .addIngredient(Material.FIRE_CORAL)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.TUBE_CORAL_FAN, "NormalToFans")
                        .addIngredient(Material.TUBE_CORAL)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.HORN_CORAL_FAN, "NormalToFans")
                        .addIngredient(Material.HORN_CORAL)
        );

        // CORAL FANS -> CORAL
        // CORAL FANS = CORAL

        RegisterRecipe(
                createShapelessRecipe(Material.BRAIN_CORAL, "FansToNormal")
                        .addIngredient(Material.BRAIN_CORAL_FAN)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.BUBBLE_CORAL, "FansToNormal")
                        .addIngredient(Material.BUBBLE_CORAL_FAN)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.FIRE_CORAL, "FansToNormal")
                        .addIngredient(Material.FIRE_CORAL_FAN)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.TUBE_CORAL, "FansToNormal")
                        .addIngredient(Material.TUBE_CORAL_FAN)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.HORN_CORAL, "FansToNormal")
                        .addIngredient(Material.HORN_CORAL_FAN)
        );

        // CORAL BLOCKS -> CORAL
        // CORAL BLOCKS = CORAL

        RegisterRecipe(
                createShapelessRecipe(Material.BRAIN_CORAL, 4, "BlocksToNormal")
                        .addIngredient(Material.BRAIN_CORAL_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.BUBBLE_CORAL, 4, "BlocksToNormal")
                        .addIngredient(Material.BUBBLE_CORAL_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.FIRE_CORAL, 4, "BlocksToNormal")
                        .addIngredient(Material.FIRE_CORAL_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.TUBE_CORAL, 4, "BlocksToNormal")
                        .addIngredient(Material.TUBE_CORAL_BLOCK)
        );

        RegisterRecipe(
                createShapelessRecipe(Material.HORN_CORAL, 4, "BlocksToNormal")
                        .addIngredient(Material.HORN_CORAL_BLOCK)
        );
    }
}