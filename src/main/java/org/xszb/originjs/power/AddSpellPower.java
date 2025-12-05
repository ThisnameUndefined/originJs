package org.xszb.originjs.power;

import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import org.xszb.originjs.power.configuration.AddSpellConfiguration;

public class AddSpellPower extends PowerFactory<AddSpellConfiguration> {
    public AddSpellPower() {
        super(AddSpellConfiguration.CODEC);
    }
}
