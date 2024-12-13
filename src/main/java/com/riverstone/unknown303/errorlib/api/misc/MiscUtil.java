package com.riverstone.unknown303.errorlib.api.misc;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class MiscUtil {
    public static Component createTranslatableComponent(String type, ResourceLocation id) {
        return Component.translatable(Util.makeDescriptionId(type, id));
    }
}
