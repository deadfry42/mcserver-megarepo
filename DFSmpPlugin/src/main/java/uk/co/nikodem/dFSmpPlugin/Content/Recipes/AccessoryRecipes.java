package uk.co.nikodem.dFSmpPlugin.Content.Recipes;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryItem;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class AccessoryRecipes extends RecipeCreator{
    public AccessoryRecipes(DFSmpPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void createRecipes() {
        createHermes();
        createFlower();
        createEssences();
        createCobaltShield();
        createPhantomRepellant();
        createHitmanBook();
        createHorseshoe();

        // cloud in a bottle is too buggy
        // for survival, as it sometimes negates
        // fall damage from high distances,
        // and can be considered unfair for others
        //
        // createCloud();
    }

    private void createHorseshoe() {
        RegisterRecipe(
                createShapedRecipe(AccessoryData.luckyHorseshoe.getAccessoryItem(), "LuckyHorseshoe")
                        .shape("FGN", "GIG", "NGF")
                        .setIngredient('G', Material.GOLD_INGOT)
                        .setIngredient('N', Material.GOLD_NUGGET)
                        .setIngredient('I', Material.BREEZE_ROD)
                        .setIngredient('F', Material.FEATHER)
        );
    }

    private void createEssences() {
        RegisterRecipe(
                createShapedRecipe(AccessoryData.vmessence.getAccessoryItem(), "VeinMinersEssence")
                        .shape("AAA", "XAP", "AAA")
                        .setIngredient('A', Material.AMETHYST_SHARD)
                        .setIngredient('P', new RecipeChoice.ExactChoice(CustomItems.createVeinPickaxe()))
                        .setIngredient('X', new RecipeChoice.ExactChoice(CustomItems.createVeinAxe()))
        );

        RegisterRecipe(
                createShapedRecipe(AccessoryData.asessence.getAccessoryItem(), "AutosmeltEssence")
                        .shape("NAN", "NNN", "PNS")
                        .setIngredient('N', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltNugget()))
                        .setIngredient('P', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltPickaxe()))
                        .setIngredient('A', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltAxe()))
                        .setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.createAutosmeltShovel()))
        );
    }

    private void createCobaltShield() {
        RegisterRecipe(
                createShapedRecipe(AccessoryData.cobaltshield.getAccessoryItem(), "CobaltShield")
                        .shape("NLN", "LGL", " N ")
                        .setIngredient('L', Material.LAPIS_LAZULI)
                        .setIngredient('G', Material.GOLD_INGOT)
                        .setIngredient('N', new RecipeChoice.ExactChoice(new ItemStack(Material.IRON_NUGGET)))
        );
    }

//    private void createCloud() {
//        RegisterRecipe(
//                createShapedRecipe(AccessoryData.cloudInABottle.getAccessoryItem(), "CloudInABottle")
//                        .shape(" C ", "CBC", " C ")
//                        .setIngredient('B', Material.GLASS_BOTTLE)
//                        .setIngredient('C', Material.WIND_CHARGE)
//        );
//    }

    private void createPacifistAccessory() {
        RegisterRecipe(
                createShapedRecipe(AccessoryData.pacifistAccessory.getAccessoryItem(), "PacifistAccessory")
                        .shape("PMP", " C ")
                        .setIngredient('M', Material.PHANTOM_MEMBRANE)
                        .setIngredient('P', Material.POISONOUS_POTATO)
                        .setIngredient('C', Material.FIRE_CHARGE)
        );
    }

    private void createPhantomRepellant() {
        RegisterRecipe(
                createShapedRecipe(AccessoryData.phantomRepellant.getAccessoryItem(), "ContaminatedMembrane")
                        .shape("PMP", " C ")
                        .setIngredient('M', Material.PHANTOM_MEMBRANE)
                        .setIngredient('P', Material.POISONOUS_POTATO)
                        .setIngredient('C', Material.FIRE_CHARGE)
        );
    }

    private void createHitmanBook() {
        RegisterRecipe(
                createShapelessRecipe(AccessoryData.htbook.getAccessoryItem(), "HitmanTechniqueBook")
                        .addIngredient(Material.BOOK)
                        .addIngredient(Material.TOTEM_OF_UNDYING)
                        .addIngredient(Material.TNT)
                        .addIngredient(Material.SHIELD)
                        .addIngredient(Material.SPECTRAL_ARROW)
        );
    }

    private void createHermes() {
        RegisterRecipe(
                createShapelessRecipe(AccessoryData.hermes.getAccessoryItem(), "HermesBoots")
                        .addIngredient(Material.LEATHER_BOOTS)
                        .addIngredient(Material.FEATHER)
                        .addIngredient(Material.CACTUS)
                        .addIngredient(Material.STRING)
        );
    }

    private void createFlower() {
        RegisterRecipe(
                createShapelessRecipe(AccessoryData.flowerBoots.getAccessoryItem(), "FlowerBoots")
                        .addIngredient(Material.LEATHER_BOOTS)
                        .addIngredient(Material.DANDELION)
                        .addIngredient(Material.POPPY)
                        .addIngredient(Material.CORNFLOWER)
        );
    }
}
