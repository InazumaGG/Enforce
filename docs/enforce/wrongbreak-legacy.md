# WrongBreak: grass in protected areas on 1.8.9

Reported with Lunar 1.8.9 in the Inazuma lobby while breaking long grass in survival.
The lobby registers Core's `DisableBuildListener`, which cancels left-click block
interactions. The patched PandaSpigot 1.8.8 `PlayerInteractManager` responds to the
cancelled interaction by sending the original block state back to the client.

The vanilla 1.8.9 client sets its tracked block's Y coordinate to `-1` after client-side
block destruction. When an instant-break block is restored in front of a block that
takes time to break, the client can subsequently send `CANCELLED_DIGGING` at this
sentinel position. This is also described in the discussion of
[upstream issue/PR 2929](https://github.com/GrimAnticheat/Grim/pull/2929).

WrongBreak already exempts this sequence, but its old coordinate comparison expected
Y = `4095` on servers older than 1.14. Inspection of the PacketEvents bytecode bundled
in Enforce `25b9314` confirms that `WrapperPlayClientPlayerDigging.read()` calls
`PacketWrapper.readBlockPosition()`, whose `Vector3i(long, ServerVersion)` constructor
sign-extends the 12-bit Y coordinate for both packed-position formats. The result
is `-1`, not `4095`.

The fix compares against `-1` for 1.8+ clients and preserves `255` for pre-1.8 clients.
It retains the existing sequence constraints, finish-dig validation and packet
cancellation behavior. It introduces no grass, lobby, client-brand or player exemption.
The value was verified against the bundled decoder rather than copied from the open
upstream PR.

## Runtime verification

After replacing the Enforce JAR and restarting:

1. Join the protected lobby with Lunar 1.8.9 in survival.
2. Break long grass in front of a normal solid block; hold/release the attack button
   and repeat while the server restores the grass.
3. Confirm that the legitimate cancel sequence no longer produces WrongBreak.
4. Confirm that lobby protection still restores the grass.

The decoder mismatch is confirmed by source and bytecode inspection. This exact
Lunar interaction still requires an in-game retest; no client session was available
during the fix. No tests were added.
