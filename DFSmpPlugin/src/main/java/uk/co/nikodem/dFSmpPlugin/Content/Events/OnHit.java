package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryData;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.CustomItems;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.FullArmourSet;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AccessoryManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AntiSpamManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.BasicModeManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

import java.awt.image.VolatileImage;
import java.util.concurrent.TimeUnit;

public class OnHit implements Listener {
    FileConfiguration config;
    public OnHit(DFSmpPlugin plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void OnPlayerHit(EntityDamageByEntityEvent e) {
        if (BasicModeManager.isBasicMode()) return;
        if (e.isCancelled()) return;
        if (e.getDamager() instanceof Player attacker) {
            ItemStack i = attacker.getInventory().getItemInMainHand();
            if (CustomItemManager.IsItem(i, CustomItems.createWildBow())) {
                CustomItems.convertToWildBowSword(i);
            }
            if (FullArmourSet.Copper.playerHasEquipped(attacker)) {
                if (e.getEntity().getWorld().hasStorm()) {
                    int random = CustomItems.isCopperTool(i) ? (int) (Math.random() * 30 + 1) : (int) (Math.random() * 50 + 1) ;
                    // 1 in 30 chance with copper tool
                    // 1 in 50 chance without copper tool
                    if (random == 10) {
                        // spawns lightning and gives a 3x multiplier on the damage
                        // might be overpowered lol
                        // but it doesn't always rain
                        e.getEntity().getWorld().strikeLightning(e.getEntity().getLocation());
                        e.setDamage(e.getDamage() * 3);
                    }
                }

            }
        }
        if (e.isCancelled()) return;
        if (e.getEntity() instanceof Player victim) {
            if (FullArmourSet.Firidium.playerHasEquipped(victim)) {
                // putting it here so entities get damaged too
                e.getDamager().setFireTicks(150);
            }
            if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.cobaltshield, victim)) {
                if (e.getDamage() > 0) {
                    victim.setVelocity(e.getEntity().getLocation().getDirection().setY(0).normalize().multiply(0.5));
                }
            }
            if (e.getDamager() instanceof Player attacker) {
                ItemStack weapon = attacker.getInventory().getItemInMainHand();
                if (AccessoryManager.playerHasAccessoryEquipped(AccessoryData.htbook, attacker)) {
                    e.setDamage(e.getDamage() * 0.75); // reduce damage by 25%
                }

                if (CustomItemManager.IsItem(weapon, CustomItems.createBluebellsarStick())) {
                    e.setCancelled(true);
                    return;
                } else if (CustomItemManager.IsItem(weapon, CustomItems.createKnockbackStick())) {
                    if (attacker.hasCooldown(CustomItems.createKnockbackStick())) {
                        e.setCancelled(true);
                    } else {
                        e.setDamage(0);
                        attacker.setCooldown(CustomItems.createKnockbackStick(), 40);
                    }
                }

                if (!CombatLoggingManager.playerInCombat(victim)) {
                    if (FullArmourSet.Sculk.playerHasEquipped(victim)) {
                        attacker.getWorld().playSound(victim.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1F, 1F);
                        attacker.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20*10, 2));
                        attacker.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*3, 0));
                        attacker.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20*3, 0));
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 0));
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20*5, 0));
                    }
                    victim.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are now in combat for "+CombatLoggingManager.getLogTime()+" seconds! Logging off will result in death."));
                }
                if (!CombatLoggingManager.playerInCombat(attacker)) {
                    attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are now in combat for "+CombatLoggingManager.getLogTime()+" seconds! Logging off will result in death."));
                }

                CombatLoggingManager.playerUpdateCombatLog(victim);
                CombatLoggingManager.playerUpdateCombatLog(attacker);
                CombatLoggingManager.playerSetLastTag(victim, attacker);
            } else if (e.getDamager() instanceof EnderDragon) {
                e.setDamage(e.getDamage() * 3);
            }
        } else if (e.getEntity() instanceof EnderDragon) {
            e.setDamage(e.getDamage() / 3);
        }
    }
}
