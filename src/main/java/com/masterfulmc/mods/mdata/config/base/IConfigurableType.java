package com.masterfulmc.mods.mdata.config.base;

import com.masterfulmc.mods.mdata.base.IMRegistryEntry;
import com.mojang.serialization.Codec;

import java.nio.file.Path;
import java.util.List;

public interface IConfigurableType<CONFIG> extends IMRegistryEntry {
    Codec<CONFIG> codec();
    Path prefix();
    void consume(List<LocatedConfig<CONFIG>> configs);
}
