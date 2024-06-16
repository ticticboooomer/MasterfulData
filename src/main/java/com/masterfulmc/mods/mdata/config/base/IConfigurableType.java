package com.masterfulmc.mods.mdata.config.base;

import com.mojang.serialization.Codec;

import java.nio.file.Path;
import java.util.List;

public interface IConfigurableType<CONFIG> {
    Codec<CONFIG> configCodec();
    Path prefix();
    void consume(List<LocatedConfig<CONFIG>> configs);
    boolean canReload();
}
