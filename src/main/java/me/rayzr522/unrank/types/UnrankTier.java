package me.rayzr522.unrank.types;

import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Objects;

public class UnrankTier {
    private final List<String> includedRanks;
    private final String targetRank;

    private UnrankTier(List<String> includedRanks, String targetRank) {
        Objects.requireNonNull(includedRanks, "includedRanks cannot be null!");
        Objects.requireNonNull(targetRank, "targetRank cannot be null!");

        if (includedRanks.size() < 1) {
            throw new IllegalArgumentException("included-ranks must have at least one rank!");
        }

        this.includedRanks = includedRanks;
        this.targetRank = targetRank;
    }

    /**
     * Attempts to load an unrank tier from a config object.
     *
     * @param config The config to load it from.
     * @return The loaded unrank tier, if it successfully loaded.
     */
    public static UnrankTier load(ConfigurationSection config) {
        return new UnrankTier(
                config.getStringList("included-ranks"),
                config.getString("target-rank")
        );
    }

    /**
     * @return The list of ranks which are included in this tier.
     */
    public List<String> getIncludedRanks() {
        return includedRanks;
    }

    /**
     * @return The rank which players should be reset to if they are in this tier.
     */
    public String getTargetRank() {
        return targetRank;
    }
}
