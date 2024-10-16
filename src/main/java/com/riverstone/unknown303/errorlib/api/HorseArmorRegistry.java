package com.riverstone.unknown303.errorlib.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HorseArmorRegistry implements CustomRegistries.CustomRegistry {
    final DeferredRegister<Item> HORSE_ARMOR_ITEMS;
    ResourceLocation registryId;

    public HorseArmorRegistry(String modId, String registryPath) {
        this.registryId = new ResourceLocation(modId, registryPath);
        HORSE_ARMOR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    }

    public RegistryObject<Item> registerHorseArmor(ArmorMaterial material,
                                                       Item.Properties properties) {
        int protection;
        if (material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                material.getDefenseForType(ArmorItem.Type.BOOTS) == 11 &&
            material != ArmorMaterials.DIAMOND) {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS) + 2;
        } else {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS);
        }
        return HORSE_ARMOR_ITEMS.register(material.getName() + "_horse_armor",
                () -> new HorseArmorItem(protection, material.getName(), properties));
    }

    @Override
    public ResourceLocation getId() {
        return registryId;
    }

    @Override
    public void register(IEventBus eventBus) {
        HORSE_ARMOR_ITEMS.register(eventBus);
    }
}
