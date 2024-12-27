package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.SetBonuses;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.*;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OnDeath implements Listener {
    public final DFSmpPlugin plugin;

    public OnDeath(DFSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent e) {
        Entity source = e.getDamageSource().getCausingEntity();
        Player plr = e.getEntity();

        if (plr.hasMetadata("feelingWatchedDeathMessage")) {
            plr.removeMetadata("feelingWatchedDeathMessage", plugin);
            e.setDeathMessage(plr.getDisplayName()+" was slain by Man From The Fog");
        }

        for (ItemStack i : plr.getInventory().getContents()) {
            SetBonuses.RemoveSetBonusText(i);
        }

        boolean diedInVoid = false;

        if (e.getDamageSource().getDamageType() == DamageType.OUT_OF_WORLD) {
            diedInVoid = true;
            if (plr.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING
                    || plr.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                if (!plugin.ca.VoidDeathTotem.isGranted(plr)) plugin.ca.VoidDeathTotem.grant(plr);
            }
            if (CombatLoggingManager.playerInCombat(plr)) {
                Player attacker = CombatLoggingManager.getPlayerLastTag(plr);
                if (attacker != null) {
                    if (!e.getDeathMessage().contains(attacker.getDisplayName())) e.setDeathMessage(e.getDeathMessage()+" whilst fighting "+attacker.getDisplayName());
                    for (ItemStack item : plr.getInventory().getContents()) {
                        if (item != null) attacker.getWorld().dropItem(attacker.getLocation(), item);
                    }
                    for (ItemStack item : AccessoryManager.removeAllAccessories(plr)) {
                        if (item != null) attacker.getWorld().dropItem(attacker.getLocation(), item);
                    }
                } else {
                    e.setKeepInventory(true);
                }
            } else {
                e.setKeepInventory(true);
            }
        } else {
            AccessoryManager.dropAccessories(plr);
            LastDeathManager.playerSetLastDeath(e);
        }

        if (source instanceof Player attacker) {
            ItemStack i = attacker.getInventory().getItemInMainHand();
            if (CustomItems.isVampireSword(i)) {
                String uuid = CustomItemManager.getItemUUID(i);

                if (uuid != null) {

                    boolean killedAlready = false;
                    Date date = new Date();

                    String key = plr.getUniqueId().toString();
                    long lastKill = ConfigManager.trackingData.getLong("vampsword."+uuid+".killed."+key);
                    if (lastKill > date.getTime()-(TimeUnit.DAYS.toMillis(1))) {
                        killedAlready = true;
                    }

                    if (!killedAlready) {
                        ConfigManager.trackingData.set("vampsword."+uuid+".killed."+key, date.getTime());
                        ConfigManager.saveData(ConfigManager.DataFiles.TRACKING);

                        CustomItems.upgradeVampireSword(i);

                        ItemMeta m = i.getItemMeta();
                        if (m != null) {
                            if (m.getCustomModelData() == CustomItemManager.getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.AXE)) {
                                if (!plugin.ca.Stage1Vampire.isGranted(attacker)) plugin.ca.Stage1Vampire.grant(attacker);
                            } else if (m.getCustomModelData() == CustomItemManager.getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.PICKAXE)) {
                                if (!plugin.ca.Stage2Vampire.isGranted(attacker)) plugin.ca.Stage2Vampire.grant(attacker);
                            } else if (m.getCustomModelData() == CustomItemManager.getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.CHESTPLATE)) {
                                if (!plugin.ca.Stage6Vampire.isGranted(attacker)) plugin.ca.Stage6Vampire.grant(attacker);
                            } else if (m.getCustomModelData() == CustomItemManager.getCustomID(CustomItemManager.IdItemType.PROGRESS_SWORD, CustomItemManager.IdItemClass.MAGICMIRROR)) {
                                if (plugin.ca.Stage9Vampire.isGranted(attacker)) {
                                    if (plugin.ca.Stage10Vampire.isGranted(attacker)) {
                                        plugin.ca.Stage10Vampire.grant(attacker);
                                    }
                                } else {
                                    plugin.ca.Stage9Vampire.grant(attacker);
                                }
                            }
                        }
                    }
                }
            }

            if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.htbook, attacker)) {
                String msg = e.getDeathMessage();
                e.setDeathMessage(null);
                attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&o&8["+msg+"&o&8]"));
                plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&o&8["+msg+"&o&8]"));
                plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You have been silenced for 3 minutes!"));
                AntiSpamManager.playerUpdateCooldownLog(plr, "silence");
            }
        } else {
            if (!CombatLoggingManager.playerInCombat(plr)
            && !diedInVoid) {
                plr.sendMessage("You can do /back to teleport back to your last death location!");
            }
        }
        if (BasicModeManager.isBasicMode()) return;
        if (CombatLoggingManager.playerInCombat(plr)) {
            CombatLoggingManager.playerRemoveCombatLog(plr);
            plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are no longer in combat!"));
        }
    }

    @EventHandler
    public void OnEntityDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() == EntityType.WARDEN) {
            ItemStack drop = CustomItems.createSculkPiece();
            drop.setAmount((int) (Math.random() * 5 + 1));
            entity.getWorld().dropItemNaturally(entity.getLocation(), drop);

            ItemStack drop2 = new ItemStack(Material.ECHO_SHARD);
            drop2.setAmount((int) (Math.random() * 3 + 1));
            entity.getWorld().dropItemNaturally(entity.getLocation(), drop2);
        }
    }
}
