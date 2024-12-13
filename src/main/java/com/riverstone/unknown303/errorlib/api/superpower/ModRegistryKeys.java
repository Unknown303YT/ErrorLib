package com.riverstone.unknown303.errorlib.api.superpower;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ModRegistryKeys {
    public static final ResourceKey<Registry<Ability>> ABILITY = key("ability");
    private static <T> ResourceKey<Registry<T>> key(String name) {
        return ResourceKey.createRegistryKey(new ResourceLocation(ErrorMod.MOD_ID, name));
    }
}
