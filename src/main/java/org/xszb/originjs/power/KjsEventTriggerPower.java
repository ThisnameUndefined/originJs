package org.xszb.originjs.power;


import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.minecraft.world.entity.Entity;
import org.xszb.originjs.power.configuration.KJSEventTriggerConfiguration;

public class KjsEventTriggerPower  extends PowerFactory<KJSEventTriggerConfiguration> {
    public KjsEventTriggerPower() {
        super(KJSEventTriggerConfiguration.CODEC);
    }

    public void executeActions(ConfiguredPower<KJSEventTriggerConfiguration, ?> config, Entity player) {
        KJSEventTriggerConfiguration configuration = config.getConfiguration();
        ConfiguredEntityAction.execute(configuration.entityAction(), player);
    }
}
