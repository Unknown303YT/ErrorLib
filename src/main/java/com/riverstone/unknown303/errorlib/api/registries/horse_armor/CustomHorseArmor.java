package com.riverstone.unknown303.errorlib.api.registries.horse_armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class CustomHorseArmor extends HorseArmorItem {
    public CustomHorseArmor(int protection, String namespace, String identifier, Properties properties) {
        this(protection, new ResourceLocation(namespace, identifier), properties);
    }

    public CustomHorseArmor(int protection, ResourceLocation resourceLocation, Properties properties) {
        super(protection, resourceLocation, properties);
    }
}
