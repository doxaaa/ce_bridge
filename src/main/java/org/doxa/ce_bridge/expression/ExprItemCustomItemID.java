package org.doxa.ce_bridge.expression;

import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizencore.objects.properties.PropertyParser;
import com.denizenscript.denizencore.objects.core.ElementTag;
import net.momirealms.craftengine.bukkit.api.CraftEngineItems;
import net.momirealms.craftengine.core.util.Key;

public class ExprItemCustomItemID {

    public static void register() {

        // <--[tag]
        // @attribute <ItemTag.ce_id>
        // @returns ElementTag
        // @description
        // Returns the CraftEngine ID of a custom item.
        // -->
        ItemTag.tagProcessor.registerStaticTag(ElementTag.class, "ce_id", (attribute, object) -> {
            net.momirealms.craftengine.core.util.Key key = CraftEngineItems.getCustomItemId(object.getItemStack());
            return key != null ? new ElementTag(key.asString()) : null;
        });
    }
}