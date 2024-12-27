package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;

public class obtainGun extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "obtain_gun");


  public obtainGun(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BOW, "Heavy metal", AdvancementFrameType.TASK, true, true, x, y , "Craft a gun."), parent, 1);
  }
}