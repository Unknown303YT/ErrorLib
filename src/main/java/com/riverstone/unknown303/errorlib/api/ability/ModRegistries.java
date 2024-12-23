package com.riverstone.unknown303.errorlib.api.ability;

import com.riverstone.unknown303.errorlib.ErrorMod;
import com.riverstone.unknown303.errorlib.ModHelpers;
import com.riverstone.unknown303.errorlib.api.helpers.registry.RegistryHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRegistries {
    public static final IForgeRegistry<Ability> ABILITIES =
            ModHelpers.REGISTRY_HELPER.createRegistry("ability");
}
