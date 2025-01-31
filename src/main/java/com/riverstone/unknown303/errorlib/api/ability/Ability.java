package com.riverstone.unknown303.errorlib.api.ability;

import com.riverstone.unknown303.errorlib.api.ability.origin.AbilityOrigin;
import com.riverstone.unknown303.errorlib.api.helpers.component.ComponentHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Ability {
    private final AbilityOrigin origin;
    private final ComponentHelper componentHelper;

    public Ability(AbilityOrigin origin, ComponentHelper componentHelper) {
        this.origin = origin;
        this.componentHelper = componentHelper;
    }

    public abstract void enable(Level level, Player owner);

    public abstract void tick(Level level, Player owner);

    public abstract void disable(Level level, Player owner);

    public Component getAbilityName() {
        return componentHelper.createTranslationWithKey("ability", getAbilityId().getPath(), "name");
    }

    public Component getAbilityDescription() {
        return componentHelper.createTranslationWithKey("ability", getAbilityId().getPath(), "description");
    }

    public ResourceLocation getAbilityId() {
        return ErrorRegistries.ABILITIES.getKey(this);
    }

    public static enum AbilityType {
        ACTION,
        HELD,
        TOGGLE,
        CONSTANT;
    }

    public enum AbilityContext {
        SUPERPOWER,
        ARMOR,
        IN_HAND;

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
