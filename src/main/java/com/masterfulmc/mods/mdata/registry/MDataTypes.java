package com.masterfulmc.mods.mdata.registry;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.base.MRegistry;
import com.masterfulmc.mods.mdata.codec.MRegistryResolverCodec;
import com.masterfulmc.mods.mdata.registry.datatype.MDataType;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import com.masterfulmc.mods.mdata.registry.datatype.str.StringDataType;
import com.mojang.serialization.Codec;

import java.util.List;

public class MDataTypes {
    public static final MRegistry<MDataValue, MDataType> DATA_TYPES = new MRegistry<>();
    public static final Codec<List<MDataValue>> LIST_CODEC = new MRegistryResolverCodec<>(DATA_TYPES, Codec::list, x -> x.getFirst().getId());

    public static final StringDataType STRING = DATA_TYPES.register(Ref.DataTypes.STRING, new StringDataType());
}
