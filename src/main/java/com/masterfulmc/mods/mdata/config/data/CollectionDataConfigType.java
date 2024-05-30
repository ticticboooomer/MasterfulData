package com.masterfulmc.mods.mdata.config.data;

import com.masterfulmc.mods.mdata.codec.MRegistryResolverCodec;
import com.masterfulmc.mods.mdata.config.base.IConfigurableType;
import com.masterfulmc.mods.mdata.config.base.LocatedConfig;
import com.masterfulmc.mods.mdata.registry.MDataLists;
import com.masterfulmc.mods.mdata.registry.MDataTypes;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListType;
import com.masterfulmc.mods.mdata.registry.datalist.MDataListValue;
import com.masterfulmc.mods.mdata.registry.datatype.MDataType;
import com.masterfulmc.mods.mdata.registry.datatype.MDataValue;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.List;

public class CollectionDataConfigType implements IConfigurableType<CollectionDataModel> {

    public static final MRegistryResolverCodec<MDataListValue, MDataListType> REG_CODEC = new MRegistryResolverCodec<>(() -> MDataLists.LIST_TYPES);
    public static final Codec<CollectionDataModel> CODEC = REG_CODEC.xmap(CollectionDataModel::new, CollectionDataModel::values);

    public Codec<CollectionDataModel> configCodec() {
        return CODEC;
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
