package com.riverstone.unknown303.errorlib.api.registries.trim;

import com.riverstone.unknown303.errorlib.api.general.ModToken;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ArmorTrimDatagen extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();

    public ArmorTrimDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ModToken token) {
        super(output, registries, BUILDER, Set.of(token.getModId()));
    }
}
