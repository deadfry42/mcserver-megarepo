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

public class VampireSwordStage9 extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "vampire-sword-stage9");

  private static ItemStack vamp = setCustomId(createVampireSword(), getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.MAGICMIRROR));

  public VampireSwordStage9(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(vamp, "True Vampire", AdvancementFrameType.CHALLENGE, true, true, x, y , "Fully upgrade a vampire sword."), parent, 1);
  }
}