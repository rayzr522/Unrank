package me.rayzr522.unrank.listeners;

import me.rayzr522.unrank.Unrank;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;

public class PlayerListener implements Listener {
    private final Unrank plugin;

    public PlayerListener(Unrank plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Date lastJoined = new Date(e.getPlayer().getLastPlayed());

        // TODO: Compare to when to reset from!
    }
}
