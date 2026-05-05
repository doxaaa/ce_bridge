package org.doxa.ce_bridge.event;

import com.denizenscript.denizen.events.BukkitScriptEvent;
import net.momirealms.craftengine.bukkit.api.event.CraftEngineReloadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EvtCraftEngineReload extends BukkitScriptEvent implements Listener {

    private static boolean hasBeenCalled = false;

    public static boolean hasBeenLoad() {
        return hasBeenCalled;
    }

    public EvtCraftEngineReload() {
        // This links the Java code to the Denizen script event name.
        registerCouldMatcher("craftengine [first] load|reload");
    }

    @Override
    public boolean matches(ScriptPath path) {
        // Logic for 'on craftengine first load' keyword
        if (path.eventArgLowerAt(1).equals("first") && hasBeenCalled) {
            return false;
        }
        return super.matches(path);
    }

    @EventHandler
    public void onCraftEngineReload(CraftEngineReloadEvent event) {
        // Mark as loaded and tell Denizen to run any scripts listening to this
        hasBeenCalled = true;
        fire(event);
    }
}