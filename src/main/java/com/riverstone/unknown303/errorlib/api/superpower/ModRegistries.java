package com.riverstone.unknown303.errorlib.api.superpower;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class ModRegistries {
    public static IForgeRegistry<Ability> ABILITY;

    static {
        RegistryManager.ACTIVE.
        ABILITY = RegistryManager.ACTIVE.getRegistry(ModRegistryKeys.ABILITY);
    }
}
