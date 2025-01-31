package com.riverstone.unknown303.errorlib.api.ability.origin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class ArmorOrigin implements AbilityOrigin {
    private final ItemLike abilityProvider;
    private final Color abilityColor;

    public ArmorOrigin(ItemLike abilityProvider, Color abilityColor) {
        this.abilityProvider = abilityProvider;
        this.abilityColor = abilityColor;
    }

    @Override
    public Type getAbilityType() {
        return Type.ARMOR;
    }

    @Override
    public Color getAbilityColor() {
        return abilityColor;
    }

    @Override
    public boolean isAvailable(Player player) {
        for (ItemStack stack : player.getInventory().armor) {
            if (stack.is(abilityProvider.asItem())) {
                return true;
            }
        }

        return false;
    }
}
