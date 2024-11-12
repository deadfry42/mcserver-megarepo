package uk.co.nikodem.dFInhibition.Inhibition;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.TimeSkipEvent;
import org.bukkit.event.world.WorldEvent;

import static uk.co.nikodem.dFInhibition.Inhibition.InhibitManager.*;

public class World implements Listener {
    @EventHandler
    public void OnWeatherChange(WeatherChangeEvent e) {
        if (!isWorldLocked()) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void SetTime(TimeSkipEvent e) {
        if (!isWorldLocked()) return;
        e.setCancelled(true);
        e.getWorld().setTime(1000);
    }

    @EventHandler
    public void KeepTime(WorldEvent e) {
        if (!isWorldLocked()) return;
        e.getWorld().setTime(1000);
    }
}
