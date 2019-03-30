package me.rayzr522.unrank.listeners;

import me.rayzr522.unrank.Unrank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    private final Unrank plugin;

    public PlayerListener(Unrank plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player == null) {
            return;
        }

        // Date lastJoined = new Date(player.getLastPlayed());
        // TODO: Compare to when to reset from!

        // Bump down their rank!
        plugin.getTierManager().unrankPlayer(player);
    }

}
