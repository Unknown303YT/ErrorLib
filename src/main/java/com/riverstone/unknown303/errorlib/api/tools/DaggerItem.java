package com.riverstone.unknown303.errorlib.api.tools;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;

public class DaggerItem extends SwordItem {
    private final float attackDamage;
    protected final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public DaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.attackDamage = (float) pAttackDamageModifier + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ToolUtils.BASE_ATTACK_REACH_UUID, "Weapon modifier", -1.0D, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolUtils.DEFAULT_DAGGER_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        handleDaggerDamage(pTarget, pAttacker);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    protected void handleDaggerDamage(LivingEntity pTarget, LivingEntity pAttacker) {
        if (pAttacker.canAttack(pTarget)) {
            if (pTarget.getArmorValue() > 10) {
                if (pAttacker instanceof Player playerAttacker) {
                    pTarget.hurt(playerAttacker.damageSources().playerAttack(playerAttacker), getDamage() / 3);
                } else {
                    pTarget.hurt(pAttacker.damageSources().mobAttack(pAttacker), getDamage() / 3);
                }
            }
        }
    }

    protected float getDaggerDamage() {
        return getDamage() / 3;
    }
}
