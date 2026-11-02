# Upstream check inventory

Snapshot: Grim 2.0 commit dc9f37c2a61d0b1caded41d877af95df4f059c6e, inspected 2026-11-02.

127 annotated implementations: **125 registered**, including **52 experimental**.
Experimental checks require the feature switch (off by default). Registration alone
does not establish version applicability or activation in a running server.
Names and descriptions below are taken from @CheckData, and registration from
CheckManager. Processors without check annotations are excluded.

## aim

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [AimDuplicateLook](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/aim/AimDuplicateLook.java) | AimDuplicateLook | No | Yes | Sent a duplicate rotation update without changing look direction |
| [AimModulo360](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/aim/AimModulo360.java) | AimModulo360 | No | Yes | Sent a large yaw snap |

## badpackets

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [BadPacketsA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsA.java) | BadPacketsA | No | Yes | Sent duplicate slot id |
| [BadPacketsB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsB.java) | BadPacketsB | No | Yes | Ignored set rotation packet |
| [BadPacketsC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsC.java) | BadPacketsC | Yes | Yes | Tried to wake up while not sleeping |
| [BadPacketsD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsD.java) | BadPacketsD | No | Yes | Sent an invalid rotation pitch outside the -90 to 90 range |
| [BadPacketsE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsE.java) | BadPacketsE | No | Yes | Sent too many movement packets without updating position |
| [BadPacketsF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsF.java) | BadPacketsF | No | Yes | Sent duplicate sprinting status |
| [BadPacketsG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsG.java) | BadPacketsG | No | Yes | Sent duplicate sneaking status |
| [BadPacketsH](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsH.java) | BadPacketsH | Yes | Yes | Sent unexpected sequence id |
| [BadPacketsI](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsI.java) | BadPacketsI | No | Yes | Claimed to be flying while unable to fly |
| [BadPacketsJ](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsJ.java) | BadPacketsJ | No | Yes | Rotation in use item packet did not match tick rotation |
| [BadPacketsK](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsK.java) | BadPacketsK | No | Yes | Sent spectate packets while not in spectator mode |
| [BadPacketsL](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsL.java) | BadPacketsL | No | Yes | Sent impossible dig packet |
| [BadPacketsM](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsM.java) | BadPacketsM | Yes | Yes | Tried to respawn while alive |
| [BadPacketsN](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsN.java) | BadPacketsN | No | Yes | Ignored or failed to accept a required server teleport |
| [BadPacketsO](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsO.java) | BadPacketsO | No | Yes | Responded with a keepalive ID that was not sent by the server |
| [BadPacketsP](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsP.java) | BadPacketsP | Yes | Yes | Invalid window click packet |
| [BadPacketsQ](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsQ.java) | BadPacketsQ | No | Yes | Sent a horse jump packet with an invalid entity, action, or boost value |
| [BadPacketsR](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsR.java) | BadPacketsR | Yes | Yes | Stopped sending position updates while still responding to transactions |
| [BadPacketsS](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsS.java) | BadPacketsS | No | Yes | Sent a window confirmation packet marked as not accepted |
| [BadPacketsU](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsU.java) | BadPacketsU | No | Yes | Sent impossible use item packet |
| [BadPacketsV](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsV.java) | BadPacketsV | Yes | Yes | Did not move far enough |
| [BadPacketsX](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsX.java) | BadPacketsX | Yes | Yes | Sent duplicate sneak or sprint input actions before the next movement packet |
| [BadPacketsY](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsY.java) | BadPacketsY | No | Yes | Sent out of bounds slot id |
| [BadPacketsZ](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/badpackets/BadPacketsZ.java) | BadPacketsZ | Yes | Yes | Sent duplicate player input packets in the same client tick |

## baritone

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [Baritone](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/baritone/Baritone.java) | Baritone | No | **No** | Detected Baritone like behavior |

