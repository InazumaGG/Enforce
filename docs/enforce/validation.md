# Initial fork validation

Date: 2026-11-02.

- **Hosted Bukkit compilation and artifact upload: passed.**
  [GitHub Actions run 41488188313](https://github.com/InazumaGG/Enforce/actions/runs/41488188313)
  built source commit `8216289f4da3a02c473d1ed7511711b3ad20a644` with JDK 21 and
  `:bukkit:shadowJar -PmavenLocalOverride=false --no-daemon`.
  Download the `Enforce-Bukkit` artifact from that run.
- Source review and `git diff --check`: passed.
- Complete inventory source paths and local documentation links: checked.
- `:bukkit:generateBukkitPluginDescription --offline`: passed with JDK 21.
  The generated descriptor identifies Enforce and retains the upstream loader/API.
- Local `:bukkit:shadowJar -PmavenLocalOverride=false`: blocked during dependency resolution.
  Both `maven.grim.ac/public/...` and the legacy `repo.grim.ac/snapshots` endpoint
  returned HTTP 403 for required artifacts. This occurred with network access enabled.

Affected pinned dependencies include:

- `ac.grim.grimac:GrimAPI:1.6.0.13`
- `ac.grim.grimac:grim-internal:1.6.0.13`
- `ac.grim.grimac:grim-bukkit-internal:1.6.0.13`
- `com.github.retrooper:packetevents-spigot:2.14.1+addb80e-SNAPSHOT`

The initial upstream build also tried to configure Fabric Loom, which requires JDK 25.
Enforce's default Bukkit-only configuration resolves that build-configuration issue.

The hosted runner resolved those dependencies and produced a compiled Enforce JAR.
The local Maven-access problem remains environment-specific; use the hosted artifact
or restore local access to the pinned dependencies for local builds.

**Runtime compatibility has not been validated.** Exercise the patched PandaSpigot
server and kit mechanics in staging before deployment. No new tests were generated;
the build task compiles/packages the plugin and does not run the inherited test suite.
