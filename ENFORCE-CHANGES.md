# Enforce modifications

Maintained by InazumaGG. Initial changes: 2026-11-02.
Based on GrimAnticheat/Grim `2.0` commit
`dc9f37c2a61d0b1caded41d877af95df4f059c6e` (base version `2.3.75`).

- Bukkit plugin identity `Enforce`, version suffix `enforce.1`, artifact prefix `enforce`.
- Native command registration disabled, including `/enforce`, `/grim`, `/grimac` and `/gl`.
- Branded translated message prefixes, help/click commands and webhook titles.
- The plugin descriptor identifies the fork and its source.
- Upstream automatic update-check registration and Bukkit bStats registration removed;
  fork versions are not advertised as upstream releases or counted in Grim's Bukkit metrics.
- Per-player custom-check registration hook under `gg.inazuma.enforce.checks`.
- Source-based check inventory and API/integration guidance.
- Bukkit-only Gradle configuration by default, with Fabric opt-in using
  `-Penforce.bukkitOnly=false` and JDK 25+.
- Enforce Bukkit artifact workflow on standard GitHub runners; upstream-specific
  publishing/runner workflows are gated to the upstream repository.

Upstream check implementations, thresholds, public API packages, stable check keys and
`grim.*` permissions are retained. Existing upstream history and license notices remain.
This initial fork targets Bukkit/PandaSpigot. Fabric sources are retained for merging
but their loader identity has not been migrated to Enforce.

Plugin-name dependencies must change from `GrimAC` to `Enforce`. Configuration belongs
under `plugins/Enforce`; migration from `plugins/GrimAC` is an explicit operator step.
Keep schema/flavor markers intact and let the upstream config migration handle supported
older schemas. Stop the server and back up configuration/history before replacing its
plugin. Run only one of GrimAC and Enforce.

Core now consumes public API flags and owns all alert recipients: `ANTICHEAT_ACCESS`
plus the separate `notify.anticheat` preference (`/alerts [on|off]`). Native alert,
proxy and webhook dispatch and automatic login toggles are disabled. History logging,
detection and configured sanctions are retained. Custom detection heuristics remain proposals.
