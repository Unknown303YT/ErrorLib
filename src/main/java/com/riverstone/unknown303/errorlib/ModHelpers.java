package com.riverstone.unknown303.errorlib;

import com.riverstone.unknown303.errorlib.api.general.ModInfo;
import com.riverstone.unknown303.errorlib.api.helpers.registry.RegistryHelper;
import com.riverstone.unknown303.errorlib.items.ModItems;

public class ModHelpers {
    public static final ModInfo MOD_INFO =
            new ModInfo(ErrorMod.MOD_ID, ErrorMod.LOGGER, ModItems.ITEMS);

    public static final RegistryHelper REGISTRY_HELPER =
            new RegistryHelper(MOD_INFO);
}
