package com.riverstone.unknown303.errorlib.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;

public class CustomRegistries {
    static List<CustomRegistry> registries = new ArrayList<>();

    public static void register(CustomRegistry registry) {
        registries.add(registry);
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
