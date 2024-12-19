package com.riverstone.unknown303.errorlib.api.ability;

import com.riverstone.unknown303.errorlib.api.misc.MiscUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

public class Ability {
    String name;
    Component translation;

    public Ability() {
        this.name = Objects.requireNonNull(ModRegistries.ABILITIES.getKey(this)).getPath();
        this.translation = createAbilityComponent(ModRegistries.ABILITIES.getKey(this));
    }

    public String getDisplayName() {
        return this.translation.getString();
    }

    public static Component createAbilityComponent(ResourceLocation location) {
        return MiscUtil.createTranslatableComponent("ability", location);
    }

    public static enum AbilityType {
        ACTION,
        HELD,
        TOGGLE,
        CONSTANT;
    }

    public static enum AbilityContext {
        SUPERPOWER,
        SUIT,
        COMBAT,
        MAIN_HAND,
        OFF_HAND;

        public static AbilityContext fromString(String name) {
            for (AbilityContext context : AbilityContext.values()) {
                if (context.toString().equals(name)) {
                    return context;
                }
            }

            return null;
        }
    }
}
