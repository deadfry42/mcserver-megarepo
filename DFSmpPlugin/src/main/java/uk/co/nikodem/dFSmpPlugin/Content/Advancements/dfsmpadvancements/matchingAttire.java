package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;

public class matchingAttire extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "matching_attire");


  public matchingAttire(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(Material.LEATHER_BOOTS, "Matching Attire", AdvancementFrameType.TASK, true, true, x, y , "Wear a full set of armour that gives you a set bonus."), parent, 1);
  }
}