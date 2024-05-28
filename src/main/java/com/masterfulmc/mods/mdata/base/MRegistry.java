package com.masterfulmc.mods.mdata.base;

import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MRegistry<ENTRY extends IMRegistryEntry> {
    private final Map<ResourceLocation, ENTRY> inner = new HashMap<>();
    public void register(ResourceLocation id, final ENTRY entry) {
        inner.put(id, entry);
    }

    public Collection<ENTRY> values() {
        return inner.values();
    }
}
