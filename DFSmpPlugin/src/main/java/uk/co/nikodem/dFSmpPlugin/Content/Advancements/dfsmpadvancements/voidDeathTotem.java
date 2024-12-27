package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.Material;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class voidDeathTotem extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "void_death_totem");


  public voidDeathTotem(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(Material.TOTEM_OF_UNDYING, "Doubling down", AdvancementFrameType.TASK, true, true, x, y , "Fall into the void while holding a Totem of Undying"), parent, 1);
  }
}