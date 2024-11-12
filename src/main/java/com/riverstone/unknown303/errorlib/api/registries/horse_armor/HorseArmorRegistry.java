package com.riverstone.unknown303.errorlib.api.registries.horse_armor;

import com.riverstone.unknown303.errorlib.api.general.CustomRegistry;
import com.riverstone.unknown303.errorlib.api.general.ModToken;
import com.riverstone.unknown303.errorlib.api.misc.CustomArmorMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HorseArmorRegistry implements CustomRegistry {
    ModToken token;
    final DeferredRegister<Item> HORSE_ARMOR_ITEMS;
    ResourceLocation registryId;

    public HorseArmorRegistry(ModToken token, String registryPath) {
        this.token = token;
        this.registryId = new ResourceLocation(token.getModId(), registryPath);
        HORSE_ARMOR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, token.getModId());
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
                () -> new CustomHorseArmor(protection, this.token.getModId(), material.getPath(), properties.stacksTo(1)));
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
                () -> new CustomHorseArmor(protection, this.token.getModId(), material.getName(), properties.stacksTo(1)));
    }

    public RegistryObject<Item> registerHorseArmor(String armorType, int protection, Item.Properties properties) {
        return HORSE_ARMOR_ITEMS.register(armorType + "_horse_armor",
                () -> new CustomHorseArmor(protection, this.token.getModId(), armorType, properties.stacksTo(1)));
    }

    @Override
    public ResourceLocation getId() {
        return registryId;
    }

    @Override
    public void register() {
        HORSE_ARMOR_ITEMS.register(this.token.getEventBus());
    }
}
