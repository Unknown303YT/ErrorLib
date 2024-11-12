package com.riverstone.unknown303.errorlib.api.general;

import static com.riverstone.unknown303.errorlib.ErrorMod.LOGGER;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ErrorAPI {
    private static final List<ModToken> REGISTERED_MODS = new ArrayList<>();

    private static void registerModTokens() {
        for (ModToken token : REGISTERED_MODS) {
            token.register();
            LOGGER.debug("Mod " + token.getModId() + " has been registered.");
        }
    }

    public static void registerMod(ModToken token) {
        REGISTERED_MODS.add(token);
    }

    @SubscribeEvent
    public static void register() {
        LOGGER.debug("Registering ModTokens");
        for (ModToken token : REGISTERED_MODS) {
            HashMap<String, CustomRegistry> map = token.getEnabledRegistries();
            for (String id : map.keySet()) {
                CustomRegistry registry = token.getRegistry(id);
                boolean value = token.getEnabledRegistries().containsValue(registry);
                if (!value) {
                    LOGGER.warn("Registry " + registry.getId().toString() + " is not enabled and will not be registered.");
                }
            }
        }
        registerModTokens();
        for (ModToken token : REGISTERED_MODS) {
            for (CustomRegistry registry : token.getRegistries()) {
                if (!token.isRegistryRegistered(registry)) {
                    LOGGER.warn("Registry " + registry.getId() + " was not registered!");
                }
            }
        }
    }
}