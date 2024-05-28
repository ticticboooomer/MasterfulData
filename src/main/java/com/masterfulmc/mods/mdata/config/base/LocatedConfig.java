package com.masterfulmc.mods.mdata.config.base;

import java.nio.file.Path;

public record LocatedConfig<CONFIG>(
        CONFIG config,
        Path relativePath
) {
}
