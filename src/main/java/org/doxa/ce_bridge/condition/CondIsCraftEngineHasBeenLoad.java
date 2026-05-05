package org.doxa.ce_bridge.condition;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.tags.TagManager;
import org.doxa.ce_bridge.event.EvtCraftEngineReload;

public class CondIsCraftEngineHasBeenLoad {

    public static void register() {
        // Syntax: <ce_is_loaded>
        TagManager.registerTagHandler(ObjectTag.class, "ce_is_loaded", (attribute) -> {
            // Returns true/false based on our Event's static boolean
            return new ElementTag(EvtCraftEngineReload.hasBeenLoad());
        });
    }
}