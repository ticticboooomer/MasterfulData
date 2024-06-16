package com.masterfulmc.mods.mdata.registry.dataref;

import com.masterfulmc.mods.mdata.base.IMRegistryEntryValue;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;

import java.util.List;

public abstract class DataRefValue implements IMRegistryEntryValue {
    public abstract List<MDataValue> resolve();
}
