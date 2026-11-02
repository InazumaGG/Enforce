# Enforce: check coverage and integration assessment

Implementation update: Inazuma Core now subscribes to flags directly, waiting for Enforce's
plugin-enable event when Core starts earlier. It uses `ANTICHEAT_ACCESS` and a separate
`notify.anticheat` preference, controlled by `/alerts [on|off]`. Enforce's native commands
and alert/proxy/webhook broadcasts are disabled. The integration architecture below
records the original assessment; the standalone bridge is now implemented inside Core.

Reviewed on 2026-11-02 against Grim's public `2.0` branch at
[`dc9f37c2a61d0b1caded41d877af95df4f059c6e`](https://github.com/GrimAnticheat/Grim/commit/dc9f37c2a61d0b1caded41d877af95df4f059c6e),
whose base version is `2.3.75`. The matching public API dependency is `1.6.0.13`;
[API source](https://github.com/GrimAnticheat/GrimAPI/tree/e9ae70ad6e13af0f3dab02ac849608443fb69f8a).
This is an upstream source assessment, not confirmation of the version or configuration
running in production. The inspected Inazuma checkout contains no Grim integration or
local Grim plugin/configuration from which to identify that deployment.

## What Grim already supplies

There are **125 registered annotated checks**, of which **52 are experimental**.
Registration does not mean a check applies to every Minecraft version or is enabled
in a particular configuration. Experimental checks are disabled by default. Two further
annotated implementations exist but are not registered: `Baritone` and `PacketOrderP`.
The full inventory, including exact names, descriptions and source links, is in
[checks.md](checks.md). Counts exclude processors that maintain state without being checks.

| Area | Implemented coverage | Relevance to Inazuma |
| --- | --- | --- |
| Movement | `Simulation`, `Phase`, `GroundSpoof`, `NoFall`, `NoSlow`, sprint-state checks | Keep the simulation engine for speed/fly/invalid movement, collision and item-use slowdown validation. These are covered through simulation rather than separate checks named Fly or Speed. |
| Velocity | `AntiKB` / `Knockback`, `AntiExplosion` / `Explosion` | Keep; validate custom knockback and kit launches against the velocity actually sent to the player. |
| Combat geometry | `Reach`, `Hitboxes`, invalid/self/multiple interaction checks | Strong existing foundation for 1.8 combat. Reach uses compensated entity state; a simple Bukkit distance check would lose that information. |
| Aim | `AimDuplicateLook`, `AimModulo360` | Specific rotation anomalies. This is not a complete aim-assist or KillAura classifier. |
| Timing | `Timer`, `TimerLimit`, `NegativeTimer`, `TickTimer`, `VehicleTimer` | Keep applicable checks; timing abuse is already covered. Some checks concern newer client protocols. |
| Block placement | Support, cursor, face, position, rotation and placement-distance checks; experimental multi-place/duplicate rotation | Existing scaffold-related validation. These do not guarantee detection of every automated builder. |
| Block breaking | `FastBreak`, invalid/wrong/air-liquid breaks, position checks; experimental reach/rotation/multi-break/no-swing | Useful for HG mining and world interaction. Validate abilities that break blocks directly on the server. |
| Inventory and actions | `MultiActions`, `PacketOrder`, `Post`, bad-packet checks | Invalid combinations, ordering, inventory actions, no-swing attacks and protocol state. Not general statistical inventory-macro detection. |
| Malformed traffic | `BadPackets`, `Crash`, `Exploit`, transaction ordering and chat protocol checks | Keep applicable protections. Chat checks validate protocol behavior; they are not chat moderation or toxicity filtering. |
| Vehicles / elytra | Vehicle simulation/control and elytra state checks | Version-dependent; many are not relevant to native 1.8 gameplay. |

`Autoclicker` appears in `punishments.yml` as a placeholder, but there is no implemented
autoclicker check in this source. `Baritone` is deliberately unregistered: its source says
the old detection was bypassed and could flag cinematic camera. Do not enable it just
because the class or punishment group exists. The README describes additional paid
heuristics as planned; they are not part of this public fork. Client brand is telemetry,
not reliable proof of a particular client or cheat. No dedicated X-ray or general
statistical aim/autoclicker detector was found.

## Recommended Enforce additions

| Priority | Addition | Implementation and limits |
| --- | --- | --- |
| 1 | Staff alerts and evidence | Bridge Grim flags into Inazuma's staff tools with server, session, check identity, client version, ping and recent kit actions. Aggregate and deduplicate alerts. Keep enforcement policy separate from detection. |
| 1 | Ability compatibility | Record server-authorized launches, teleports, knockback changes and flight transitions. First verify that Grim tracks them normally. Add narrowly scoped handling only for reproduced mismatches. |
| 2 | Autoclicker heuristics | Measure repeated combat click patterns over sufficient samples and multiple windows. Account for client ticks, packet batching, mining and interaction context. CPS alone, or one low-variance window, is not proof. Begin with staff review. |
| 2 | Aim-assist / combat heuristics | Combine rotation/sensitivity behavior, target tracking and attack context using compensated state. Validate against legitimate mouse input, cinematic camera, mods, target switches and teleports. Begin with staff review. |
| 3 | Auto-soup / refill heuristics | Correlate inventory slots, soup consumption, bowl handling and refill sequences. Existing ordering checks already cover some impossible actions; high speed alone can be legitimate. Useful only if these actions are relevant to the deployed game mode. |
| 3 | Ability integrity records | Reject invalid cooldown/state transitions in the authoritative game code and attach those records to investigations. An invalid transition can also be a server bug; it is not automatically a cheating verdict. |

These are proposed additions. The initial fork contains the registration hook but
does not claim to implement these detectors. A separate X-ray mitigation should hide
ore information at the server/chunk layer; adding a movement flag does not address it.

## Fit with this server

The inspected project targets Java 21 and PandaSpigot 1.8.8. Grim's Bukkit runtime
requires Java 17+, so the Java target fits. Compatibility with this exact patched
server and its plugins still needs a staging run. Grim belongs on each gameplay backend.
With Velocity, ViaVersion must be on the backend only according to upstream's installation
requirements; check the actual proxy deployment as well. Bedrock/Geyser users are exempt
in upstream Grim, so this fork does not provide equivalent Bedrock detection.

Relevant Inazuma code inspected:

- `Kangaroo` and `Hulk` apply server velocity; `Anchor` changes the next player velocity event.
- `Blink`, `Ninja`, and `Switcher` use server teleports.
- `StaffModeComponent` changes flight permissions, flight state, velocity and movement speed.
- `PunishmentService` already supports network punishments; `SQLPunishmentService` publishes
  punishment updates and player disconnect packets.
- `StaffNotificationService` demonstrates delivery on the Bukkit server thread with
  loaded-profile, current-session and staff-preference checks.

The local Minecraft knowledge base for PandaSpigot build 199 shows `CraftEntity.setVelocity`
sets velocity and marks it changed; `EntityTrackerEntry` applies `PlayerVelocityEvent`
before broadcasting that changed velocity. Grim's `KnockbackHandler` observes the outbound
entity-velocity packet. This supports validating the transmitted value first, rather than
automatically exempting Anchor or Kangaroo from all movement checks. It does not prove every
damage or plugin packet path behaves identically. The knowledge-base JAR hash is
`062f94702ecb350a6e331063c9a3bff89ac8ec4d3f217028bb4e0a01ad29d401`.

Avoid broad temporary exemptions around every ability. They can hide unrelated movement
and combat violations. Where an exemption is necessary, bind it to the player session,
specific check, authorized action and a short bounded lifetime; align it with client
acknowledgement where possible. Removing a flag is not necessarily equivalent to stopping
every packet cancellation or resynchronization path.

## Integration architecture

Use an independent Bukkit plugin, for example **EnforceBridge**, that depends on `Core`
and `Enforce`. This avoids forcing Core's `STARTUP` loader to initialize the anticheat API
before Grim has enabled. Build against the MIT-licensed public API with Maven `provided`;
do not shade it. An optional integration needs an isolated adapter and a presence/readiness
check before any API class is loaded. See [api.md](api.md).

The data flow should be:

```text
Grim / custom check (player Netty thread)
  -> immutable evidence -> bounded queue
  -> evidence worker / SQLBuilder persistence
  -> Inazuma network packet -> staff UI on the Bukkit thread
  -> reviewed enforcement policy -> PunishmentService
```

Do not run SQL, Redis requests, HTTP calls or Bukkit world/player operations directly in
a flag callback. Snapshot mutable values before queuing; never carry the live check or
player object into a worker. Bound queue growth, track dropped records, and record the
server/session identity to avoid attributing delayed records to a new login. Use existing
Inazuma messaging implementations and `SQLBuilder` for new statements.

Use `PunishmentService` for decided sanctions so ban history and proxy disconnect behavior
remain consistent. Deduplicate enforcement by session/evidence decision. Do not independently
auto-ban through both Grim command rules and the bridge. Start new heuristic checks in
observation mode, then set thresholds from legitimate staging and production samples.

Grim already has local alerts, histories, configurable commands, Discord webhooks and
optional proxy alert forwarding. Reuse those where sufficient. Redis integration is useful
for your existing network staff tools; it does not require rewriting the prediction engine.

For 1.8 PvP, evaluate `Reach.enable-post-packet: true` in staging: upstream specifically
recommends considering it for 1.8 PvP servers and notes the additional bandwidth. Keep
`Reach.block-impossible-hits` enabled unless a reproduced compatibility issue justifies a
change. Leave experimental checks disabled globally until their relevant version/mechanics
have been assessed. The first fork preserves upstream check thresholds and punishments.

## Rebranding and licensing

A display-only wrapper can provide Enforce alerts/commands around stock Grim with a small
maintenance burden. Native prediction/rotation/packet checks belong in this fork when they
need Grim's internal compensated state and dispatch ordering. The public API exposes
events and check inspection, but no supported native check-factory registration interface.
`GrimUser.getChecks()` is an unmodifiable collection in the inspected implementation.

The fork keeps upstream packages, stable check keys and `grim.*` permissions to make future
merges practical. Its Bukkit plugin identity is `Enforce`; plugins hard-dependent on the
name `GrimAC` must update their dependency declaration, especially on 1.8 where modern
plugin alias metadata cannot be assumed. API class compatibility does not replace plugin
loader dependency compatibility. Never run GrimAC and Enforce together.

Grim is GPLv3. Renaming and modifying it are allowed; retain the license and copyright
notices, identify modifications, and provide the corresponding source under the GPL when
distributing modified binaries. Running it privately on your own servers does not by
itself trigger a network-source requirement: this is GPL, not AGPL. This public fork is
a straightforward way to publish matching source. The separate public GrimAPI repository
is MIT licensed; using that API is different from copying GPL engine code into a plugin.

## Primary references

- [Registered checks and listener dispatch](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/manager/CheckManager.java)
- [Default configuration](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/resources/config/en.yml)
- [Default punishments and autoclicker placeholder](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/resources/punishments/en.yml)
- [Grim API source](https://github.com/GrimAnticheat/GrimAPI/tree/e9ae70ad6e13af0f3dab02ac849608443fb69f8a)
- [Installation and architecture](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/README.md)
- [GPL license](../../LICENSE) and [MIT API license](https://github.com/GrimAnticheat/GrimAPI/blob/e9ae70ad6e13af0f3dab02ac849608443fb69f8a/LICENSE)
