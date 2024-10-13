package com.riverstone.unknown303.errorlib.items;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ErrorMod.MOD_ID);

    public static final RegistryObject<Item> CORRUPTED_HEART = ITEMS.register("corrupted_heart",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .stacksTo(1).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
