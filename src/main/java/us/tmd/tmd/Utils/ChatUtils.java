package us.tmd.tmd.Utils;

import com.google.common.io.Files;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import us.tmd.tmd.Main;

import java.nio.charset.Charset;
import java.util.List;

public class ChatUtils {

    private static int l = 100;

    public static void logChat(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

    public static String[] getBoundChat(int a, int b) {
        try {
            List<String> chatLogs = Files.readLines(Main.chatLogs, Charset.defaultCharset());
            if(a > chatLogs.size() || b > chatLogs.size())
                return (String[]) chatLogs.subList(0, chatLogs.size()).toArray();
            else
                return (String[]) chatLogs.subList(a, b).toArray();
        } catch (Exception e) {
             e.printStackTrace();
        }

        return null;
    }

    public static void setChatLength(int l) {
        ChatUtils.l = l;
    }

    public static String[] getChat(int a) {
        return getBoundChat(a, a + l);
    }

}
