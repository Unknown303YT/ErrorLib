package com.riverstone.unknown303.errorlib.api.helpers.tier;

import com.riverstone.unknown303.errorlib.api.general.ModInfo;
import com.riverstone.unknown303.errorlib.api.helpers.ErrorLibHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ToolTierHelper extends ErrorLibHelper {
    public ToolTierHelper(ModInfo modInfo) {
        super(modInfo);
    }

    public Tier createToolTier(String tierId, TierInfo tierInfo) {
        return TierSortingRegistry.registerTier(
                new ForgeTier(tierInfo.getLevel(), tierInfo.getDurability(),
                        tierInfo.getAttackSpeed(), tierInfo.getTierAttackDamage(),
                        tierInfo.getEnchantability(), tierInfo.getMiningTag(),
                        tierInfo.getRepairIngredient()),
                new ResourceLocation(this.getModId(), tierId),
                tierInfo.getLowerRank(), tierInfo.getHigherRank());
    }

    public TierInfo createTierInfo(int durability, float attackSpeed,
                                   float attackDamage, int enchantability) {
        return new TierInfo(this.getModLogger(), durability,
                attackSpeed, attackDamage, enchantability);
    }
}
