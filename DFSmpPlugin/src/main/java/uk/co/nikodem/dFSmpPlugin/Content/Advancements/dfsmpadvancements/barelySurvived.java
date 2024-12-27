package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;

public class barelySurvived extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "barely_survived");


  public barelySurvived(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SHIELD, "Not even close, baby!", AdvancementFrameType.TASK, true, true, x, y , "Get out of combat on a heart or less."), parent, 1);
  }
}