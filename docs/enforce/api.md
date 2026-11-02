# Using the API from EnforceBridge

This guide is pinned to the fork's `ac.grim.grimac:GrimAPI:1.6.0.13` dependency.
Check the actual deployed Grim/API version before integrating an older build. The wiki's
`1.3.2.1` example and the API README's `onFlag` examples lag behind this source: the
current preferred flag callback is `onFlagSupplier`.
The pinned Maven endpoint returned HTTP 403 during the initial build; see
[validation.md](validation.md) before treating this as a verified dependency download.

## Dependency and lifecycle

Add to a standalone Bukkit bridge's Maven POM:

```xml
<repositories>
  <repository>
    <id>grim-public-releases</id>
    <url>https://maven.grim.ac/public/releases</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>ac.grim.grimac</groupId>
    <artifactId>GrimAPI</artifactId>
    <version>1.6.0.13</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

For the Enforce fork, use `depend: [Core, Enforce]` in the bridge's `plugin.yml`.
A bridge for unmodified Grim uses `GrimAC` instead of `Enforce`. Do not list both as
hard dependencies. Initialize in `onEnable()`, after dependencies have enabled.
Keep API classes out of your shaded artifact.

## Observing flags

The following is a registration excerpt for the bridge, not a complete persistence service.
`evidence` is a bounded `ArrayBlockingQueue<Evidence>` owned and drained by the bridge;
`droppedEvidence` is an `AtomicLong`. Create these before registering the handler.
Cache the server/session identity in your evidence model as well.

```java
import ac.grim.grimac.api.GrimAPIProvider;
import ac.grim.grimac.api.GrimAbstractAPI;
import ac.grim.grimac.api.event.ListenerPriority;
import ac.grim.grimac.api.event.events.FlagEvent;
import ac.grim.grimac.api.plugin.GrimPlugin;
import java.util.UUID;

record Evidence(UUID playerId, String playerName, String checkKey, String checkName,
                double violationsBeforeFlag, int ping, String clientVersion,
                String verbose, long observedAt) {}

// Inside the bridge's onEnable(), where `this` is the JavaPlugin.
GrimAbstractAPI api = GrimAPIProvider.get();
GrimPlugin owner = api.getGrimPlugin(this);
api.getEventBus().get(FlagEvent.class).onFlagSupplier(owner,
        (user, check, verbose, cancelled) -> {
            if (!cancelled) {
                Evidence snapshot = new Evidence(user.getUniqueId(), user.getName(),
                        check.getStableKey(), check.getCheckName(), check.getViolations(),
                        user.getTransactionPing(), user.getVersionName(), verbose.get(),
                        System.currentTimeMillis());
                if (!evidence.offer(snapshot)) {
                    droppedEvidence.incrementAndGet();
                }
            }
            return cancelled;
        }, ListenerPriority.MONITOR, true);
```

The flag callback occurs **before** Grim increments the check's violations. Do not label
`check.getViolations()` there as the post-flag total. It is also different from the active,
time-windowed count in a punishment group. Do not sum arbitrary violation levels from
different checks into a universal probability of cheating.

This API's `ignoreCancelled = true` means the callback still runs after cancellation;
the example explicitly ignores those records and preserves the incoming state. This
differs from the intuitive reading of Bukkit's similarly named option. `MONITOR` observes
the final state. Cancellation policies should run at an earlier priority and return
`true` only for their specific case; otherwise preserve `cancelled`.

Unregister using the same owner/context on disable, and stop/drain the bridge's workers:

```java
api.getEventBus().unregisterAllListeners(owner);
```

Grim also performs lifecycle cleanup for plugin-bound listeners. Retain the cached API
and owner so cleanup does not depend on looking up a newly disabled plugin.

## Useful supported hooks

| API | Application |
| --- | --- |
| `FlagEvent` | Observe or narrowly suppress a flag. Not a raw attack/movement stream. |
| `CommandExecuteEvent.onCommandExecuteSupplier` | Observe/intercept configured actions. Preserve ordinary alert/log actions if replacing a sanction. |
| `CompletePredictionEvent` | Observe prediction completion and offset. Its cancellation affects processing, so an observer preserves state. |
| Transaction send/receive events | Align recorded server actions with what the player could have acknowledged. |
| Teleport and player/vehicle setback events | Add context and distinguish server corrections from unexplained movement. |
| `GrimJoinEvent`, `GrimQuitEvent` | Create/clear session-bound evidence state. |
| `api.getGrimUser(UUID)` | Nullable lookup; some users are exempt or not yet initialized. |
| `user.getChecks()` | Inspect known checks; use `user.runSafely(...)` when reading mutable state from another thread. |
| `user.runSafely(...)`, transaction tasks | Execute on the player's Netty thread; these do not schedule onto Bukkit's main thread. |
| `user.updatePermissions()` | Refresh Grim's permission cache after custom permission-provider changes. |
| `api.registerVariable(...)` | Add server/network placeholders to supported messages. |
| `user.setResyncHandler(...)` | Custom block resynchronization when a plugin owns packet-only fake blocks. |
| `api.getBackendRegistry()` | Advanced storage-provider integration registered before the datastore starts. |

The current `GrimAbstractAPI` does **not** contain the verdict registry/history accessors
listed in an older wiki section. Do not build against undocumented imagined methods.
`registerFunction` is not a supported check-registration API. For native checks, use
the fork's [custom-check registration](custom-checks.md).
