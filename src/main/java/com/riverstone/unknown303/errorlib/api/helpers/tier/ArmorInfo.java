package com.riverstone.unknown303.errorlib.api.helpers.tier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

public class ArmorInfo {
    private final int durabilityMultiplier;
    private final int[] protection;
    private final float toughness;
    private final int enchantability;
    private float knockbackResistance;
    private Lazy<SoundEvent> equipSound;
    private Ingredient repairIngredient;

    public ArmorInfo(int durabilityMultiplier, int[] protection,
                    float toughness, int enchantability) {
        this.durabilityMultiplier = durabilityMultiplier;
        this.protection = protection;
        this.toughness = toughness;
        this.enchantability = enchantability;
        this.knockbackResistance = 0.0F;
        this.equipSound = Lazy.of(() -> SoundEvents.EMPTY);
        this.repairIngredient = Ingredient.EMPTY;
    }

    public ArmorInfo knockbackResistance(float knockbackResistance) {
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public ArmorInfo equipSound(SoundEvent equipSound) {
        this.equipSound = Lazy.of(() -> equipSound);
        return this;
    }

    public ArmorInfo repairIngredient(ItemLike repairIngredient) {
        this.repairIngredient = Ingredient.of(repairIngredient);
        return this;
    }

    public int getDurabilityMultiplier() {
        return this.durabilityMultiplier;
    }

    public int[] getProtection() {
        return this.protection;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Lazy<SoundEvent> getEquipSound() {
        return this.equipSound;
    }

    public Supplier<Ingredient> getRepairIngredient() {
        return () -> this.repairIngredient;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
