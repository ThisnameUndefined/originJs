package org.xszb.originjs.power;

import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.common.power.configuration.ActionOverTimeConfiguration;
import io.redspace.ironsspellbooks.network.ClientboundEquipmentChanged;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import io.redspace.ironsspellbooks.setup.Messages;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.xszb.originjs.power.configuration.AddSpellConfiguration;

import java.util.concurrent.atomic.AtomicBoolean;

public class AddSpellPower extends PowerFactory<AddSpellConfiguration> {
    public AddSpellPower() {
        super(AddSpellConfiguration.CODEC);
        this.ticking(true);
    }

    protected void onGained(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple) {
            ClientMagicData.updateSpellSelectionManager(ple);
        }
    }

    protected void onLost(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple) {
            ClientMagicData.updateSpellSelectionManager(ple);
        }
    }

    protected void onAdded(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple) {
            ClientMagicData.updateSpellSelectionManager(ple);
        }
    }

    protected void onRemoved(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple) {
            ClientMagicData.updateSpellSelectionManager(ple);
        }
    }

    protected void onRespawn(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple) {
            ClientMagicData.updateSpellSelectionManager(ple);
        }
    }

    public void tick(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof ServerPlayer ple && ple.tickCount % 20 == 0) {
            Messages.sendToPlayer(new ClientboundEquipmentChanged(), ple);
            this.ticking(false);
        }
    }
}
