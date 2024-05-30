package com.masterfulmc.mods.mdata.base;

import com.masterfulmc.mods.mdata.codec.MRegistryResolverCodec;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public interface IMRegistryEntry<VALUE extends IMRegistryEntryValue, ENTRY extends IMRegistryEntry<VALUE, ENTRY>> {
    ResourceLocation getId();
    Codec<? extends VALUE> codec();
}
