package com.riverstone.unknown303.errorlib.api.helpers.registry;

import com.riverstone.unknown303.errorlib.ErrorMod;
import com.riverstone.unknown303.errorlib.api.ability.Ability;
import com.riverstone.unknown303.errorlib.api.general.ModInfo;
import com.riverstone.unknown303.errorlib.api.helpers.ErrorLibHelper;
import com.riverstone.unknown303.errorlib.items.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.List;
import java.util.function.Supplier;

public class RegistryHelper extends ErrorLibHelper {
    public RegistryHelper(ModInfo modInfo) {
        super(modInfo);
    }

    /**
     * Should be used if you want to make mods be able to register variables and later access those variables.
     * @param registryId The string id of your custom registry, not including the namespace.
     * @param type Used to set the class the {@link IForgeRegistry<T> IForgeRegistry} handles.<br> Intended Use (replace Ability with your {@link IForgeRegistry IForgeRegistry} type: <pre><code>createRegistry("ability", Ability.class)</code></pre>
     */
    public <T> IForgeRegistry<T> createRegistry(String registryId, Class<T> type) {
        ResourceKey<Registry<T>> registryKey = key(registryId, type);
        DeferredRegister<T> REGISTRY = DeferredRegister.create(registryKey, this.getModId());
        return REGISTRY.makeRegistry(RegistryBuilder::new).get();
    }

    /**
     * Used in {@link #createRegistry(String, Supplier) createRegistry} to make the ResourceKey for the {@link IForgeRegistry<T> IForgeRegistry}.
     */
    private <T> ResourceKey<Registry<T>> key(String registryId, Class<T> type) {
        return ResourceKey.createRegistryKey(new ResourceLocation(this.getModId(), registryId));
    }

    public <T> List<T> getValidRegistrations(IForgeRegistry<T> reg, Class<T> type) {
        return reg.getValues().stream().toList();
    }

    public <T> T getRegistration(IForgeRegistry<T> reg, String registryId, Class<T> type) {
        return reg.getValue(new ResourceLocation(this.getModId(), registryId));
    }
}
