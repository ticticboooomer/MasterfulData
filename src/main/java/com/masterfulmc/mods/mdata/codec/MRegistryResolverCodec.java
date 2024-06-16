package com.masterfulmc.mods.mdata.codec;

import com.masterfulmc.mods.mdata.base.IMRegistryEntry;
import com.masterfulmc.mods.mdata.base.IMRegistryEntryValue;
import com.masterfulmc.mods.mdata.base.IMRegistryIdentifiable;
import com.masterfulmc.mods.mdata.base.MRegistry;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class MRegistryResolverCodec<VAL extends IMRegistryEntryValue, ENTRY extends IMRegistryEntry<VAL, ENTRY>, RESULT> implements Codec<RESULT> {

    private final MRegistry<VAL, ENTRY> registry;
    private final Function<Codec<VAL>, Codec<RESULT>> mapper;
    private final Function<RESULT, ResourceLocation> idGetter;

    private Map<Class<VAL>, Codec<RESULT>> resolvedCodecs = new HashMap<>();

    public static final GlobalHandlerHelper ALL = new GlobalHandlerHelper();

    public MRegistryResolverCodec(MRegistry<VAL, ENTRY> registry, Function<Codec<VAL>, Codec<RESULT>> mapper, Function<RESULT, ResourceLocation> idGetter) {
        this.registry = registry;
        this.mapper = mapper;
        this.idGetter = idGetter;
    }

    @Override
    public <T1> DataResult<Pair<RESULT, T1>> decode(DynamicOps<T1> ops, T1 input) {
        DataResult<T1> typeDR = ops.get(input, "type");
        if (typeDR.error().isPresent() || typeDR.result().isEmpty()) {
            return DataResult.error(() -> "Failed to get 'type' field");
        }
        var typeStringDR = ops.getStringValue(typeDR.result().get());
        if (typeStringDR.error().isPresent() || typeStringDR.result().isEmpty()) {
            return DataResult.error(() -> "Failed to get 'type' field as string");
        }
        var type = new ResourceLocation(typeStringDR.result().get());
        var entry = registry.getEntry(type);
        Codec<RESULT> innerCodec = resolvedCodecs.get(entry.getValueClass());
        return ops.withDecoder(innerCodec).apply(input);
    }

    @Override
    public <T1> DataResult<T1> encode(RESULT input, DynamicOps<T1> ops, T1 prefix) {
        ENTRY entry = registry.getEntry(idGetter.apply(input));
        var codec = resolvedCodecs.get(entry.getValueClass());
        return ops.withEncoder(codec).apply(input);
    }

    public void populateMappings() {
        for (ENTRY value : registry.values()) {
            var valClass = value.getValueClass();
            var resCodec = resolvedCodecs.get(valClass);
            resolvedCodecs.put((Class<VAL>) valClass, resCodec);
        }
    }

    public static final class GlobalHandlerHelper {
        public final List<MRegistryResolverCodec<?, ?, ?>> allResolvers = new ArrayList<>();

        public void populate() {
            for (MRegistryResolverCodec<?, ?, ?> res : allResolvers) {
                res.populateMappings();
            }
        }
    }
}
