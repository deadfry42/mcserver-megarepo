package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.visibilities.HiddenVisibility;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class feelingWatched extends BaseAdvancement implements HiddenVisibility {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "feeling_watched");

  public feelingWatched(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(CustomItems.createBloodyTear(), "Feeling Watched", AdvancementFrameType.TASK, true, true, x, y, "Man spawning first time"), parent, 1);
  }
}