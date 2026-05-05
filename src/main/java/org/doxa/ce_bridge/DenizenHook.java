package org.doxa.ce_bridge;

import org.doxa.ce_bridge.condition.CondIsCraftEngineHasBeenLoad;
import org.doxa.ce_bridge.condition.CondIsCustomItem;
import org.doxa.ce_bridge.expression.ExprCustomItem;
import org.doxa.ce_bridge.expression.ExprItemCustomItemID;

public class DenizenHook {

    public static void register() {
        // Register Global Tags (e.g., <ce_item[id]> and <ce_is_loaded>)
        ExprCustomItem.register();
        CondIsCraftEngineHasBeenLoad.register();

        // Register Object Properties (e.g., <item.is_ce_item> and <item.ce_id>)
        CondIsCustomItem.register();
        ExprItemCustomItemID.register();
    }
}