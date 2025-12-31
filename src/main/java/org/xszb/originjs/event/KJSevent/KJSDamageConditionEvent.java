package org.xszb.originjs.event.KJSevent;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.eventbus.api.Event;
import org.xszb.originjs.power.configuration.KJSDamageConditionPowerConfiguration;
import org.xszb.originjs.power.configuration.KJSitemConditionPowerConfiguration;

public class KJSDamageConditionEvent extends Event {
    private final DamageSource source;
    private final float amount;
    private final String key;
    public boolean checkresult;

    public KJSDamageConditionEvent(DamageSource source, float amount, KJSDamageConditionPowerConfiguration configuration) {
        this.source = source;
        this.amount = amount;
        this.key = configuration.key();
        this.checkresult = false;
    }

    public DamageSource getSource() {
        return source;
    }

    public float getAmount() {
        return amount;
    }

    public String getKey() {
        return key;
    }

    public void setCheckResult(boolean result) {
        this.checkresult = result;
    }

    public boolean getCheckResult() {
        return this.checkresult;
    }
}