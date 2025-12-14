package org.xszb.originjs.origins;

import io.github.edwinmindcraft.apoli.api.ApoliAPI;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.xszb.originjs.power.configuration.KJSEventTriggerConfiguration;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public interface KubeJSOriginHelper {
    default int GetOriginResource (String resourceName) {
        Entity entity = (Entity)this;
        Optional<Integer> resourcepower = IPowerContainer.get(entity).resolve()
                .map(x -> x.getPower(ResourceLocation.parse(resourceName))).map(power -> {
                    if (entity instanceof LivingEntity living) {
                        OptionalInt value = power.value().getValue((Entity) living);
                        return value.orElse(0);
                    }
                    return 0;
                });
        return resourcepower.map(Integer::intValue).orElse(0);
    }

    default void ChangeOriginResource (String resourceName,int num) {
        Entity entity = (Entity)this;
        IPowerContainer.get(entity).resolve()
                .map(x -> x.getPower(ResourceLocation.parse(resourceName))).ifPresent(power -> {
                    if (entity instanceof LivingEntity living) {
                        power.value().change(living, num);
                        ApoliAPI.synchronizePowerContainer(living);
                    }
                });
    }

    default boolean HasOriginPower (String resourceName) {
        Entity entity = (Entity)this;
        return  IPowerContainer.get(entity).resolve()
                .map(x -> x.getPower(ResourceLocation.parse(resourceName))).isPresent();
    }

    default void RemoveOriginPower(String resourceName, String source,@Nullable Boolean notsync) {
        Entity entity = (Entity) this;
        boolean shouldSync = notsync == null || !notsync;
        IPowerContainer.get(entity).ifPresent(container -> {
            ResourceLocation powerLocation = ResourceLocation.parse(resourceName);
            ResourceLocation sourceLocation = ResourceLocation.parse(source);

            container.removePower(powerLocation, sourceLocation);
            if (shouldSync) {
                container.sync();
            }
        });
    }

    default void AddOriginPower(String resourceName, String source,@Nullable Boolean notsync) {
        Entity entity = (Entity) this;
        boolean shouldSync = notsync == null || !notsync;

        IPowerContainer.get(entity).ifPresent(container -> {
            ResourceLocation powerLocation = ResourceLocation.parse(resourceName);
            ResourceLocation sourceLocation = ResourceLocation.parse(source);

            container.addPower(powerLocation, sourceLocation);
            if (shouldSync) {
                container.sync();
            }
        });
    }

    default void triggeredKjsPower (String key) {
        Entity entity = (Entity) this;
        IPowerContainer.get(entity).ifPresent(container -> {
            container.getPowers().forEach(power -> {
                if (power.value().getConfiguration() instanceof KJSEventTriggerConfiguration evt){
                    if (Objects.equals(key, evt.key())){
                        ConfiguredEntityAction.execute(evt.entityAction(), entity);
                    }
                }
            });
        });
    }

    default boolean GetPowerIsActive (String resourceName) {
        Entity entity = (Entity)this;
        return IPowerContainer.get(entity)
                .filter(x-> x.hasPower(ResourceLocation.parse(resourceName)))
                .map((x) -> x.getPower(ResourceLocation.parse(resourceName)))
                .map((x) -> x.get().isActive(entity))
                .orElse(false);

    }
}
