package com.masterfulmc.mods.mdata.registry.datatype.str;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.datatype.MDataType;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public class StringDataType extends MDataType {

    public static final Codec<StringDataValue> CODEC = Codec.STRING.xmap(StringDataValue::new, x -> x.data);

    @Override
    public ResourceLocation getId() {
        return Ref.DataTypes.STRING;
    }

    @Override
    public Codec<? extends MDataValue> codec() {
        return CODEC;
    }
}
