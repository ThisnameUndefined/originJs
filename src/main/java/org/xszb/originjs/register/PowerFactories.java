package org.xszb.originjs.register;

import net.minecraftforge.registries.RegistryObject;
import org.xszb.originjs.power.KjsEventTriggerPower;

public class PowerFactories {

    public static final RegistryObject<KjsEventTriggerPower> KJS_TRIGGER_POWER =
            OriginjsRegisters.POWER_FACTORIES.register(
                    "trigger_power",
                    KjsEventTriggerPower::new
            );

    public static void bootstrap() {

    }
}
