package com.riverstone.unknown303.errorlib.api.helpers.trim;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class ArmorTrimDatagen extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();

    protected ArmorTrimDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Objects.requireNonNull(getModId())));
    }

    // MUST BE OVERRIDDEN
    protected static String getModId() {
        return null;
    }
}
