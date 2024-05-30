package com.masterfulmc.mods.mdata.registry.datalist.str;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListValue;
import com.masterfulmc.mods.mdata.registry.datatype.str.StringDataValue;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class StringListValue extends MDataListValue {

    public final List<StringDataValue> values;

    public StringListValue(List<StringDataValue> values) {
        this.values = values;
    }

    @Override
    public ResourceLocation getId() {
        return Ref.DataTypes.STRING;
    }
}
