package com.riverstone.unknown303.errorlib.api.misc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;

public interface CustomArmorMaterial extends ArmorMaterial {
    public ResourceLocation getId();
    default public String getPath() {
        return getId().getPath();
    };
    @Override
    default public String getName() {
        return getId().toString();
    }
}
