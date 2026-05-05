package org.doxa.ce_bridge;

import org.bukkit.plugin.java.JavaPlugin;
import org.doxa.ce_bridge.event.EvtCraftEngineReload; // <--- ADD THIS
import com.denizenscript.denizencore.events.ScriptEvent; // <--- ADD THIS

public class CEBridge extends JavaPlugin {

    @Override
    public void onEnable() {
        // 1. Create the event instance
        EvtCraftEngineReload reloadEvent = new EvtCraftEngineReload();

        // 2. Register it so Denizen scripts can use 'on craftengine reload'
        ScriptEvent.registerScriptEvent(reloadEvent);

        // 3. Register it so the @EventHandler actually catches the CraftEngine event
        getServer().getPluginManager().registerEvents(reloadEvent, this);

        // 4. Register all your tags (IDs, items, etc)
        DenizenHook.register();

        getLogger().info("CraftEngine Denizen Bridge has been loaded!");
    }
}