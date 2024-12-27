package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;

import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.getCustomID;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.setCustomId;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems.createVampireSword;

public class VampireSwordStage6 extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "vampire-sword-stage6");

  private static ItemStack vamp = setCustomId(createVampireSword(), getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.CHESTPLATE));

  public VampireSwordStage6(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(vamp, "Stale Blood", AdvancementFrameType.TASK, true, true, x, y , "Get your 6th kill with a vampire sword."), parent, 1);
  }
}