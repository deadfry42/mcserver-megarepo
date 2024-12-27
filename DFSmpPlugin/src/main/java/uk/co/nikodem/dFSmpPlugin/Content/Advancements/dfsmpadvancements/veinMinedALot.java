package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class veinMinedALot extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "veinmined_a_lot");


  public veinMinedALot(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(CustomItems.createVeinPickaxe(), "Vein Maniac", AdvancementFrameType.TASK, true, true, x, y , "Vein Mine 50 times with a Vein Miner's tool."), parent, 50);
  }
}