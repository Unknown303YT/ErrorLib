package com.riverstone.unknown303.errorlib.items;

import com.riverstone.unknown303.errorlib.ErrorMod;
import com.riverstone.unknown303.errorlib.api.tools.DaggerItem;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ErrorMod.MOD_ID);

//    public static final RegistryObject<Item> CORRUPTED_HEART = ITEMS.register("corrupted_heart",
//            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
//                    .stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new DaggerItem(Tiers.DIAMOND, 3, -2F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
