package uk.co.nikodem.dFSmpPlugin.Content.Events;

import com.fren_gor.ultimateAdvancementAPI.events.PlayerLoadingCompletedEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.Bedrock;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.ExtraAdvancementManager;
import uk.co.nikodem.dFSmpPlugin.DFSmpPlugin;

public class OnJoin implements Listener {
    public final DFSmpPlugin plugin;

    public OnJoin(DFSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player plr = e.getPlayer();
        plugin.vr.discoverRecipes(plr);
        plugin.cir.discoverRecipes(plr);
        plugin.ar.discoverRecipes(plr);
    }

    @EventHandler
    public void onJoin(PlayerLoadingCompletedEvent e) {
        // Called after a player has successfully been loaded by the API
        Player plr = e.getPlayer();

        // I put this statement here to not give advancements to floodgate users, as it forces the geysermc advancement menu to open
        if (Bedrock.isJavaPlayer(plr)) {
            plugin.ca.dfsmpadvancements.grantRootAdvancement(plr);
            plugin.ca.dfsmpadvancements.showTab(plr);

            ExtraAdvancementManager.loadKeys(plr);
        } else {
            plugin.ca.dfsmpadvancements.hideTab(plr);
        }
    }
}
