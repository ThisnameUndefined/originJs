package org.xszb.originjs.register;

import net.minecraftforge.registries.RegistryObject;
import org.xszb.originjs.power.AddSpellPower;
import org.xszb.originjs.power.action.KJSBientActionPower;
import org.xszb.originjs.power.action.KJSblockActionPower;
import org.xszb.originjs.power.action.KJSentActionPower;
import org.xszb.originjs.power.action.KJSitemActionPower;

public class PowerFactories {
    public static final RegistryObject<AddSpellPower> ADD_SPELL_POWER =
            OriginjsRegisters.POWER_FACTORIES.register(
                    "add_spell",
                    AddSpellPower::new
            );

    public static void bootstrap() {

    }
}
