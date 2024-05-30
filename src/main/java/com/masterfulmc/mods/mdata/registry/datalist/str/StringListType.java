package com.masterfulmc.mods.mdata.registry.datalist.str;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListType;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListValue;
import com.masterfulmc.mods.mdata.registry.datatype.str.StringDataType;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

public class StringListType extends MDataListType {

    public static final Codec<StringListValue> CODEC = Codec.list(StringDataType.CODEC).xmap(StringListValue::new, x -> x.values);

    @Override
    public ResourceLocation getId() {
        return Ref.DataTypes.STRING;
    }

    @Override
    public Codec<? extends MDataListValue> codec() {
        return CODEC;
    }
}
