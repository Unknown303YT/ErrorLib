package com.riverstone.unknown303.errorlib.api.ability.origin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class InHandOrigin implements AbilityOrigin {
    private final ItemLike abilityProvider;
    private final Color abilityColor;

    public InHandOrigin(ItemLike abilityProvider, Color abilityColor) {
        this.abilityProvider = abilityProvider;
        this.abilityColor = abilityColor;
    }

    @Override
    public Type getAbilityType() {
        return Type.IN_HAND;
    }

    @Override
    public Color getAbilityColor() {
        return abilityColor;
    }

    @Override
    public boolean isAvailable(Player player) {
        return player.getInventory().getSelected().is(abilityProvider.asItem()) || player.getOffhandItem().is(abilityProvider.asItem());
    }
}
