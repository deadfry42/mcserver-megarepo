package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import com.fren_gor.ultimateAdvancementAPI.visibilities.HiddenVisibility;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;

import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.getCustomID;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.setCustomId;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems.createVampireSword;

public class VampireSwordStage10 extends BaseAdvancement implements HiddenVisibility {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "vampire-sword-stage10");

  private static ItemStack vamp = setCustomId(createVampireSword(), getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.MAGICMIRROR));

  public VampireSwordStage10(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(vamp, "Thirsty for more", AdvancementFrameType.TASK, true, true, x, y , "Get a kill with the fully upgraded Vampire Sword."), parent, 1);
  }
}