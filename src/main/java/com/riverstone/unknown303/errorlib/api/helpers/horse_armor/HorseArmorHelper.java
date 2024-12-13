package com.riverstone.unknown303.errorlib.api.helpers.horse_armor;

import com.riverstone.unknown303.errorlib.api.misc.CustomArmorMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HorseArmorHelper {
    String modId;
    DeferredRegister<Item> register;

    public HorseArmorHelper(String modId, DeferredRegister<Item> register) {
        this.modId = modId;
        this.register = register;
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
        return this.register.register(material.getPath() + "_horse_armor",
                () -> new HorseArmorItem(protection, horseArmorTexture(material.getPath()), properties.stacksTo(1)));
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
        return this.register.register(material.getName() + "_horse_armor",
                () -> new HorseArmorItem(protection, material.getName(), properties.stacksTo(1)));
    }

    public RegistryObject<Item> registerHorseArmor(String armorType, int protection, Item.Properties properties) {
        return this.register.register(armorType + "_horse_armor",
                () -> new HorseArmorItem(protection, horseArmorTexture(armorType), properties.stacksTo(1)));
    }

    private ResourceLocation horseArmorTexture(String armorId) {
        return new ResourceLocation(this.modId, "textures/entity/horse/armor/horse_armor_" + armorId + ".png");
    }
}
