package com.riverstone.unknown303.errorlib.api.ability.origin;

import net.minecraft.world.entity.player.Player;

public interface AbilityOrigin {
    public Type getAbilityType();
    public Color getAbilityColor();
    public boolean isAvailable(Player player);

    public enum Type {
        SUPERPOWER,
        AMULET,
        ARMOR,
        IN_HAND;
    }

    public enum Color {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        CYAN,
        BLUE,
        PURPLE,
        PINK,
        WHITE,
        GOLD,
        SILVER,
        BRONZE,
        BLACK;
    }
}
