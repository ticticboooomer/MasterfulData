package com.masterfulmc.mods.mdata.base;

import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MRegistry<VAL extends IMRegistryEntryValue, ENTRY extends IMRegistryEntry<VAL, ENTRY>> {
    private final Map<ResourceLocation, ENTRY> inner = new HashMap<>();

    public <T extends ENTRY> T register(ResourceLocation id, final T entry) {
        inner.put(id, entry);
        return entry;
    }

    public Collection<ENTRY> values() {
        return inner.values();
    }

    public ENTRY getEntry(ResourceLocation id) {
        return inner.get(id);
    }
}
