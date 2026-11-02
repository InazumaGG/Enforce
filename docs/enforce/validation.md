# Initial fork validation

Date: 2026-11-02.

- Source review and `git diff --check`: passed.
- Complete inventory source paths and local documentation links: checked.
- `:bukkit:generateBukkitPluginDescription --offline`: passed with JDK 21.
  The generated descriptor identifies Enforce and retains the upstream loader/API.
- `:bukkit:shadowJar -PmavenLocalOverride=false`: blocked during dependency resolution.
  Both `maven.grim.ac/public/...` and the legacy `repo.grim.ac/snapshots` endpoint
  returned HTTP 403 for required artifacts. This occurred with network access enabled.

Affected pinned dependencies include:

- `ac.grim.grimac:GrimAPI:1.6.0.13`
- `ac.grim.grimac:grim-internal:1.6.0.13`
- `ac.grim.grimac:grim-bukkit-internal:1.6.0.13`
- `com.github.retrooper:packetevents-spigot:2.14.1+addb80e-SNAPSHOT`

The initial upstream build also tried to configure Fabric Loom, which requires JDK 25.
Enforce's default Bukkit-only configuration resolves that build-configuration issue.

**No compiled Enforce JAR or runtime compatibility result is claimed.** Restoring access
to the pinned Maven artifacts, or reproducibly building the matching public dependency
sources, is required before compilation and staging validation can complete. The GitHub
workflow attempts the same Bukkit build on a hosted runner; its result must be checked
separately. No new tests were generated.
