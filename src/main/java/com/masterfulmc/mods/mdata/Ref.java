package com.masterfulmc.mods.mdata;

import net.minecraft.resources.ResourceLocation;

public class Ref {
    public static final String ID = "mdata";

    public static ResourceLocation id(String path) {
        return new ResourceLocation(ID, path);
    }

    public static class Configs {
    }

    public static class DataTypes {
        public static final ResourceLocation STRING = id("datatype/string");
    }
}
