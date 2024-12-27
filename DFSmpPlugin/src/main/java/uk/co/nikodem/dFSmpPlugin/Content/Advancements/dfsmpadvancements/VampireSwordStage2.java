package uk.co.nikodem.dFSmpPlugin.Content.Advancements.dfsmpadvancements;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import org.bukkit.inventory.ItemStack;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems.*;
import static uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager.*;

public class VampireSwordStage2 extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.dfsmpadvancements_NAMESPACE, "vampire-sword-stage2");

  private static ItemStack vamp = setCustomId(createVampireSword(), getCustomID(IdItemType.PROGRESS_SWORD, IdItemClass.PICKAXE));

  public VampireSwordStage2(Advancement parent, float x, float y) {
    super(KEY.getKey(), new AdvancementDisplay(vamp, "Fresh Blood", AdvancementFrameType.TASK, true, true, x, y , "Get your second kill with a vampire sword."), parent, 1);
  }
}