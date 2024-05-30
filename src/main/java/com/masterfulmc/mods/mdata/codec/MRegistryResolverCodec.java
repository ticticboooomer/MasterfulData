package com.masterfulmc.mods.mdata.codec;

import com.masterfulmc.mods.mdata.base.IMRegistryEntry;
import com.masterfulmc.mods.mdata.base.IMRegistryEntryValue;
import com.masterfulmc.mods.mdata.base.MRegistry;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class MRegistryResolverCodec<VAL extends IMRegistryEntryValue, ENTRY extends IMRegistryEntry<VAL, ENTRY>> implements Codec<VAL> {
    private final Supplier<MRegistry<VAL, ENTRY>> registrySupplier;

    public MRegistryResolverCodec(Supplier<MRegistry<VAL, ENTRY>> registrySupplier) {
        this.registrySupplier = registrySupplier;
    }

    @Override
    public <T1> DataResult<Pair<VAL, T1>> decode(DynamicOps<T1> ops, T1 input) {
        DataResult<T1> typeDR = ops.get(input, "type");
        if (typeDR.error().isPresent() || typeDR.result().isEmpty()) {
            return DataResult.error(() -> "Failed to get 'type' field");
        }
        var typeStringDR = ops.getStringValue(typeDR.result().get());
        if (typeStringDR.error().isPresent() || typeStringDR.result().isEmpty()) {
            return DataResult.error(() -> "Failed to get 'type' field as string");
        }
        var type = new ResourceLocation(typeStringDR.result().get());
        var entry = registrySupplier.get().getEntry(type);
        Codec<VAL> innerCodec = (Codec<VAL>) entry.codec();
        return ops.withDecoder(innerCodec).apply(input);
    }

    @Override
    public <T1> DataResult<T1> encode(VAL input, DynamicOps<T1> ops, T1 prefix) {
        ENTRY entry = registrySupplier.get().getEntry(input.getId());
        Codec<VAL> codec = (Codec<VAL>) entry.codec();
        return ops.withEncoder(codec).apply(input);
    }
}
