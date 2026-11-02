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

Run the build script from your checkout (macOS/Linux):

```sh
./build.sh
```

It selects JDK 21 from `JAVA_HOME`, macOS's installed JDKs, or Java on `PATH`,
runs the included Gradle wrapper, and prints the exact finished JAR path. The log
is saved to `build/enforce-build.log`. Additional Gradle options are supported,
for example `./build.sh --no-daemon`. Use `./build.sh --help` for usage.

To invoke Gradle directly with JDK 21:

```sh
./gradlew :bukkit:shadowJar -PmavenLocalOverride=false
```

If dependency downloads return HTTP 403, run the
[Enforce Bukkit workflow](https://github.com/InazumaGG/Enforce/actions/workflows/enforce.yml)
and download its `Enforce-Bukkit` artifact. It runs the same build script.

The Bukkit artifact is written to `bukkit/build/libs/enforce-bukkit-*.jar`.
It includes PacketEvents by default. Runtime requires Java 17 or newer.
Bukkit-only configuration is the default. To work on the retained Fabric sources,
use `-Penforce.bukkitOnly=false` with JDK 25 or newer for the Gradle runtime.
This fork targets the Inazuma PandaSpigot 1.8.8 environment; inherited support for other
versions still needs validation with the actual server and plugin configuration.

The Bukkit plugin name and data directory are `Enforce`. Native command registration
is disabled: `/grim`, `/grimac`, `/gl`, `/enforce` and their namespaced forms are absent.
Core owns flag delivery through the public API. Recipients require the explicit
`ANTICHEAT_ACCESS` subrole and the independent `notify.anticheat` preference.
Core's `/alerts [on|off]` controls that preference. Native alert/proxy/webhook broadcasts
and login notification toggles are disabled so they cannot bypass Core's access checks.
Detection, history writes and configured sanctions continue to run.

## Status

The Bukkit JAR compiled successfully on [GitHub Actions](https://github.com/InazumaGG/Enforce/actions/runs/41488188313).
The build artifact is available from that run. Local plugin metadata generation also
passed; the local full build encountered upstream HTTP 403 responses. Live-server
validation remains outstanding. See [validation details](docs/enforce/validation.md).

The initial fork adds branding and extension infrastructure. The 125 registered
inherited checks include 52 marked experimental; applicability and activation depend
on protocol and configuration. New autoclicker/aim heuristics remain implementation
proposals; the runtime flag integration lives in Inazuma Core. See the assessment before enabling
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