## breaking

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [AirLiquidBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/AirLiquidBreak.java) | AirLiquidBreak | No | Yes | Breaking a block that cannot be broken |
| [FarBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/FarBreak.java) | FarBreak | Yes | Yes | Breaking blocks too far away |
| [FastBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/FastBreak.java) | FastBreak | No | Yes | Breaking blocks too quickly |
| [InvalidBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/InvalidBreak.java) | InvalidBreak | No | Yes | Sent impossible block face id |
| [MultiBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/MultiBreak.java) | MultiBreak | Yes | Yes | Tried to break multiple different blocks in the same movement tick |
| [NoSwingBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/NoSwingBreak.java) | NoSwingBreak | Yes | Yes | Did not swing while breaking block |
| [PositionBreakA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/PositionBreakA.java) | PositionBreakA | No | Yes | Tried to break a block face from an impossible eye position |
| [PositionBreakB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/PositionBreakB.java) | PositionBreakB | No | Yes | Cancelled block breaking with an invalid block face |
| [RotationBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/RotationBreak.java) | RotationBreak | Yes | Yes | Tried to break a block without looking at it |
| [WrongBreak](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/breaking/WrongBreak.java) | WrongBreak | No | Yes | Sent block break progress for a different block than the one being mined |

## chat

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [ChatA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/chat/ChatA.java) | ChatA | Yes | Yes | Sent a tab complete packet with no command or input text |
| [ChatB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/chat/ChatB.java) | ChatB | No | Yes | Invalid chat message |
| [ChatC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/chat/ChatC.java) | ChatC | Yes | Yes | Moving while chatting |
| [ChatD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/chat/ChatD.java) | ChatD | No | Yes | Chatting while chat is hidden |

## combat

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [Hitboxes](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/Hitboxes.java) | Hitboxes | No | Yes | Tried to hit an entity outside its valid hitbox |
| [InvalidInteractCursor](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/InvalidInteractCursor.java) | InvalidInteractCursor | No | Yes | Sent an entity interaction vector outside the target player's hitbox |
| [InvalidInteractTarget](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/InvalidInteractTarget.java) | InvalidInteractTarget | Yes | Yes | Interacted with non-existent entity |
| [MultiInteractA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/MultiInteractA.java) | MultiInteractA | Yes | Yes | Interacted with multiple entities in the same tick |
| [MultiInteractB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/MultiInteractB.java) | MultiInteractB | Yes | Yes | Sent multiple entity interaction packets with different hit positions in one tick |
| [Reach](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/Reach.java) | Reach | No | Yes | Attacked an entity from too far away |
| [SelfInteract](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/combat/SelfInteract.java) | SelfInteract | No | Yes | Interacted with self |

## crash

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [CrashA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashA.java) | CrashA | No | Yes | Sent a position outside the valid world bounds |
| [CrashB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashB.java) | CrashB | No | Yes | Sent creative mode inventory click packets while not in creative mode |
| [CrashC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashC.java) | CrashC | No | Yes | Sent non-finite position or rotation |
| [CrashD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashD.java) | CrashD | No | Yes | Clicking slots in lectern window |
| [CrashE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashE.java) | CrashE | No | Yes | Sent a client view distance below the minimum allowed value |
| [CrashF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashF.java) | CrashF | No | Yes | Sent an inventory click with an invalid button or slot value |
| [CrashG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashG.java) | CrashG | No | Yes | Sent negative sequence id |
| [CrashH](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashH.java) | CrashH | No | Yes | Sent a tab complete request with invalid or excessive length |
| [CrashI](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/crash/CrashI.java) | CrashI | No | Yes | Sent a bundle item selection with an invalid negative slot index |

## elytra

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [ElytraA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraA.java) | ElytraA | No | Yes | Started gliding while already gliding |
| [ElytraB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraB.java) | ElytraB | No | Yes | Started gliding without jumping |
| [ElytraC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraC.java) | ElytraC | No | Yes | Started gliding too frequently |
| [ElytraD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraD.java) | ElytraD | Yes | Yes | Started gliding without an elytra |
| [ElytraE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraE.java) | ElytraE | Yes | Yes | Started gliding while flying |
| [ElytraF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraF.java) | ElytraF | No | Yes | Started gliding while on ground |
| [ElytraG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraG.java) | ElytraG | Yes | Yes | Started gliding with levitation |
| [ElytraH](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraH.java) | ElytraH | Yes | Yes | Started gliding in vehicle |
| [ElytraI](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/elytra/ElytraI.java) | ElytraI | Yes | Yes | Started gliding in water |

