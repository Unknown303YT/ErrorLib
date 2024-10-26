package com.riverstone.unknown303.errorlib.api;

import com.riverstone.unknown303.errorlib.ErrorMod;
import it.unimi.dsi.fastutil.Hash;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomRegistries {
    static HashMap<String, CustomRegistry> registries = new HashMap<>();
    static HashMap<String, Boolean> isEnabled = new HashMap<>();
    static HashMap<String, Boolean> isRegistered = new HashMap<>();

    public static CustomRegistry createRegistry(CustomRegistry registry) {
        registries.put(registry.getId().toString(), registry);
        isEnabled.put(registry.getId().toString(), false);
        isRegistered.put(registry.getId().toString(), false);
        return registry;
    }

    public static void enableRegistry(CustomRegistry registry) {
        if (!registries.containsKey(registry.getId().toString())) {
            ErrorMod.LOGGER.error("Registry " + registry.getId().toString() + " is not already registered. Please register it first.");
            return;
        }
        registries.put(registry.getId().toString(), registry);
        isEnabled.put(registry.getId().toString(), true);
    }

    public static List<CustomRegistry> getRegistries() {
        return registries.values().stream().toList();
    }

    public static HashMap<String, Boolean> getEnabledRegistries() {
        return isEnabled;
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
        for (String s : getEnabledRegistries().keySet()) {
            CustomRegistry registry = getRegistry(s);
            registry.register();
            isRegistered.put(registry.getId().toString(), true);
            ErrorMod.LOGGER.debug("REGISTRY " + registry.getId().toString() + " SUCCESSFULLY REGISTERED.");
        }
    }

    public static boolean isRegistryRegistered(CustomRegistry registry) {
        return isRegistered.get(registry.getId().toString());
    }

    public interface CustomRegistry {
        public ResourceLocation getId();
        public void register();
    }
}
