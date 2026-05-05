// <--[tag]
// @attribute <ce_item[<id>]>
// @returns ItemTag
// @description
// Returns a CraftEngine item by its namespace ID.
// Example: <ce_item[fmc:dark_matter]>
// -->

package org.doxa.ce_bridge.expression;

import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.tags.Attribute;
import com.denizenscript.denizencore.tags.TagManager;
import net.momirealms.craftengine.bukkit.api.CraftEngineItems;
import net.momirealms.craftengine.core.item.CustomItem;
import net.momirealms.craftengine.core.item.ItemBuildContext;
import net.momirealms.craftengine.core.util.Key;
import org.bukkit.inventory.ItemStack;

public class ExprCustomItem {

    public static void register() {
        // Syntax: <ce_item[id]>
        TagManager.registerTagHandler(ObjectTag.class, "ce_item", (attribute) -> {
            if (!attribute.hasContext(1)) {
                return null;
            }

            // 1. Get the ID and fulfill the context so Denizen moves the 'cursor' past the [id]
            String id = attribute.getContext(1);
            attribute.fulfill(1);

            // 2. Fetch from CraftEngine
            CustomItem<ItemStack> customItem = CraftEngineItems.byId(Key.of(id));

            if (customItem == null) {
                return null;
            }

            // 3. Build the Denizen ItemTag
            ItemTag item = new ItemTag(customItem.buildItemStack(ItemBuildContext.empty()));

            // 4. THIS IS THE CRITICAL PART:
            // This passes the tag chain (like .material) to the ItemTag itself.
            // If the code below is red, try item.getAttribute(attribute) instead.
            return item.getObjectAttribute(attribute);
        });
    }
}