## exploit

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [ExploitA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/exploit/ExploitA.java) | ExploitA | No | Yes | Too long item name in anvil |
| [ExploitB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/exploit/ExploitB.java) | ExploitB | No | Yes | Invalid book edit |

## groundspoof

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [NoFall](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/groundspoof/NoFall.java) | NoFall | No | Yes | Sent an on-ground packet while not colliding with the ground |

## misc

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [Post](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/misc/Post.java) | Post | No | Yes | Sent packets out of the expected movement tick order |
| [TransactionOrder](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/misc/TransactionOrder.java) | TransactionOrder | No | Yes | Sent transaction or ping responses in an invalid order |

## movement

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [NoSlow](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/movement/NoSlow.java) | NoSlow | No | Yes | Was not slowed while using an item |

## multiactions

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [MultiActionsA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsA.java) | MultiActionsA | Yes | Yes | Attacked while using an item |
| [MultiActionsB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsB.java) | MultiActionsB | Yes | Yes | Breaking blocks while using an item |
| [MultiActionsC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsC.java) | MultiActionsC | No | Yes | Clicked in inventory while moving |
| [MultiActionsD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsD.java) | MultiActionsD | No | Yes | Closed inventory while moving |
| [MultiActionsE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsE.java) | MultiActionsE | Yes | Yes | Swinging while using an item |
| [MultiActionsF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsF.java) | MultiActionsF | Yes | Yes | Interacting with a block and an entity in the same tick |
| [MultiActionsG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/multiactions/MultiActionsG.java) | MultiActionsG | Yes | Yes | Attacking or using items while rowing a boat |

## packetorder

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [PacketOrderA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderA.java) | PacketOrderA | Yes | Yes | Sent pickup and quick-move inventory clicks in an invalid order |
| [PacketOrderB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderB.java) | PacketOrderB | No | Yes | Did not swing for attack |
| [PacketOrderC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderC.java) | PacketOrderC | No | Yes | Sent INTERACT and INTERACT_AT entity packets in the wrong order |
| [PacketOrderD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderD.java) | PacketOrderD | Yes | Yes | Sent offhand entity interaction before the matching mainhand interaction |
| [PacketOrderE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderE.java) | PacketOrderE | Yes | Yes | Changed held item slot during another conflicting action |
| [PacketOrderF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderF.java) | PacketOrderF | Yes | Yes | Sent action packets after sneak or sprint input in an invalid order |
| [PacketOrderG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderG.java) | PacketOrderG | Yes | Yes | Managed hotbar or inventory while performing another conflicting action |
| [PacketOrderH](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderH.java) | PacketOrderH | Yes | Yes | Sent sprinting and sneaking state changes in an invalid packet order |
| [PacketOrderI](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderI.java) | PacketOrderI | Yes | Yes | Sent combat, use, release, or digging packets in an invalid tick order |
| [PacketOrderJ](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderJ.java) | PacketOrderJ | Yes | Yes | Sent use item after attacking without the expected interaction packet |
| [PacketOrderK](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderK.java) | PacketOrderK | Yes | Yes | Opened, clicked, or closed inventory in the wrong packet order |
| [PacketOrderL](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderL.java) | PacketOrderL | Yes | Yes | Sent drop, inventory open, or offhand swap packets in an invalid order |
| [PacketOrderM](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderM.java) | PacketOrderM | Yes | Yes | Sent use item and entity interaction packets in an invalid order |
| [PacketOrderN](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderN.java) | PacketOrderN | Yes | Yes | Sent use item and block place packets in an invalid order |
| [PacketOrderO](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderO.java) | PacketOrderO | Yes | Yes | Sent packets after movement before the expected client tick end |
| [PacketOrderP](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/packetorder/PacketOrderP.java) | PacketOrderP | Yes | **No** | Responded to chunk batch packets in an invalid transaction order |

## prediction

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [GroundSpoof](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/prediction/GroundSpoof.java) | GroundSpoof | No | Yes | Claimed to be on ground when predicted otherwise |
| [Simulation](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/prediction/OffsetHandler.java) | Simulation | No | Yes | Moved differently than predicted movement simulation |
| [Phase](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/prediction/Phase.java) | Phase | No | Yes | Moved into a solid block during movement prediction |

