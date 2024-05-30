package com.masterfulmc.mods.mdata.config;

import com.masterfulmc.mods.mdata.config.base.IConfigurableType;
import com.masterfulmc.mods.mdata.config.data.CollectionDataConfigType;

import java.util.ArrayList;
import java.util.List;

public class ConfigTypeRegistry {
    public static final List<IConfigurableType<?>> TYPES = new ArrayList<>();

    public static final CollectionDataConfigType LIST_DATA = register(new CollectionDataConfigType());

    private static <T extends IConfigurableType<?>> T register(final T type) {
        TYPES.add(type);
        return type;
    }
}
