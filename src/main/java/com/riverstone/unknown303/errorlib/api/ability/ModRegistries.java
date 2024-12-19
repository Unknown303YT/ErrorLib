package com.riverstone.unknown303.errorlib.api.ability;

import com.riverstone.unknown303.errorlib.ErrorMod;
import com.riverstone.unknown303.errorlib.api.helpers.registry.RegistryHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRegistries {
    private static final RegistryHelper HELPER =
            new RegistryHelper(ErrorMod.MOD_ID);

    public static final IForgeRegistry<Ability> ABILITIES =
            HELPER.createRegistry("ability");
}
