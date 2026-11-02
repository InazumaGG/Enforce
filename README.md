# Enforce

Enforce is InazumaGG's Bukkit anticheat fork of [GrimAC](https://github.com/GrimAnticheat/Grim),
based on upstream 2.3.75. It preserves Grim's prediction engine and public API while adding
Enforce branding and a source registration point for custom checks.

- [Check coverage and Inazuma integration assessment](docs/enforce/assessment.md)
- [Complete check inventory](docs/enforce/checks.md)
- [Using the public API](docs/enforce/api.md)
- [Adding custom checks](docs/enforce/custom-checks.md)
- [Fork changes and migration notes](ENFORCE-CHANGES.md)
- [Upstream documentation](docs/enforce/upstream-README.md)

## Build

Use JDK 21 and the included Gradle wrapper:

```sh
./gradlew :bukkit:shadowJar -PmavenLocalOverride=false
```

The Bukkit artifact is written to `bukkit/build/libs/enforce-bukkit-*.jar`.
It includes PacketEvents by default. Runtime requires Java 17 or newer.
Bukkit-only configuration is the default. To work on the retained Fabric sources,
use `-Penforce.bukkitOnly=false` with JDK 25 or newer for the Gradle runtime.
This fork targets the Inazuma PandaSpigot 1.8.8 environment; inherited support for other
versions still needs validation with the actual server and plugin configuration.

Use `/enforce help` and `/enforce version`. Existing `grim.*` permissions and `/grim`
aliases remain available. The Bukkit plugin name and data directory are `Enforce`.
Update dependent plugins accordingly and run only one anticheat engine instance.

## Status

The Bukkit JAR compiled successfully on [GitHub Actions](https://github.com/InazumaGG/Enforce/actions/runs/41488188313).
The build artifact is available from that run. Local plugin metadata generation also
passed; the local full build encountered upstream HTTP 403 responses. Live-server
validation remains outstanding. See [validation details](docs/enforce/validation.md).

The initial fork adds branding and extension infrastructure. The 125 registered
inherited checks include 52 marked experimental; applicability and activation depend
on protocol and configuration. New autoclicker/aim heuristics and EnforceBridge are
implementation proposals, not shipped detections. See the assessment before enabling
experimental checks or choosing automatic sanctions.

## Upstream updates

The local `upstream` remote points to GrimAnticheat/Grim; `origin` points to
InazumaGG/Enforce. The `enforce` branch carries this fork's changes.

```sh
git fetch upstream
git switch enforce
git merge upstream/2.0
./gradlew :bukkit:shadowJar -PmavenLocalOverride=false
```

Review conflicts, API/dependency changes, check defaults and the inventory when merging.
Retain the upstream commit and matching source for each distributed artifact.

## License and attribution

GrimAC and this derivative are licensed under [GPLv3](LICENSE). Original copyright
notices and Git history are retained. Modifications are identified in
[ENFORCE-CHANGES.md](ENFORCE-CHANGES.md). Enforce is maintained by InazumaGG and is not
an official GrimAnticheat release. Grim's separate public API is MIT licensed.
