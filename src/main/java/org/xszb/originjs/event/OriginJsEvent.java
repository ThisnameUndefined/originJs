package org.xszb.originjs.event;

import dev.latvian.mods.kubejs.event.*;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.script.ScriptTypeHolder;
import org.xszb.originjs.event.KJSevent.*;


public class OriginJsEvent {
    public static final EventGroup GROUP = EventGroup.of("OriginEvents");

    public static final EventHandler EntityAction = GROUP.common("OriginEntAction", () -> PlayerEventKjsEntityAction.class).extra(Extra.STRING).hasResult();

    public static final EventHandler BiEntityAction = GROUP.common("OriginBiEntAction", () -> PlayerEventKjsBiEntityAction.class).extra(Extra.STRING).hasResult();

    public static final EventHandler ItemAction = GROUP.common("OriginItemAction", () -> ItemEventKjsItemAction.class).extra(Extra.STRING).hasResult();

    public static final EventHandler BlockAction = GROUP.common("OriginBlockAction", () -> BlockEventKjsBlockAction.class).extra(Extra.STRING).hasResult();


    public static final EventHandler EntityCondition = GROUP.common("OriginEntCondition", () -> PlayerEventKjsEntityCondition.class).extra(Extra.STRING).hasResult();

    public static final EventHandler BiEntityCondition = GROUP.common("OriginBiEntCondition", () -> PlayerEventKjsBiEntityCondition.class).extra(Extra.STRING).hasResult();

    public static final EventHandler ItemCondition = GROUP.common("OriginItemCondition", () -> ItemEventKjsItemCondition.class).extra(Extra.STRING).hasResult();

    public static final EventHandler BlockCondition = GROUP.common("OriginBlockCondition", () -> BlockEventKjsBlockCondition.class).extra(Extra.STRING).hasResult();

    public static final EventHandler DamageCondition = GROUP.common("OriginDamageCondition", () -> DamageEventKjsDamageCondition.class).extra(Extra.STRING).hasResult();




    public static void EntityAction(KJSEntityActionEvent event) {
        if (EntityAction.hasListeners()) {
                EntityAction.post((ScriptTypeHolder)event.getEntity(),event.getKey() ,(EventJS) new PlayerEventKjsEntityAction(event)).interruptFalse();
        }
    }

    public static void BiEntityAction(KJSBiEntityActionEvent event) {
        if (BiEntityAction.hasListeners()) {
            BiEntityAction.post((ScriptTypeHolder)event.getEntity(),event.getKey() ,(EventJS) new PlayerEventKjsBiEntityAction(event)).interruptFalse();
        }
    }

    public static void EntityCondition(KJSEntityConditionEvent event) {
        if (EntityCondition.hasListeners()) {
            EntityCondition.post((ScriptTypeHolder)event.getEntity(),event.getKey() ,(EventJS) new PlayerEventKjsEntityCondition(event)).interruptFalse();
        }
    }

    public static void BiEntityCondition(KJSBiEntityConditionEvent event) {
        if (BiEntityCondition.hasListeners()) {
            BiEntityCondition.post((ScriptTypeHolder)event.getEntity(),event.getKey() ,(EventJS) new PlayerEventKjsBiEntityCondition(event)).interruptFalse();
        }
    }

    public static void ItemCondition(KJSitemConditionEvent event) {
        if (ItemCondition.hasListeners()) {
            ItemCondition.post((ScriptTypeHolder)event.getLevel(),event.getKey() ,(EventJS) new ItemEventKjsItemCondition(event)).interruptFalse();
        }
    }

    public static void ItemAction (KJSitemActionEvent event) {
        if (ItemAction.hasListeners()) {
            ItemAction.post((ScriptTypeHolder)event.getLevel(),event.getKey() ,(EventJS) new ItemEventKjsItemAction(event)).interruptFalse();
        }
    }

    public static void BlockCondition (KJSblockConditionEvent event) {
        if (BlockCondition.hasListeners()) {
            BlockCondition.post(ScriptType.SERVER,event.getKey() ,(EventJS) new BlockEventKjsBlockCondition(event)).interruptFalse();
        }
    }

    public static void BlockAction  (KJSblockActionEvent event) {
        if (BlockAction.hasListeners()) {
            BlockAction.post((ScriptTypeHolder)event.getLevel(),event.getKey() ,(EventJS) new BlockEventKjsBlockAction(event)).interruptFalse();
        }
    }

    public static void DamageCondition(KJSDamageConditionEvent event) {
        if (DamageCondition.hasListeners()) {
            DamageCondition.post(ScriptType.SERVER,event.getKey() ,(EventJS) new DamageEventKjsDamageCondition(event)).interruptFalse();
        }
    }

}
