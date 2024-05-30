package com.masterfulmc.mods.mdata.registry;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.base.MRegistry;
import com.masterfulmc.mods.mdata.registry.datatype.MDataType;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import com.masterfulmc.mods.mdata.registry.datatype.str.StringDataType;

public class MDataTypes {
    public static final MRegistry<MDataValue, MDataType> DATA_TYPES = new MRegistry<>();
    public static final StringDataType STRING = DATA_TYPES.register(Ref.DataTypes.STRING, new StringDataType());
}
