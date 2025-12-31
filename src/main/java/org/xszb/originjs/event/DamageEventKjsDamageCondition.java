package org.xszb.originjs.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.xszb.originjs.event.KJSevent.KJSDamageConditionEvent;
import org.xszb.originjs.event.KJSevent.KJSitemConditionEvent;
import org.xszb.originjs.event.KJSevent.OriginEventJS;

public class DamageEventKjsDamageCondition extends OriginEventJS {
    private KJSDamageConditionEvent event;

    public DamageEventKjsDamageCondition(KJSDamageConditionEvent event) {
        this.event = event;
    }

    public DamageSource getSource() {
        return this.event.getSource();
    }

    public Object getKey() {
        return this.event.getKey();
    }

    public Object hasResult() {
        return this.event.getCheckResult();
    }

    public void setResult(boolean result) {
        this.event.setCheckResult(result);
        this.event.setCanceled(true);
    }

    public float getAmount() { return event.getAmount();}
}