## scaffolding

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [AirLiquidPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/AirLiquidPlace.java) | AirLiquidPlace | No | Yes | Placed a block against an invalid support |
| [DuplicateRotPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/DuplicateRotPlace.java) | DuplicateRotPlace | Yes | Yes | Repeated the same rotation delta while placing blocks |
| [FabricatedPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/FabricatedPlace.java) | FabricatedPlace | No | Yes | Sent out of bounds cursor position |
| [FarPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/FarPlace.java) | FarPlace | No | Yes | Placing blocks from too far away |
| [InvalidPlaceCursor](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/InvalidPlaceCursor.java) | InvalidPlaceCursor | No | Yes | Sent invalid cursor position |
| [InvalidPlaceFace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/InvalidPlaceFace.java) | InvalidPlaceFace | No | Yes | Sent impossible block face id |
| [MultiPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/MultiPlace.java) | MultiPlace | Yes | Yes | Placed multiple blocks in a tick |
| [PositionPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/PositionPlace.java) | PositionPlace | No | Yes | Placed a block against a hidden face |
| [RotationPlace](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/scaffolding/RotationPlace.java) | RotationPlace | No | Yes | Placed a block while not looking at it |

## sprint

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [SprintA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintA.java) | SprintA | No | Yes | Sprinting with too low hunger |
| [SprintB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintB.java) | SprintB | Yes | Yes | Sprinting while sneaking or crawling |
| [SprintC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintC.java) | SprintC | Yes | Yes | Sprinting while using an item |
| [SprintD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintD.java) | SprintD | Yes | Yes | Started sprinting while having blindness |
| [SprintE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintE.java) | SprintE | Yes | Yes | Sprinting while colliding with a wall |
| [SprintF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintF.java) | SprintF | Yes | Yes | Sprinting while gliding |
| [SprintG](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/sprint/SprintG.java) | SprintG | Yes | Yes | Sprinting while in water |

## timer

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [NegativeTimer](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/timer/NegativeTimer.java) | NegativeTimer | Yes | Yes | Sent movement packets slower than the expected client tick rate |
| [TickTimer](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/timer/TickTimer.java) | TickTimer | No | Yes | Did not send client tick end packet |
| [Timer](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/timer/Timer.java) | TimerA | No | Yes | The players game is running faster than normal |
| [TimerLimit](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/timer/TimerLimit.java) | TimerLimit | No | Yes | The player has sent too many packets after high latency |
| [VehicleTimer](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/timer/VehicleTimer.java) | VehicleTimer | No | Yes | Sent vehicle movement packets faster than the expected client tick rate |

## vehicle

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [VehicleA](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleA.java) | VehicleA | No | Yes | Impossible input values |
| [VehicleB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleB.java) | VehicleB | No | Yes | Claimed to be in a vehicle while not in a vehicle |
| [VehicleC](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleC.java) | VehicleC | No | Yes | Moved a vehicle in a way that did not match predicted vehicle control |
| [VehicleD](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleD.java) | VehicleD | Yes | Yes | Jumped in a vehicle that cannot jump |
| [VehicleE](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleE.java) | VehicleE | Yes | Yes | Sent boat paddle states while not in a boat |
| [VehicleF](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/vehicle/VehicleF.java) | VehicleF | Yes | Yes | Sent incorrect boat paddle states |

## velocity

| Check | Config name | Experimental | Registered | Description |
| --- | --- | --- | --- | --- |
| [AntiExplosion](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/velocity/ExplosionHandler.java) | Explosion | No | Yes | Did not take the expected explosion knockback |
| [AntiKB](https://github.com/GrimAnticheat/Grim/blob/dc9f37c2a61d0b1caded41d877af95df4f059c6e/common/src/main/java/ac/grim/grimac/checks/impl/velocity/KnockbackHandler.java) | Knockback | No | Yes | Did not take the expected entity knockback |

AntiKB uses config name Knockback and alternative name AntiKnockback.
AntiExplosion uses config name Explosion; Timer uses config name TimerA.
Punishment groups match check/alternative names using substring matching, so inspect
the actual groups before adding or removing names. Autoclicker is only a punishment
placeholder, not a registered check.
