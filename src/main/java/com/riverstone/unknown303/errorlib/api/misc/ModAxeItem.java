package com.riverstone.unknown303.errorlib.api.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import javax.annotation.Nullable;

public class ModAxeItem extends AxeItem {
    boolean hasInstance;
    MobEffectInstance instance = null;

    public ModAxeItem(Tier pTier, int pAttackDamageModifier,
                        float pAttackSpeedModifier, Properties pProperties) {
        this(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, null);
    }

    public ModAxeItem(Tier pTier, int pAttackDamageModifier,
                        float pAttackSpeedModifier, Properties pProperties, @Nullable MobEffectInstance instance) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties.stacksTo(1));
        if (instance == null) {
            hasInstance = false;
            return;
        }
        hasInstance = true;
        this.instance = instance;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (hasInstance) {
            pTarget.addEffect(this.instance, pAttacker);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
