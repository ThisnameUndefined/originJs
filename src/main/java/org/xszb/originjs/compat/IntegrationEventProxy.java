package org.xszb.originjs.compat;

import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.xszb.originjs.Originjs;

@Mod.EventBusSubscriber(modid = Originjs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class IntegrationEventProxy {
    private static final String IRON_SPELLS_MODID = "irons_spellbooks";
    private static boolean isIronSpellsLoaded = false;

        static {
            isIronSpellsLoaded = ModList.get().isLoaded(IRON_SPELLS_MODID);
        }

        @SubscribeEvent
        public static void onGenericForgeEvent(Event rawEvent) {
            if (!isIronSpellsLoaded) {
                return;
            }

            try {
                Class<?> integrationClass = Class.forName("org.xszb.originjs.compat.irons_spells.IronSpellsIntegration");
                var method = integrationClass.getMethod("onEvent", Event.class);
                method.invoke(null, rawEvent);
            } catch (ClassNotFoundException e) {
            } catch (Exception e) {

            }
        }
}
