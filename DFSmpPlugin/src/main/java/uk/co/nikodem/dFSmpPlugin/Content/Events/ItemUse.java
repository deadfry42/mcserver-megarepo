package uk.co.nikodem.dFSmpPlugin.Content.Events;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CustomItemManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.AntiSpamManager;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.CombatLoggingManager;

import java.util.Objects;

import static uk.co.nikodem.dFSmpPlugin.Content.Utils.SoundManager.PlayFailedSound;
import static uk.co.nikodem.dFSmpPlugin.Content.Utils.SoundManager.PlaySucceedSound;
import static uk.co.nikodem.dFSmpPlugin.Content.Utils.VeinMinableBlocks.*;

public class ItemUse implements Listener {
    @EventHandler
    public void OnRightClick(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_AIR) && !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        Player plr = e.getPlayer();

        if (!e.hasItem()) return;
        if (e.getItem() == null) return;
        if (CustomItemManager.IsItem(e.getItem(), CustomItemManager.createMagicMirror())) {
            // if magic mirror is used
            e.setCancelled(true);
            if (AntiSpamManager.playerInCooldown(plr, "MagicMirror", 1)) return;
            Location bed = plr.getBedSpawnLocation();
            if (CombatLoggingManager.playerInCombat(plr)) {
                PlayFailedSound(plr);
                plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You are currently in combat!"));
                return;
            }
            if (bed != null) {
                PlaySucceedSound(plr);
                plr.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, plr.getLocation(), 15);
                int random = (int )(Math.random() * 4096 + 1);
                if (random == 69) {
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5You wake up in your bed in a cold sweat.."));
                } else {
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5Teleported to your bed!"));
                }
                plr.teleport(bed);
                plr.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, plr.getLocation(), 15);
                PlaySucceedSound(plr);
                AntiSpamManager.playerUpdateCooldownLog(plr, "MagicMirror");
            } else {
                PlayFailedSound(plr);
                plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You do not have a bed!"));
            }
        }
    }

    @EventHandler
    public void OnEntityBucketUse(PlayerInteractEntityEvent e) {
        Entity en = e.getRightClicked();
        ItemStack bucket = e.getPlayer().getInventory().getItemInMainHand();
        if (CustomItemManager.IsItem(bucket, CustomItemManager.createEntityBucket())) {
            e.setCancelled(true);
            Material setTo = null;
            switch (en.getType()) {
                case BAT -> setTo = Material.BAT_SPAWN_EGG;
                case BEE -> setTo = Material.BEE_SPAWN_EGG;
                case CAT -> setTo = Material.CAT_SPAWN_EGG;
                case COD -> setTo = Material.COD_SPAWN_EGG;
                case COW -> setTo = Material.COW_SPAWN_EGG;
                case FOX -> setTo = Material.FOX_SPAWN_EGG;
                case PIG -> setTo = Material.PIG_SPAWN_EGG;
                case VEX -> setTo = Material.VEX_SPAWN_EGG;
                case FROG -> setTo = Material.FROG_SPAWN_EGG;
                case GOAT -> setTo = Material.GOAT_SPAWN_EGG;
                case HUSK -> setTo = Material.HUSK_SPAWN_EGG;
                case MULE -> setTo = Material.MULE_SPAWN_EGG;
                case WOLF -> setTo = Material.WOLF_SPAWN_EGG;
                case ALLAY -> setTo = Material.ALLAY_SPAWN_EGG;
                case BLAZE -> setTo = Material.BLAZE_SPAWN_EGG;
                case CAMEL -> setTo = Material.CAMEL_SPAWN_EGG;
                case GHAST -> setTo = Material.GHAST_SPAWN_EGG;
                case HORSE -> setTo = Material.HORSE_SPAWN_EGG;
                case LLAMA -> setTo = Material.LLAMA_SPAWN_EGG;
                case PANDA -> setTo = Material.PANDA_SPAWN_EGG;
                case SHEEP -> setTo = Material.SHEEP_SPAWN_EGG;
                case SLIME -> setTo = Material.SLIME_SPAWN_EGG;
                case SQUID -> setTo = Material.SQUID_SPAWN_EGG;
                case STRAY -> setTo = Material.STRAY_SPAWN_EGG;
                case WITCH -> setTo = Material.WITCH_SPAWN_EGG;
                case EVOKER -> setTo = Material.EVOKER_SPAWN_EGG;
                case DONKEY -> setTo = Material.DONKEY_SPAWN_EGG;
                case HOGLIN -> setTo = Material.HOGLIN_SPAWN_EGG;
                case OCELOT -> setTo = Material.OCELOT_SPAWN_EGG;
                case PARROT -> setTo = Material.PARROT_SPAWN_EGG;
                case PIGLIN -> setTo = Material.PIGLIN_SPAWN_EGG;
                case RABBIT -> setTo = Material.RABBIT_SPAWN_EGG;
                case SALMON -> setTo = Material.SALMON_SPAWN_EGG;
                case SPIDER -> setTo = Material.SPIDER_SPAWN_EGG;
                case TURTLE -> setTo = Material.TURTLE_SPAWN_EGG;
                //case WARDEN -> setTo = Material.WARDEN_SPAWN_EGG;
                //case WITHER -> setTo = Material.WITHER_SPAWN_EGG;
                case ZOGLIN -> setTo = Material.ZOGLIN_SPAWN_EGG;
                case ZOMBIE -> setTo = Material.ZOMBIE_SPAWN_EGG;
                case AXOLOTL -> setTo = Material.AXOLOTL_SPAWN_EGG;
                case CHICKEN -> setTo = Material.CHICKEN_SPAWN_EGG;
                case CREEPER -> setTo = Material.CREEPER_SPAWN_EGG;
                case DOLPHIN -> setTo = Material.DOLPHIN_SPAWN_EGG;
                case DROWNED -> setTo = Material.DROWNED_SPAWN_EGG;
                case PHANTOM -> setTo = Material.PHANTOM_SPAWN_EGG;
                case RAVAGER -> setTo = Material.RAVAGER_SPAWN_EGG;
                case SHULKER -> setTo = Material.SHULKER_SPAWN_EGG;
                case SNIFFER -> setTo = Material.SNIFFER_SPAWN_EGG;
                case SNOWMAN -> setTo = Material.SNOW_GOLEM_SPAWN_EGG;
                case STRIDER -> setTo = Material.STRIDER_SPAWN_EGG;
                case TADPOLE -> setTo = Material.TADPOLE_SPAWN_EGG;
                case ENDERMAN -> setTo = Material.ENDERMAN_SPAWN_EGG;
                case GUARDIAN -> setTo = Material.GUARDIAN_SPAWN_EGG;
                case PILLAGER -> setTo = Material.PILLAGER_SPAWN_EGG;
                case SKELETON -> setTo = Material.SKELETON_SPAWN_EGG;
                case VILLAGER -> setTo = Material.VILLAGER_SPAWN_EGG;
                case ENDERMITE -> setTo = Material.ENDERMITE_SPAWN_EGG;
                case GLOW_SQUID -> setTo = Material.GLOW_SQUID_SPAWN_EGG;
                case IRON_GOLEM -> setTo = Material.IRON_GOLEM_SPAWN_EGG;
                case MAGMA_CUBE -> setTo = Material.MAGMA_CUBE_SPAWN_EGG;
                case POLAR_BEAR -> setTo = Material.POLAR_BEAR_SPAWN_EGG;
                case PUFFERFISH -> setTo = Material.PUFFERFISH_SPAWN_EGG;
                case SILVERFISH -> setTo = Material.SILVERFISH_SPAWN_EGG;
                case VINDICATOR -> setTo = Material.VINDICATOR_SPAWN_EGG;
                case CAVE_SPIDER -> setTo = Material.CAVE_SPIDER_SPAWN_EGG;
                case MUSHROOM_COW -> setTo = Material.MOOSHROOM_SPAWN_EGG;
                case PIGLIN_BRUTE -> setTo = Material.PIGLIN_BRUTE_SPAWN_EGG;
                case ZOMBIE_HORSE -> setTo = Material.ZOMBIE_HORSE_SPAWN_EGG;
                case TROPICAL_FISH -> setTo = Material.TROPICAL_FISH_SPAWN_EGG;
                //case ELDER_GUARDIAN -> setTo = Material.ELDER_GUARDIAN_SPAWN_EGG;
                case WITHER_SKELETON -> setTo = Material.WITHER_SKELETON_SPAWN_EGG;
                case ZOMBIE_VILLAGER -> setTo = Material.ZOMBIE_VILLAGER_SPAWN_EGG;
                case ZOMBIFIED_PIGLIN -> setTo = Material.ZOMBIFIED_PIGLIN_SPAWN_EGG;
                case WANDERING_TRADER -> setTo = Material.WANDERING_TRADER_SPAWN_EGG;
                case SKELETON_HORSE -> setTo = Material.SKELETON_HORSE_SPAWN_EGG;
            }
            if (setTo != null) {
                e.getPlayer().getWorld().playSound(e.getPlayer(), Sound.ITEM_BUCKET_FILL, 1F, 1F);
                if (bucket.getAmount() > 1) {
                    bucket.setAmount(bucket.getAmount() - 1);
                    ItemStack newItem = new ItemStack(setTo);
                    e.getPlayer().getInventory().addItem(newItem);
                } else {
                    bucket.setItemMeta(null);
                    bucket.setType(setTo);
                }
                en.remove();
            }
        }
    }

    @EventHandler
    public void OnLeftClick(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.LEFT_CLICK_BLOCK)) return;
        if (!e.hasItem()) return;
        if (e.getItem() == null) return;
        Player plr = e.getPlayer();
        if (CustomItemManager.IsItem(e.getItem(), CustomItemManager.createObsidianAxe()) || CustomItemManager.IsItem(e.getItem(), CustomItemManager.createObsidianPickaxe())) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 2, false, false));
        } else if (CustomItemManager.IsItem(e.getItem(), CustomItemManager.createVeinPickaxe())) {
            if (!isVeinMinable(Objects.requireNonNull(e.getClickedBlock()).getType())) return;
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1, false, false));
            plr.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 40, 1, false, false));
        } else if (CustomItemManager.IsItem(e.getItem(), CustomItemManager.createVeinAxe())) {
            if (!isVeinLogMinable(Objects.requireNonNull(e.getClickedBlock()).getType())) return;
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1, false, false));
            plr.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 40, 1, false, false));
        } else if (
                CustomItemManager.IsItem(e.getItem(), CustomItemManager.createCalcitePickaxe())
                || CustomItemManager.IsItem(e.getItem(), CustomItemManager.createCalciteAxe())
                || CustomItemManager.IsItem(e.getItem(), CustomItemManager.createCalciteShovel())
                || CustomItemManager.IsItem(e.getItem(), CustomItemManager.createCalciteSword())
                || CustomItemManager.IsItem(e.getItem(), CustomItemManager.createCalciteHoe())
        ) {
            plr.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1, false, false));
        }
    }
}