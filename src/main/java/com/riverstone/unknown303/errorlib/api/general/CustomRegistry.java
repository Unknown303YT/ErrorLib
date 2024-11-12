package com.riverstone.unknown303.errorlib.api.general;

import com.riverstone.unknown303.errorlib.ErrorMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingException;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.List;

public interface CustomRegistry {
        public ResourceLocation getId();
        public void register();
}