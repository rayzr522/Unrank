# Unrank

> A simple tool to reset users ranks based on preconfigured rules.

This simple Bukkit plugin allows you to soft-reset the rank-up progress of your players at will. **Unrank** groups user ranks into "tiers", with each tier having a specific rank that it resets back to. This allows for flexibility with how far you set your players back during a soft-reset.

## Installation

Grab the latest version from the [releases page](https://github.com/Rayzr522/Unrank/releases) and drop it in your `plugins` folder.

The only requirements are **Vault** and a permissions plugin!

## Usage

Simply configure the `tiers.yml` file to suit your soft-reset needs, and then run `/unrank reset` in-game or from the server console. (This requires the `Unrank.use` permission)

All online players will be kicked, and upon re-joining, player will have their ranks soft-reset based on your configured tiers.
