package com.masterfulmc.mods.mdata.registry.datatype.str;


import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class StringDataValue extends MDataValue implements Comparable<String> {

    public final String data;

    public StringDataValue(String data) {

        this.data = data;
    }

    @Override
    public ResourceLocation getId() {
        return Ref.DataTypes.STRING;
    }

    @Override
    public int compareTo(@NotNull String o) {
        return o.compareTo(this.data);
    }
}
