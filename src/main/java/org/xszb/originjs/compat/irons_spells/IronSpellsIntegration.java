package org.xszb.originjs.compat.irons_spells;

import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellData;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;
import org.xszb.originjs.power.configuration.AddSpellConfiguration;

public class IronSpellsIntegration {

    public static void onEvent(Event rawEvent) {
        if (!(rawEvent instanceof SpellSelectionManager.SpellSelectionEvent event)) {
            return;
        }
        Player player = event.getEntity();
        IPowerContainer.get(player).ifPresent(powerContainer -> {
            powerContainer.getPowers().forEach(power -> {
                if (power.get().getConfiguration() instanceof AddSpellConfiguration config) {
                    int initialIndex = event.getManager().getSpellCount();
                    event.addSelectionOption(
                            new SpellData(SpellRegistry.getSpell(config.SpellName()), config.SpellLevel(), true),
                            power.toString() + "_" + config.SpellName(),
                            initialIndex + 1
                    );
                }
            });
        });
    }
}
