package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class firstVeinTool extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "first_vein_tool");


  public firstVeinTool(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(Material.AMETHYST_SHARD, "Hairline Fracture", AdvancementFrameType.TASK, true, true, x, y , "Craft any Vein Miner's Tool"), parent, 1);
  }
}