package org.xszb.originjs.power.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import net.minecraft.core.Holder;

public record KJSEventTriggerConfiguration (
        Holder<ConfiguredEntityAction<?, ?>> entityAction,
        String key
) implements IDynamicFeatureConfiguration {

    public static final Codec<KJSEventTriggerConfiguration> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    ConfiguredEntityAction.optional("entity_action").forGetter(KJSEventTriggerConfiguration::entityAction),
                    Codec.STRING
                            .fieldOf("key")
                            .forGetter(KJSEventTriggerConfiguration::key)
            ).apply(instance, KJSEventTriggerConfiguration::new)
    );
}