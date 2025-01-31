package com.riverstone.unknown303.errorlib.api.helpers.component;

import com.riverstone.unknown303.errorlib.api.general.ModInfo;
import com.riverstone.unknown303.errorlib.api.helpers.ErrorLibHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class ComponentHelper extends ErrorLibHelper {
    public ComponentHelper(ModInfo modInfo) {
        super(modInfo);
    }

    public Component createTranslation(String type, String id) {
        return Component.translatable(new ResourceLocation(this.getModId(), id).toLanguageKey(type));
    }

    public Component createTranslationWithKey(String type, String id, String key) {
        return Component.translatable(new ResourceLocation(this.getModId(), id).toLanguageKey(type, key));
    }

    public Component combineComponents(MutableComponent base, MutableComponent addition) {
        return base.append(addition);
    }

    public Component combineComponents(MutableComponent base, List<MutableComponent> additions) {
        MutableComponent toReturn = base;
        for (MutableComponent addition : additions) {
            toReturn.append(addition);
        }

        return toReturn;
    }
}
