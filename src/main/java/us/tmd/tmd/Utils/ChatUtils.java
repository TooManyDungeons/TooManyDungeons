package us.tmd.tmd.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import us.tmd.tmd.Main;

public class ChatUtils {

    public static void logChat(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

}
