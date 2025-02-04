package com.riverstone.unknown303.errorlib.api.tools;

import com.google.common.collect.Sets;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToolUtils {
    public static final UUID BASE_ATTACK_REACH_UUID =
            UUID.fromString("556345bf-bfd4-48cc-a1ef-73658ec3af6a");
    public static final Set<ToolAction> DEFAULT_DAGGER_ACTIONS = of(ToolActions.SWORD_DIG);

    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }
}
