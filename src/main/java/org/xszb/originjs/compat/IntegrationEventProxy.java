package org.xszb.originjs.compat;

import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.xszb.originjs.Originjs;

import java.lang.reflect.Method;

@Mod.EventBusSubscriber(modid = Originjs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class IntegrationEventProxy {
    private static final String IRON_SPELLS_MODID = "irons_spellbooks";
    private static final boolean IS_IRON_SPELLS_LOADED;
    private static Method CACHED_METHOD = null;
    private static boolean METHOD_LOAD_ATTEMPTED = false;

    static {
        IS_IRON_SPELLS_LOADED = ModList.get().isLoaded(IRON_SPELLS_MODID);
    }

    @SubscribeEvent
    public static void onGenericForgeEvent(Event rawEvent) {
        if (!IS_IRON_SPELLS_LOADED) {
            return;
        }

        if (METHOD_LOAD_ATTEMPTED && CACHED_METHOD == null) {
            return;
        }

        if (CACHED_METHOD == null && !METHOD_LOAD_ATTEMPTED) {
            synchronized (IntegrationEventProxy.class) {
                if (CACHED_METHOD == null && !METHOD_LOAD_ATTEMPTED) {
                    METHOD_LOAD_ATTEMPTED = true;
                    try {
                        Class<?> integrationClass = Class.forName("org.xszb.originjs.compat.irons_spells.IronSpellsIntegration");
                        CACHED_METHOD = integrationClass.getMethod("onEvent", Event.class);
                        CACHED_METHOD.setAccessible(true);
                    } catch (Exception ignored) {
                     }
                }
            }
        }

        if (CACHED_METHOD != null) {
            try {
                CACHED_METHOD.invoke(null, rawEvent);
            } catch (Exception ignored) {
            }
        }
    }
}