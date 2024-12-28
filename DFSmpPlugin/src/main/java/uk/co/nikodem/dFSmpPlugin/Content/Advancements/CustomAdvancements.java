package uk.co.nikodem.dFSmpPlugin.Content.Advancements;

import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import com.fren_gor.ultimateAdvancementAPI.advancement.RootAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.util.CoordAdapter;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements.*;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class CustomAdvancements {

    public final DFSmpPlugin plugin;

    public static UltimateAdvancementAPI api;
    public AdvancementTab dfsmpadvancements;

    public final firstVeinTool FirstVeinTool;
    public final veinMinedALot VeinMinedALot;

    public final VampireSwordStage1 Stage1Vampire;
    public final VampireSwordStage2 Stage2Vampire;
    public final VampireSwordStage6 Stage6Vampire;
    public final VampireSwordStage9 Stage9Vampire;
    public final VampireSwordStage10 Stage10Vampire;

    public final firstAutosmeltTool FirstAutosmeltTool;
    public final autoSmeltedALot AutoSmeltedALot;

    public final barelySurvived BarelySurvived;
    public final voidDeathTotem VoidDeathTotem;

    public final feelingWatched FeelingWatched;
    public final trueBluebellsar TrueBluebellsar;

    public final matchingAttire MatchingAttire;
    public final indecisiveWardrobe IndecisiveWardrobe;

    public final equipAccessory EquipAccessory;

//    public final obtainGun ObtainGun;

    public CustomAdvancements(DFSmpPlugin plugin) {
        this.plugin = plugin;
        api = UltimateAdvancementAPI.getInstance(plugin);
        dfsmpadvancements = api.createAdvancementTab(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE);
        AdvancementKey rootKey = new AdvancementKey(dfsmpadvancements.getNamespace(), "root");
        CoordAdapter adapter = CoordAdapter.builder().add(rootKey, 0f, 0f)
                .add(feelingWatched.KEY, -1f, 0f)
                .add(VampireSwordStage1.KEY, 1f, 0f)
                .add(VampireSwordStage2.KEY, 2f, 0f)
                .add(VampireSwordStage6.KEY, 3f, 0f)
                .add(VampireSwordStage9.KEY, 4f, 0f)
                .add(VampireSwordStage10.KEY, 5f, 0f)
                .add(firstVeinTool.KEY, 1f, 1f)
                .add(veinMinedALot.KEY, 2f, 1f)
                .add(firstAutosmeltTool.KEY, 1f, -1f)
                .add(autoSmeltedALot.KEY, 2f, -1f)
                .add(voidDeathTotem.KEY, 1f, -2f)
                .add(barelySurvived.KEY, 1f, 2f)
                .add(matchingAttire.KEY, 1f, 3f)
                .add(indecisiveWardrobe.KEY, 2f, 3f)
//                .add(obtainGun.KEY, 1f, -3f)
                .add(trueBluebellsar.KEY, -2f, 0f)
                .add(equipAccessory.KEY, 1f, 4f)
                .build();
        RootAdvancement root = new RootAdvancement(dfsmpadvancements, rootKey.getKey(), new AdvancementDisplay(Material.OAK_SAPLING, "SMP", AdvancementFrameType.TASK, false, false, adapter.getX(rootKey), adapter.getY(rootKey), "Thanks for playing!"), "textures/block/crimson_planks.png", 1);

        FirstVeinTool = new firstVeinTool(root, adapter.getX(firstVeinTool.KEY), adapter.getY(firstVeinTool.KEY));
        VeinMinedALot = new veinMinedALot(FirstVeinTool, adapter.getX(veinMinedALot.KEY), adapter.getY(veinMinedALot.KEY));

        FirstAutosmeltTool = new firstAutosmeltTool(root, adapter.getX(firstAutosmeltTool.KEY), adapter.getY(firstAutosmeltTool.KEY));
        AutoSmeltedALot = new autoSmeltedALot(FirstAutosmeltTool, adapter.getX(autoSmeltedALot.KEY), adapter.getY(autoSmeltedALot.KEY));

        Stage1Vampire = new VampireSwordStage1(root, adapter.getX(VampireSwordStage1.KEY), adapter.getY(VampireSwordStage1.KEY));
        Stage2Vampire = new VampireSwordStage2(Stage1Vampire, adapter.getX(VampireSwordStage2.KEY), adapter.getY(VampireSwordStage2.KEY));
        Stage6Vampire = new VampireSwordStage6(Stage2Vampire, adapter.getX(VampireSwordStage6.KEY), adapter.getY(VampireSwordStage6.KEY));
        Stage9Vampire = new VampireSwordStage9(Stage6Vampire, adapter.getX(VampireSwordStage9.KEY), adapter.getY(VampireSwordStage9.KEY));
        Stage10Vampire = new VampireSwordStage10(Stage9Vampire, adapter.getX(VampireSwordStage10.KEY), adapter.getY(VampireSwordStage10.KEY));

        BarelySurvived = new barelySurvived(root, adapter.getX(barelySurvived.KEY), adapter.getY(barelySurvived.KEY));
        VoidDeathTotem = new voidDeathTotem(root, adapter.getX(voidDeathTotem.KEY), adapter.getY(voidDeathTotem.KEY));

        FeelingWatched = new feelingWatched(root, adapter.getX(feelingWatched.KEY), adapter.getY(feelingWatched.KEY));
        TrueBluebellsar = new trueBluebellsar(root, adapter.getX(trueBluebellsar.KEY), adapter.getY(trueBluebellsar.KEY));

        MatchingAttire = new matchingAttire(root, adapter.getX(matchingAttire.KEY), adapter.getY(matchingAttire.KEY));
        IndecisiveWardrobe = new indecisiveWardrobe(MatchingAttire, adapter.getX(indecisiveWardrobe.KEY), adapter.getY(indecisiveWardrobe.KEY));

//        ObtainGun = new obtainGun(root, adapter.getX(obtainGun.KEY), adapter.getY(obtainGun.KEY));

        EquipAccessory = new equipAccessory(root, adapter.getX(equipAccessory.KEY), adapter.getY(equipAccessory.KEY));

        dfsmpadvancements.registerAdvancements(
                root,

                FeelingWatched,
                TrueBluebellsar,

                FirstVeinTool,
                VeinMinedALot,

                BarelySurvived,
                VoidDeathTotem,

                Stage1Vampire,
                Stage2Vampire,
                Stage6Vampire,
                Stage9Vampire,
                Stage10Vampire,

                FirstAutosmeltTool,
                AutoSmeltedALot,

                MatchingAttire,
                IndecisiveWardrobe,

//                ObtainGun,

                EquipAccessory
        );
    }
}
