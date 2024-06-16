package com.masterfulmc.mods.mdata.registry.dataref.literal;

import com.masterfulmc.mods.mdata.Ref;
import com.masterfulmc.mods.mdata.registry.dataref.DataRefType;
import com.masterfulmc.mods.mdata.registry.dataref.DataRefValue;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class LiteralDataRefType extends DataRefType {

    public static final Codec<LiteralDataRefValue> CODEC = RecordCodecBuilder.create(b -> b.group(
            Codec.STRING.fieldOf("value").forGetter(LiteralDataRefValue::getVal)
    ).apply(b, LiteralDataRefValue::new));

    @Override
    public ResourceLocation getId() {
        return Ref.DataRefTypes.LITERAL;
    }

    @Override
    public Class<? extends DataRefValue> getValueClass() {
        return LiteralDataRefValue.class;
    }

    @Override
    public Codec<? extends DataRefValue> codec() {
        return CODEC;
    }
}
