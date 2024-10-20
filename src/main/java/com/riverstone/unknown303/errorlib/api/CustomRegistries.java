package com.riverstone.unknown303.errorlib.api;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;

public class CustomRegistries {
    static List<CustomRegistry> registries = new ArrayList<>();

    public static CustomRegistry addRegistry(CustomRegistry registry) {
        registries.add(registry);
        return registry;
    }

    public static CustomRegistry getRegistry(ResourceLocation registryId) {
        boolean isValidId = false;
        for (CustomRegistry registry : registries) {
            if (registry.getId() == registryId) {
                isValidId = true;
                return registry;
            }
        }
        IllegalArgumentException error = new IllegalArgumentException("Error: No registry with ID " + registryId.toString() + " was found.");
        ErrorMod.LOGGER.error("Error: No registry with ID " + registryId.toString() + " was found.", error);
        throw error;
    }

    public static void register(IEventBus eventBus) {
        for (CustomRegistry registry : registries) {
            registry.register(eventBus);
        }
    }

    public interface CustomRegistry {
        public ResourceLocation getId();
        public void register(IEventBus eventBus);
    }
}
