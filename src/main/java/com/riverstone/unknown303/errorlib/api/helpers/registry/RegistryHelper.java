package com.riverstone.unknown303.errorlib.api.helpers.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.List;

public class RegistryHelper {
    String modId;

    public RegistryHelper(String modId) {
        this.modId = modId;
    }

    public <V> IForgeRegistry<V> createRegistry(String registryId) {
        ResourceKey<Registry<V>> registryKey = key(registryId);
        DeferredRegister<V> REGISTRY = DeferredRegister.create(registryKey, this.modId);
        return REGISTRY.makeRegistry(RegistryBuilder::new).get();
    }

    private <T> ResourceKey<Registry<T>> key(String registryId) {
        return ResourceKey.createRegistryKey(new ResourceLocation(this.modId, registryId));
    }

    public <E> List<E> getValidRegistrations(IForgeRegistry<E> reg) {
        return reg.getValues().stream().toList();
    }

    public <E> E getRegistration(IForgeRegistry<E> reg, String registryId) {
        return reg.getValue(new ResourceLocation(this.modId, registryId));
    }
}
