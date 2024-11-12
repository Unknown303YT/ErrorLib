package com.riverstone.unknown303.errorlib.api.general;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ModToken {
    String modId;
    IEventBus eventBus;

    HashMap<String, CustomRegistry> registries = new HashMap<>();
    HashMap<String, Boolean> isRegistered = new HashMap<>();
    HashMap<String, CustomRegistry> enabledRegistries = new HashMap<>();

    public ModToken(String modId, IEventBus eventBus) {
        this.modId = modId;
        this.eventBus = eventBus;
    }

    public String getModId() {
        return modId;
    }

    public IEventBus getEventBus() {
        return eventBus;
    }

    public CustomRegistry createRegistry(CustomRegistry registry) {
        registries.put(registry.getId().toString(), registry);
        isRegistered.put(registry.getId().toString(), false);
        return registry;
    }

    public void enableRegistry(CustomRegistry registry) {
        if (!registries.containsKey(registry.getId().toString())) {
            ErrorMod.LOGGER.error("Registry " + registry.getId().toString() + " is not already registered. Please register it first.");
            return;
        }
        registries.put(registry.getId().toString(), registry);
        enabledRegistries.put(registry.getId().toString(), registry);
    }

    public List<CustomRegistry> getRegistries() {
        return registries.values().stream().toList();
    }

    public HashMap<String, CustomRegistry> getEnabledRegistries() {
        return enabledRegistries;
    }

    public CustomRegistry getRegistry(ResourceLocation registryId) {
        return getRegistry(registryId.toString());
    }

    public CustomRegistry getRegistry(String registryId) {
        boolean isValidId = false;
        for (CustomRegistry registry : getRegistries()) {
            if (registry.getId().toString().equals(registryId)) {
                isValidId = true;
                return registry;
            }
        }
        IllegalArgumentException error = new IllegalArgumentException("Error: No registry with ID " + registryId.toString() + " was found.");
        ErrorMod.LOGGER.error("Error: No registry with ID " + registryId.toString() + " was found.", error);
        throw error;
    }

    public void register() {
        for (String s : getEnabledRegistries().keySet()) {
            CustomRegistry registry = getRegistry(s);
            registry.register();
            isRegistered.put(registry.getId().toString(), true);
            ErrorMod.LOGGER.debug("REGISTRY " + registry.getId().toString() + " SUCCESSFULLY REGISTERED.");
        }
    }

    public boolean isRegistryRegistered(CustomRegistry registry) {
        return isRegistryRegistered(registry.getId().toString());
    }

    public boolean isRegistryRegistered(String registryId) {
        return isRegistered.get(registryId);
    }
}
