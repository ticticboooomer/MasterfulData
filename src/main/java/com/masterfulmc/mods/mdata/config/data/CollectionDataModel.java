package com.masterfulmc.mods.mdata.config.data;

import com.masterfulmc.mods.mdata.base.IMRegistryIdentifiable;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record CollectionDataModel(
        ResourceLocation type,
        List<MDataValue> values
) implements IMRegistryIdentifiable {
    @Override
    public ResourceLocation getId() {
        return type;
    }
}
