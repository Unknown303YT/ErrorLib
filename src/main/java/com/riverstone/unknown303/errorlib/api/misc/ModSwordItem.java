package com.riverstone.unknown303.errorlib.api.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModSwordItem extends SwordItem {
    List<MobEffectInstance> instances;

    public ModSwordItem(Tier pTier, int pAttackDamageModifier,
                        float pAttackSpeedModifier, Properties pProperties) {
        this(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, null);
    }

    public ModSwordItem(Tier pTier, int pAttackDamageModifier,
                      float pAttackSpeedModifier, Properties pProperties, @Nullable List<MobEffectInstance> instances) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties.stacksTo(1));
        if (instances != null) {
            this.instances = instances;
        } else {
            this.instances = new ArrayList<>();
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        for (MobEffectInstance instance : this.instances) {
            pTarget.addEffect(instance, pAttacker);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
