package com.masterfulmc.mods.mdata.registry.dataref.literal;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.dataref.DataRefValue;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@Getter
public class LiteralDataRefValue extends DataRefValue {

    private final MDataValue val;

    public LiteralDataRefValue(MDataValue val) {
        this.val = val;
    }

    @Override
    public ResourceLocation getId() {
        return Ref.DataRefTypes.LITERAL;
    }

    @Override
    public List<MDataValue> resolve() {
        return List.of();
    }
}
