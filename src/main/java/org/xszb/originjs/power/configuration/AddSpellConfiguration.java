package org.xszb.originjs.power.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;

public record AddSpellConfiguration (
        String SpellName,
        int SpellLevel
) implements IDynamicFeatureConfiguration {
    public static final Codec<AddSpellConfiguration> CODEC =
            RecordCodecBuilder.create((instance) ->
                    instance.group(
                            Codec.STRING
                                    .fieldOf("spellname")
                                    .forGetter(AddSpellConfiguration::SpellName),
                            Codec.INT
                                    .fieldOf("spelllevel")
                                    .forGetter(AddSpellConfiguration::SpellLevel)
                    ).apply(instance, AddSpellConfiguration::new)
            );
}