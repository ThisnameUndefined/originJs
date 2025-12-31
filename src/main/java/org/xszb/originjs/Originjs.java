package org.xszb.originjs;


import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.xszb.originjs.event.OriginJsEvent;
import org.xszb.originjs.register.OriginjsRegisters;


@Mod(Originjs.MODID)
@SuppressWarnings("removal")
public class Originjs {


    public static final String MODID = "originjs";

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation("originjs", path);
    }

    @SuppressWarnings("removal")
    public Originjs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        forgeEventBus.addListener(OriginJsEvent::EntityAction);
        forgeEventBus.addListener(OriginJsEvent::BiEntityAction);
        forgeEventBus.addListener(OriginJsEvent::ItemAction);
        forgeEventBus.addListener(OriginJsEvent::BlockAction);
        forgeEventBus.addListener(OriginJsEvent::EntityCondition);
        forgeEventBus.addListener(OriginJsEvent::BiEntityCondition);
        forgeEventBus.addListener(OriginJsEvent::ItemCondition);
        forgeEventBus.addListener(OriginJsEvent::BlockCondition);
        forgeEventBus.addListener(OriginJsEvent::DamageCondition);

        OriginjsRegisters.initialize(modEventBus);

        OriginJsEvent.GROUP.register();
        MinecraftForge.EVENT_BUS.register(this);
    }


}
