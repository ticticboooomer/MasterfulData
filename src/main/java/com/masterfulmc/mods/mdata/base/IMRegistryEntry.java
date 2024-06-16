package com.masterfulmc.mods.mdata.base;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public interface IMRegistryEntry<VALUE extends IMRegistryEntryValue, ENTRY extends IMRegistryEntry<VALUE, ENTRY>> {
    ResourceLocation getId();
    Class<? extends VALUE> getValueClass();
    Codec<? extends VALUE> codec();
}
