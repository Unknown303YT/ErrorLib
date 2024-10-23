package com.riverstone.unknown303.errorlib.api.registries.horse_armor;

import com.riverstone.unknown303.errorlib.api.CustomArmorMaterial;
import com.riverstone.unknown303.errorlib.api.CustomRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HorseArmorRegistry implements CustomRegistries.CustomRegistry {
    String modId;
    final DeferredRegister<Item> HORSE_ARMOR_ITEMS;
    ResourceLocation registryId;
    IEventBus eventBus;

    public HorseArmorRegistry(String modId, String registryPath, IEventBus eventBus) {
        this.modId = modId;
        this.registryId = new ResourceLocation(modId, registryPath);
        HORSE_ARMOR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
        this.eventBus = eventBus;
    }

    public RegistryObject<Item> registerHorseArmor(CustomArmorMaterial material,
                                                   Item.Properties properties) {
        int protection;
        if (material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                material.getDefenseForType(ArmorItem.Type.BOOTS) == 11) {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS) + 2;
        } else {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS);
        }
        return HORSE_ARMOR_ITEMS.register(material.getPath() + "_horse_armor",
                () -> new CustomHorseArmor(protection, this.modId, material.getPath(), properties.stacksTo(1)));
    }

    public RegistryObject<Item> registerVanillaHorseArmor(ArmorMaterial material,
                                                   Item.Properties properties) {
        int protection;
        if (material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                material.getDefenseForType(ArmorItem.Type.BOOTS) == 11 &&
                material == ArmorMaterials.NETHERITE) {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS) + 2;
        } else {
            protection = material.getDefenseForType(ArmorItem.Type.CHESTPLATE) +
                    material.getDefenseForType(ArmorItem.Type.BOOTS);
        }
        return HORSE_ARMOR_ITEMS.register(material.getName() + "_horse_armor",
                () -> new CustomHorseArmor(protection, this.modId, material.getName(), properties.stacksTo(1)));
    }

    @Override
    public ResourceLocation getId() {
        return registryId;
    }

    @Override
    public void register() {
        HORSE_ARMOR_ITEMS.register(this.eventBus);
    }
}
