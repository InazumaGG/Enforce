# Core display interactions

Core renders hologram text as packet-only armor stands and NPCs as packet-only
players. Its NMS use-entity interceptor handles clicks after packet decoding and
consumes them before vanilla handles them. Enforce's packet listeners run earlier,
so these UI interactions previously entered Reach's combat geometry checks and
could produce Reach or Hitboxes flags before Core received the click.

The updated Core registers `enforce:display-entity:v1` with
`GrimAbstractAPI.registerFunction`. The contract is:

- Input: an immutable `Map.Entry<UUID, Integer>` containing the viewer UUID and
  target entity ID.
- Output: `Boolean.TRUE` only when the target is owned by an active Core display
  manager and is currently visible to that viewer. Other values mean no exemption.
- Execution: the packet thread; the callback only reads concurrent registries and
  viewer sets, with no Bukkit world access, database calls or network requests.

Reach consults this function before cancelling or queuing an interaction and before
evaluating queued geometry. Hitboxes shares that geometry path. No other check is
disabled. There is no blanket armor-stand, NPC-type, lobby, entity-ID-range or player
exemption. Real entities follow the existing path, even when clicked immediately
before or after a display. Missing or failed lookups keep combat checks active.

Core unregisters its function on detach. Display removal/reindexing, viewer hide/quit
and manager shutdown update the existing live registries used by the lookup. The
API contract uses only JDK types and needs no shared PacketEvents or engine classes.
Both Core and Enforce must be updated.

## Runtime verification

On Lunar 1.8.9, left- and right-click hologram lines and NPC labels, including displays
with dynamically added or replaced lines. Confirm clicks still execute once and no
Reach/Hitboxes flags are produced for these displays. Verify normal combat and actual
armor stands still follow the ordinary checks, then remove/hide a display and ensure
its old IDs no longer qualify. These in-game scenarios still need a server retest.
