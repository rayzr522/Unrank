package me.rayzr522.unrank.command;

import me.rayzr522.unrank.Unrank;
import me.rayzr522.unrank.data.TierManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUnrank implements CommandExecutor {
    private final Unrank plugin;

    public CommandUnrank(Unrank plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!plugin.checkPermission(sender, "use", true)) {
            return true;
        }

        if (args.length < 1) {
            showUsage(sender);
            return true;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            case "version":
                sender.sendMessage(plugin.tr("command.unrank.version", plugin.getName(), plugin.getDescription().getVersion()));
                break;
            case "reload":
                plugin.reload();
                sender.sendMessage(plugin.tr("command.unrank.reloaded"));
                break;
            case "reset":
                sender.sendMessage(plugin.tr("command.unrank.reset"));
                Bukkit.getServer().getOnlinePlayers().forEach(player -> player.kickPlayer(plugin.tr("kick.reset")));
                plugin.updateLastResetTime();
                break;
            case "help":
            case "?":
            default:
                showUsage(sender);
        }

        return true;
    }

    private void showUsage(CommandSender sender) {
        sender.sendMessage(plugin.tr("command.unrank.help.message"));
    }
}