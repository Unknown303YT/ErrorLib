package com.riverstone.unknown303.errorlib.api.general;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

public class ModInfo {
    private final String modId;
    private boolean hasLogger;
    private Logger logger;
    private boolean hasItemRegister;
    private DeferredRegister<Item> register;

    public ModInfo(String modId) {
        this.modId = modId;
        this.hasLogger = false;
        this.hasItemRegister = false;
    }

    public ModInfo logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public ModInfo itemRegister(DeferredRegister<Item> itemRegister) {
        this.register = itemRegister;
        return this;
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
