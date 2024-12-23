package com.riverstone.unknown303.errorlib.api.helpers.registry;

import com.riverstone.unknown303.errorlib.api.general.ModInfo;
import com.riverstone.unknown303.errorlib.api.helpers.ErrorLibHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.List;

public class RegistryHelper extends ErrorLibHelper {
    public RegistryHelper(ModInfo modInfo) {
        super(modInfo);
    }

    public <V> IForgeRegistry<V> createRegistry(String registryId) {
        ResourceKey<Registry<V>> registryKey = key(registryId);
        DeferredRegister<V> REGISTRY = DeferredRegister.create(registryKey, this.getModId());
        return REGISTRY.makeRegistry(RegistryBuilder::new).get();
    }

    private <T> ResourceKey<Registry<T>> key(String registryId) {
        return ResourceKey.createRegistryKey(new ResourceLocation(this.getModId(), registryId));
    }

    public <E> List<E> getValidRegistrations(IForgeRegistry<E> reg) {
        return reg.getValues().stream().toList();
    }

    public <E> E getRegistration(IForgeRegistry<E> reg, String registryId) {
        return reg.getValue(new ResourceLocation(this.getModId(), registryId));
    }
}
