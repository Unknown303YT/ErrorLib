package com.riverstone.unknown303.errorlib;

import com.mojang.logging.LogUtils;
import com.riverstone.unknown303.errorlib.api.CustomRegistries;
import com.riverstone.unknown303.errorlib.api.event.CreativeTabsReadyEvent;
import com.riverstone.unknown303.errorlib.api.event.RegisterReadyEvent;
import com.riverstone.unknown303.errorlib.blocks.ModBlocks;
import com.riverstone.unknown303.errorlib.items.ModCreativeTabs;
import com.riverstone.unknown303.errorlib.items.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ErrorMod.MOD_ID)
public class ErrorMod {
    public static final String MOD_ID = "errorlib";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ErrorMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModCreativeTabs.register(modEventBus);

        CustomRegistries.register();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

//    @SubscribeEvent
//    public void onReady(RegisterReadyEvent event) {
//        CustomRegistries.register();
//        MinecraftForge.EVENT_BUS.post(new CreativeTabsReadyEvent());
//    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common Setup
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //Creative Mod Tabs Here
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        for (CustomRegistries.CustomRegistry registry : CustomRegistries.getRegistries()) {
            if (!CustomRegistries.isRegistryRegistered(registry)) {
                LOGGER.warn("Registry " + registry.getId() + "is not registered!");
            }
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
        }
    }
}
