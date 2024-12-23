package com.riverstone.unknown303.errorlib.api.general;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

public class ModInfo {
    private final String modId;
    private final Logger logger;
    private final DeferredRegister<Item> register;

    public ModInfo(String modId, Logger logger, DeferredRegister<Item> register) {
        this.modId = modId;
        this.logger = logger;
        this.register = register;
    }

    public String getModId() {
        return this.modId;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public DeferredRegister<Item> getRegister() {
        return this.register;
    }
}
