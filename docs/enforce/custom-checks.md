# Adding native Enforce checks

The initial fork inherits Grim's existing checks. It registers no new detections.
The dedicated hook is
[`EnforceChecks.register`](../../common/src/main/java/gg/inazuma/enforce/checks/EnforceChecks.java).
It runs once per player, before `CheckManager` freezes its processor map and constructs
the listener arrays. It is a source extension point for this fork, not a runtime public API.

1. Put a new check under `gg.inazuma.enforce.checks`, extend Grim's `Check`, and annotate
   it with `@CheckData`. Choose a distinct name and stable key such as
   `EnforceAimA` and `enforce.combat.aim_a`; do not rename an upstream stable key.
2. Implement the appropriate listener: `RotationListener`, `PacketReceiveListener`,
   `PreViaPacketReceiveListener`, `PostPredictionListener`, `BlockPlaceListener`, etc.
   Follow a neighboring upstream check's thread and version assumptions.
3. Instantiate one check per player in the hook:
   `checks.put(EnforceAimA.class, new EnforceAimA(player));`.
4. Add an explicit punishment group for the new check name. Start with logging and
   controlled staff alerts; do not add bans or setbacks before validating detection.
5. Keep buffers in the check instance; apply decay/reward on legitimate observations.
   Record enough evidence to explain a flag. Avoid unbounded per-packet collections.
6. Use Grim's `flag(...)` path so cancellation, permissions, violation accounting,
   storage and configured actions continue to work. Packet cancellation additionally
   needs the normal `shouldModifyPackets()` checks; flagging alone does not require it.
7. Restrict version applicability where necessary. `isApplicable()` is evaluated once
   while creating dispatch arrays, so only immutable connection properties belong
   there. Kit, staff or temporary ability state must be evaluated dynamically.

`experimental = true` uses Grim's shared experimental feature switch. Enabling it for
one Enforce prototype can also enable upstream experimental checks. Prefer a dedicated,
default-off Enforce configuration gate as well, and document both gates.

The hook appends listeners after upstream processors. If a new check needs to run before
a specific built-in processor, review and make that ordering explicit rather than
assuming every listener position is equivalent. Use compensated packet state instead
of accessing live Bukkit entities or worlds from a Netty callback. Game state must
arrive through immutable session-bound snapshots or properly scheduled player tasks.

Suggested first work: establish an observation-only combat dataset, then build an
autoclicker check followed by contextual aim heuristics. Do not treat a high CPS value,
client brand or a single low-variance window as sufficient for automatic punishment.

Before deployment, manually exercise native 1.8 and supported translated clients, high
latency/jitter, teleport kits, Anchor, Kangaroo, staff mode entry/exit, death/respawn,
vehicles, and inventory interaction. Confirm the engine still tracks state when a
check is suppressed. No new tests were generated for the initial fork.
