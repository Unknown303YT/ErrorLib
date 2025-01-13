package com.riverstone.unknown303.errorlib.api.general;

import com.riverstone.unknown303.errorlib.ErrorMod;
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
        this.hasLogger = true;
        this.logger = logger;
        return this;
    }

    public ModInfo itemRegister(DeferredRegister<Item> itemRegister) {
        this.hasItemRegister = true;
        this.register = itemRegister;
        return this;
    }

    public String getModId() {
        return this.modId;
    }

    public Logger getLogger() {
        if (hasLogger) {
            return this.logger;
        } else {
            IllegalStateException exception = new IllegalStateException("Logger not provided to ModInfo");
            ErrorMod.LOGGER.error("Logger not provided to ModInfo", exception);
            throw exception;
        }
    }

    public DeferredRegister<Item> getRegister() {
        if (hasItemRegister) {
            return this.register;
        } else {
            IllegalStateException exception = new IllegalStateException("Register not provided to ModInfo");
            ErrorMod.LOGGER.error("Register not provided to ModInfo", exception);
            throw exception;
        }
    }
}
