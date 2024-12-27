package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.visibilities.HiddenVisibility;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class trueBluebellsar extends BaseAdvancement implements HiddenVisibility {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "bluebellsar");


  public trueBluebellsar(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(CustomItems.createBluebellsarStick(), "In memory of Bluebellsar", AdvancementFrameType.TASK, true, true, x, y , "Obtain the Bluebellsar Stick."), parent, 69);
  }
}