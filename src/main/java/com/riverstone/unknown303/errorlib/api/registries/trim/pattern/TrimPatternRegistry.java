package com.riverstone.unknown303.errorlib.api.registries.trim.pattern;

import com.riverstone.unknown303.errorlib.api.general.CustomRegistry;
import com.riverstone.unknown303.errorlib.api.general.ModToken;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class TrimPatternRegistry implements CustomRegistry {
    ModToken token;
    final DeferredRegister<Item> TRIM_PATTERN_ITEMS;
    ResourceLocation registryId;
    private static final LinkedHashMap<ResourceKey<TrimPattern>, Item> trimPatterns = new LinkedHashMap<>();

    public TrimPatternRegistry(ModToken token, String registryPath) {
        this.token = token;
        this.registryId = new ResourceLocation(token.getModId(), registryPath);
        TRIM_PATTERN_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, token.getModId());
    }

    public RegistryObject<Item> registerTrimPattern(String id) {
        ResourceLocation resourceLocation = new ResourceLocation(this.token.getModId(), id);
        ResourceKey<TrimPattern> trimPattern = ResourceKey.create(Registries.TRIM_PATTERN,
                resourceLocation);
        RegistryObject<Item> toReturn = TRIM_PATTERN_ITEMS.register(id + "_armor_trim_smithing_template",
                () -> SmithingTemplateItem.createArmorTrimTemplate(trimPattern));
        trimPatterns.put(trimPattern, toReturn.get());
        return toReturn;
    }

    public static void bootstrap(BootstapContext<TrimPattern> context) {
        for (ResourceKey<TrimPattern> key : trimPatterns.keySet()) {
            Item item = trimPatterns.get(key);
            register(context, item, key);
        }
    }

    private static void register(BootstapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())));
        context.register(key, trimPattern);
    }

    @Override
    public ResourceLocation getId() {
        return registryId;
    }

    @Override
    public void register() {
        TRIM_PATTERN_ITEMS.register(token.getEventBus());
    }
}
