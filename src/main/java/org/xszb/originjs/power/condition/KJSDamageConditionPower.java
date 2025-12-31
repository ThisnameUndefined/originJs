package org.xszb.originjs.power.condition;

import io.github.edwinmindcraft.apoli.api.power.factory.DamageCondition;
import io.github.edwinmindcraft.apoli.api.power.factory.ItemCondition;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import org.xszb.originjs.event.KJSevent.KJSDamageConditionEvent;
import org.xszb.originjs.event.KJSevent.KJSitemConditionEvent;
import org.xszb.originjs.power.configuration.KJSDamageConditionPowerConfiguration;
import org.xszb.originjs.power.configuration.KJSitemConditionPowerConfiguration;

import javax.annotation.Nullable;

public class KJSDamageConditionPower extends DamageCondition<KJSDamageConditionPowerConfiguration> {
    public KJSDamageConditionPower() {
        super(KJSDamageConditionPowerConfiguration.CODEC);
    }
    public boolean check(KJSDamageConditionPowerConfiguration configuration, DamageSource source, float amount) {

        KJSDamageConditionEvent event = new KJSDamageConditionEvent(
                source,
                amount,
                configuration
        );

        MinecraftForge.EVENT_BUS.post(event);


        return event.getCheckResult();
    }
}
