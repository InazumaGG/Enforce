package gg.inazuma.enforce.checks;

import ac.grim.grimac.api.AbstractProcessor;
import ac.grim.grimac.player.GrimPlayer;
import com.google.common.collect.ImmutableClassToInstanceMap;

/** Registers Enforce checks before Grim builds each player's listener dispatch arrays. */
public final class EnforceChecks {
    private EnforceChecks() {
    }

    public static void register(GrimPlayer player, ImmutableClassToInstanceMap.Builder<AbstractProcessor> checks) {
        // Add reviewed checks here: checks.put(MyCheck.class, new MyCheck(player));
        // Each check instance belongs to this player; see docs/enforce/custom-checks.md.
    }
}
