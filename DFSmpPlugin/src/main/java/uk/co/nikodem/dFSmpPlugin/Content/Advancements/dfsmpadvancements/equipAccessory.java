package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;

public class equipAccessory extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "equip_accessory");


  public equipAccessory(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(AccessoryData.hermes.getIcon(), "Accessorised", AdvancementFrameType.TASK, true, true, x, y , "Equip any accessory for the first time."), parent, 1);
  }
}