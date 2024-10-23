package com.riverstone.unknown303.errorlib.api;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomRegistries {
    static HashMap<String, CustomRegistry> registries = new HashMap<>();
    static HashMap<CustomRegistry, Boolean> isRegistered = new HashMap<>();

    public static CustomRegistry createRegistry(CustomRegistry registry) {
        registries.put(registry.getId().toString(), registry);
        isRegistered.put(registry, false);
        return registry;
    }

    public static void enableRegistry(CustomRegistry registry) {
        if (!registries.containsKey(registry.getId().toString())) {
            ErrorMod.LOGGER.error("Registry " + registry.getId().toString() + " is not already registered. Please register it first.");
            return;
        }
        registries.put(registry.getId().toString(), registry);
    }

    public static List<CustomRegistry> getRegistries() {
        return registries.values().stream().toList();
    }

    public static CustomRegistry getRegistry(ResourceLocation registryId) {
        return getRegistry(registryId.toString());
    }

    public static CustomRegistry getRegistry(String registryId) {
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

    public static void register() {
        for (CustomRegistry registry : getRegistries()) {
            registry.register();
            isRegistered.put(registry, true);
            ErrorMod.LOGGER.debug("REGISTRY " + registry.getId().toString() + " SUCCESSFULLY REGISTERED.");
        }
    }

    public static boolean isRegistryRegistered(CustomRegistry registry) {
        return isRegistered.get(registry);
    }

    public interface CustomRegistry {
        public ResourceLocation getId();
        public void register();
    }
}
