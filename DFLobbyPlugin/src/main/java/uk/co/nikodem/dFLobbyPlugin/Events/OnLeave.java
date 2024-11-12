package uk.co.nikodem.dFLobbyPlugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {
    @EventHandler
    public void OnPlayerLeave(PlayerQuitEvent e)
    {
        e.setQuitMessage(null);
    }
}
