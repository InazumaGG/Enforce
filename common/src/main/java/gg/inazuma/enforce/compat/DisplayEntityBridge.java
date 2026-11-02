package gg.inazuma.enforce.compat;

import ac.grim.grimac.GrimAPI;
import ac.grim.grimac.utils.anticheat.LogUtil;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/** Optional Core display lookup through the public Grim API's function registry. */
public final class DisplayEntityBridge {
    private static final String FUNCTION = "enforce:display-entity:v1";
    private static final AtomicBoolean REPORTED_FAILURE = new AtomicBoolean();

    private DisplayEntityBridge() {
    }

    public static boolean isDisplayEntity(UUID viewer, int entityId) {
        Function<Object, Object> lookup = GrimAPI.INSTANCE.getExternalAPI().getFunction(FUNCTION);
        if (lookup == null || viewer == null) return false;
        try {
            // Contract: immutable (viewer UUID, target entity ID) entry -> Boolean.
            // The provider must use thread-safe registries, without Bukkit/world access.
            return Boolean.TRUE.equals(lookup.apply(Map.entry(viewer, entityId)));
        } catch (RuntimeException failure) {
            if (REPORTED_FAILURE.compareAndSet(false, true)) {
                LogUtil.error("Core display lookup failed; combat checks remain active.", failure);
            }
            return false;
        }
    }
}
