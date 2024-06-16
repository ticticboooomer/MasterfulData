package com.masterfulmc.mods.mdata.config.data;

import com.masterfulmc.mods.mdata.codec.MRegistryResolverCodec;
import com.masterfulmc.mods.mdata.config.base.IConfigurableType;
import com.masterfulmc.mods.mdata.config.base.LocatedConfig;
import com.masterfulmc.mods.mdata.registry.MDataTypes;
import com.masterfulmc.mods.mdata.registry.datatype.MDataType;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.List;

public class CollectionDataConfigType implements IConfigurableType<CollectionDataModel> {

    public static final MRegistryResolverCodec<MDataValue, MDataType, CollectionDataModel> REG_CODEC = new MRegistryResolverCodec<>(MDataTypes.DATA_TYPES, x -> RecordCodecBuilder.create(b -> b.group(
            ResourceLocation.CODEC.fieldOf("type").forGetter(CollectionDataModel::type),
            Codec.list(x).fieldOf("values").forGetter(CollectionDataModel::values)
    ).apply(b, CollectionDataModel::new)), CollectionDataModel::type);

    public Codec<CollectionDataModel> configCodec() {
        return REG_CODEC;
    }

    @Override
    public Path prefix() {
        return Path.of("lists");
    }

    @Override
    public void consume(List<LocatedConfig<CollectionDataModel>> locatedConfigs) {

    }

    @Override
    public boolean canReload() {
        return true;
    }
}
