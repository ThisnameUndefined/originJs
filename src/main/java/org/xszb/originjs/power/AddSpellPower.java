package org.xszb.originjs.power;

import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.xszb.originjs.power.configuration.AddSpellConfiguration;

public class AddSpellPower extends PowerFactory<AddSpellConfiguration> {
    public AddSpellPower() {
        super(AddSpellConfiguration.CODEC);
    }

    protected void onGained(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof Player ple) {
            ClientMagicData.updateSpellSelectionManager((ServerPlayer) ple);
        }
    }

    protected void onLost(AddSpellConfiguration configuration, Entity player) {
        if (player instanceof Player ple) {
            ClientMagicData.updateSpellSelectionManager((ServerPlayer) ple);
        }
    }
}
