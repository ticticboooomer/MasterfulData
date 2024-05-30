package com.masterfulmc.mods.mdata.registry;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.base.MRegistry;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListType;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListValue;
import com.masterfulmc.mods.mdata.registry.datalist.str.StringListType;

public class MDataLists {
    public static final MRegistry<MDataListValue, MDataListType> LIST_TYPES = new MRegistry<>();
    public static final StringListType STRINGS = LIST_TYPES.register(Ref.DataTypes.STRING, new StringListType());
}
