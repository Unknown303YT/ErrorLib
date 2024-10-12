package com.riverstone.unknown303.errorlib.items;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ErrorMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ERROR_TAB =
            CREATIVE_TABS.register("error_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.CRAFTING_TABLE)) //Example
                            .title(Component.translatable("creativetab.errorlib.error_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(Blocks.CRAFTING_TABLE); //Example
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
