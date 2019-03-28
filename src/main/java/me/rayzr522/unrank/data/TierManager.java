package me.rayzr522.unrank.data;

import me.rayzr522.unrank.Unrank;
import me.rayzr522.unrank.types.UnrankTier;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class TierManager {
    private final Unrank plugin;

    private List<UnrankTier> tierList = new ArrayList<>();

    public TierManager(Unrank plugin) {
        this.plugin = plugin;
    }

    public void load() {
        YamlConfiguration config = plugin.getConfig("tiers.yml");

        tierList = config.getKeys(false).stream()
                .filter(config::isConfigurationSection)
                .map(key -> {
                    try {
                        return UnrankTier.load(config.getConfigurationSection(key));
                    } catch (Exception e) {
                        plugin.getLogger().log(Level.WARNING, "Failed to load Unrank tier from config:", e);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Attempts to find an Unrank tier that includes the given rank.
     *
     * @param rank The rank to check for.
     * @return The tier, if one was found.
     */
    public Optional<UnrankTier> getTier(String rank) {
        return tierList.stream()
                .filter(tier -> tier.getIncludedRanks().contains(rank))
                .findFirst();
    }
}
