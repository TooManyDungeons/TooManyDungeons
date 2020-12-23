package us.tmd.tmd;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.HashMap;

public class KeyBindings {

    private static HashMap<String, KeyBinding> keyBinds = new HashMap<String, KeyBinding>();
    private static boolean finalized;

    public static KeyBinding getBind(String id) {
        return keyBinds.get(id);
    }

    public static void bind(String id, KeyBinding binding) {
        if(!finalized) keyBinds.put(id, binding);
        else System.err.println("TMD Bind Error: Cannot bind key after finalization.");
    }

    public static void unbind(String name) {
        if(!finalized) keyBinds.remove(name);
        else System.err.println("TMD Unbind Error: Cannot unbind key after finalization.");
    }

    public static void finalizeKeybindings() {
        finalized = true;
        for(KeyBinding keyBind : keyBinds.values())
            ClientRegistry.registerKeyBinding(keyBind);
    }

}
