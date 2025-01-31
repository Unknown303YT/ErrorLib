package com.riverstone.unknown303.errorlib.api.ability;

import com.riverstone.unknown303.errorlib.ModHelpers;
import net.minecraftforge.registries.IForgeRegistry;

public class ErrorRegistries {
    public static final IForgeRegistry<Ability> ABILITIES =
            ModHelpers.REGISTRY_HELPER.createRegistry("ability", Ability.class);
}
